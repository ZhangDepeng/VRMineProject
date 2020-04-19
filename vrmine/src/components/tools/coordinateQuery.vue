<template>
  <div>
    <span slot="prepend" style="font-weight:bold">X :</span>
    <Input v-model="valuex" placeholder="Enter something..." clearable style="width: 200px" />
    <br />
    <span slot="prepend" style="font-weight:bold">Y :</span>
    <Input v-model="valuey" placeholder="Enter something..." clearable style="width: 200px" />
    <br />
    <span slot="prepend" style="font-weight:bold">Z :</span>
    <Input v-model="valuez" placeholder="Enter something..." clearable style="width: 200px" />
    <Button type="primary" style="float:top" @click="locate()">定位</Button>
    <Button type="primary" style="float:right" @click="clear()">清除坐标</Button>
  </div>
</template>
<script>
import Cesium from "cesium/Cesium.js";
import cesiumContainer from "../cesiumViewer/cesiumViewer.vue";

export default {
  data() {
    return {
      
      valuex: "",
      valuey: "",
      valuez: ""
    };
  },
  props: {
    // API URL
    url: {
      type: String,
      default: ""
    },
    viewer: {
      type: Object,
      default: () => {}
    },
    // URL路径中的参数，如：/posts/#{id}/comments
    pathParams: {
      type: Object,
      default: () => {}
    },
    // Query参数
    options: {
      type: Object,
      default: function() {
        return { params: {} };
      }
    }
  },
  
  
  mounted() {
   
  },

  methods: {

    locate() {
    //var str=this.valuex.concat(",",this.valuey,",",this.valuez);
    var str = "X:"+this.valuex+",Y:"+this.valuey+",Z:"+this.valuez;
 
    var X= parseFloat(this.valuex); 
    var Y= parseFloat(this.valuey); 
    var Z= parseFloat(this.valuez);
    
    
     
      window.viewer.entities.add({
        position : Cesium.Cartesian3.fromDegrees(X,Y,Z),
        point : {
            show : true, // default
            color : Cesium.Color.RED, 
            pixelSize : 10, // default: 1
            outlineColor : Cesium.Color.YELLOW, 
            outlineWidth : 3 // default: 0
        },
        
        label : { 
              
            text :str,
            pixelOffset: new Cesium.Cartesian2(0, -30), //偏移量
            font : '24px Helvetica',
            fillColor : Cesium.Color.SKYBLUE,
            outlineColor : Cesium.Color.BLACK,
            outlineWidth : 2,
            style : Cesium.LabelStyle.FILL_AND_OUTLINE
        }
    });
      window.viewer.camera.flyTo({
        destination : Cesium.Cartesian3.fromDegrees(X,Y,Z)
      });
    
                
    },

    //清除坐标和实体
    clear(){
      this.valuex = "";
      this.valuey = "";
      this.valuez = "";
      window.viewer.entities.removeAll();

    }

  }
 
};
</script>