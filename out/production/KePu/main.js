import {createApp} from 'vue';
import ElementPlus from 'element-plus';
import 'element-plus/dist/index.css';
import App from './App.vue';
import router from "@/router";
import { Form, Field, CellGroup } from 'vant';



const app = createApp(App);
app.use(Form);
app.use(Field);
app.use(CellGroup);
app.use(router);
app.use(ElementPlus);
app.mount('#app');
