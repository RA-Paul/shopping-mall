<template>
  <div>
    <h1>會員註冊</h1>
    <div id="form-content">
      <form @submit.prevent="handleSubmit">
        <div class="form-row">
          <label for="account">帳號:</label>
          <input type="text" id="account" required v-model="account" />
        </div>
        <div class="form-row">
          <label for="password">密碼:</label>
          <input type="password" id="password" required v-model="password" />
        </div>
        <button type="submit">註冊</button>
      </form>
    </div>
  </div>
</template>

<script>
export default {
  name: "MemberRegister",
  data() {
    return {
      account: "",
      password: "",
    };
  },
  methods: {
    handleSubmit() {
      if (this.account == "" || this.password == "") {
        alert("帳號或密碼不得為空");
        return;
      }

      //發起註冊請求
      this.$axios
        .post("/members/register", {
          account: this.account,
          password: this.password,
        })
        .then((response) => {
          console.log(response);
          alert("註冊成功，開始登入使用吧");
          // 註冊成功，導航到 member-login 頁面
          this.$router.push("/member-login");
        })
        .catch((error) => {
          alert("註冊失敗");
          // 登入失敗，處理錯誤
          console.error(error);
        });
    },
  },
};
</script>

<style scoped>
/* 添加一些基本樣式 */
form {
  width: 100%;
}

.form-row {
  width: 100%;
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-top: 10px;
}

button {
  margin-top: 10px;
  padding: 5px 10px;
}

#form-content {
  margin-top: 20px;
  padding: 20px;
  border: 1px solid #ccc;
  border-radius: 5px;
  width: 250px;
  margin: 0 auto;
}
</style>
