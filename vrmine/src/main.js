import Vue from "vue"
import App from "./App.vue"
import router from "./router"
import store from "./store"
import axios from 'axios'
import Cesium from 'cesium/Cesium'
import 'cesium/Widgets/widgets.css'
import VueCookies from 'vue-cookies'
import echarts from 'echarts' //引入echarts
Vue.prototype.$echarts = echarts //引入组件
import utils from './utils';   //获取url参数方法 
Vue.prototype.$utils = utils;   //注册全局方法


//此处为引进iviewUI，全局定义此组件
//import为ES6的写法
import iView from 'iview'
import 'iview/dist/styles/iview.css'


//main.js为整个程序的入口，即全局变量均需在此处声明
//此处告诉vue要使用iview
Vue.use(iView);
Vue.use(VueCookies);
Vue.config.productionTip = false;
Vue.prototype.bus = new Vue();
Vue.config.productionTip = false;
Vue.prototype.$axios = axios


new Vue({
  router,
  store,
  render: h => h(App),
}).$mount("#app");
