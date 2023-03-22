<template>
  <div style="width: 100%;height: 100vh;background-color: #17A2B8;overflow: hidden">
    <div style="width: 400px;margin: 150px auto">
      <div style="color: white;font-size: 30px; text-align: center">
        欢迎注册！
      </div>
      <div class="wrap">
        <el-form class="loginForm" :model="loginForm" :rules="loginFormRules" ref="loginFormRef"
                 label-position="top">
          <el-form-item label="用户名" prop="username">
            <el-input v-model="loginForm.username"></el-input>
          </el-form-item>
          <el-form-item label="输入密码" prop="password" type="password">
            <el-input type="password" v-model="loginForm.password"></el-input>
          </el-form-item>
          <el-form-item label="再次输入密码" prop="repassword" type="password">
            <el-input  type="password" v-model="loginForm.repassword"></el-input>
          </el-form-item>
          <el-form-item label="手机号" prop="phone">
            <el-input v-model="loginForm.phone"></el-input>
          </el-form-item>
          <el-form-item label="手机验证码" prop="captcha">
            <el-input v-model=" loginForm.captcha">
              <template slot="append">
                <!--  -->
                <el-button v-if="loginForm.showloginCode" type="primary"
                           @click="getloginPhoneCode">获取验证码</el-button>
                <div v-else>{{ loginForm.count }}</div>
              </template>
            </el-input>
          </el-form-item>
          <el-form-item class="btns">
            <el-button type="primary" @click="handleLogin">注册</el-button>
          </el-form-item>
        </el-form>
      </div>
    </div>
  </div>
</template>

<script>
import request from "@/utils/request";
// import login from "@/components/login";

export default {
  name: "register",
  data() {
    // 正则验证手机号是否合法
    var checkMobile = (rules, value, callback) => {
      const regMobile = /^(0|86|17951)?(13[0-9]|15[0123456789]|17[678]|18[0-9]|14[57])[0-9]{8}$/;
      if (regMobile.test(value) == true) {
        return callback();
      } else {
        callback(new Error("请输入合法的手机号"));
      }
    };

    // 验证输入的手机号验证码是否和手机接收到的验证码相同
    var checkPhoneCode = (rules, value, callback) => {
      if (value == this.loginForm.captcha) {
        return callback();
      } else {
        callback(new Error("验证码错误"));
      }
    };

    return{
      loginForm: {
        username:"",
        password:"",
        repassword:"",
        phone: "", //手机号
        captcha: "", //验证码
        timer: null, //定时器的开关
        showloginCode: true, //获取成功验证码后倒计时跟获取不成功后没有倒计时按钮的开关
        count: "", //倒计时
      },
      userform:{
        username:"",
        password: "",
        phone:"",
        role:"",
      },
      // 验证规则
      loginFormRules: {
        phone: [{
          required: true,
          message: "请输入手机号",
          trigger: "blur"
        },
          {
            validator: checkMobile,
            trigger: "blur"
          },
        ],
        captcha: [{
          required: true,
          message: "请输入手机验证码",
          trigger: "blur"
        },
          {
            validator: checkPhoneCode,
            trigger: "blur"
          },
        ],
      },
    }
  },
  methods:{
    getloginPhoneCode() {

      // 如果没有输入手机号，则不往下执行
      if (this.loginForm.phone == "") {
        return false;
      }

      let phone = this.loginForm.phone
      request.get("/mes/sendSMS?mobile="+phone).then(() => {
        // console.log(res);
        this.$message.success("已发送");
          const time = 60;
          if (!this.loginForm.timer) {
            this.loginForm.showloginCode = false;
            this.loginForm.count = time;
            this.loginForm.timer = setInterval(() => {
              if (
                  this.loginForm.count > 0 &&
                  this.loginForm.count <= time
              ) {
                this.loginForm.count -= 1;
              } else {
                this.loginForm.showloginCode = true;
                clearInterval(this.loginForm.timer);
                this.loginForm.timer = null;
              }
            }, 1000);
          }
        // }
      });
    },
    handleLogin() {
      //点击登录
      request.get("/mes/checkCode", this.loginForm.captcha).then(res => {
        console.log(res);
      }).catch(error => {
        console.log(error + "验证码输入错误")
      })
      this.userform.username=this.loginForm.username;
      this.userform.password=this.loginForm.password;
      this.userform.phone=this.loginForm.phone;
      this.userform.role=2;
      request.post("user",this.userform).then(res=>{
        console.log(this.userform);
        console.log(res);
        this.$message.success("注册成功，请登录")
        this.$router.push("/login");
      }).catch(error => {
        console.log(error + "验证码输入错误")
      })
    },

  }
}
</script>

<style scoped>
.loginForm {
  width: 500px;
  margin: 0 auto;
}
.btns {
  text-align: right;
}
</style>