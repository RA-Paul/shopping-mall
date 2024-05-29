<template>
  <div>
    <table>
      <thead>
        <tr>
          <th>產品編碼</th>
          <th>產品名稱</th>
          <th>價格</th>
          <th>庫存</th>
          <th>編輯</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="product in productList" :key="product.productId">
          <td>{{ product.productId }}</td>
          <td>{{ product.productName }}</td>
          <td>{{ formatCurrency(product.price) }}</td>
          <td>{{ product.quantity }}</td>
          <td></td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import axios from "axios";
export default {
  name: "ProductList",
  data() {
    return {
      productList: [
        {
          productId: "P001",
          productName: "osii 舒壓按摩椅",
          price: 98000,
          quantity: 5,
        },
        {
          productId: "P002",
          productName: "網友最愛起司蛋糕",
          price: 1200,
          quantity: 50,
        },
        {
          productId: "P003",
          productName: "真愛密碼項鍊",
          price: 8500,
          quantity: 20,
        },
      ],
    };
  },
  methods: {
    getProducts() {
      this.productList = [];
      axios
        .get("http://localhost:8080/api/products")
        .then((response) => {
          this.productList = response.data;
        })
        .catch((error) => {
          console.error(error);
        });
    },

    formatCurrency(value) {
      // Implement your currency formatting logic here
      return new Intl.NumberFormat("en-US", {
        style: "currency",
        currency: "USD",
      }).format(value);
    },
  },
  mounted() {
    this.getProducts();
  },
};
</script>

<style>
table {
  width: 90%;
  margin: auto;
  border-bottom: 1px solid #000000;
  border-right: 1px solid #000000;
  border-collapse: collapse;
}

thead {
  background-color: #f0f0f0;
}

th,
td {
  padding: 10px;
  border-top: 1px solid #000000;
  border-left: 1px solid #000000;
}
</style>
