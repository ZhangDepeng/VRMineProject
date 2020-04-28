<style scoped>
  .model {
    height: 250px;
    width: 100%;
    border: 1px solid #dcdee2;
  }

  .model-form {
    margin: 20px;
  }
</style>
<template>
  <div class="model">
    <Form :model="formNumber" :label-width="50" class="model-form">
      <FormItem label="位置">
        <br />
        <span :style="{marginRight: '10px'}">X</span>
        <InputNumber v-model="formNumber.posX" size="large" :step="0.000001" :style="{width:'110px'}"></InputNumber>
        <span :style="{margin: '0 10px 0 30px'}">Y</span>
        <InputNumber v-model="formNumber.posY" size="large" :step="0.000001" :style="{width:'110px'}"></InputNumber>
        <span :style="{margin: '0 10px 0 10px'}">Z</span>
        <InputNumber v-model="formNumber.posZ" size="large" :step="0.000001" :style="{width:'110px'}"></InputNumber>
      </FormItem>
      <FormItem label="旋转">
        <br />
        <span :style="{marginRight: '10px'}">X</span>
        <InputNumber v-model="formNumber.rotationX" size="large" :step="0.1" :style="{width:'110px'}"></InputNumber>
        <span :style="{margin: '0 10px 0 30px'}">Y</span>
        <InputNumber v-model="formNumber.rotationY" size="large" :step="0.1" :style="{width:'110px'}"></InputNumber>
        <span :style="{margin: '0 10px 0 10px'}">Z</span>
        <InputNumber v-model="formNumber.rotationZ" size="large" :step="0.1" :style="{width:'110px'}"></InputNumber>
      </FormItem>
      <FormItem>
        <Button type="primary" @click="handleSubmit()" size="large" style="display:block;margin:0 auto">提交</Button>
      </FormItem>
    </Form>
  </div>
</template>
<script src="public\Build\Cesium\Cesium.js"></script>
<script>
  export default {
    props: {
      // API URL
      xxxData: {
        type: Number,
        default: null
      },
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
    data() {
      return {
        formNumber: {},
        iseditable:"",
      }
    },

    created(){ 
      // 获取用户参数
       this.iseditable=this.$parent.$parent.iseditable;
       //alert(this.iseditable);
  
      var id = this.xxxData;
      var getByIdEntity = this.viewer.entities.getById(id);
      this.viewer.zoomTo(getByIdEntity);
      if (id.toString().startsWith("3")) {
        id = id - 3 * 100000;
        this.$axios("api/persorientatio/ID/" + id).then(res => {
          this.formNumber = res.data.data;
        })
      } else if (id.toString().startsWith("4")) {
        id = id - 4 * 100000;
        this.$axios("api/sensor/sensorID/" + id).then(res => {
          this.formNumber = res.data.data;
        })
      } else if (id.toString().startsWith("1")) {
        id = id - 1 * 100000;
        this.$axios("api/equipment/equipmentID/" + id).then(res => {
          this.formNumber = res.data.data;
        })
      }
    },
    watch: {
      formNumber: {
        handler: function (val) {
          var position = Cesium.Cartesian3.fromDegrees(val.posY, val.posX, val.posZ);
          var heading = Cesium.Math.toRadians(val.rotationY);//俯仰角
          var pitch = Cesium.Math.toRadians(val.rotationX);//偏行角
          var roll = Cesium.Math.toRadians(val.rotationZ);//滚转角
          var hpr = new Cesium.HeadingPitchRoll(heading, pitch, roll);
          var orientation = Cesium.Transforms.headingPitchRollQuaternion(
            position,
            hpr
          );
          this.viewer.entities.getById(this.xxxData).position = position;
          //更新姿态
          this.viewer.entities.getById(this.xxxData).orientation = orientation;
        },
        deep: true
      }

    },

    methods: {
      handleSubmit() {
        var id = this.xxxData;
        
        if (id.toString().startsWith("3")) {
          id = id - 3 * 100000;
          this.$axios({
            url: 'api/persorientatio/ID',
            method: 'put',
            data: {
              ...this.formNumber
            }
          }).then(res => {
            // console.log(res)
            if (res.data.code == 200) {
              this.$Message.success('更新成功')
            } else {
              this.$Message.error('更新失败')
            }
          })
        } else if (id.toString().startsWith("4")) {
          id = id - 4 * 100000;
          this.$axios({
            url: 'api/sensor/sensorID',
            method: 'put',
            data: {
              ...this.formNumber
            }
          }).then(res => {
            // console.log(res)
            if (res.data.code == 200) {
              this.$Message.success('更新成功')
            } else {
              this.$Message.error('更新失败')
            }
          })

        } else if (id.toString().startsWith("1")) {
          id = id - 1 * 100000;
          this.$axios({
            url: 'api/equipment/equipmentID',
            method: 'put',
            data: {
              ...this.formNumber
            }
          }).then(res => {
            // console.log(res)
            if (res.data.code == 200) {
              this.$Message.success('更新成功')
            } else {
              this.$Message.error('更新失败')
            }
          })
        }
      },

    },
  };
</script>