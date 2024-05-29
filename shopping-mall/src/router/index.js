import { createRouter, createWebHistory } from "vue-router";
import UserLogin from "../pages/UserLogin.vue";
import ProductList from "../pages/ProductList.vue";

const routes = [
  { path: "/", component: UserLogin },
  { path: "/product-list", component: ProductList },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
