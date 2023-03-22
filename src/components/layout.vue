<template>
  <div>
    <app-header :user="user"/>
    <app-container/>
  </div>
</template>

<script>
import appHeader from "@/components/header";
import appContainer from "@/components/container";
import request from "@/utils/request";
import form from "@/data/form";

export default {
  name: "layout",
  components: {
    appHeader,
    appContainer,
  },
  data() {
    return {
      user: {}
    }
  },
  created() {
    this.refreshUser()
  },
  methods: {
    refreshUser() {
      let userJson = sessionStorage.getItem("user");
      if (!userJson) {
        return
      }
      let userId = JSON.parse(userJson).id
      // 从后台取出更新后的最新用户信息
      request.get("/user?id=" + userId).then(res => {
        this.user = res.data
        console.log(res);
        form.fullName = res.data.fullname;
        form.job = res.data.job;
        form.phone = res.data.phone;
        form.email = res.data.email;
        form.resume = res.data.resume;
        form.experiences = res.data.experiencesList;
        console.log(form.experiences.fromTo);
        form.projects = res.data.projectsList;
        form.educations = res.data.educationsList;
        form.languages = res.data.languages;
        form.links = res.data.links.split(",");
        // form.socialNetworks=res.data.socialNetworks;
        // form.experiences.fromTo=res.data.experiencesList.fromto.split(",");
        form.interests = res.data.links.split(",");
        // for (var i=0;i<res.data.experiencesList.length;i++){
        //
        //   form.experiences.fromTo=res.data.experiencesList.fromto.split(",");
        // }
        //
        // form.projects=res.data.projects;
        // form.educations=res.data.educations;
        // form.skills=res.data.skills;
        // form.languages=res.data.languages;
        // form.interests=res.data.interests;
        // form.certificate=res.data.certificate;
      })
    }
  }
}
</script>

<style scoped>

</style>