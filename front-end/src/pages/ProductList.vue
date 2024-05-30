<template>
  <MemberHeader />
  <div style="width: 90%; margin: auto">
    <div class="action-content">
      <button class="action-button" @click="creatOrderCheck">建立訂單</button>
    </div>
    <table>
      <thead>
        <tr>
          <th>挑選</th>
          <th>產品編碼</th>
          <th>產品名稱</th>
          <th>價格</th>
          <th>庫存</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="product in productList" :key="product.productId">
          <td>
            <input type="checkbox" v-model="product.checked" />
          </td>
          <td>{{ product.productId }}</td>
          <td>{{ product.productName }}</td>
          <td>{{ formatCurrency(product.price) }}</td>
          <td>{{ product.quantity }}</td>
        </tr>
      </tbody>
    </table>
  </div>

  <transition name="modal">
    <div class="modal" v-if="showModal">
      <div class="modal-content">
        <h1>訂單確認</h1>
        <div class="detail-content">
          <div>產品名稱</div>
          <div>單價</div>
          <div>數量</div>
          <div>小計</div>
        </div>
        <div
          class="detail-content"
          v-for="(detail, index) in order.orderDetail"
          :key="index"
        >
          <div>{{ detail?.product?.productName }}</div>
          <div>{{ formatCurrency(detail?.standPrice) }}</div>
          <div>
            <input
              type="number"
              v-model="detail.quantity"
              :max="detail.product.quantity"
              :min="1"
              @change="quantityChange(detail)"
            />
          </div>
          <div>{{ formatCurrency(detail?.itemPrice) }}</div>
        </div>
        <div class="flex-end-row">
          <div>總金額: {{ formatCurrency(order.price) }}</div>
        </div>
        <div class="action-content">
          <button class="action-button" @click="closeModal">取消</button>
          <button class="action-button" @click="creteOrder">確認</button>
        </div>
      </div>
    </div>
  </transition>
</template>

<script>
import MemberHeader from "@/components/MemberHeader.vue";

export default {
  name: "ProductList",
  components: {
    MemberHeader,
  },
  data() {
    return {
      productList: [],
      showModal: false,
      order: {
        orderDetail: [],
        price: 0,
      },
    };
  },
  methods: {
    getProducts() {
      this.productList = [];
      this.$axios
        .get("/products?inStock=true")
        .then((response) => {
          response.data.forEach((element) => {
            element.checked = false;
            this.productList.push(element);
          });
        })
        .catch((error) => {
          console.error(error);
        });
    },

    formatCurrency(value) {
      return new Intl.NumberFormat("en-US", {
        style: "currency",
        currency: "USD",
        maximumFractionDigits: 0,
      }).format(value);
    },

    creatOrderCheck() {
      this.order = {
        orderDetail: [],
        price: 0,
      };

      let sum_price = 0;

      this.productList.forEach((element) => {
        if (element.checked) {
          let detail = {
            product: {
              productId: element.productId,
              productName: element.productName,
              price: element.price,
              quantity: element.quantity,
            },
            standPrice: element.price,
            quantity: 1,
            itemPrice: 0,
          };

          let itemPrice = detail.standPrice * detail.quantity;
          detail.itemPrice = itemPrice;
          sum_price += itemPrice;

          console.log("Detail before pushing:", detail);

          this.order.orderDetail.push(detail);
        }
      });

      this.order.price = sum_price;

      if (this.order.orderDetail.length === 0) {
        alert("請選擇商品");
        return;
      }

      this.openModal();
    },

    quantityChange(detail) {
      detail.itemPrice = detail.standPrice * detail.quantity;
      this.priceCalculate();
    },

    priceCalculate() {
      let sum_price = 0;
      this.order.orderDetail.forEach((element) => {
        sum_price += element.itemPrice;
      });

      this.order.price = sum_price;
    },

    creteOrder() {
      let buyItemList = [];
      this.order.orderDetail.forEach((element) => {
        let item = {
          productId: element.product.productId,
          quantity: element.quantity,
        };
        buyItemList.push(item);
      });

      let member_id = this.$store.state.member.memberId;

      this.$axios
        .post("/members/" + member_id + "/orders", {
          buyItemList: buyItemList,
        })
        .then((response) => {
          console.log(response);
          alert("訂單建立成功");
          this.getProducts();
          this.closeModal();
        })
        .catch((error) => {
          alert("訂單建立失敗");
          console.error(error);
        });
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

<style scoped>
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

tr:nth-child(1) {
  max-width: 4em;
}

.action-content {
  display: flex;
  justify-content: flex-end;
  margin-top: 20px;
  gap: 10px;
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
  min-width: 768px;
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

.detail-content {
  display: grid;
  grid-template-columns: 2fr 1fr 1fr 1fr;
  padding: 20px 10px;
}

.detail-content:nth-child(odd) {
  background-color: #f0f0f0;
}

.detail-content:nth-child(even) {
  background-color: #acacac;
}

.flex-end-row {
  display: flex;
  justify-content: flex-end;
  padding: 20px 10px;
}

input[type="checkbox"] {
  width: 20px;
  height: 20px;
}

@media screen and (max-width: 768px) {
  .modal-content {
    min-width: 90%;
  }

  .detail-content {
    grid-template-columns: 2fr 1fr;
  }
}
</style>
