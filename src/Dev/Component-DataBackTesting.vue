<template>
    <div class="row">
        <div class="col-xs-12">
            <!--图表展示区-->
            <div class="row">
                <div class="col-xs-12">
                    <div id="DataBackTestingChart" style="width:auto;height: 500px;border: #cce0ff solid 1px">
                    </div>
                    <div style="width:auto;height: 36px;text-align: center">
                        <div class="btn-group" role="group" aria-label="Default button group"
                             style="margin-left: auto;margin-right: auto">
                            <button id="refreshCharBtn" type="button" class="btn btn-default" @click="DataBackTestingChartShow()">更新图表</button>
                            <!--<button type="button" class="btn btn-default">清空图表</button>-->
                        </div>
                    </div>
                </div>
            </div>
            <!--参数配置区-->
            <div class="row" style="margin-top: 20px;margin-bottom: 20px;border: #cce0ff solid 1px">
                <div class="col-xs-12">
                    <!--小标题-->
                    <div class="row">
                        <div class="col-xs-12 title">
                            参比基金配置
                        </div>
                    </div>
                    <!--参比基金搜索区-->
                    <div class="row">
                        <div class="col-xs-12">
                            <!--表单标签，仅为了用相关样式-->
                            <form class="navbar-form navbar-left" role="search" v-clickoutside="handleClose">
                                <div class="form-group">
                                    <input type="text" class="form-control" placeholder="搜索参比基金"
                                           style="width: 300px;margin-top: 15px"
                                           v-model="searchStr"
                                           @click="GetFocusSearchResultListShow">
                                </div>
                                <!--搜索结果展示，默认不展示-->
                                <div v-show="searchResultListShow"
                                     style="overflow:scroll;height:300px;width: 300px;border: #cce0ff solid 1px;background-color: white;position: absolute;z-index: 1;display: none">
                                    <ul style="list-style-type:none;padding:0px;">
                                        <!--white-space: nowrap，内容不换行显示-->
                                        <li style="white-space: nowrap;cursor: pointer;"
                                            v-for="item in searchResultArray">
                                            <a @click="AddSearchResultToFundNameAndCodeArray(item)">{{item.fundCode}}
                                                {{item.fundName}} {{item.fundShortName}}</a>
                                        </li>
                                    </ul>
                                </div>
                            </form>
                            <!--出现重复时，提示-->
                            <div class="alert alert-danger" role="alert"
                                 style="display: inline-block;margin-top: 23px;padding-top: 6px;padding-bottom: 6px; margin-bottom: 0"
                                 v-show="searchMsgTipShow">
                                <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
                                <span class="sr-only">Error:</span>
                                {{GetSearchMsgTip}}
                            </div>
                        </div>
                    </div>
                </div>
                <!--参比基金列表-->
                <div class="row">
                    <div class="col-xs-7">
                        <ul class="list-group" style="margin-left: 30px;margin-top: 20px;">
                            <li class="list-group-item"
                                v-for="(item,index) in this.$store.getters.GetFundNameAndCodeArray"
                                style="height: 50px;margin: 0;padding: 0;">
                                <span style="line-height: 50px;margin-left: 10px">{{item.fundName}}[{{item.fundCode}}]</span>
                                <div style="float: right;line-height: 50px">
                                    <date-picker v-model="eachFundNameAndCodeItemTimeRangeArray[index]"
                                                 format="YYYY-MM-DD"
                                                 type="date"
                                                 confirm
                                                 confirm-text="确认"
                                                 range
                                                 width=220
                                                 @change="RefreshSeriesData($event,index,'fundFlag')">
                                    </date-picker>
                                    <a style="cursor: pointer;margin-left: 10px;margin-right: 10px"
                                       @click="DelFundAndCodeItemFromArray(item,index,'fundFlag')">删除</a>
                                </div>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>

            <!--参数配置区-->
            <div class="row" style="margin-top: 20px;margin-bottom: 20px;border: #cce0ff solid 1px">
                <div class="col-xs-12">
                    <!--小标题-->
                    <div class="row">
                        <div class="col-xs-12 title">
                            业绩基准配置
                        </div>
                    </div>

                    <!--业绩基准下拉菜单-->
                    <div class="row">
                        <div class="col-xs-6">
                            <!--表单标签，仅为了用相关样式-->
                            <form class="navbar-form navbar-left" role="search">
                                <div class="dropdown" style="margin-top: 15px;">
                                    <button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown"
                                            aria-haspopup="true" aria-expanded="true"
                                            style="width: 300px;text-align: left">选择参比业绩基准
                                        <span class="caret" style="display: inline-block;margin-left: 150px"></span>
                                    </button>
                                    <ul class="dropdown-menu" aria-labelledby="dropdownMenu1" style="width: 300px">
                                        <li style="white-space: nowrap;cursor: pointer;"
                                            v-for="(item,index) in GetStandardSelectArray">
                                            <a @click="AddItemToStandardNameAndCodeArray(item,index)">{{item.stockName}}[{{item.stockCode}}]</a>
                                        </li>
                                    </ul>
                                </div>
                            </form>
                        </div>
                    </div>

                    <!--参比业绩基准列表-->
                    <div class="row">
                        <div class="col-xs-7">
                            <ul class="list-group" style="margin-left: 15px;margin-top: 20px;">
                                <li class="list-group-item"
                                    v-for="(item,index) in this.$store.getters.GetStandardNameAndCodeArray"
                                    style="height: 50px;margin: 0;padding: 0;">
                                    <span style="line-height: 50px;margin-left: 10px">{{item.stockName}}[{{item.stockCode}}]</span>
                                    <div style="float: right;line-height: 50px">
                                        <date-picker v-model="eachStandardNameAndCodeItemTimeRangeArray[index]"
                                                     format="YYYY-MM-DD"
                                                     type="date"
                                                     confirm
                                                     confirm-text="确认"
                                                     range
                                                     width=220
                                                     @change="RefreshSeriesData($event,index,'stockFlag')">
                                        </date-picker>
                                        <a style="cursor: pointer;margin-left: 10px;margin-right: 10px"
                                           @click="DelFundAndCodeItemFromArray(item,index,'stockFlag')">删除</a>
                                    </div>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>
<script>
    //引入echarts
    var echarts = require("echarts/dist/echarts");
    //图表实例
    var dataBackTestingChart;
    //引入lodash
    var lodash = require("lodash");

    export default {
        created: function () {
            //延迟发送快速搜索栏的查询字符串，防止引发多次查询，使结果混淆
            this.DelayAjax = lodash.debounce(this.DataBackTestingSearchResultShow, 400);
        },
        mounted() {
            //初始化图表实例
            dataBackTestingChart = echarts.init(document.getElementById("DataBackTestingChart"), 'light');
        },
        data() {
            return {
                //参比基金搜索栏字符串
                searchStr: "",
                //参比基金搜索结果区域展示内容
                searchResultArray: [],
                //是否出现搜索结果区域展示列表，默认不显示
                searchResultListShow: false,
                //搜索信息提示，显示在参比基金搜索区域右侧。提示信息包括：1、参比基金已存在；2、参比基金不能超过3个
                searchMsgTip: "",
                //是否出现搜索信息提示，默认不显示
                searchMsgTipShow: false,
                //视图中显示列表遍历的数据来源：vuex中的fundNameAndCodeArray和standardNameAndCodeArray
                //1、对于基金：当从搜索区域选定基金后，将相关信息添加到vuex中的fundNameAndCodeArray
                //2、对于股票（业绩基准）：从下拉列表中选定业绩基准后，将相关信息添加到vuex中的standardNameAndCodeArray
                //基金视图列表确定后，当修改时间段时，将时间信息保存到eachFundNameAndCodeItemTimeRangeArray
                //股票（业绩基准）视图列表确定后，当修改时间段时，将时间信息保存到eachStandardNameAndCodeItemTimeRangeArray
                //注意：fundNameAndCodeArray对于eachFundNameAndCodeItemTimeRangeArray，项目的下标（index）是相同的；
                //同理，standardNameAndCodeArray对于eachStandardNameAndCodeItemTimeRangeArray，项目的下标（index）是相同的；
                //所以，当执行删除时，可以根据下标（index）删除对应的项目
                //独立：各参比基金时间段
                eachFundNameAndCodeItemTimeRangeArray: [],
                //独立：各业绩基准时间段
                eachStandardNameAndCodeItemTimeRangeArray: [],
                //共享：当前参与计算的基金或股票的代码
                currentComputingCode: "",
                //共享：当前参与计算的基金或股票的名称
                currentComputingName: "",
                //共享：当前参与计算的基金或股票的的起始日期
                currentComputingStartDate: "",
                //共享：当前参与计算的基金或股票的的结束日期
                currentComputingEndDate: "",
                //共享：图表展示区数据，对象数组，每个对象属性：name:''、type:'line'，data：[]
                seriesDataArray: [],
                //可选业绩基准下拉列表项
                standardSelectArray: [
                    {"stockName": "沪深300", "stockCode": "000300"},
                    {"stockName": "中证500", "stockCode": "000905"},
                ]
            };
        },
        watch: {
            //监听快速搜索栏
            searchStr(newValue, oldValue) {
                //快速搜索栏输入内容就清空右侧提示“已存在”的搜索消息提示并隐藏
                this.searchMsgTipShow = false;
                this.searchMsgTip = "";
                //延迟发送ajax，防止引发多次查询，使结果混淆
                this.DelayAjax();
                //查询字符串如果为空，则隐藏搜索结果列表；输入内容时显示
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
            //快速搜索栏实时显示查询结果
            DataBackTestingSearchResultShow() {
                $.ajax({
                    type: "POST",
                    url: "DataBackTestingSearchResultShow.do",
                    data: this.searchStr,
                    contentType: "application/json;charset=utf-8",
                    dataType: "json",
                    success: (data) => {
                        //展示新查询结果前，清空旧查询结果
                        this.searchResultArray = [];
                        //遍历数据库查询结果
                        $.each(data, (index, item) => {
                            //将从fundbasedata表查询到的基金数据，遍历每个元素，并保存到searchResultList
                            //每个元素均为实体类EntityFundBaseData的实例，属性对应实体类EntityFundBaseData的定义
                            this.searchResultArray.push(item);
                        });
                    },
                    error: () => {
                        //若查询出现错误，仅清空旧查询结果
                        this.searchResultArray = [];
                    }
                });
            },
            //点击搜索栏实时显示的查询结果，将选中的条目添加到参比基金列表
            AddSearchResultToFundNameAndCodeArray(item) {
                //增加条目到参比基金列表前，清除搜索字符串，触发监听，使搜索结果区域隐藏
                this.searchStr = "";
                //判断当前参比基金数量，最多3支
                if (this.$store.getters.GetFundNameAndCodeArray.length >= 3) {
                    this.$nextTick(() => {
                        this.searchMsgTipShow = true;
                        this.searchMsgTip = "参比基金数量最多为3";
                    });
                    return;
                }
                //添加数据到vuex前，进行是否重复的判断
                //注意：some的返回值，当数组为空或没有满足条件时，返回false；当满足条件返回true
                //stopAddElementFlag，禁止添加元素的标志：
                //当this.$store.getters.GetFundNameList为空或没有重复时，值为false，即允许添加元素
                //当this.$store.getters.GetFundNameList有重复时，值为true，即禁止添加元素
                let stopAddElementFlag = this.$store.getters.GetFundNameAndCodeArray.some((existItem, index) => {
                    return item.fundCode === existItem.fundCode;
                });
                //允许添加元素到vuex
                if (stopAddElementFlag === false) {
                    this.$store.commit("AddItemToFundNameAndCodeArray", item);
                }
                //禁止添加元素，设置搜索消息提示并显示
                else {
                    this.$nextTick(() => {
                        this.searchMsgTipShow = true;
                        this.searchMsgTip = item.fundName + "[" + item.fundCode + "]已存在";
                    });
                }
            },
            //点击参比基金列表中的“删除”时，根据index移除数组中相应数据
            DelFundAndCodeItemFromArray(item, index, dataFlag) {
                if (dataFlag.indexOf("fundFlag") != -1) {
                    //删除指定下标的列表项
                    this.$store.commit("DelItemFromFundNameAndCodeArray", index);
                    //删除指定下标的时间段
                    this.eachFundNameAndCodeItemTimeRangeArray.splice(index, 1);
                    //删除指定下标的图表数据
                    let delElementIndex;
                    this.seriesDataArray.some((existItem, index) => {
                        delElementIndex = index;
                        return item.fundName === existItem.name;
                    });
                    this.seriesDataArray.splice(delElementIndex, 1);
                }
                if (dataFlag.indexOf("stockFlag") != -1) {
                    //删除指定下标的列表项
                    this.$store.commit("DelItemFromStandardNameAndCodeArray", index);
                    //删除指定下标的时间段
                    this.eachStandardNameAndCodeItemTimeRangeArray.splice(index, 1);
                    //删除指定下标的图表数据
                    let delElementIndex;
                    this.seriesDataArray.some((existItem, index) => {
                        delElementIndex = index;
                        return item.stockName === existItem.name;
                    });
                    this.seriesDataArray.splice(delElementIndex, 1);
                    //添加删除的元素回列表
                    this.standardSelectArray.push({"stockName": item.stockName, "stockCode": item.stockCode});
                }
            },
            AddItemToStandardNameAndCodeArray(item, index) {
                this.standardSelectArray.splice(index, 1);
                this.$store.commit("AddItemToStandardNameAndCodeArray", item);
            },
            //当参比基金的时间段发生变化时触发的事件，接收三个参数：当前日期、下标、数据标志
            //更新四个公共数据：
            //1、更新currentComputingCode
            //2、更新currentComputingName
            //3、更新currentComputingStartDate
            //4、更新currentComputingEndDate
            //最后主动触发查询累计净值增长率事件GetFundValueGrowthRateData，并传入数据标志
            RefreshSeriesData(currentDate, index, dataFlag) {
                //分支1，数据标志为基金时
                if (dataFlag.indexOf("fundFlag") != -1) {
                    //获取第outIndex个参比基金的基金代码
                    this.currentComputingCode = this.$store.getters.GetFundNameAndCodeArray[index].fundCode;
                    //获取第outIndex个参比基金的基金名称
                    this.currentComputingName = this.$store.getters.GetFundNameAndCodeArray[index].fundName;
                    //转化日期为yyyy-mm-dd格式
                    this.currentComputingStartDate = currentDate[0].getFullYear() + "-" + (currentDate[0].getMonth() + 1) + "-" + currentDate[0].getDate();
                    this.currentComputingEndDate = currentDate[1].getFullYear() + "-" + (currentDate[1].getMonth() + 1) + "-" + currentDate[1].getDate();
                    //查询累计净值增长率
                }
                //分支2，数据标志为股票时
                if (dataFlag.indexOf("stockFlag") != -1) {
                    //获取第outIndex个参比基金的基金代码
                    this.currentComputingCode = this.$store.getters.GetStandardNameAndCodeArray[index].stockCode;
                    //获取第outIndex个参比基金的基金名称
                    this.currentComputingName = this.$store.getters.GetStandardNameAndCodeArray[index].stockName;
                    //转化日期为yyyy-mm-dd格式
                    this.currentComputingStartDate = currentDate[0].getFullYear() + "-" + (currentDate[0].getMonth() + 1) + "-" + currentDate[0].getDate();
                    this.currentComputingEndDate = currentDate[1].getFullYear() + "-" + (currentDate[1].getMonth() + 1) + "-" + currentDate[1].getDate();
                }
                //主动触发查询累计净值增长率事件，并传入数据标志
                this.GetFundValueGrowthRateData(dataFlag);
            },
            //查询累计净值增长率
            GetFundValueGrowthRateData(dataFlag) {
                //清空临时数组
                this.$store.commit("ClearDataTransferArray");
                //拆分出来，保存日期的数组
                let dateArray = [];
                //拆分出来，保存净值或股票价格的数组
                let valueArray = [];
                $.ajax({
                    type: "POST",
                    url: "GetFundValueGrowthRateData.do",
                    data: "{\"fundCode\":\"" + this.currentComputingCode + "\",\"startDate\":\"" + this.currentComputingStartDate + "\",\"endDate\":\"" + this.currentComputingEndDate + "\",\"dataFlag\":\"" + dataFlag + "\"}",
                    contentType: "application/json",
                    dataType: "json",
                    success: (data) => {
                        let valueGrowthRate = "-";
                        $.each(data, (index, item) => {
                            dateArray.push(item.valueDate);
                            //分支1，数据标志为基金时
                            if (dataFlag.indexOf("fundFlag") != -1) {
                                valueArray.push(item.cumulativeNAV);
                            }
                            //分支2，数据标志为股票时
                            if (dataFlag.indexOf("stockFlag") != -1) {
                                valueArray.push(item.closingPrice);
                            }
                            //从第二个净值起计算增长率才有意义
                            if (index > 0) {
                                valueGrowthRate = (valueArray[index] / valueArray[index - 1] - 1);
                            }
                            //注意：基金实例和股票实例都有dailyGrowthRate属性
                            item.dailyGrowthRate = valueGrowthRate;
                            //更新临时数组
                            this.$store.commit("AddItemToDataTransferArray", item);
                        });
                        //计算累计净值总回报：以1.0为起始，根据累计净值增长率计算出总回报，保存在incomeArray
                        let incomeArray = [1.0];
                        //获取数据中转数组
                        let tempArray = this.$store.getters.GetDataTransferArray;
                        //计算指定时间段的总回报
                        for (let indexArray = 1; indexArray < tempArray.length; indexArray++) {
                            //累计净值增长率数组的第一个元素不存在，因此从下标从1开始
                            //由：累计净值增长率=末/初-1，反推得到：末=（累计净值增长率+1）*初
                            //将计算结果从第二个元素起，添加到incomeArray
                            incomeArray.push(((tempArray[indexArray].dailyGrowthRate + 1.0) * incomeArray[indexArray - 1]).toFixed(6));
                        }
                        //seriesDataArray的数据顺序和临时数组this.$store.getters.GetDataList的数据顺序是一样的，因此元素下标也相同
                        //通过name来判断当前参与计算的基金是否已经存在
                        //注意：some的返回值，当数组为空或没有满足条件时，返回false；当满足条件返回true
                        //stopAddElementFlag，禁止添加新基金图表数据的标志：
                        //当seriesDataArray为空或没有重复时，值为false，即允许添加新基金图表数据
                        //当seriesDataArray有重复时，值为true，即禁止添加新基金图表数据
                        //elementIndex，保存出现重复时的下标，仅修改该下标对应基金图表数据对象的data属性
                        let elementIndex = -1;
                        let stopAddElementFlag = this.seriesDataArray.some((item, index) => {
                            elementIndex = index;
                            return item.name === this.currentComputingName;
                        });
                        //允许添加新基金图表数据
                        if (stopAddElementFlag == false) {
                            //将名称、总回报数组组成对象，添加到seriesDataArray
                            //注意：seriesDataArray为基金和股票（业绩基准）共享
                            this.seriesDataArray.push(
                                {
                                    "name": this.currentComputingName,
                                    "type": "line",
                                    "data": incomeArray
                                }
                            );
                        }
                        //禁止添加数据到图表，仅修改data属性
                        else {
                            this.$set(this.seriesDataArray[elementIndex], "data", incomeArray);
                        }
                    },
                    error: () => {
                    }
                });
            },
            //手动更新图表的事件
            DataBackTestingChartShow() {
                //图表配置项，setOption添加第二个参数true，根据series实时更新图表
                dataBackTestingChart.setOption({
                    title: {
                        text: '累计净值回报',
                        x: 'center',
                    },
                    tooltip: {
                        trigger: 'axis'
                    },
                    legend: {
                        //缺省data属性时，默认取数据的name属性作为标注
                        x: 'center',
                        top: 30
                    },
                    grid: {
                        left: '3%',
                        right: '4%',
                        bottom: '3%',
                        containLabel: true
                    },
                    xAxis: {
                        type: 'category',
                        boundaryGap: false,
                        data: this.GetxAxisData
                    },
                    yAxis: {
                        type: 'value',
                        min: function (value) {
                            return value.min;
                        },
                        max: function (value) {
                            return value.max;
                        }
                    },
                    series: this.GetSeriesDataArray
                }, true);
            },
            handleClose() {
                this.searchResultListShow = false;
            },
            GetFocusSearchResultListShow(){
                if(this.searchStr!==""){
                    this.searchResultListShow = true;
                }
            }
        },
        computed: {
            //返回搜索信息提示，两个值：“”（空字符串）、“基金名称[基金代码]已存在”
            GetSearchMsgTip() {
                return this.searchMsgTip;
            },
            //返回图表展示区数据
            GetSeriesDataArray() {
                return this.seriesDataArray;
            },
            //返回按钮显示文本，两个值：“更新图表”（默认值）、“数据更新中...”
            GetRefreshChartMsg() {
                return this.refreshChartMsg;
            },
            //返回seriesDataArray中data属性最长的数量，用作x轴标记
            GetxAxisData() {
                let countNumArray = 0;
                let tempNum;
                for (let index = 0; index < this.seriesDataArray.length; index++) {
                    tempNum = this.seriesDataArray[index].data.length;
                    if (tempNum > countNumArray) {
                        countNumArray = tempNum;
                    }
                }
                let xAxisDataArray = [];
                for (let index = 1; index < countNumArray; index++) {
                    xAxisDataArray.push(index);
                }
                return xAxisDataArray;
            },
            GetStandardSelectArray() {
                return this.standardSelectArray;
            }
        }
    }
</script>
<style scoped>
    .title {
        font-family: "微软雅黑";
        font-size: 18px;
        line-height: 40px;
        color: #333333;
        background: #eee;
    }
</style>
