<template>
  <header>
    <h1>電商購物中心平台</h1>
    <nav>
      <ul>
        <li><a href="#">訂單紀錄</a></li>
        <li><a href="#">產品總表</a></li>
        <li><a href="#">登出</a></li>
      </ul>
    </nav>
  </header>
</template>

<script>
export default {
  name: "MemberHeader",
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
}

nav ul li a {
  text-decoration: none;
  color: #333;
}
</style>
