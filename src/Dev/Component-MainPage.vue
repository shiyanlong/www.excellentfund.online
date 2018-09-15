<template>
    <div class="row">
        <div class="col-xs-12">
            <div class="row">
                <div class="col-xs-12">
                    <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                        <!--小圆点，指示当前图片序号-->
                        <ol class="carousel-indicators">
                            <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                            <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                            <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                        </ol>
                        <!--展示图片-->
                        <div class="carousel-inner" role="listbox">
                            <div class="item active">
                                <div style="width:auto;height:250px;background-image:url('./Pic/FirstPic.jpg');background-size:cover;"></div>
                                <div class="carousel-caption"></div>
                            </div>
                            <div class="item">
                                <div style="width:auto;height:250px;background-image:url('./Pic/SecondPic.jpg');background-size:cover;"></div>
                                <div class="carousel-caption"></div>
                            </div>
                            <div class="item">
                                <div style="width:auto;height:250px;background-image:url('./Pic/ThirdPic.jpg');background-size:cover;"></div>
                                <div class="carousel-caption"></div>
                            </div>
                        </div>
                        <!--左右切换轮动图片的span隐藏效果按钮-->
                        <a class="left carousel-control" href="#carousel-example-generic" role="button"
                           data-slide="prev">
                            <span style="margin-top: 100px;margin-bottom: 100px;width: 40px;height: 56px;display: inline-block;background-image:url('./Pic/ArrowLeft.png')"/>
                            <span class="sr-only">Previous</span>
                        </a>
                        <a class="right carousel-control" href="#carousel-example-generic" role="button"
                           data-slide="next">
                            <span style="margin-top: 100px;margin-bottom: 100px;width: 40px;height: 56px;display: inline-block;background-image:url('./Pic/ArrowRight.png')"/>
                            <span class="sr-only">Next</span>
                        </a>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-xs-12" style="margin-top: 15px;margin-bottom: 15px">
                    <span style="font-family: 微软雅黑;font-size: 25px;color: #337ab7">市场主要指数走势</span>
                </div>
            </div>

            <div class="row">
                <div class="col-xs-2">
                    <div class="box">
                        <ul class="nav nav-pills nav-stacked nav-pills-stacked-example">
                            <li role="presentation" class="MainIndexSelectTab active" style="cursor: pointer;"><a
                                    @click="MainIndexChartShow('000300')"><span>沪深300</span></a>
                            </li>
                            <li role="presentation" class="MainIndexSelectTab" style="cursor: pointer;"><a
                                    @click="MainIndexChartShow('000918')"><span>300成长</span></a>
                            </li>
                            <li role="presentation" class="MainIndexSelectTab" style="cursor: pointer;"><a
                                    @click="MainIndexChartShow('000919')"><span>300价值</span></a>
                            </li>
                            <li role="presentation" class="MainIndexSelectTab" style="cursor: pointer;"><a
                                    @click="MainIndexChartShow('000905')"><span>中证500</span></a>
                            </li>
                            <li role="presentation" class="MainIndexSelectTab" style="cursor: pointer;"><a
                                    @click="MainIndexChartShow('000852')"><span>中证1000</span></a>
                            </li>
                            <li role="presentation" class="MainIndexSelectTab" style="cursor: pointer;"><a
                                    @click="MainIndexChartShow('399006')"><span>创业板指</span></a>
                            </li>
                            <li role="presentation" class="MainIndexSelectTab" style="cursor: pointer;"><a
                                    @click="MainIndexChartShow('000010')"><span>上证180</span></a>
                            </li>
                            <li role="presentation" class="MainIndexSelectTab" style="cursor: pointer;"><a
                                    @click="MainIndexChartShow('000046')"><span>上证中小盘指数</span></a>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="col-xs-10">
                    <div id="MainIndexChart" style="width:953px;height: 500px;border: #cce0ff solid 1px"></div>
                </div>
            </div>
        </div>
    </div>
</template>
<script>
    //引入echarts
    var echarts = require("echarts/dist/echarts");
    //图表实例
    var MainPageChart;
    //用SplitData方法处理后返回的全局对象dataStrObject,该对象包含两个数组属性：1、全部日期categoryData，2、全部净值values
    var dataStrObject;

    //将ajax响应结果做日期、净值数据分离，返回一个对象，该对象包含两个数组属性：1、全部日期categoryData，2、全部净值values
    function SplitData(rawData) {
        let categoryData = [];
        let values = []
        for (let arrayIndex = 0; arrayIndex < rawData.length; arrayIndex++) {
            categoryData.push(rawData[arrayIndex].splice(0, 1)[0]);
            values.push(rawData[arrayIndex])
        }
        return {
            categoryData: categoryData,
            values: values
        };
    }

    //计算均线数值
    function CalculateMA(dayCount) {
        let result = [];
        for (let arrayIndex = 0, len = dataStrObject.values.length; arrayIndex < len; arrayIndex++) {
            if (arrayIndex < dayCount) {
                result.push('-');
                continue;
            }
            let sum = 0;
            for (let currentDay = 0; currentDay < dayCount; currentDay++) {
                //将时间字符串转化为数值
                sum += Number(dataStrObject.values[arrayIndex - currentDay][1]);
            }
            //均线计算结果保留4位小数
            result.push((sum / dayCount).toFixed(4));
        }
        return result;
    }

    export default {
        mounted() {
            //初始化图表实例
            MainPageChart = echarts.init(document.getElementById("MainIndexChart"), 'light');
            //组件加载时默认显示沪深300图线
            this.MainIndexChartShow('000300');
            $(function () {
                //设置并起动图片轮播，设置轮播频率为3000ms。当组件切换时，回到首页时，会出现轮播功能失效
                $('.carousel').carousel({interval: 3000});
                //主要市场指数标签的选中效果
                $("li.MainIndexSelectTab").bind("click", function () {
                    $(this).siblings().removeClass("active");
                    $(this).addClass("active");
                });
            });
        },
        data() {
            return {};
        },
        methods: {
            MainIndexChartShow(stockCode) {
                //显示数据载入图标
                MainPageChart.showLoading();
                $.ajax({
                    type: "POST",
                    url: "MainIndexChartShow.do",
                    data: stockCode,
                    contentType: "application/json",
                    dataType: "json",
                    success: (data) => {
                        //日期数据数组
                        var dataArray = new Array();
                        //图表标题
                        var chartTitle;
                        $.each(data, (index, item) => {
                            //净值数据数组
                            var SingleDayValueArray = new Array();
                            SingleDayValueArray[0] = item.valueDate;
                            SingleDayValueArray[1] = item.openingPrice;
                            SingleDayValueArray[2] = item.closingPrice;
                            SingleDayValueArray[3] = item.lowestPrice;
                            SingleDayValueArray[4] = item.topPrice;
                            dataArray[index] = SingleDayValueArray;
                        });
                        //将ajax响应结果做日期、净值数据分离，返回一个对象，该对象包含两个数组属性：1、全部日期categoryData，2、全部净值values
                        dataStrObject = SplitData(dataArray);
                        //根据股票代码确定图表名称
                        if (stockCode.search("000300") != -1) {
                            chartTitle = "沪深300" + "(" + stockCode + ")";
                        }
                        if (stockCode.search("000918") != -1) {
                            chartTitle = "沪深300成长指数" + "(" + stockCode + ")";
                        }
                        if (stockCode.search("000919") != -1) {
                            chartTitle = "沪深300价值指数" + "(" + stockCode + ")";
                        }
                        if (stockCode.search("000905") != -1) {
                            chartTitle = "中证500" + "(" + stockCode + ")";
                        }
                        if (stockCode.search("000852") != -1) {
                            chartTitle = "中证1000" + "(" + stockCode + ")";
                        }
                        if (stockCode.search("399006") != -1) {
                            chartTitle = "创业板指" + "(" + stockCode + ")";
                        }
                        if (stockCode.search("000010") != -1) {
                            chartTitle = "上证180" + "(" + stockCode + ")";
                        }
                        if (stockCode.search("000046") != -1) {
                            chartTitle = "上证中小盘指数" + "(" + stockCode + ")";
                        }
                        //隐藏数据载入图标
                        MainPageChart.hideLoading();
                        //图表配置项
                        MainPageChart.setOption({
                            title: {
                                text: chartTitle,
                                x: 'center',
                            },
                            tooltip: {
                                trigger: 'axis',
                                axisPointer: {
                                    type: 'cross'
                                }
                            },
                            legend: {
                                data: ['日K', 'MA5', 'MA10', 'MA20', 'MA30'],
                                x: 'center',
                                top: 30
                            },
                            grid: {
                                left: '10%',
                                right: '10%',
                                bottom: '15%'
                            },
                            xAxis: {
                                type: 'category',
                                data: dataStrObject.categoryData,
                                scale: true,
                                boundaryGap: false,
                                axisLine: {onZero: false},
                                splitLine: {show: false},
                                splitNumber: 20,
                                min: 'dataMin',
                                max: 'dataMax'
                            },
                            yAxis: {
                                scale: true,
                                splitArea: {
                                    show: true
                                }
                            },
                            dataZoom: [
                                {
                                    type: 'inside',
                                    start: 95,
                                    end: 100
                                },
                                {
                                    show: true,
                                    type: 'slider',
                                    y: '90%',
                                    start: 95,
                                    end: 100
                                }
                            ],
                            series: [
                                {
                                    name: '日K',
                                    type: 'candlestick',
                                    data: dataStrObject.values,
                                    itemStyle: {
                                        normal: {
                                            color: '#ec0000',
                                            color0: '#00da3c',
                                            borderColor: '#8A0000',
                                            borderColor0: '#008F28'
                                        }
                                    },
                                    markPoint: {
                                        label: {
                                            normal: {
                                                formatter: function (param) {
                                                    return param != null ? Math.round(param.value) : '';
                                                }
                                            }
                                        },
                                        //最大值和最小值之间的连线
                                        // data: [
                                        //     {
                                        //         name: 'highest value',
                                        //         type: 'max',
                                        //         valueDim: 'highest'
                                        //     },
                                        //     {
                                        //         name: 'lowest value',
                                        //         type: 'min',
                                        //         valueDim: 'lowest'
                                        //     },
                                        // ],
                                        tooltip: {
                                            formatter: function (param) {
                                                return param.name + '<br>' + (param.data.coord || '');
                                            }
                                        }
                                    },
                                    markLine: {
                                        symbol: ['none', 'none'],
                                        data: [
                                            //标注最大值和最小值数据点
                                            // [
                                            //     {
                                            //         name: 'from lowest to highest',
                                            //         type: 'min',
                                            //         valueDim: 'lowest',
                                            //         symbol: 'circle',
                                            //         symbolSize: 10,
                                            //         label: {
                                            //             normal: {show: false},
                                            //             emphasis: {show: false}
                                            //         }
                                            //     },
                                            //     {
                                            //         type: 'max',
                                            //         valueDim: 'highest',
                                            //         symbol: 'circle',
                                            //         symbolSize: 10,
                                            //         label: {
                                            //             normal: {show: false},
                                            //             emphasis: {show: false}
                                            //         }
                                            //     }
                                            // ],
                                            {
                                                //当前视图中收盘价最小值的虚线标注
                                                name: 'min line on close',
                                                type: 'min',
                                                valueDim: 'close'
                                            },
                                            {
                                                //当前视图中收盘价最大值的虚线标注
                                                name: 'max line on close',
                                                type: 'max',
                                                valueDim: 'close'
                                            }
                                        ]
                                    }
                                },
                                {
                                    name: 'MA5',
                                    type: 'line',
                                    data: CalculateMA(5),
                                    smooth: true,
                                    lineStyle: {
                                        normal: {opacity: 0.5}
                                    }
                                },
                                {
                                    name: 'MA10',
                                    type: 'line',
                                    data: CalculateMA(10),
                                    smooth: true,
                                    lineStyle: {
                                        normal: {opacity: 0.5}
                                    }
                                },
                                {
                                    name: 'MA20',
                                    type: 'line',
                                    data: CalculateMA(20),
                                    smooth: true,
                                    lineStyle: {
                                        normal: {opacity: 0.5}
                                    }
                                },
                                {
                                    name: 'MA30',
                                    type: 'line',
                                    data: CalculateMA(30),
                                    smooth: true,
                                    lineStyle: {
                                        normal: {opacity: 0.5}
                                    }
                                },

                            ]
                        });
                    },
                    error: () => {
                        //隐藏数据载入图标
                        MainPageChart.hideLoading();
                        alert("载入图表失败");
                    }
                });
            }
        }
    };
</script>
