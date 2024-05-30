<template>
  <header>
    <h1>電商購物中心平台</h1>
    <nav>
      <ul>
        <li @click="toProductSetting">產品總表</li>
        <li @click="logOut">登出</li>
      </ul>
    </nav>
  </header>
</template>

<script>
export default {
  name: "UserHeader",
  methods: {
    toProductSetting() {
      this.$router.push("/product-setting");
    },

    logOut() {
      // 清除登入資訊
      this.$store.commit("SET_MEMBER", null);
      // 導航到首頁
      this.$router.push("/");
    },
  },
};
</script>

<style scoped>
header {
  background-color: #f2f2f2;
  padding: 10px;
  display: flex;
  justify-content: space-between;
  align-items: center;
}

h1 {
  margin: 0;
}

nav ul {
  list-style-type: none;
  padding: 0;
  margin: 0;
}

nav ul li {
  display: inline-block;
  margin-right: 10px;
  cursor: pointer;
}
</style>
