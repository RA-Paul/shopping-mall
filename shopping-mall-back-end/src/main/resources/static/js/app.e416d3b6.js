(function(){"use strict";var t={3146:function(t,e,r){var o=r(5130),n=r(6768);const a={id:"app"};function s(t,e,r,o,s,l){const u=(0,n.g2)("router-view");return(0,n.uX)(),(0,n.CE)("div",a,[(0,n.bF)(u)])}var l={name:"App",components:{}},u=r(1241);const i=(0,u.A)(l,[["render",s]]);var d=i,c=r(1387);const p=t=>((0,n.Qi)("data-v-57a601ac"),t=t(),(0,n.jt)(),t),m=p((()=>(0,n.Lk)("h1",null,"管理者登入",-1))),h={id:"form-content"},k={class:"form-row"},L=p((()=>(0,n.Lk)("label",{for:"account"},"帳號:",-1))),b={class:"form-row"},v=p((()=>(0,n.Lk)("label",{for:"password"},"密碼:",-1))),f=p((()=>(0,n.Lk)("button",{type:"submit"},"登入",-1)));function g(t,e,r,a,s,l){return(0,n.uX)(),(0,n.CE)("div",null,[m,(0,n.Lk)("div",h,[(0,n.Lk)("form",{onSubmit:e[3]||(e[3]=(0,o.D$)(((...t)=>l.handleSubmit&&l.handleSubmit(...t)),["prevent"]))},[(0,n.Lk)("div",k,[L,(0,n.bo)((0,n.Lk)("input",{type:"text",id:"account",required:"","onUpdate:modelValue":e[0]||(e[0]=t=>s.account=t)},null,512),[[o.Jo,s.account]])]),(0,n.Lk)("div",b,[v,(0,n.bo)((0,n.Lk)("input",{type:"password",id:"password",required:"","onUpdate:modelValue":e[1]||(e[1]=t=>s.password=t)},null,512),[[o.Jo,s.password]])]),f,(0,n.Lk)("p",null,[(0,n.Lk)("a",{onClick:e[2]||(e[2]=(...t)=>l.toUserRegister&&l.toUserRegister(...t))},"還不是管理者？")])],32)])])}r(4114);var y={name:"UserLogin",data(){return{account:"",password:""}},methods:{handleSubmit(){""!=this.account&&""!=this.password?this.$axios.post("/users/login",{account:this.account,password:this.password}).then((t=>{console.log(t);const e=t.data;this.$store.commit("SET_USER",e),this.$router.push("/product-setting")})).catch((t=>{alert("帳號或密碼錯誤"),console.error(t)})):alert("帳號或密碼不得為空")},toUserRegister(){this.$router.push("/user-register")}}};const w=(0,u.A)(y,[["render",g],["__scopeId","data-v-57a601ac"]]);var C=w;const S=t=>((0,n.Qi)("data-v-4dc590c5"),t=t(),(0,n.jt)(),t),M=S((()=>(0,n.Lk)("h1",null,"管理者註冊",-1))),_={id:"form-content"},E={class:"form-row"},I=S((()=>(0,n.Lk)("label",{for:"account"},"帳號:",-1))),O={class:"form-row"},P=S((()=>(0,n.Lk)("label",{for:"password"},"密碼:",-1))),q=S((()=>(0,n.Lk)("button",{type:"submit"},"註冊",-1)));function U(t,e,r,a,s,l){return(0,n.uX)(),(0,n.CE)("div",null,[M,(0,n.Lk)("div",_,[(0,n.Lk)("form",{onSubmit:e[2]||(e[2]=(0,o.D$)(((...t)=>l.handleSubmit&&l.handleSubmit(...t)),["prevent"]))},[(0,n.Lk)("div",E,[I,(0,n.bo)((0,n.Lk)("input",{type:"text",id:"account",required:"","onUpdate:modelValue":e[0]||(e[0]=t=>s.account=t)},null,512),[[o.Jo,s.account]])]),(0,n.Lk)("div",O,[P,(0,n.bo)((0,n.Lk)("input",{type:"password",id:"password",required:"","onUpdate:modelValue":e[1]||(e[1]=t=>s.password=t)},null,512),[[o.Jo,s.password]])]),q],32)])])}var $={name:"UserRegister",data(){return{account:"",password:""}},methods:{handleSubmit(){""!=this.account&&""!=this.password?this.$axios.post("/users/register",{account:this.account,password:this.password}).then((t=>{console.log(t),alert("註冊成功，開始登入使用吧"),this.$router.push("/user-login")})).catch((t=>{alert("註冊失敗"),console.error(t)})):alert("帳號或密碼不得為空")}}};const x=(0,u.A)($,[["render",U],["__scopeId","data-v-4dc590c5"]]);var X=x,D=r.p+"img/member.1006e362.png",F=r.p+"img/user.84cfcc49.png";const N=t=>((0,n.Qi)("data-v-dea1b65c"),t=t(),(0,n.jt)(),t),A=N((()=>(0,n.Lk)("h1",null,"電商購物中心平台",-1))),j={id:"row"},J=N((()=>(0,n.Lk)("img",{src:D,alt:"member"},null,-1))),R=N((()=>(0,n.Lk)("h1",null,"會員登入",-1))),V=[J,R],Q=N((()=>(0,n.Lk)("img",{src:F,alt:"user"},null,-1))),T=N((()=>(0,n.Lk)("h1",null,"管理者登入",-1))),H=[Q,T];function K(t,e,r,o,a,s){return(0,n.uX)(),(0,n.CE)(n.FK,null,[A,(0,n.Lk)("div",j,[(0,n.Lk)("div",{class:"card",onClick:e[0]||(e[0]=(...t)=>s.toMemberPage&&s.toMemberPage(...t))},V),(0,n.Lk)("div",{class:"card",onClick:e[1]||(e[1]=(...t)=>s.toUserPage&&s.toUserPage(...t))},H)])],64)}var B={name:"HomePage",data(){return{}},methods:{toMemberPage(){this.$router.push("/member-login")},toUserPage(){this.$router.push("/user-login")}}};const z=(0,u.A)(B,[["render",K],["__scopeId","data-v-dea1b65c"]]);var G=z;const W=t=>((0,n.Qi)("data-v-00071120"),t=t(),(0,n.jt)(),t),Y=W((()=>(0,n.Lk)("h1",null,"會員登入",-1))),Z={id:"form-content"},tt={class:"form-row"},et=W((()=>(0,n.Lk)("label",{for:"account"},"帳號:",-1))),rt={class:"form-row"},ot=W((()=>(0,n.Lk)("label",{for:"password"},"密碼:",-1))),nt=W((()=>(0,n.Lk)("button",{type:"submit"},"登入",-1)));function at(t,e,r,a,s,l){return(0,n.uX)(),(0,n.CE)("div",null,[Y,(0,n.Lk)("div",Z,[(0,n.Lk)("form",{onSubmit:e[3]||(e[3]=(0,o.D$)(((...t)=>l.handleSubmit&&l.handleSubmit(...t)),["prevent"]))},[(0,n.Lk)("div",tt,[et,(0,n.bo)((0,n.Lk)("input",{type:"text",id:"account",required:"","onUpdate:modelValue":e[0]||(e[0]=t=>s.account=t)},null,512),[[o.Jo,s.account]])]),(0,n.Lk)("div",rt,[ot,(0,n.bo)((0,n.Lk)("input",{type:"password",id:"password",required:"","onUpdate:modelValue":e[1]||(e[1]=t=>s.password=t)},null,512),[[o.Jo,s.password]])]),nt,(0,n.Lk)("p",null,[(0,n.Lk)("a",{onClick:e[2]||(e[2]=(...t)=>l.toMemberRegister&&l.toMemberRegister(...t))},"還不是會員？")])],32)])])}var st={name:"MemberLogin",data(){return{account:"",password:""}},methods:{handleSubmit(){""!=this.account&&""!=this.password?this.$axios.post("/members/login",{account:this.account,password:this.password}).then((t=>{console.log(t);const e=t.data;console.log(e),this.$store.commit("SET_MEMBER",e),this.$router.push("/product-list")})).catch((t=>{alert("帳號或密碼錯誤"),console.error(t)})):alert("帳號或密碼不得為空")},toMemberRegister(){this.$router.push("/member-register")}}};const lt=(0,u.A)(st,[["render",at],["__scopeId","data-v-00071120"]]);var ut=lt;const it=t=>((0,n.Qi)("data-v-455a653e"),t=t(),(0,n.jt)(),t),dt=it((()=>(0,n.Lk)("h1",null,"會員註冊",-1))),ct={id:"form-content"},pt={class:"form-row"},mt=it((()=>(0,n.Lk)("label",{for:"account"},"帳號:",-1))),ht={class:"form-row"},kt=it((()=>(0,n.Lk)("label",{for:"password"},"密碼:",-1))),Lt=it((()=>(0,n.Lk)("button",{type:"submit"},"註冊",-1)));function bt(t,e,r,a,s,l){return(0,n.uX)(),(0,n.CE)("div",null,[dt,(0,n.Lk)("div",ct,[(0,n.Lk)("form",{onSubmit:e[2]||(e[2]=(0,o.D$)(((...t)=>l.handleSubmit&&l.handleSubmit(...t)),["prevent"]))},[(0,n.Lk)("div",pt,[mt,(0,n.bo)((0,n.Lk)("input",{type:"text",id:"account",required:"","onUpdate:modelValue":e[0]||(e[0]=t=>s.account=t)},null,512),[[o.Jo,s.account]])]),(0,n.Lk)("div",ht,[kt,(0,n.bo)((0,n.Lk)("input",{type:"password",id:"password",required:"","onUpdate:modelValue":e[1]||(e[1]=t=>s.password=t)},null,512),[[o.Jo,s.password]])]),Lt],32)])])}var vt={name:"MemberRegister",data(){return{account:"",password:""}},methods:{handleSubmit(){""!=this.account&&""!=this.password?this.$axios.post("/members/register",{account:this.account,password:this.password}).then((t=>{console.log(t),alert("註冊成功，開始登入使用吧"),this.$router.push("/member-login")})).catch((t=>{alert("註冊失敗"),console.error(t)})):alert("帳號或密碼不得為空")}}};const ft=(0,u.A)(vt,[["render",bt],["__scopeId","data-v-455a653e"]]);var gt=ft,yt=r(4232);const wt=t=>((0,n.Qi)("data-v-a36eece2"),t=t(),(0,n.jt)(),t),Ct={style:{width:"90%",margin:"auto"}},St={class:"action-content"},Mt=wt((()=>(0,n.Lk)("thead",null,[(0,n.Lk)("tr",null,[(0,n.Lk)("th",null,"產品編碼"),(0,n.Lk)("th",null,"產品名稱"),(0,n.Lk)("th",null,"價格"),(0,n.Lk)("th",null,"庫存")])],-1))),_t={key:0,class:"modal"},Et={class:"modal-content"},It={id:"form-content"},Ot={class:"form-row"},Pt=wt((()=>(0,n.Lk)("label",{for:"productName"},"產品名稱:",-1))),qt={class:"form-row"},Ut=wt((()=>(0,n.Lk)("label",{for:"price"},"價格:",-1))),$t={class:"form-row"},xt=wt((()=>(0,n.Lk)("label",{for:"quantity"},"庫存:",-1))),Xt={class:"form-buttons"},Dt=wt((()=>(0,n.Lk)("button",{type:"submit",class:"action-button"},"創建",-1)));function Ft(t,e,r,a,s,l){const u=(0,n.g2)("UserHeader");return(0,n.uX)(),(0,n.CE)(n.FK,null,[(0,n.bF)(u),(0,n.Lk)("div",Ct,[(0,n.Lk)("div",St,[(0,n.Lk)("button",{class:"action-button",onClick:e[0]||(e[0]=(...t)=>l.openModal&&l.openModal(...t))},"新增")]),(0,n.Lk)("table",null,[Mt,(0,n.Lk)("tbody",null,[((0,n.uX)(!0),(0,n.CE)(n.FK,null,(0,n.pI)(s.productList,(t=>((0,n.uX)(),(0,n.CE)("tr",{key:t.productId},[(0,n.Lk)("td",null,(0,yt.v_)(t.productId),1),(0,n.Lk)("td",null,(0,yt.v_)(t.productName),1),(0,n.Lk)("td",null,(0,yt.v_)(l.formatCurrency(t.price)),1),(0,n.Lk)("td",null,(0,yt.v_)(t.quantity),1)])))),128))])])]),(0,n.bF)(o.eB,{name:"modal"},{default:(0,n.k6)((()=>[s.showModal?((0,n.uX)(),(0,n.CE)("div",_t,[(0,n.Lk)("div",Et,[(0,n.Lk)("div",It,[(0,n.Lk)("form",{onSubmit:e[5]||(e[5]=(0,o.D$)(((...t)=>l.createProduct&&l.createProduct(...t)),["prevent"]))},[(0,n.Lk)("div",Ot,[Pt,(0,n.bo)((0,n.Lk)("input",{type:"text",id:"productName","onUpdate:modelValue":e[1]||(e[1]=t=>s.product.productName=t),required:""},null,512),[[o.Jo,s.product.productName]])]),(0,n.Lk)("div",qt,[Ut,(0,n.bo)((0,n.Lk)("input",{type:"number",id:"price","onUpdate:modelValue":e[2]||(e[2]=t=>s.product.price=t),required:""},null,512),[[o.Jo,s.product.price]])]),(0,n.Lk)("div",$t,[xt,(0,n.bo)((0,n.Lk)("input",{type:"number",id:"quantity","onUpdate:modelValue":e[3]||(e[3]=t=>s.product.quantity=t),required:""},null,512),[[o.Jo,s.product.quantity]])]),(0,n.Lk)("div",Xt,[(0,n.Lk)("button",{type:"button",class:"action-button",onClick:e[4]||(e[4]=(...t)=>l.closeModal&&l.closeModal(...t))}," 取消 "),Dt])],32)])])])):(0,n.Q3)("",!0)])),_:1})],64)}const Nt=t=>((0,n.Qi)("data-v-3f6d54d0"),t=t(),(0,n.jt)(),t),At=Nt((()=>(0,n.Lk)("h1",null,"電商購物中心平台",-1)));function jt(t,e,r,o,a,s){return(0,n.uX)(),(0,n.CE)("header",null,[At,(0,n.Lk)("nav",null,[(0,n.Lk)("ul",null,[(0,n.Lk)("li",{onClick:e[0]||(e[0]=(...t)=>s.toProductSetting&&s.toProductSetting(...t))},"產品總表"),(0,n.Lk)("li",{onClick:e[1]||(e[1]=(...t)=>s.logOut&&s.logOut(...t))},"登出")])])])}var Jt={name:"UserHeader",methods:{toProductSetting(){this.$router.push("/product-setting")},logOut(){this.$store.commit("SET_MEMBER",null),this.$router.push("/")}}};const Rt=(0,u.A)(Jt,[["render",jt],["__scopeId","data-v-3f6d54d0"]]);var Vt=Rt,Qt={name:"ProductSetting",components:{UserHeader:Vt},data(){return{productList:[],showModal:!1,product:{productName:"",price:0,quantity:0}}},methods:{getProducts(){this.productList=[],this.$axios.get("/products").then((t=>{this.productList=t.data})).catch((t=>{console.error(t)}))},createProduct(){this.product.productName&&this.product.price&&this.product.quantity?this.$axios.post("/products",this.product).then((t=>{alert("新增成功"),console.log(t),this.getProducts(),this.closeModal()})).catch((t=>{alert("新增失敗"),console.error(t)})):alert("請填寫所有欄位")},formatCurrency(t){return new Intl.NumberFormat("en-US",{style:"currency",currency:"USD",maximumFractionDigits:0}).format(t)},openModal(){this.showModal=!0},closeModal(){this.showModal=!1}},mounted(){this.getProducts()}};const Tt=(0,u.A)(Qt,[["render",Ft],["__scopeId","data-v-a36eece2"]]);var Ht=Tt;const Kt=t=>((0,n.Qi)("data-v-3b57525c"),t=t(),(0,n.jt)(),t),Bt={style:{width:"90%",margin:"auto"}},zt={class:"action-content"},Gt=Kt((()=>(0,n.Lk)("thead",null,[(0,n.Lk)("tr",null,[(0,n.Lk)("th",null,"挑選"),(0,n.Lk)("th",null,"產品編碼"),(0,n.Lk)("th",null,"產品名稱"),(0,n.Lk)("th",null,"價格"),(0,n.Lk)("th",null,"庫存")])],-1))),Wt=["onUpdate:modelValue"],Yt={key:0,class:"modal"},Zt={class:"modal-content"},te=Kt((()=>(0,n.Lk)("h1",null,"訂單確認",-1))),ee=Kt((()=>(0,n.Lk)("div",{class:"detail-content"},[(0,n.Lk)("div",null,"產品名稱"),(0,n.Lk)("div",null,"單價"),(0,n.Lk)("div",null,"數量"),(0,n.Lk)("div",null,"小計")],-1))),re=["onUpdate:modelValue","max","onChange"],oe={class:"flex-end-row"},ne={class:"action-content"};function ae(t,e,r,a,s,l){const u=(0,n.g2)("MemberHeader");return(0,n.uX)(),(0,n.CE)(n.FK,null,[(0,n.bF)(u),(0,n.Lk)("div",Bt,[(0,n.Lk)("div",zt,[(0,n.Lk)("button",{class:"action-button",onClick:e[0]||(e[0]=(...t)=>l.creatOrderCheck&&l.creatOrderCheck(...t))},"建立訂單")]),(0,n.Lk)("table",null,[Gt,(0,n.Lk)("tbody",null,[((0,n.uX)(!0),(0,n.CE)(n.FK,null,(0,n.pI)(s.productList,(t=>((0,n.uX)(),(0,n.CE)("tr",{key:t.productId},[(0,n.Lk)("td",null,[(0,n.bo)((0,n.Lk)("input",{type:"checkbox","onUpdate:modelValue":e=>t.checked=e},null,8,Wt),[[o.lH,t.checked]])]),(0,n.Lk)("td",null,(0,yt.v_)(t.productId),1),(0,n.Lk)("td",null,(0,yt.v_)(t.productName),1),(0,n.Lk)("td",null,(0,yt.v_)(l.formatCurrency(t.price)),1),(0,n.Lk)("td",null,(0,yt.v_)(t.quantity),1)])))),128))])])]),(0,n.bF)(o.eB,{name:"modal"},{default:(0,n.k6)((()=>[s.showModal?((0,n.uX)(),(0,n.CE)("div",Yt,[(0,n.Lk)("div",Zt,[te,ee,((0,n.uX)(!0),(0,n.CE)(n.FK,null,(0,n.pI)(s.order.orderDetail,((t,e)=>((0,n.uX)(),(0,n.CE)("div",{class:"detail-content",key:e},[(0,n.Lk)("div",null,(0,yt.v_)(t?.product?.productName),1),(0,n.Lk)("div",null,(0,yt.v_)(l.formatCurrency(t?.standPrice)),1),(0,n.Lk)("div",null,[(0,n.bo)((0,n.Lk)("input",{type:"number","onUpdate:modelValue":e=>t.quantity=e,max:t.product.quantity,min:1,onChange:e=>l.quantityChange(t)},null,40,re),[[o.Jo,t.quantity]])]),(0,n.Lk)("div",null,(0,yt.v_)(l.formatCurrency(t?.itemPrice)),1)])))),128)),(0,n.Lk)("div",oe,[(0,n.Lk)("div",null,"總金額: "+(0,yt.v_)(l.formatCurrency(s.order.price)),1)]),(0,n.Lk)("div",ne,[(0,n.Lk)("button",{class:"action-button",onClick:e[1]||(e[1]=(...t)=>l.closeModal&&l.closeModal(...t))},"取消"),(0,n.Lk)("button",{class:"action-button",onClick:e[2]||(e[2]=(...t)=>l.creteOrder&&l.creteOrder(...t))},"確認")])])])):(0,n.Q3)("",!0)])),_:1})],64)}const se=t=>((0,n.Qi)("data-v-43da24d6"),t=t(),(0,n.jt)(),t),le=se((()=>(0,n.Lk)("h1",null,"電商購物中心平台",-1)));function ue(t,e,r,o,a,s){return(0,n.uX)(),(0,n.CE)("header",null,[le,(0,n.Lk)("nav",null,[(0,n.Lk)("ul",null,[(0,n.Lk)("li",{onClick:e[0]||(e[0]=(...t)=>s.toProductList&&s.toProductList(...t))},"產品總表"),(0,n.Lk)("li",{onClick:e[1]||(e[1]=(...t)=>s.toOrderList&&s.toOrderList(...t))},"訂單紀錄"),(0,n.Lk)("li",{onClick:e[2]||(e[2]=(...t)=>s.logOut&&s.logOut(...t))},"登出")])])])}var ie={name:"MemberHeader",methods:{toProductList(){this.$router.push("/product-list")},toOrderList(){this.$router.push("/order-list")},logOut(){this.$store.commit("SET_MEMBER",null),this.$router.push("/")}}};const de=(0,u.A)(ie,[["render",ue],["__scopeId","data-v-43da24d6"]]);var ce=de,pe={name:"ProductList",components:{MemberHeader:ce},data(){return{productList:[],showModal:!1,order:{orderDetail:[],price:0}}},methods:{getProducts(){this.productList=[],this.$axios.get("/products?inStock=true").then((t=>{t.data.forEach((t=>{t.checked=!1,this.productList.push(t)}))})).catch((t=>{console.error(t)}))},formatCurrency(t){return new Intl.NumberFormat("en-US",{style:"currency",currency:"USD",maximumFractionDigits:0}).format(t)},creatOrderCheck(){this.order={orderDetail:[],price:0};let t=0;this.productList.forEach((e=>{if(e.checked){let r={product:{productId:e.productId,productName:e.productName,price:e.price,quantity:e.quantity},standPrice:e.price,quantity:1,itemPrice:0},o=r.standPrice*r.quantity;r.itemPrice=o,t+=o,console.log("Detail before pushing:",r),this.order.orderDetail.push(r)}})),this.order.price=t,0!==this.order.orderDetail.length?this.openModal():alert("請選擇商品")},quantityChange(t){t.itemPrice=t.standPrice*t.quantity,this.priceCalculate()},priceCalculate(){let t=0;this.order.orderDetail.forEach((e=>{t+=e.itemPrice})),this.order.price=t},creteOrder(){let t=[];this.order.orderDetail.forEach((e=>{let r={productId:e.product.productId,quantity:e.quantity};t.push(r)}));let e=this.$store.state.member.memberId;this.$axios.post("/members/"+e+"/orders",{buyItemList:t}).then((t=>{console.log(t),alert("訂單建立成功"),this.getProducts(),this.closeModal()})).catch((t=>{alert("訂單建立失敗"),console.error(t)}))},openModal(){this.showModal=!0},closeModal(){this.showModal=!1}},mounted(){this.getProducts()}};const me=(0,u.A)(pe,[["render",ae],["__scopeId","data-v-3b57525c"]]);var he=me,ke=r.p+"img/rectangle-list.2f22c4d0.png";const Le=t=>((0,n.Qi)("data-v-0b296188"),t=t(),(0,n.jt)(),t),be={style:{width:"90%",margin:"auto"}},ve=Le((()=>(0,n.Lk)("thead",null,[(0,n.Lk)("tr",null,[(0,n.Lk)("th",null,"訂單編碼"),(0,n.Lk)("th",null,"價格"),(0,n.Lk)("th",null,"付款狀態"),(0,n.Lk)("th",null,"內容")])],-1))),fe={key:0},ge={key:1},ye=["onClick"],we={key:0,class:"modal"},Ce={class:"modal-content"},Se=Le((()=>(0,n.Lk)("div",{class:"detail-content"},[(0,n.Lk)("div",null,"產品編號"),(0,n.Lk)("div",null,"單價"),(0,n.Lk)("div",null,"數量"),(0,n.Lk)("div",null,"小計")],-1))),Me={class:"flex-end-row"},_e={class:"action-content"};function Ee(t,e,r,a,s,l){const u=(0,n.g2)("MemberHeader");return(0,n.uX)(),(0,n.CE)(n.FK,null,[(0,n.bF)(u),(0,n.Lk)("div",be,[(0,n.Lk)("table",null,[ve,(0,n.Lk)("tbody",null,[((0,n.uX)(!0),(0,n.CE)(n.FK,null,(0,n.pI)(s.orderList,((t,e)=>((0,n.uX)(),(0,n.CE)("tr",{key:e},[(0,n.Lk)("td",null,(0,yt.v_)(t.orderId),1),(0,n.Lk)("td",null,(0,yt.v_)(l.formatCurrency(t.price)),1),0==t.payStatus?((0,n.uX)(),(0,n.CE)("td",fe,"未付款")):(0,n.Q3)("",!0),1==t.payStatus?((0,n.uX)(),(0,n.CE)("td",ge,"已付款")):(0,n.Q3)("",!0),(0,n.Lk)("td",null,[(0,n.Lk)("img",{src:ke,alt:"rectangle-list",width:"20px",height:"20px",onClick:e=>l.showOrderDetails(t)},null,8,ye)])])))),128))])])]),(0,n.bF)(o.eB,{name:"modal"},{default:(0,n.k6)((()=>[s.showModal?((0,n.uX)(),(0,n.CE)("div",we,[(0,n.Lk)("div",Ce,[(0,n.Lk)("h1",null,(0,yt.v_)(s.order.orderId),1),Se,((0,n.uX)(!0),(0,n.CE)(n.FK,null,(0,n.pI)(s.order.orderDetail,((t,e)=>((0,n.uX)(),(0,n.CE)("div",{class:"detail-content",key:e},[(0,n.Lk)("div",null,(0,yt.v_)(t?.productId),1),(0,n.Lk)("div",null,(0,yt.v_)(l.formatCurrency(t?.standPrice)),1),(0,n.Lk)("div",null,(0,yt.v_)(t.quantity),1),(0,n.Lk)("div",null,(0,yt.v_)(l.formatCurrency(t?.itemPrice)),1)])))),128)),(0,n.Lk)("div",Me,[(0,n.Lk)("div",null,"總金額: "+(0,yt.v_)(l.formatCurrency(s.order.price)),1)]),(0,n.Lk)("div",_e,[(0,n.Lk)("button",{class:"action-button",onClick:e[0]||(e[0]=(...t)=>l.closeModal&&l.closeModal(...t))},"確認")])])])):(0,n.Q3)("",!0)])),_:1})],64)}var Ie={name:"OrderList",components:{MemberHeader:ce},data(){return{orderList:[],showModal:!1,order:{orderDetail:[],price:0}}},methods:{getOrders(){this.orderList=[];let t=this.$store.state.member.memberId;this.$axios.get("/members/"+t+"/orders").then((t=>{t.data.forEach((t=>{this.orderList.push(t)}))})).catch((t=>{console.error(t)}))},formatCurrency(t){return new Intl.NumberFormat("en-US",{style:"currency",currency:"USD",maximumFractionDigits:0}).format(t)},showOrderDetails(t){this.order={orderDetail:[],orderId:t.orderId,price:t.price,payStatus:t.payStatus},this.$axios.get("/orders/"+t.orderId+"/details").then((t=>{t.data.forEach((t=>{this.order.orderDetail.push(t)})),this.openModal()})).catch((t=>{console.error(t)}))},openModal(){this.showModal=!0},closeModal(){this.showModal=!1}},mounted(){this.getOrders()}};const Oe=(0,u.A)(Ie,[["render",Ee],["__scopeId","data-v-0b296188"]]);var Pe=Oe;const qe=[{path:"/",component:G},{path:"/user-login",component:C},{path:"/user-register",component:X},{path:"/member-login",component:ut},{path:"/member-register",component:gt},{path:"/product-setting",component:Ht,meta:{requireUserAuth:!0}},{path:"/product-list",component:he,meta:{requireMemberAuth:!0}},{path:"/order-list",component:Pe,meta:{requireMemberAuth:!0}}],Ue=(0,c.aE)({history:(0,c.LA)(),routes:qe});var $e=Ue,xe=r(782),Xe=new xe.Ay.Store({state:{token:sessionStorage.getItem("token"),user:JSON.parse(sessionStorage.getItem("user")),member:JSON.parse(sessionStorage.getItem("member"))},mutations:{SET_TOKENN:(t,e)=>{t.token=e,sessionStorage.setItem("token",e)},SET_USER:(t,e)=>{t.user=e,sessionStorage.setItem("user",JSON.stringify(e))},SET_MEMBER:(t,e)=>{t.member=e,sessionStorage.setItem("member",JSON.stringify(e))},REMOVE_INFO:t=>{t.token="",t.user={},t.member={},sessionStorage.setItem("token",""),sessionStorage.setItem("user",JSON.stringify("")),sessionStorage.setItem("member",JSON.stringify(""))}},getters:{},actions:{},modules:{}}),De=r(4373);const Fe=(0,o.Ef)(d);Fe.config.globalProperties.$axios=De.A,De.A.defaults.baseURL="http://localhost:8080/api",$e.beforeEach(((t,e,r)=>{t.meta.requireUserAuth?Xe.state.user?r():r({path:"user-login",query:{redirect:t.fullPath}}):t.meta.requireMemberAuth?Xe.state.member?r():r({path:"member-login",query:{redirect:t.fullPath}}):r()})),Fe.use($e).use(Xe).mount("#app")}},e={};function r(o){var n=e[o];if(void 0!==n)return n.exports;var a=e[o]={exports:{}};return t[o].call(a.exports,a,a.exports,r),a.exports}r.m=t,function(){var t=[];r.O=function(e,o,n,a){if(!o){var s=1/0;for(d=0;d<t.length;d++){o=t[d][0],n=t[d][1],a=t[d][2];for(var l=!0,u=0;u<o.length;u++)(!1&a||s>=a)&&Object.keys(r.O).every((function(t){return r.O[t](o[u])}))?o.splice(u--,1):(l=!1,a<s&&(s=a));if(l){t.splice(d--,1);var i=n();void 0!==i&&(e=i)}}return e}a=a||0;for(var d=t.length;d>0&&t[d-1][2]>a;d--)t[d]=t[d-1];t[d]=[o,n,a]}}(),function(){r.n=function(t){var e=t&&t.__esModule?function(){return t["default"]}:function(){return t};return r.d(e,{a:e}),e}}(),function(){r.d=function(t,e){for(var o in e)r.o(e,o)&&!r.o(t,o)&&Object.defineProperty(t,o,{enumerable:!0,get:e[o]})}}(),function(){r.g=function(){if("object"===typeof globalThis)return globalThis;try{return this||new Function("return this")()}catch(t){if("object"===typeof window)return window}}()}(),function(){r.o=function(t,e){return Object.prototype.hasOwnProperty.call(t,e)}}(),function(){r.r=function(t){"undefined"!==typeof Symbol&&Symbol.toStringTag&&Object.defineProperty(t,Symbol.toStringTag,{value:"Module"}),Object.defineProperty(t,"__esModule",{value:!0})}}(),function(){r.p="/"}(),function(){var t={524:0};r.O.j=function(e){return 0===t[e]};var e=function(e,o){var n,a,s=o[0],l=o[1],u=o[2],i=0;if(s.some((function(e){return 0!==t[e]}))){for(n in l)r.o(l,n)&&(r.m[n]=l[n]);if(u)var d=u(r)}for(e&&e(o);i<s.length;i++)a=s[i],r.o(t,a)&&t[a]&&t[a][0](),t[a]=0;return r.O(d)},o=self["webpackChunkshopping_mall"]=self["webpackChunkshopping_mall"]||[];o.forEach(e.bind(null,0)),o.push=e.bind(null,o.push.bind(o))}();var o=r.O(void 0,[504],(function(){return r(3146)}));o=r.O(o)})();
//# sourceMappingURL=app.e416d3b6.js.map