import { createApp } from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";
import axios from "axios";

const app = createApp(App);

app.config.globalProperties.$axios = axios;
axios.defaults.baseURL = "http://localhost:8080/api";

router.beforeEach((to, from, next) => {
  if (to.meta.requireUserAuth) {
    if (store.state.user) {
      next();
    } else {
      next({
        path: "user-login",
        query: { redirect: to.fullPath },
      });
    }
  } else if (to.meta.requireMemberAuth) {
    if (store.state.member) {
      next();
    } else {
      next({
        path: "member-login",
        query: { redirect: to.fullPath },
      });
    }
  } else {
    next();
  }
});

app.use(router).use(store).mount("#app");
