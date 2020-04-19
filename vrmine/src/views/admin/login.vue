<style scoped>
.login {
  width: 100vw;
  height: 100vh;
  background-image: url("../../assets/images/login-bg.jpg");
  background-size: cover;
  background-position: center;
  position: relative;
}
.login-con {
  width: 400px;
  height: 400px;
  float: right;
  position: relative;
  top: 200px;
  right: 200px;
}
.form-con {
  padding: 10px 0 0;  
}
</style>
<template>
  <div class="login">
    <div class="login-con">
      <Card icon="log-in" title="欢迎登录" :bordered="false">
        <div class="form-con">
          <Form ref="formInline" :model="formInline" :rules="ruleInline" inline>
            <FormItem prop="username">
              <Input v-model.number="formInline.username" placeholder="用户名">
                <Icon type="ios-person-outline" slot="prepend"></Icon>
              </Input>
            </FormItem>
            <FormItem prop="密码">
              <Input type="password" v-model="formInline.password" placeholder="Password">
                <Icon type="ios-lock-outline" slot="prepend"></Icon>
              </Input>
            </FormItem>
            <FormItem>
              <Button type="primary" @click="handleSubmit('formInline')">登录</Button>
            </FormItem>
          </Form>
        </div>
      </Card>
    </div>
  </div>
</template>
<script>
export default {
  name: "login",
  data() {
    return {
      formInline: {
        username: '9527',
        password: '123'
      },
      ruleInline: {
        username: [{ required: true, message: "请填入用户名", trigger: "blur" }],
        password: [
          { required: true, message: "请输入密码", trigger: "blur" },
          {
            type: "string",
            min: 6,
            message: "密码不能少于6位",
            trigger: "blur"
          }
        ]
      }
    }
  },
  methods: {
    handleSubmit() {
      console.log("登录操作执行-----");
      this.$axios({
        url:`/api/login`,
        method:'post',
        data:{
          ...this.formInline
        }
      }).then(res=>{
        let resData = res.data.data;
        console.log(resData);
        if(resData!=null){
          this.$cookies.set("cname", resData.studentName);
          this.$cookies.set("cid", resData.adminId);
          this.$router.push({path: '/home'})
        }
      if(resData == null) { //错误提示
      this.$Message.warning('用户名或者密码错误');
        }
      })
    },
      clickTag(key) {
      this.role = key
    }
  },
  mounted() {
  }
}
</script>

