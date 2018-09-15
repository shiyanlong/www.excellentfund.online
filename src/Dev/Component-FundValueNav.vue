<template>
    <div id="FundMsgTable" class="row">
        <div class="col-xs-12">
            <div class="row">
                <div class="col-xs-4" style="margin-top: 15px;margin-bottom: 15px">
                    <span style="font-family: 微软雅黑;font-size: 25px;color: #337ab7">基金净值数据概览</span>
                </div>
                <!--搜索功能，点击结果直接跳转到详情页-->
                <div class="col-xs-4 col-xs-offset-4" style="margin-top: 15px;margin-bottom: 15px" v-clickoutside="handleClose">
                    <div class="row">
                        <div class="col-xs-12">
                            <div class="input-group">
                                <input id="SearchStr" type="text" class="form-control" placeholder="快速搜索"
                                       style="width: 370px;height: 41px;font-size: 16px;font-family: 微软雅黑"
                                       v-model="searchStr"
                                       @click="GetFocusSearchResultListShow">
                            </div>
                        </div>
                    </div>
                    <!--搜索结果展示，默认不展示-->
                    <div class="row">
                        <div class="col-xs-12">
                            <div v-show="searchResultListShow"
                                 style="overflow:scroll;height:300px;width: 370px;border: #cce0ff solid 1px;background-color: white;position: absolute;z-index: 1;display: none">
                                <ul style="list-style-type:none;padding:0px;">
                                    <li style="white-space: nowrap;cursor: pointer;"
                                        @click="ShowSingleFundMsg(item)"
                                        v-for="item in searchResultArray">
                                        <a>{{item.fundCode}} {{item.fundName}} {{item.fundShortName}}</a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!--分类标签-->
            <div class="row">
                <div class="col-xs-12">
                    <ul class="nav nav-tabs">
                        <li role="presentation" class="FundPerformanceTableSelectTab active">
                            <a @click="ShowValueList('gp')">股票基金</a>
                        </li>
                        <li role="presentation" class="FundPerformanceTableSelectTab">
                            <a @click="ShowValueList('zq')">债券基金</a>
                        </li>
                        <li role="presentation" class="FundPerformanceTableSelectTab">
                            <a @click="ShowValueList('hh')">混合基金</a>
                        </li>
                        <li role="presentation" class="FundPerformanceTableSelectTab">
                            <a @click="ShowValueList('bb')">保本基金</a>
                        </li>
                        <li role="presentation" class="FundPerformanceTableSelectTab">
                            <a @click="ShowValueList('zs')">指数基金</a>
                        </li>
                        <li role="presentation" class="FundPerformanceTableSelectTab">
                            <a @click="ShowValueList('qdii')">QDII基金</a>
                        </li>
                        <li role="presentation" class="FundPerformanceTableSelectTab">
                            <a @click="ShowValueList('lof')">LOF基金</a>
                        </li>
                    </ul>
                </div>
            </div>
            <!--该行有1列，是路由展示的地方-->
            <div class="row">
                <div class="col-xs-12 navStyle" style="margin-top: 0px;margin-bottom: 10px;">
                    <router-view></router-view>
                </div>
            </div>
        </div>
    </div>
</template>
<script>
    //引入lodash
    var lodash = require("lodash");
    export default {
        created: function () {
            //延迟发送快速搜索栏的查询字符串，防止引发多次查询，使结果混淆
            this.DelayAjax = lodash.debounce(this.FundValueNavSearchResultShow, 400);
        },
        mounted() {
            $(function () {
                //基金业绩概览标签的选中效果
                $("li.FundPerformanceTableSelectTab").bind("click", function () {
                    $(this).siblings().removeClass("active");
                    $(this).addClass("active");
                });
            });
            //加载组件时默认在股票基金页面
            this.ShowValueList("gp");
        },
        data() {
            return {
                //搜索栏字符串
                searchStr: "",
                //搜索结果
                searchResultArray: [],
                //是否出现搜索结果列表
                searchResultListShow: false
            };
        },
        watch: {
            //监听快速搜索栏
            searchStr(newValue, oldValue) {
                //延迟发送ajax，防止引发多次查询，使结果混淆
                this.DelayAjax();
                //查询字符串searchStr新值如果为空，则隐藏搜索结果列表；反之显示
                if (newValue !== "") {
                    this.searchResultListShow = true;
                }
                else {
                    this.searchResultListShow = false;
                }
            }
        },
        directives: {
            clickoutside: {
                bind: function (el, binding) {
                    function DocumentHandle(e) {
                        //判断点击区域，在document内则退出
                        if (el.contains(e.target)) {
                            return false;
                        }
                        if (binding.expression) {
                            binding.value(e);
                        }
                    }
                    el.vueClickOutSide = DocumentHandle;
                    document.addEventListener("click", DocumentHandle);
                },
                unbind: function (el) {
                    document.removeEventListener("click", el.vueClickOutSide);
                    delete el.vueClickOutSide;
                }
            }
        },
        methods: {
            ShowValueList(fundType) {
                this.$router.push({
                    path: "/fundValueNav/valueList",
                    query: {
                        "fundType": fundType,
                    }
                });
                this.$router.push("/fundValueNav/refreshRoute");
            },
            FundValueNavSearchResultShow() {
                $.ajax({
                    type: "POST",
                    url: "FundValueNavSearchResultShow.do",
                    data: this.searchStr,
                    contentType: "application/json;charset=utf-8",
                    dataType: "json",
                    success: (data) => {
                        //展示新查询结果前，清空数组
                        this.searchResultArray = [];
                        //遍历查询结果
                        $.each(data, (index, item) => {
                            //将从fundbasedata表查询到的基金数据，整个对象保存到searchResultList
                            this.searchResultArray.push(item);
                        });
                    },
                    error: () => {
                        //若查询出现错误，清空数组
                        this.searchResultArray = [];
                    }
                });
            },
            //从快速搜索直接跳转到singleFundMsg，将查询到的整个item对象传递到下一个路由
            ShowSingleFundMsg(item) {
                this.$router.push({
                    name: 'singleFundMsg',
                    params: {
                        "item": item
                    }
                });
            },
            handleClose() {
                this.searchResultListShow = false;
            },
            GetFocusSearchResultListShow(){
                if(this.searchStr!==""){
                    this.searchResultListShow = true;
                }
            }
        }
    };
</script>
