import Vue from "vue";
import VueResource from "vue-resource";
import App from "./App";

Vue.use(VueResource);
Vue.http.headers.common.Accept = 'application/json';

/* eslint-disable no-new */
new Vue({
  el: 'body',
  components: {App}
})
