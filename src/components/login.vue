<template>
  <div style="width: 100%;height: 100vh;background-color: #17A2B8;overflow: hidden">
    <div style="width: 400px;margin: 150px auto">
      <div style="color: white;font-size: 30px; text-align: center">
        欢迎登录！
      </div>
      <div>
        <b-form v-if="show">
          <b-form-group
              id="input-group-1"
              label="用户名"
              label-for="input-1"
              style="color: white"
          >
            <b-form-input
                id="input-1"
                v-model="form2.username"
                placeholder="输入用户名"
            ></b-form-input>
          </b-form-group>

          <b-form-group id="input-group-2" label="密码:" label-for="input-2" style="color: white">
            <b-form-input
                id="input-2"
                v-model="form2.password"
                placeholder="输入密码"
                type="password"

            ></b-form-input>
          </b-form-group>
          <b-form-group id="input-group-4" v-slot="{ ariaDescribedby }">
            <b-form-checkbox-group
                v-model="form2.checked"
                id="checkboxes-4"
                :aria-describedby="ariaDescribedby"
            >
              <b-form-checkbox value="me">记住密码</b-form-checkbox>
            </b-form-checkbox-group>
          </b-form-group>

          <b-button @click="Submit">登录</b-button>
          <b-button @click="Reset" variant="danger">去注册</b-button>
        </b-form>
      </div>
    </div>
  </div>
</template>

<script>
import request from "@/utils/request";

export default {
  name: "login",
  data() {
    return {
      form2: {
        username: '',
        password: '',
      },
      show: true
    }
  },
  mounted() {
    sessionStorage.removeItem("user")
  },
  methods: {
    Submit() {
      // var userid=''
      // var that=this
      request.post("user/login", this.form2).then(res => {
        // const userMeg = {
        //   username: this.form.username,
        //   id:"",
        // }
        if (res.code === '0') {
          this.$message({
            type: "success",
            message: "登录成功"
          })
          sessionStorage.setItem("user", JSON.stringify(res.data))  // 缓存用户信息
          // sessionStorage.setItem("userid", JSON.stringify(this.$root.userid))
          if (res.data.role == 1)
            this.$router.push("/adminlayout")
          if (res.data.role == 2)
            this.$router.push("/")  //登录成功之后进行页面的跳转，跳转到主页
          // this.$root.userid=res.data;
          // this.$root.username=this.form2.username;
          // alert(this.$root.username);
          // that.userid=res.data;
          // this.from.username=this.form2.username;
          // console.log(this.Global.id);
          // console.log(this.from.username);
          // Vue.prototype.$userMeg=userMeg;
          // console.log(userMeg);
        } else {
          this.$message({
            type: "error",
            message: res.msg
          })
        }
      })
    },
    Reset() {
      this.$router.push("/register")
      this.form.username = ''
      this.form.password = ''
    },
  }
}
</script>

<style scoped>

</style>