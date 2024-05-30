import Vuex from "vuex";

export default new Vuex.Store({
  state: {
    token: sessionStorage.getItem("token"),
    user: JSON.parse(sessionStorage.getItem("user")),
    member: JSON.parse(sessionStorage.getItem("member")),
  },
  mutations: {
    SET_TOKENN: (state, token) => {
      state.token = token;
      sessionStorage.setItem("token", token);
    },
    SET_USER: (state, user) => {
      state.user = user;
      sessionStorage.setItem("user", JSON.stringify(user));
    },
    SET_MEMBER: (state, member) => {
      state.member = member;
      sessionStorage.setItem("member", JSON.stringify(member));
    },
    REMOVE_INFO: (state) => {
      state.token = "";
      state.user = {};
      state.member = {};
      sessionStorage.setItem("token", "");
      sessionStorage.setItem("user", JSON.stringify(""));
      sessionStorage.setItem("member", JSON.stringify(""));
    },
  },
  getters: {},
  actions: {},
  modules: {},
});
