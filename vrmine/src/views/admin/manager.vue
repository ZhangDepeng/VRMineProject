<!--管理中心-->
<template>
  <Collapse simple>
    <Panel name="1">
      个人信息
      <p slot="content">
        <List  border>
            <ListItem>用户ID:
            </ListItem><Divider />
            <ListItem>姓名:
            </ListItem><Divider />
            <ListItem>性别:
            </ListItem><Divider />
            <ListItem>电话:
            </ListItem><Divider />
            <ListItem>邮箱:
            </ListItem>
        </List>
      </p>
    </Panel> 
   <Panel name="2">
      修改密码
      <p slot="content">
        <Form ref="formCustom" :model="formCustom" label-position="left" :rules="ruleCustom" :label-width="80">
          <FormItem label="密码" prop="passwd" class="passwd"> 
            <Input type="password" v-model="formCustom.passwd"></Input>
          </FormItem>
          <FormItem label="确认密码" prop="passwdCheck" class="passwdCheck">
            <Input type="password" v-model="formCustom.passwdCheck"></Input>
          </FormItem>
          <FormItem>
            <Button type="primary" @click="handleSubmit('formCustom')">提交</Button>
            <Button @click="handleReset('formCustom')" style="margin-left: 8px">重置</Button>
          </FormItem>
        </Form>
    </p>
   </Panel>
  </Collapse>
</template>
<script>
  export default {
    data() {
      var validatePass = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请输入密码'));
        } else {
          if (this.formCustom.passwdCheck !== '') {
            this.$refs.formCustom.validateField('passwdCheck');
          }
          callback();
        }
      };
      var validatePass2 = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请再次输入密码'));
        } else if (value !== this.formCustom.passwd) {
          callback(new Error('两次输入密码不一致!'));
        } else {
          callback();
        }
      };
      return {
        key: null, //搜索关键字
        adminInfo:null,
        formCustom: {
          passwd: '',
          passwdCheck: ''
        },
      };
    },
    created(){
      this.getAdminInfo()
    },
    methods: {
      getAdminInfo(){
        this.$axios(`/api/admins`).then(res => {
        let adminInfo = res.data.data
        console.log("------测试-----")
        console.log(adminInfo)
      }).catch(error => {
        console.log(error)
      })
      },
      handleSubmit(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            let adminId = this.$cookies.get("cid")
            this.$axios({ //修改密码
              url: '/api/adminPWD',
              method: 'put',
              data: {
                pwd: this.formCustom.passwd,
                adminId
              }
            }).then(res => {
              if(res.data != null ) { //修改成功提示
                this.$Message.success('密码修改成功');
              }
            })
          } else {
            console.log('error submit!!');
            return false;
          }
        });
      },
      handleReset(formName) {
        this.$refs[formName].resetFields();
      }
    }
  }
</script>

<style scoped>
#manager .pass  label{
  color: red;
  font-size: 20px;
}
#manager {
  width: 600px;
  margin: 0 auto;
  margin-top: 100px;
  text-align: center;
  margin-bottom: 300px;
}
#manager .alter {
  margin: 30px 0px;
}
</style>