<template>
  <div class="layer">
    <Scroll height="750">
      <div style="position:relative; left:20px;">
        <SurefaceShow :viewer="viewer" />
        <TunnelShow :viewer="viewer" />
      </div>
      <Tree :data="treeData" :render="renderContent" @on-check-change="checkItem" @on-select-change="clickItem"
        show-checkbox>
      </Tree>
    </Scroll>
    <Modal v-model="showDialog" title="设备详情" width="600px" draggable :styles="{left: '20px'}">
      <Modelmodify v-if="showDialog" :xxxData="xxxData" :viewer="viewer"></Modelmodify>
      <div slot="footer"></div>
    </Modal>
  </div>
</template>
<script src="public\Build\Cesium\Cesium.js"></script>
<script>
  // import Cesium from "cesium/Cesium.js";
  import TunnelShow from "./TunnelShow.vue";
  import SurefaceShow from "./surfaceModel.vue";
  import Modelmodify from "./modelModify.vue";
  export default {
    data() {
      return {
        treeData: [
          {
            id: "1",
            title: "人员定位",
            expand: false,
            render: (h, { root, node, data }) => {
              return h('span', {
                style: {
                  display: 'inline-block',
                  width: '100%'
                }
              }, [
                h('span', [

                  h('span', data.title)
                ]),
              ])
            },
            children: []
          },
          {
            id: "2",
            title: "监控模型",
            expand: false,
            render: (h, { root, node, data }) => {
              return h('span', {
                style: {
                  display: 'inline-block',
                  width: '100%'
                }
              }, [
                h('span', [

                  h('span', data.title)
                ]),
              ])
            },
            children: []
          },
          {
            id: "3",
            title: "机电设备",
            expand: false,
            render: (h, { root, node, data }) => {
              return h('span', {
                style: {
                  display: 'inline-block',
                  width: '100%'
                }
              }, [
                h('span', [

                  h('span', data.title)
                ]),
              ])
            },
            children: []
          }
        ],
        equipmentData: [],
        persorientatioData: [],
        sensorData: [],
        showDialog: false,
        xxxData: null,
        isEdited: true,
        iseditable:"",
        mineid:"",
      };
    },
    components: {
      TunnelShow,
      SurefaceShow,
      Modelmodify
    },
    props: {
      // API URL
      url: {
        type: String,
        default: ""
      },
      viewer: {
        type: Object,
        default: () => { }
      },
      // URL路径中的参数，如：/posts/#{id}/comments
      pathParams: {
        type: Object,
        default: () => { }
      },
      // Query参数
      options: {
        type: Object,
        default: function () {
          return { params: {} };
        }
      }
    },
    created(){
        //获取用户参数
      //  this.iseditable=this.$parent.$parent.$parent.$parent.iseditable;
      //  this.mineid=this.$parent.$parent.$parent.$parent.mineid;
      //  if(this.iseditable!="yes"){         
      //     this.isEdited = false; //参数不对，禁止操作模型        
      //  }      
      this.treeData.forEach(it => {
        if (it.title == "人员定位") {
          this.$axios("api/persorientatio")
            .then(res => {
              this.persorientatioData = res.data.data;
              this.persorientatioData.forEach(a => {
                it.children.push({
                  title: a.name,
                  id: a.tableType * 100000 + a.id,
                  disableCheckbox: true
                });
              });
            })
            .catch(error => { });
        } else if (it.title == "监控模型") {
          this.$axios("api/sensor")
            .then(res => {
              this.sensorData = res.data.data;
              this.sensorData.forEach(a => {
                it.children.push({
                  title: a.sensorName,
                  id: a.tableType * 100000 + a.sensorID,
                  disableCheckbox: true
                });
              });
            })
            .catch(error => { });
        } else if (it.title == "机电设备") {
          this.$axios("api/equipment")
            .then(res => {
              this.equipmentData = res.data.data;
              this.equipmentData.forEach(a => {
                it.children.push({
                  title: a.equipmentName,
                  id: a.tableType * 100000 + a.equipmentID,
                  disableCheckbox: true
                });
              });
            })
            .catch(error => { });
        }
      });
    },

    methods: {
      renderContent(h, { root, node, data }) {
        if (this.isEdited == false) {
          return h('span', {
            style: {
              display: 'inline-block',
              width: '100%'
            }
          }, [
            h('span', {
              style: {
                color: '#666',
                cursor: 'pointer'
              },
              domProps: {
                className: 'btn'
              },
              on: {
                click: () => {
                  this.clickItem(data)
                }
              }
            }, data.title)
          ]
          )
        } else {
          return h('span', {
            style: {
              display: 'inline-block',
              width: '100%'
            }
          }, [
            h('span', {
              style: {
                color: '#666',
                cursor: 'pointer'
              },
              domProps: {
                className: 'btn'
              },
              on: {
                click: () => {
                  this.clickItem(data)
                }
              }
            }, data.title),
            h('span', {
              style: {
                display: 'inline-block',
                float: 'right',
                marginRight: '35px'
              }
            }, [
              h('Button', {
                props: Object.assign({}, this.buttonProps, {
                  icon: 'ios-create-outline',
                  size: 'small',
                }),
                style: {
                  marginRight: '8px',

                },
                on: {
                  click: () => { this.modify(data) }
                }
              }),

            ])
          ]);
        }
      },
      modify(data) {
        // console.log(data.id)
        this.showDialog = true,
          this.xxxData = data.id

      },
      checkItem(selectedArr, selectedItem) {
        // console.log("===selectedItem.checked===" + selectedItem.checked);
        var modelData = [];
        if (selectedItem.title == "机电设备") {
          if (selectedItem.checked == false) {
            this.viewer.entities.removeAll();
            return;
          }
          modelData = this.equipmentData;
          // console.log("===equipmentData" + modelData);
        } else if (selectedItem.title == "人员定位") {
          if (selectedItem.checked == false) {
            this.viewer.entities.removeAll();
            return;
          }
          modelData = this.persorientatioData;
          // console.log("===persorientatioData" + modelData);
        } else if (selectedItem.title == "监控模型") {
          if (selectedItem.checked == false) {
            this.viewer.entities.removeAll();
            return;
          }
          modelData = this.sensorData;
          // console.log("===sensorData" + modelData);
        }

        // this.viewer.entities.removeAll();
        modelData.forEach(it => {
          var position = Cesium.Cartesian3.fromDegrees(it.posY, it.posX, it.posZ);
          var heading = Cesium.Math.toRadians(it.rotationY);//俯仰角
          var pitch = Cesium.Math.toRadians(it.rotationX);//偏行角
          var roll = Cesium.Math.toRadians(it.rotationZ);//滚转角
          var hpr = new Cesium.HeadingPitchRoll(heading, pitch, roll);
          var orientation = Cesium.Transforms.headingPitchRollQuaternion(
            position,
            hpr
          );
          this.viewer.entities.add({
            id: it.tableType * 100000 + (it.id || it.sensorID || it.equipmentID),
            name: it.installationsite || it.equipmentName,
            position: position,
            orientation: orientation,
            // label: {
            //     text: 'aaaaaaa',
            //     font: '20px sans-serif',
            //     pixelOffset: new Cesium.Cartesian2(0, -500),
            //     translucencyByDistance: new Cesium.NearFarScalar(1.5e5, 1.0, 1.5e7, 0.0)
            //   },
            model: {
              uri: "model3D/CesiumBalloon/" + it.modelName,
              
            }
          });
        });
      },

      clickItem(clickedItem) {
        // console.log(clickedItem);
        var getByIdEntity = this.viewer.entities.getById(clickedItem.id);
        // console.log(getByIdEntity)
        this.viewer.zoomTo(getByIdEntity);
      },

    }
  };
</script>