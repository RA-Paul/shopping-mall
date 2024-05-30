<template>
  <MemberHeader />
  <div style="width: 90%; margin: auto">
    <table>
      <thead>
        <tr>
          <th>訂單編碼</th>
          <th>價格</th>
          <th>付款狀態</th>
          <th>內容</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="(order, index) in orderList" :key="index">
          <td>{{ order.orderId }}</td>
          <td>{{ formatCurrency(order.price) }}</td>
          <td v-if="order.payStatus == 0">未付款</td>
          <td v-if="order.payStatus == 1">已付款</td>
          <td>
            <img
              src="../assets/images/rectangle-list.png"
              alt="rectangle-list"
              width="20px"
              height="20px"
              @click="showOrderDetails(order)"
            />
          </td>
        </tr>
      </tbody>
    </table>
  </div>

  <transition name="modal">
    <div class="modal" v-if="showModal">
      <div class="modal-content">
        <h1>{{ order.orderId }}</h1>
        <div class="detail-content">
          <div>產品編號</div>
          <div>單價</div>
          <div>數量</div>
          <div>小計</div>
        </div>
        <div
          class="detail-content"
          v-for="(detail, index) in order.orderDetail"
          :key="index"
        >
          <div>{{ detail?.productId }}</div>
          <div>{{ formatCurrency(detail?.standPrice) }}</div>
          <div>{{ detail.quantity }}</div>
          <div>{{ formatCurrency(detail?.itemPrice) }}</div>
        </div>
        <div class="flex-end-row">
          <div>總金額: {{ formatCurrency(order.price) }}</div>
        </div>
        <div class="action-content">
          <button class="action-button" @click="closeModal">確認</button>
        </div>
      </div>
    </div>
  </transition>
</template>

<script>
import MemberHeader from "@/components/MemberHeader.vue";

export default {
  name: "OrderList",
  components: {
    MemberHeader,
  },
  data() {
    return {
      orderList: [],
      showModal: false,
      order: {
        orderDetail: [],
        price: 0,
      },
    };
  },
  methods: {
    getOrders() {
      this.orderList = [];

      let member_id = this.$store.state.member.memberId;

      this.$axios
        .get("/members/" + member_id + "/orders")
        .then((response) => {
          response.data.forEach((element) => {
            this.orderList.push(element);
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

    showOrderDetails(order) {
      this.order = {
        orderDetail: [],
        orderId: order.orderId,
        price: order.price,
        payStatus: order.payStatus,
      };

      this.$axios
        .get("/orders/" + order.orderId + "/details")
        .then((response) => {
          response.data.forEach((element) => {
            this.order.orderDetail.push(element);
          });
          this.openModal();
        })
        .catch((error) => {
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
    this.getOrders();
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
