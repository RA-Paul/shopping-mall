<template>
  <div>
    <h1>電商購物中心系統</h1>
    <div id="form-content">
      <form @submit.prevent="handleSubmit">
        <div class="form-row">
          <label for="account">Account:</label>
          <input type="text" id="account" v-model="account" />
        </div>
        <div class="form-row">
          <label for="password">Password:</label>
          <input type="password" id="password" v-model="password" />
        </div>
        <button type="submit">Login</button>
      </form>
    </div>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "LoginForm",
  data() {
    return {
      username: "",
      password: "",
    };
  },
  methods: {
    handleSubmit() {
      // 處理表單提交邏輯
      console.log(`Account: ${this.account}, Password: ${this.password}`);
      //發起登入請求
      axios
        .post("http://localhost:8080/api/users/login", {
          account: this.account,
          password: this.password,
        })
        .then((response) => {
          console.log(response);
          // 獲取回傳內容JSON
          const data = response.data;
          console.log(data);
          // 登入成功，導航到 product-list 頁面
          this.$router.push("/product-list");
        })
        .catch((error) => {
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
  width: 300px;
  margin: 0 auto;
}
</style>
