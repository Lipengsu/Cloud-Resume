import Vue from 'vue';
import Router from 'vue-router'
Vue.use(Router);

import Layout from "@/components/layout";
import Login from "@/components/login";
// import Register from "@/components/register";
import adminLayout from "@/components/adminlayout";
// import Register2 from "@/components/regiset2";
import Register from "@/components/register";
export default new Router({
    //
    // name:'router-view',
    //********默认为hash，改变hash不会重新加载页面，因为要改为history
    mode:"history",
    routes :[
        {
            path: '/',
            name: 'layout',
            component: Layout,
            meta: {
                requireAuth: true // 标识该路由是否需要登录
            }
        },
        {
            path: '/adminlayout',
            name: 'adminLayout',
            component: adminLayout
        },
        {
            path: '/login',
            name: 'login',
            component: Login
        },
        {
            path: '/register',
            name: 'register',
            component: Register
        },
    ],
})


