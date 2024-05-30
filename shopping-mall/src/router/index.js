import { createRouter, createWebHistory } from "vue-router";
import UserLogin from "../pages/UserLogin.vue";
import HomePage from "../pages/HomePage.vue";
import MemberLogin from "../pages/MemberLogin.vue";
import ProductSetting from "../pages/ProductSetting.vue";
import ProductList from "../pages/ProductList.vue";

const routes = [
  { path: "/", component: HomePage },
  { path: "/user-login", component: UserLogin },
  { path: "/member-login", component: MemberLogin },
  {
    path: "/product-setting",
    component: ProductSetting,
    meta: {
      requireUserAuth: true,
    },
  },
  {
    path: "/product-list",
    component: ProductList,
    meta: {
      requireMemberAuth: true,
    },
  },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
