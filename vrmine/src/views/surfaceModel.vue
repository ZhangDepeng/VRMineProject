<template>
<div>
    <Checkbox  @on-change="change">地表建筑</Checkbox>
</div>

</template>

<script>
import Cesium from "cesium/Cesium.js";
export default {
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
  methods:{
      change(checked) {
          if (checked == false) {
              this.viewer.entities.removeAll();
                return;
        }
        else{
            var position = Cesium.Cartesian3.fromDegrees(112.894773, 26.337838,0);
            var height = -5.0;
        var heading = 0;
        var pitch = 0;
        var roll = 0;
        var hpr = new Cesium.HeadingPitchRoll(heading, pitch, roll);
        var orientation = Cesium.Transforms.headingPitchRollQuaternion(
          position,
          hpr
        );
        this.viewer.entities.add({
          id:1,
          position: position,
          orientation: orientation,
          
          model: {
            uri: "model3D/CesiumBalloon/model2.gltf",
          }
        });
        this.viewer.zoomTo(this.viewer.entities);
       }
      }
  }
  
}
</script>