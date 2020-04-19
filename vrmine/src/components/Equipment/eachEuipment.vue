<style>
  .demo {
    height: 550px;
    width: 100%;
    border: 1px solid #dcdee2;
  }

  .demo-form {
    width: 400px;
    height: 500px;
    margin: 10px 20px;
  }
</style>
<template>

  <div class="demo-form">
    <Form :model="formItem" :label-width="80" class="demo-form">
      <FormItem label="设备名称">
        <Input v-model="formItem.equipmentName" :readonly="isReaded"></Input>
      </FormItem>
      <FormItem label="模型名称">
        <Input v-model="formItem.modelName" :readonly="isReaded"></Input>
      </FormItem>
      <FormItem label="规格型号">
        <Input v-model="formItem.type" :readonly="isReaded"></Input>
      </FormItem>
      <FormItem label="制造厂家">
        <Input v-model="formItem.manufacturer" :readonly="isReaded"></Input>
      </FormItem>
      <FormItem label="出厂序号">
        <Input v-model="formItem.equipmentNum" :readonly="isReaded"></Input>
      </FormItem>
      <FormItem label="出厂日期">
        <Input v-model="formItem.equipmentDate" :readonly="isReaded"></Input>
      </FormItem>
      <FormItem label="存放位置">
        <Input v-model="formItem.position" :readonly="isReaded"></Input>
      </FormItem>
      <FormItem label="技术参数">
        <Input v-model="formItem.parameters" type="textarea" :readonly="isReaded" :autosize="{minRows: 2,maxRows: 2}"></Input>
      </FormItem>
      <FormItem>
        <Button type="primary"  @click="handleSubmit()" v-if="isEdited">提交</Button>
      </FormItem>
    </Form>

  </div>
</template>

<script>
  export default {
    data() {
      return {
        formItem: {},
        isEdited: true,
        isReaded: false,
        iseditable:"",
        mineid:"",
      }
    },
    created(){
      //获取用户参数
       this.iseditable=this.$parent.$parent.$parent.iseditable;
       this.mineid=this.$parent.$parent.$parent.mineid; 
       
      //  if(this.iseditable!="yes"){//参数不对，不允许编辑和提交
      //     this.isEdited = false;
      //     this.isReaded = true;         
      //  }    
    },
    mounted() {
      var id = this.xxxData;
      this.getEachEquipment(id);
      
    },
    methods: {
      getEachEquipment: function (id) {
        this.$axios("api/equipment/equipmentID/" + id)
          .then(res => {
            this.formItem = res.data.data;
          })
          .catch(error => { });
      },
      handleSubmit() {
       this.$axios({
            url: 'api/equipment/equipmentID',
            method: 'put',
            data: {
              ...this.formItem
            }
          }).then(res => {
            // console.log(res)
            if (res.data.code == 200) {
              this.$Message.success('更新成功')
            } else {
              this.$Message.error('更新失败')
            }
          })
      },
    },
    props: {
      // API URL
      xxxData: {
        type: Number,
        default: null
      }
    }
  };
</script>