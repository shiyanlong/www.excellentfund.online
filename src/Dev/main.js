import Vue from "vue";
//组件
import navBar from "./Component-NavBar.vue";
import mainPage from "./Component-MainPage.vue";
import fundValueNav from "./Component-FundValueNav.vue";
import valueList from "./Component-FundValueNav-ValueList.vue";
import refreshRoute from "./Component-RefreshRoute.vue";
import economicTerms from "./Component-EconomicTerms.vue";
import dataBackTesting from "./Component-DataBackTesting.vue";
import aboutMsg from "./Component-AboutMsg.vue";
import singleFundMsg from "./Component-SingleFundMsg.vue";
import footMsg from "./Component-FootMsg.vue";
//mint-ui
import {InfiniteScroll} from "mint-ui";

Vue.use(InfiniteScroll);
//bootstrap 3.3.7，jquery 3.0.0
import 'jquery/dist/jquery.min.js';
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap/dist/js/bootstrap.min.js';
//vue路由
import VueRouter from 'vue-router';

Vue.use(VueRouter);
//datepicker
import DatePicker from 'vue2-datepicker';

Vue.use(DatePicker);
//vuex
import Vuex from 'vuex'

Vue.use(Vuex);

//ElementUI
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';

Vue.use(ElementUI);

//引入axios
import axios from 'axios';
Vue.prototype.$http = axios;

const store = new Vuex.Store({
    state: {
        //独立：参比基金列表要遍历展示的数据
        fundNameAndCodeArray: [],
        //独立：业绩基准列表要遍历展示的数据
        standardNameAndCodeArray: [],
        //共享：数据中转数组
        dataTransferArray: [],
    },
    mutations: {
        AddItemToFundNameAndCodeArray(state, item) {
            state.fundNameAndCodeArray.push(item);
        },
        DelItemFromFundNameAndCodeArray(state, index) {
            state.fundNameAndCodeArray.splice(index, 1);
        },
        AddItemToStandardNameAndCodeArray(state, item) {
            state.standardNameAndCodeArray.push(item);
        },
        DelItemFromStandardNameAndCodeArray(state, index) {
            state.standardNameAndCodeArray.splice(index, 1);
        },
        //添加数据到vuex的数据中转数组
        AddItemToDataTransferArray(state, item) {
            state.dataTransferArray.push(item);
        },
        //清空vuex的数据中转数组
        ClearDataTransferArray(state) {
            state.dataTransferArray = [];
        }
    },
    getters: {
        GetFundNameAndCodeArray: (state) => {
            return state.fundNameAndCodeArray;
        },
        GetStandardNameAndCodeArray: (state) => {
            return state.standardNameAndCodeArray;
        },
        GetDataTransferArray: (state) => {
            return state.dataTransferArray;
        }
    }
});

const router = new VueRouter({
    routes: [
        //根目录重定向到mainPage组件
        {path: '/', redirect: '/mainPage'},
        //导航条“首页”
        {path: '/mainPage', name: 'mainPage', component: mainPage},
        //导航条“净值数据”，加载fundValueNav导航条组件，该导航条内容为基金分类
        {
            path: '/fundValueNav', name: 'fundValueNav', component: fundValueNav,
            children: [
                //显示各分类净值信息
                {path: 'valueList', name: 'valueList', component: valueList},
                //空路由
                {path: 'refreshRoute', name: 'refreshRoute', component: refreshRoute}
            ]
        },
        //净值信息列表中的单个基金代码或名称，加载singleFundMsg组件，显示单基金详细信息
        {path: '/singleFundMsg', name: 'singleFundMsg', component: singleFundMsg},
        //导航条“名词解释”
        {path: '/economicTerms', name: 'economicTerms', component: economicTerms},
        //导航条“数据回测”
        {path: '/dataBackTesting', name: 'dataBackTesting', component: dataBackTesting},
        //导航条“关于”
        {path: '/aboutMsg', name: 'aboutMsg', component: aboutMsg},
    ]
});

new Vue({
    el: "#navBar",
    render(createElements) {
        return createElements(navBar)
    },
    router,
    store
});

new Vue({
    el: "#footMsg",
    render(createElements) {
        return createElements(footMsg)
    }
});