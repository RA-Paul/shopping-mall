import { createRouter, createWebHistory } from "vue-router";
import UserLogin from "../pages/UserLogin.vue";
import UserRegister from "../pages/UserRegister.vue";
import HomePage from "../pages/HomePage.vue";
import MemberLogin from "../pages/MemberLogin.vue";
import MemberRegister from "../pages/MemberRegister.vue";
import ProductSetting from "../pages/ProductSetting.vue";
import ProductList from "../pages/ProductList.vue";
import OrderList from "../pages/OrderList.vue";

const routes = [
  { path: "/", component: HomePage },
  { path: "/user-login", component: UserLogin },
  { path: "/user-register", component: UserRegister },
  { path: "/member-login", component: MemberLogin },
  { path: "/member-register", component: MemberRegister },
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
  {
    path: "/order-list",
    component: OrderList,
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
