import Vue from "vue";
import Router from "vue-router";

Vue.use(Router);

//记录url的映射
const router = new Router({
  routes: [

    
    {
      path: "",
      name: "home",
      component: () => import( "./views/Home.vue"),
      meta : {
        title : "主页"
      },           
    },
    {
      path: "/404",
      name: "404",
      component: () => import("./views/404.vue"),
      meta : {
        title : "非法访问"
      }
    },    
    {
      path: "/help",
      name: "help",
      component: () => import("./views/help/Help.vue"),
      meta : {
        title : "帮助"
      }
    }
  ]
});





export default router
//引入iView
import iView from 'iview';
Vue.use(iView);
//vue导航守卫
router.beforeEach((to, from, next) => {
  //进度条
  iView.LoadingBar.start();
  //标题
  if(to.meta && to.meta.title) document.title = to.meta.title
  next()
})

router.afterEach(() => {
  //进度条
  iView.LoadingBar.finish();
})