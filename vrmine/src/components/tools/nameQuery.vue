
  <template>
<div>
    <span slot="prepend" style="font-weight:bold" >巷道名称 : </span>
    <Row>
        
        <i-col span="12">
            <Input v-model="inputName" placeholder="请输入"></Input>
        </i-col>
            <Button type="primary" style="float:right" @click="MFAH()">定位</Button>
             
    </Row>
</div> 
</template>  

<script>
import Cesium from 'cesium/Cesium.js';
import cesiumContainer from "../cesiumViewer/cesiumViewer.vue";

    export default {
        data () {
             return {
                paramData:"",
                X:"",
                Y:"",
                Z:"",                            

            }
        },
        methods: {

            MFAH(){

                    this.setparam();
                    this.getTunnelData(this.paramData);
                    //相机飞向坐标            
                    window.viewer.camera.flyTo({
                    destination : Cesium.Cartesian3.fromDegrees(this.X,this.Y,this.Z)
                    });              
                                   
            },

            //设置请求参数
            setparam() {
                    this.paramData = {
                    tunnelName: this.inputName,
                    }                                            
            }, 
      
            //调接口获取数据
            getTunnelData(paramData) {
                
                this.$axios({
                    url: "api/tunneldata/sometunnelName",
                    method: "get",
                    params: paramData,
                })
                    .then(res => {
                    var show = res.data.data;
                    var len = parseInt((show.length)/2);

                    this.X = parseFloat(show[len].latitude);
                    this.Y = parseFloat(show[len].longitude);
                    this.Z = parseFloat(show[len].altitude);
                    
                    
                    })
                    .catch(error => {});
            },

            //模型高亮显示
          
              /* 

                var silhouetteGreen = Cesium.PostProcessStageLibrary.createEdgeDetectionStage();
                silhouetteGreen.uniforms.color = Cesium.Color.LIME;
                silhouetteGreen.uniforms.length = 0.01;
                silhouetteGreen.selected = [];//高亮显示该模型
            */
        }

    }        
</script> 
