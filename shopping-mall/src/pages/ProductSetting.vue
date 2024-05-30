<template>
  <div style="width: 90%; margin: auto">
    <div class="action-content">
      <button class="action-button" @click="openModal">新增</button>
    </div>
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

  <transition name="modal">
    <div class="modal" v-if="showModal">
      <div class="modal-content">
        <div id="form-content">
          <form @submit.prevent="handleSubmit">
            <div class="form-row">
              <label for="productId">產品編號:</label>
              <input
                type="text"
                id="productId"
                v-model="product.productId"
                required
              />
            </div>
            <div class="form-row">
              <label for="productName">產品名稱:</label>
              <input
                type="text"
                id="productName"
                v-model="product.productName"
                required
              />
            </div>
            <div class="form-row">
              <label for="price">價格:</label>
              <input
                type="number"
                id="price"
                v-model="product.price"
                required
              />
            </div>
            <div class="form-row">
              <label for="quantity">庫存:</label>
              <input
                type="number"
                id="quantity"
                v-model="product.quantity"
                required
              />
            </div>
            <div class="form-buttons">
              <button class="action-button" @click="closeModal">取消</button>
              <button type="submit" class="action-button">創建</button>
            </div>
          </form>
        </div>
      </div>
    </div>
  </transition>
</template>

<script>
export default {
  name: "ProductSetting",
  data() {
    return {
      productList: [],
      showModal: false,
      product: {
        productId: "",
        productName: "",
        price: 0,
        quantity: 0,
      },
    };
  },
  methods: {
    getProducts() {
      this.productList = [];
      this.$axios
        .get("/products")
        .then((response) => {
          this.productList = response.data;
        })
        .catch((error) => {
          console.error(error);
        });
    },

    createProduct() {
      // 檢差輸入項目
      if (
        !this.product.productId ||
        !this.product.productName ||
        !this.product.price ||
        !this.product.quantity
      ) {
        alert("請填寫所有欄位");
        return;
      }

      this.$axios
        .post("/products", this.product)
        .then((response) => {
          console.log(response);
          this.getProducts();
          this.closeModal();
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

    openModal() {
      this.showModal = true;
    },

    closeModal() {
      this.showModal = false;
    },
  },
  mounted() {
    this.getProducts();
  },
};
</script>

<style>
table {
  width: 100%;
  margin-top: 20px;
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

.action-content {
  display: flex;
  justify-content: flex-end;
  margin-top: 20px;
}

.action-button {
  padding: 5px 10px;
  border: 1px solid #3c3c3c;
  border-radius: 5px;
  background-color: #f0f0f0;
}

.action-button:hover {
  cursor: pointer;
  background-color: #3c3c3c;
  color: white;
}

.modal {
  position: fixed;
  z-index: 9998;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.5);
  display: flex;
  justify-content: center;
  align-items: center;
}

.modal-content {
  background: white;
  padding: 20px;
  border-radius: 5px;
}

.modal-enter-active,
.modal-leave-active {
  transition: opacity 0.5s;
}

.modal-enter,
.modal-leave-to {
  opacity: 0;
}

#form-content {
  margin-top: 20px;
  padding: 20px;
  border: 1px solid #ccc;
  border-radius: 5px;
  width: 300px;
  margin: 0 auto;
}

.form-row {
  width: 100%;
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-top: 10px;
}

.form-buttons {
  display: flex;
  justify-content: space-evenly;
  margin-top: 10px;
}
</style>
