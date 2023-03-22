<template>
  <div>
    <adminHeader :user="user"/>
    <div style="display: flex">
      <adminAside />
      <admin style="flex: 1"/>
    </div>
  </div>
</template>

<script>
import adminHeader from "@/components/adminheader";
import admin from "@/components/admin";
import adminAside from "@/components/adminaside";
import request from "@/utils/request";

export default {
  name: "adminLayout",
  components: {
    adminAside,
    adminHeader,
    admin,
  },
  data() {
    return {
      user: {}
    }
  },
  created() {
    this.load();
  },
  methods: {
    load() {
      let userJson = sessionStorage.getItem("user");
      if (!userJson) {
        return
      }
      let userId = JSON.parse(userJson).id
      // 从后台取出更新后的最新用户信息
      request.get("/user?id=" + userId).then(res => {
        this.user = res.data;
      })
    }
  }
}
</script>

<style scoped>

</style>