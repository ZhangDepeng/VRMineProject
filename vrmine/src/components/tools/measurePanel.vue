
<template>
  <div >
     <Radio-group v-model="measuretype">
        <Radio label="distance">                             
          <span>距离量测</span>
        </Radio>
        <Radio label="area">                            
          <span>面积量测</span>
        </Radio>
        <Radio label="height">                    
          <span>高度量测</span>
        </Radio>
    </Radio-group>
    <i-button type="primary" size="small" shape="circle" :title="curMeasureStatus" @click="toggleClick">开始测量</i-button>
    <i-button type="primary" size="small" shape="circle" title="一键删除"  @click="removeAll" >清除</i-button>

  </div>
</template>




<script>
import Cesium from "cesium/Cesium.js"; 
//import cesiumContainer from "../cesiumViewer/cesiumTunnel.vue";
import { PolylineGraphic, PolygonGraphic, HeightGraphic } from "./graphic.js";
//
const graphics = [];
export default {
  name: "cesiumMeasure",
  data() {
    return {     
      measuretype: 'distance',
      curMeasureStatus: "开始测量",     
      areaManager: null,
      distanceManager: null,
      heightManager: null,
      entities: [],
      positions: [],
      bool:true,
      
    };
  }, 
  components: {
   
  },

  computed: {},
  created(){
    
  },
  mounted() {
    
    const self = this;
    self.name = "";
    window.distanceManagers = [];
    window.areaManagers = [];
    window.heightManagers = [];
           
  },
  methods: {
    
    createTip() {
      const tooltip = document.createElement("div");
      tooltip.id = "measure_tip";
      tooltip.className = "tip-class";
      tooltip.innerHTML = "单击添加节点，右击结束量算.";
     
      document.body.appendChild(tooltip);
      return tooltip;
    },
    updateTipText(text) {
      const tip = document.getElementById("measure_tip");
      if (!tip) {
        return;
      }
      tip.innerHTML = text;
    },
    tipVisible(status) {
      const tip = document.getElementById("measure_tip");
      if (!tip) {
        return;
      }
      if (status) {
        tip.style.display = "block";
      } else {
        tip.style.display = "none";
      }
    },
    init(viewer) {
      
      const self = this;   
      const handler = new Cesium.ScreenSpaceEventHandler(viewer.canvas);
      const tooltip=this.createTip();
      this.tipVisible(false);
      handler.setInputAction(e => {
        const pixel = e.position;
        const ray = viewer.camera.getPickRay(pixel);
        const cartesian = viewer.scene.globe.pick(ray, viewer.scene);

        
        if (this.measuretype === "height") {
          this.updateTipText('请单击地图添加终点.')
          self.positions.pop()
          self.heightMeasureHandler(pixel);

          if (this.positions.length === 2) {
            
            this.stopDraw();
          }
          return;
        }
        if (cartesian) {
          self.positions.push(cartesian);
        }
      }, Cesium.ScreenSpaceEventType.LEFT_CLICK);
      handler.setInputAction(e => {
        const pixel = e.endPosition;
        tooltip.style.left = pixel.x + 10 + 'px';
        tooltip.style.top = pixel.y + 10 + 'px';
        const ray = viewer.camera.getPickRay(pixel);
        const cartesian = viewer.scene.globe.pick(ray, viewer.scene);
       
        if (!cartesian) {
          return;
        }
        // if (self.mode === "height") {
        //   return;
        // }
        if (self.positions.length > 1) {
          self.positions.pop();
        }
        if (self.positions.length > 0) {
          self.positions.push(cartesian);
        }
      }, Cesium.ScreenSpaceEventType.MOUSE_MOVE);
      handler.setInputAction(() => {       
        self.stopDraw();
      }, Cesium.ScreenSpaceEventType.RIGHT_CLICK);
    },
    heightMeasureHandler(pixel) {
      const viewer = window.viewer;
      const position = viewer.scene.pickPosition(pixel);
      this.positions.push(position);
    },
    stopDraw() {
      if(window.graphicManager===undefined){
        return;
      }
      window.graphicManager.stopEdit();
      graphics.push(window.graphicManager.entity);
      window.graphicManager.destory();
      this.tipVisible(false);
      this.positions = [];
      this.curMeasureStatus = "开始测量";
      window.graphicManager = null;
    },
    removeAll() {
      const viewer = window.viewer;
      for (let e of graphics) {
        viewer.entities.remove(e);
        viewer.entities.removeAll();
      }
    },
    toggleClick() {
      
      if(this.bool==true){
        const viewer = window.viewer;
        this.init(viewer);
        this.bool=false;
      }
           
      if (window.graphicManager) {
        this.stopDraw();
        return;
      }
      this.tipVisible(true);
      this.curMeasureStatus = "结束测量";

      switch (this.measuretype) {
        case "distance":
          this.updateTipText("单击添加节点，右击结束量算.");
          window.graphicManager = new PolylineGraphic(viewer, {
           
            positions: this.positions,
            material: Cesium.Color.RED,
            width: 3,
            clampToGround: true
          });                     
          break;
        case "area":
          this.updateTipText("单击添加节点，右击结束量算.");
          window.graphicManager = new PolygonGraphic(viewer, {
            hierarchy: this.positions,
            material: Cesium.Color.RED,
            width: 3,
            heightReference: Cesium.HeightReference.CLAMP_TO_GROUND
          });          
          break;
        case "height":
          this.updateTipText("请单击地图确定起点.");
          window.graphicManager = new HeightGraphic(viewer, {
            positions: this.positions,
            material: Cesium.Color.RED,
            width: 3
          });         
          break;
      }
    }
  },
  watch: {}
};




</script>

<style scoped>
#measurePanel {
  position: fixed;
  width: 400px;
  height: 50px;
  color: #fff;
  left: 210px;
  border-radius: 3px;
  background: rgba(0, 0, 0, 0.7);
  border: 1px solid #01c5fd;
  box-shadow: 0 0 5px rgba(1, 197, 253, 0.75);
  z-index: 10;
}

.clostbtn {
  font-family: element-icons !important;
  float: right;
  margin-right: -10px;
}

.clostbtn:after {
  content: "\E6DB";
}

.el-header {
  height: 40% !important;
}

.el-main {
  height: 60% !important;
  padding: 5px 0px 0px 20px;
  line-height: 60%;
  vertical-align: middle;
}

.el-main img {
  display: inline-block;
}

.el-main .el-radio {
  display: inline-block;
  margin: 5px;
}
</style>
<style>
#measurePanel .el-radio {
  color: #fff;
}
.tip-class {
  position: fixed;
  border: 1px #b6aeae solid;
  width: 250px;
  height: 30px;
  line-height: 30px;
  padding-left: 10px;
  background-color: #b6aeae;
  color: #fff;
  border-radius: 6px 6px 6px 0px;
  pointer-events: none;
}
</style>


