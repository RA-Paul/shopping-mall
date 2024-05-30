<template>
  <div>
    <h1>管理者登入</h1>
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
        <button type="submit">登入</button>
        <p><a @click="toUserRegister">還不是管理者？</a></p>
      </form>
    </div>
  </div>
</template>

<script>
export default {
  name: "UserLogin",
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
      //發起登入請求
      this.$axios
        .post("/users/login", {
          account: this.account,
          password: this.password,
        })
        .then((response) => {
          console.log(response);
          // 獲取回傳內容JSON
          const data = response.data;

          //紀錄登入資訊
          this.$store.commit("SET_USER", data);

          // 登入成功，導航到 product-setting 頁面
          this.$router.push("/product-setting");
        })
        .catch((error) => {
          alert("帳號或密碼錯誤");
          // 登入失敗，處理錯誤
          console.error(error);
        });
    },
    toUserRegister() {
      this.$router.push("/user-register");
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

p {
  cursor: pointer;
  font-size: 0.2em;
  margin-bottom: 0px;
}

a:hover {
  color: blue;
}
</style>
