<template>
<div>
    <Checkbox  @on-change="change">巷道</Checkbox>
</div>

</template>
<script src = "public\Build\Cesium\Cesium.js"></script>
<script>
// import Cesium from "cesium/Cesium.js";
export default {
  data() {
    return {
       tunnelData:[],
       mineid:"",
    }
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

  created(){
    //获取用户参数
        this.mineid=this.$parent.$parent.mineid;
       
  },

  mounted() {          
        this.$axios("api/tunneldata",{
            params:{
                 // mineId:this.mineid
            }
        })
          .then(res => {
            this.tunnelData = res.data.data;
           
            
            
          })
          .catch(error => {})
  },

  methods: {
    change(checked) {
      // console.log("===selectedItem.checked===" + selectedItem.checked);
      var modelData = [];

        if (checked == false) {
              this.viewer.entities.removeAll();
                return;
        }
        else{
             modelData =this.tunnelData;
       }
        function computeCircle(radius1,radius2) {
            var positions = [];
            for (var i = 0; i <= 180; i++) {
                var radians1 = Cesium.Math.toRadians(i);
                positions.push(new Cesium.Cartesian2(radius1 * Math.cos(radians1), radius1 * Math.sin(radians1)));
            }
            for (var i = 180; i >=0; i--) {
                var radians2 = Cesium.Math.toRadians(i);
                positions.push(new Cesium.Cartesian2(radius2 * Math.cos(radians2), radius2 * Math.sin(radians2)));
            }
            return positions;
      }
    var map = [];
    var dest = [];
      for(var i = 0; i <  modelData.length; i++){
        var ai =  modelData[i];
        // console.log(ai.latitude);
        // console.log(typeof(parseFloat(ai.latitude)));
        if(!map[ai.tunnelName]){
            dest.push({   
                tunnelName: ai.tunnelName,
                data1: [parseFloat(ai.longitude),parseFloat(ai.latitude),parseFloat(ai.altitude)],
                data2:[parseFloat(ai.longitude),parseFloat(ai.latitude),parseFloat(ai.altitude)+3.2]
            });
            map[ai.tunnelName] = ai;
        }else{
            for(var j = 0; j < dest.length; j++){
                var dj = dest[j]; 
                if(dj.tunnelName == ai.tunnelName){
                    dj.data1.push(parseFloat(ai.longitude),parseFloat(ai.latitude),parseFloat(ai.altitude));
                    dj.data2.push(parseFloat(ai.longitude),parseFloat(ai.latitude),parseFloat(ai.altitude)+3.2);
                    break;
                }
            }
        }  
    }
 
    for (var m = 0; m < dest.length; m++){
          //console.log(dest[m].data1);

          var redTube = this.viewer.entities.add({
                  name : dest[m].tunnelName,
                  polylineVolume : {
                      positions :Cesium.Cartesian3.fromDegreesArrayHeights(dest[m].data2), 
                      shape : computeCircle(1.7,1.6999),
                      material : Cesium.Color.RED
                  },

                });
          var greenBox = this.viewer.entities.add({
              name: dest[m].tunnelName,
              polylineVolume : {
                  positions :Cesium.Cartesian3.fromDegreesArrayHeights(dest[m].data1),
                  shape :[new Cesium.Cartesian2(-1.7, -1.7),
                          new Cesium.Cartesian2(1.7, -1.7),
                          new Cesium.Cartesian2(1.7, 1.7),
                          new Cesium.Cartesian2(1.6999,1.7),
                          new Cesium.Cartesian2(1.6999, -1.6999),
                          new Cesium.Cartesian2(-1.6999, -1.6999),
                          new Cesium.Cartesian2(-1.6999, 1.7),
                          new Cesium.Cartesian2(-1.7, 1.7),
                      ],
                  cornerType : Cesium.CornerType.ROUNDED ,
                  material :Cesium.Color.GREEN.withAlpha(0.5) ,
                  // outline : true,
                  // outlineColor : Cesium.Color.BLUE
              }
          }); 

   
    }
      this.viewer.zoomTo(this.viewer.entities);



    },
  }
};
</script>

