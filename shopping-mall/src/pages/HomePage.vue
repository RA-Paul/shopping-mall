<template>
  <h1>電商購物中心平台</h1>
  <div id="row">
    <div class="card" v-on:click="toMemberPage">
      <img src="../assets/images/member.png" alt="member" />
      <h1>會員登入</h1>
    </div>
    <div class="card" v-on:click="toUserPage">
      <img src="../assets/images/user.png" alt="user" />
      <h1>管理者登入</h1>
    </div>
  </div>
</template>

<script>
export default {
  name: "HomePage",
  data() {
    return {};
  },
  methods: {
    toMemberPage() {
      this.$router.push("/member-login");
    },
    toUserPage() {
      this.$router.push("/user-login");
    },
  },
};
</script>

<style>
#row {
  display: flex;
  justify-content: center;
  gap: 20px;
  flex-wrap: wrap;
}

.card {
  width: 300px;
  padding: 50px 30px;
  border: 1px solid #303030;
  border-radius: 20px;
}

.card:hover {
  cursor: pointer;
  background-color: #f0f0f0;
}

.card img {
  width: 90%;
  margin: auto;
}
</style>
