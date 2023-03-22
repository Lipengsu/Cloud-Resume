<template>
  <div>
    <b-navbar toggleable="lg" type="dark" variant="info">
      <b-navbar-brand href="#">Enterprise recruitment</b-navbar-brand>

      <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

      <b-collapse id="nav-collapse" is-nav>
        <b-navbar-nav>
        </b-navbar-nav>
        <b-navbar-nav class="ml-auto">
          <b-nav-form>

          </b-nav-form>

          <b-nav-item>
<!--            <locale-changer/>-->
          </b-nav-item>
          <b-nav-item-dropdown right>
            <!-- Using 'button-content' slot -->
            <template #button-content>
              <em >{{ user.username }}</em>
            </template>
            <b-dropdown-item href="#">个人信息</b-dropdown-item>
            <b-dropdown-item href="#">修改密码</b-dropdown-item>
            <b-dropdown-item @click="$router.push('/login')">退出登录</b-dropdown-item>
          </b-nav-item-dropdown>
        </b-navbar-nav>
      </b-collapse>
    </b-navbar>
  </div>
</template>

<script>
// import localeChanger from './form/localeChanger'
// import {mapGetters} from "vuex";
// import form from "@/data/form";

export default {
  name: 'adminHeader',
  components:{},
  props: ['user'],
  data(){
    return{
    }
  },
  // computed: {
  //   ...mapGetters([
  //       "getFullName"
  //   ]),
  // },

  // created() {
  //   this.load()
  // },
  // methods:{
  //   load(){
  //     this.username=form.fullName;
  //     console.log(form.fullName);
  //   }
  // }
}
</script>
