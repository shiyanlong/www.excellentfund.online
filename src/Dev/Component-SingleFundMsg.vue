<template>
    <div class="row">
        <div class="col-xs-12">

            <div class="row" style="margin-top: 20px;margin-bottom: 20px;border: #cce0ff solid 1px">
                <div class="col-xs-12">
                    <!--标题-->
                    <div class="row">
                        <div class="col-xs-12 title">
                            <div>
                                {{fundBaseDataItem.fundName}}[{{fundBaseDataItem.fundCode}}]
                                <!--btn-primary样式为蓝底背景、glyphicon-plus样式为加号，未添加当前基金时显示，此时alreadyAddElementToFundNameAndCodeArray为false-->
                                <!--btn-default为白底背景，glyphicon-ok样式为打勾，添加当前基金后显示，此时alreadyAddElementToFundNameAndCodeArray为true-->
                                <button type="button" class="btn"
                                        :class="{'btn-primary':!alreadyAddElementToFundNameAndCodeArray,'btn-default':alreadyAddElementToFundNameAndCodeArray}"
                                        @click="AddElementToFundNameAndCodeArray(fundBaseDataItem)"
                                        style="margin-left: 15px;margin-bottom:4px;margin-top:3px">
                                    <span class="glyphicon"
                                          :class="{'glyphicon-plus':!alreadyAddElementToFundNameAndCodeArray,'glyphicon-ok':alreadyAddElementToFundNameAndCodeArray}"
                                          aria-hidden="true"></span>{{GetAddElementToFundNameAndCodeArrayBtnStr}}
                                </button>
                                <!--出现重复时，提示-->
                                <div class="alert alert-danger" role="alert"
                                     style="display: inline-block;font-size: 14px;padding-top: 1px;padding-bottom: 1px;margin-left: 15px; margin-bottom: 0;line-height:30px;"
                                     v-show="searchMsgTipShow">
                                    <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
                                    <span class="sr-only">Error:</span>
                                    {{GetSearchMsgTip}}
                                </div>
                            </div>
                        </div>
                    </div>
                    <!--最新累计净值-->
                    <div class="row">
                        <div class="col-xs-4">
                            <div style="font-size: 16px;font-family: '微软雅黑';line-height: 30px;">
                                <p>单位净值（<span>{{fundBaseDataItem.fundLastNAVDate}}</span>）</p>
                            </div>
                            <div style="font-size: 26px;font-family: Arial;line-height: 50px;">
                                <p id="NAVShow">{{fundBaseDataItem.fundLastNAV}}</p>
                            </div>
                        </div>
                        <div class="col-xs-4">
                            <div style="font-size: 16px;font-family: '微软雅黑';line-height: 30px;">
                                <p>累计净值</p>
                            </div>
                            <div style="font-size: 26px;font-family: Arial;line-height: 50px;">
                                <p id="cumulativeNAVShow">{{fundBaseDataItem.fundCumulativeNAV}}</p>
                            </div>
                        </div>
                        <div class="col-xs-4">
                            <div style="font-size: 16px;font-family: '微软雅黑';line-height: 30px;">
                                <p>基金类型</p>
                            </div>
                            <div style="font-size: 26px;font-family: Arial;line-height: 50px;">
                                <p id="fundTypeShow">{{GetFundType}}</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row" style="margin-top: 20px;margin-bottom: 20px;border: #cce0ff solid 1px">
                <div class="col-xs-12">
                    <!--标题-->
                    <div class="row">
                        <div class="col-xs-12 title">
                            <p>单位净值自然日区间增长率</p>
                        </div>
                    </div>
                    <!--最新累计净值-->
                    <div class="row">
                        <div class="col-xs-2">
                            <div style="font-size: 16px;font-family: '微软雅黑';line-height: 30px;">
                                <p>近1周：<span>{{fundBaseDataItem.fundIncomeRateOneWeek===""?"-":fundBaseDataItem.fundIncomeRateOneWeek+"%"}}</span>
                                </p>
                            </div>
                        </div>
                        <div class="col-xs-2">
                            <div style="font-size: 16px;font-family: '微软雅黑';line-height: 30px;">
                                <p>近1月：<span>{{fundBaseDataItem.fundIncomeRateOneMonth===""?"-":fundBaseDataItem.fundIncomeRateOneMonth+"%"}}</span>
                                </p>
                            </div>
                        </div>
                        <div class="col-xs-2">
                            <div style="font-size: 16px;font-family: '微软雅黑';line-height: 30px;">
                                <p>近3月：<span>{{fundBaseDataItem.fundIncomeRateThreeMonth===""?"-":fundBaseDataItem.fundIncomeRateThreeMonth+"%"}}</span>
                                </p>
                            </div>
                        </div>
                        <div class="col-xs-2">
                            <div style="font-size: 16px;font-family: '微软雅黑';line-height: 30px;">
                                <p>近6月：<span>{{fundBaseDataItem.fundIncomeRateSixMonth===""?"-":fundBaseDataItem.fundIncomeRateSixMonth+"%"}}</span>
                                </p>
                            </div>
                        </div>
                        <div class="col-xs-2">
                            <div style="font-size: 16px;font-family: '微软雅黑';line-height: 30px;">
                                <p>近1年：<span>{{fundBaseDataItem.fundIncomeRateOneYear===""?"-":fundBaseDataItem.fundIncomeRateOneYear+"%"}}</span>
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-2">
                            <div style="font-size: 16px;font-family: '微软雅黑';line-height: 30px;">
                                <p>近2年：<span>{{fundBaseDataItem.fundIncomeRateTwoYear===""?"-":fundBaseDataItem.fundIncomeRateTwoYear+"%"}}</span>
                                </p>
                            </div>
                        </div>
                        <div class="col-xs-2">
                            <div style="font-size: 16px;font-family: '微软雅黑';line-height: 30px;">
                                <p>近3年：<span>{{fundBaseDataItem.fundIncomeRateThreeYear===""?"-":fundBaseDataItem.fundIncomeRateThreeYear+"%"}}</span>
                                </p>
                            </div>
                        </div>
                        <div class="col-xs-2">
                            <div style="font-size: 16px;font-family: '微软雅黑';line-height: 30px;">
                                <p>今年以来：<span>{{fundBaseDataItem.fundIncomeRateCurrentYear===""?"-":fundBaseDataItem.fundIncomeRateCurrentYear+"%"}}</span>
                                </p>
                            </div>
                        </div>
                        <div class="col-xs-2">
                            <div style="font-size: 16px;font-family: '微软雅黑';line-height: 30px;">
                                <p>成立至今：<span>{{fundBaseDataItem.fundIncomeRateCreatedToNow===""?"-":fundBaseDataItem.fundIncomeRateCreatedToNow+"%"}}</span>
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-12">
                            <!--分割线-->
                            <div style="height: 1px;border-top: 1px solid #ddd;text-align: center;"></div>
                            <!--数据说明-->
                            <ul style="font-family:'微软雅黑';font-size: 12px;color: #474747;text-align: left;list-style: none;padding: 0">
                                <li>数据说明：</li>
                                <li>
                                    该指标的时间区间为自然日，周末也计入时间区间。例如：计算7月11日近1周的单位净值区间收益率，要从7月11日回退7个自然日，若期间的7月8日、9日为周末，也一并计入时间区间，对应时间区间为7月4日起至7月11日，取7月4日和7月11日两天的单位净值计算。
                                </li>
                                <li>
                                    多数的基金排行喜用这个指标，直观简洁，然而该指标衡量基金成长性比较片面。采用单位净值，如果计算区间遇到基金分红、份额折算，从数值上看，会形成回撤假象，造成极大的计算误差。
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row" style="margin-top: 20px;margin-bottom: 20px;border: #cce0ff solid 1px">
                <div class="col-xs-12">
                    <!--标题-->
                    <div class="row">
                        <div class="col-xs-12 title">
                            <p>累计净值工作日区间增长率</p>
                        </div>
                    </div>
                    <!--最新累计净值-->
                    <div class="row">
                        <div class="col-xs-4">
                            <div style="font-size: 16px;font-family: '微软雅黑';line-height: 30px;">
                                <p>近30工作日：<span>{{fundPerformanceDataItem.fundIncomeRate30Day===""?"-":(fundPerformanceDataItem.fundIncomeRate30Day*100).toFixed(2)+"%"}}</span>
                                </p>
                            </div>
                        </div>
                        <div class="col-xs-4">
                            <div style="font-size: 16px;font-family: '微软雅黑';line-height: 30px;">
                                <p>近90工作日：<span>{{fundPerformanceDataItem.fundIncomeRate90Day===""?"-":(fundPerformanceDataItem.fundIncomeRate90Day*100).toFixed(2)+"%"}}</span>
                                </p>
                            </div>
                        </div>
                        <div class="col-xs-4">
                            <div style="font-size: 16px;font-family: '微软雅黑';line-height: 30px;">
                                <p>近180工作日：<span>{{fundPerformanceDataItem.fundIncomeRate180Day===""?"-":(fundPerformanceDataItem.fundIncomeRate180Day*100).toFixed(2)+"%"}}</span>
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-4">
                            <div style="font-size: 16px;font-family: '微软雅黑';line-height: 30px;">
                                <p>近360工作日：<span>{{fundPerformanceDataItem.fundIncomeRate360Day===""?"-":(fundPerformanceDataItem.fundIncomeRate360Day*100).toFixed(2)+"%"}}</span>
                                </p>
                            </div>
                        </div>
                        <div class="col-xs-4">
                            <div style="font-size: 16px;font-family: '微软雅黑';line-height: 30px;">
                                <p>近1080工作日：<span>{{fundPerformanceDataItem.fundIncomeRate1080Day===""?"-":(fundPerformanceDataItem.fundIncomeRate1080Day*100).toFixed(2)+"%"}}</span>
                                </p>
                            </div>
                        </div>
                        <div class="col-xs-4">
                            <div style="font-size: 16px;font-family: '微软雅黑';line-height: 30px;">
                                <p>成立至今：<span>{{fundPerformanceDataItem.fundIncomeRateCreatedToNow===""?"-":(fundPerformanceDataItem.fundIncomeRateCreatedToNow*100).toFixed(2)+"%"}}</span>
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-12">
                            <!--分割线-->
                            <div style="height: 1px;border-top: 1px solid #ddd;text-align: center;"></div>
                            <!--数据说明-->
                            <ul style="font-family:'微软雅黑';font-size: 12px;color: #474747;text-align: left;list-style: none;padding: 0">
                                <li>数据说明：</li>
                                <li>
                                    该指标的时间区间为工作日，周末不计入时间区间。例如：计算7月11日近7天的累计净值工作日区间增长率，要从7月11日回退7个工作日，，若期间的7月8日、9日为周末，则不计入时间区间，对应时间区间为7月2日起至7月11日，取7月2日和7月11日两天的累计净值计算。
                                </li>
                                <li>
                                    选取工作日，可体现基金在实际运行过程中的变化情况。采用累计净值进行计算，可避免由于基金分红、份额折算形成的回撤假象，可以减少对净值本身的干扰因素，也有助于连续观察基金的波动情况、回撤情况等。
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row" style="margin-top: 20px;margin-bottom: 20px;border: #cce0ff solid 1px">
                <div class="col-xs-12">
                    <!--标题-->
                    <div class="row">
                        <div class="col-xs-12 title">
                            <p>最大回撤</p>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-4">
                            <div style="font-size: 16px;font-family: '微软雅黑';line-height: 30px;">
                                <p>近180工作日最大回撤：<span>{{fundPerformanceDataItem.fundMaxDown180Day===""?"-":fundPerformanceDataItem.fundMaxDown180Day}}</span>
                                </p>
                            </div>
                        </div>
                        <div class="col-xs-4">
                            <div style="font-size: 16px;font-family: '微软雅黑';line-height: 30px;">
                                <p>近180工作日最大回撤持续时间：<span>{{fundPerformanceDataItem.fundMaxDownTime180Day===""?"-":fundPerformanceDataItem.fundMaxDownTime180Day+"天"}}</span>
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-4">
                            <div style="font-size: 16px;font-family: '微软雅黑';line-height: 30px;">
                                <p>近360工作日最大回撤：<span>{{fundPerformanceDataItem.fundMaxDown360Day===""?"-":fundPerformanceDataItem.fundMaxDown360Day}}</span>
                                </p>
                            </div>
                        </div>
                        <div class="col-xs-4">
                            <div style="font-size: 16px;font-family: '微软雅黑';line-height: 30px;">
                                <p>近360工作日最大回撤持续时间：<span>{{fundPerformanceDataItem.fundMaxDownTime360Day===""?"-":fundPerformanceDataItem.fundMaxDownTime360Day+"天"}}</span>
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-12">
                            <!--分割线-->
                            <div style="height: 1px;border-top: 1px solid #ddd;text-align: center;"></div>
                            <!--数据说明-->
                            <ul style="font-family:'微软雅黑';font-size: 12px;color: #474747;text-align: left;list-style: none;padding: 0">
                                <li>数据说明：</li>
                                <li>引入最大回撤持续时间的概念是为了说明净值从最高点到最低点所经历的时间，持续时间越长，则说明基金净值处于下跌状态越久。</li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row" style="margin-top: 20px;margin-bottom: 20px;border: #cce0ff solid 1px">
                <div class="col-xs-12">
                    <!--标题-->
                    <div class="row">
                        <div class="col-xs-12 title">
                            <p>JensenAlpha</p>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-4">
                            <div style="font-size: 16px;font-family: '微软雅黑';line-height: 30px;">
                                <p>近90工作日JensenAlpha：<span>{{fundPerformanceDataItem.fundJensenAlpha90Day===""?"-":fundPerformanceDataItem.fundJensenAlpha90Day}}</span>
                                </p>
                            </div>
                        </div>
                        <div class="col-xs-4">
                            <div style="font-size: 16px;font-family: '微软雅黑';line-height: 30px;">
                                <p>近180工作日JensenAlpha：<span>{{fundPerformanceDataItem.fundJensenAlpha180Day===""?"-":fundPerformanceDataItem.fundJensenAlpha180Day}}</span>
                                </p>
                            </div>
                        </div>
                        <div class="col-xs-4">
                            <div style="font-size: 16px;font-family: '微软雅黑';line-height: 30px;">
                                <p>近360工作日JensenAlpha：<span>{{fundPerformanceDataItem.fundJensenAlpha360Day===""?"-":fundPerformanceDataItem.fundJensenAlpha360Day}}</span>
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-12">
                            <!--分割线-->
                            <div style="height: 1px;border-top: 1px solid #ddd;text-align: center;"></div>
                            <!--数据说明-->
                            <ul style="font-family:'微软雅黑';font-size: 12px;color: #474747;text-align: left;list-style: none;padding: 0">
                                <li>数据说明：</li>
                                <li>衡量基金跑赢业绩比较基准的程度。</li>
                                <li>目前使用的业绩比较基准：沪深300指数、中证500指数以及中债新综合指数对应工作日收益率。</li>
                                <li>
                                    目前无风险利率选取：近90工作日的无风险利率取中债国债收益率标准期限为0.25y时的收益率2.0049%；近180工作日的无风险利率取中债国债收益率标准期限为0.25y时的收益率2.5341%；近360工作日的无风险利率取中债国债收益率标准期限为1.0y时的收益率2.84%
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row" style="margin-top: 20px;margin-bottom: 20px;border: #cce0ff solid 1px">
                <div class="col-xs-12">
                    <!--标题-->
                    <div class="row">
                        <div class="col-xs-12 title">
                            <p>下行标准差</p>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-4">
                            <div style="font-size: 16px;font-family: '微软雅黑';line-height: 30px;">
                                <p>近360工作日下行标准差：<span>{{fundPerformanceDataItem.fundDownStdevp360Day===""?"-":fundPerformanceDataItem.fundDownStdevp360Day}}</span>
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-12">
                            <!--分割线-->
                            <div style="height: 1px;border-top: 1px solid #ddd;text-align: center;"></div>
                            <!--数据说明-->
                            <ul style="font-family:'微软雅黑';font-size: 12px;color: #474747;text-align: left;list-style: none;padding: 0">
                                <li>数据说明：</li>
                                <li>
                                    下行标准差源自标准差，描述不良收益情况下的风险，计算时忽略良性偏移量（即上涨时的偏移量，上涨对于投资人是有利的）产生的影响。通常情况下，该指标数值越小越好，理想状态下，该指标数值为零。该指标需要长期数据作支撑，短期数据的评价意义有限。
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row" style="margin-top: 20px;margin-bottom: 20px;border: #cce0ff solid 1px">
                <div class="col-xs-12">
                    <!--内容第一行：标题-->
                    <div class="row">
                        <div class="col-xs-12 title">
                            <p>累计净值走势</p>
                        </div>
                    </div>
                    <!--内容第一行结束-->

                    <!--内容第二行：累计净值图表-->
                    <div class="row">
                        <div class="col-xs-12">
                            <div id="SingleFundChart" style="overflow: auto;height: 300px;"></div>
                        </div>
                    </div>
                    <!--内容第二行结束-->
                </div>
            </div>

            <!--展示历史数据和业绩指标，1×2布局-->
            <div class="row">
                <!--第一列-->
                <div class="col-xs-7" style="margin-top: 20px;margin-bottom: 20px;border: #cce0ff solid 1px">
                    <div class="row">
                        <div class="col-xs-12 title">
                            <p>历史累计净值</p>
                        </div>
                    </div>
                    <!--第一列第一行结束-->

                    <!--第一列第二行：历史累计净值列表-->
                    <div class="row">
                        <div class="col-xs-12">
                            <table class="table table-striped" style="margin-bottom: 0;">
                                <thead>
                                    <tr>
                                        <th style="width:14%;text-align:center;vertical-align:middle;">日期</th>
                                        <th style="width:14%;text-align:center;vertical-align:middle;">单位净值</th>
                                        <th style="width:14%;text-align:center;vertical-align:middle;">累计净值</th>
                                        <th style="width:14%;text-align:center;vertical-align:middle;">累计净值日增长率</th>
                                        <th style="width:14%;text-align:center;vertical-align:middle;">申购状态</th>
                                        <th style="width:14%;text-align:center;vertical-align:middle;">赎回状态</th>
                                        <th style="width:16%;text-align:center;vertical-align:middle;">分红状态</th>
                                    </tr>
                                </thead>
                            </table>
                            <div style="overflow:auto;height:500px;margin-bottom: 20px;border: #cce0ff solid 1px">
                                <table class="table table-striped"
                                       style="table-layout: fixed;word-break: break-all;word-wrap: break-word;">
                                    <tbody>
                                        <tr v-for="item in dataList">
                                            <td style="width:14%;text-align:center;vertical-align:middle;">
                                                {{item.valueDate}}
                                            </td>
                                            <td style="width:14%;text-align:center;vertical-align:middle;">
                                                {{item.nAV}}
                                            </td>
                                            <td style="width:14%;text-align:center;vertical-align:middle;">
                                                {{item.cumulativeNAV}}
                                            </td>
                                            <td style="width:14%;text-align:center;vertical-align:middle;">
                                                {{item.dailyGrowthRate}}
                                            </td>
                                            <td style="width:14%;text-align:center;vertical-align:middle;">
                                                {{item.subscribeStatus}}
                                            </td>
                                            <td style="width:14%;text-align:center;vertical-align:middle;">
                                                {{item.redemptionStatus}}
                                            </td>
                                            <td style="width:16%;text-align:center;vertical-align:middle;">
                                                {{item.melonCutting}}
                                            </td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    <!--第一列第二行结束-->
                </div>

                <!--占位-->
                <div class="col-xs-1"></div>


                <!--第二列-->
                <div class="col-xs-4"
                     style="margin-top: 20px;margin-bottom: 20px;height: 630px; border: #cce0ff solid 1px">
                    <!--第二列第一行：标题-->
                    <div class="row">
                        <div class="col-xs-12 title">
                            <p>现任基金经理</p>
                        </div>
                    </div>
                    <!--第二列第一行结束-->

                    <!--第二列第二行：业绩指标数据-->
                    <div class="row">
                        <div class="col-xs-12" style="margin-top:10px;margin-bottom: 20px;overflow:auto;height:543px;">
                            <div v-for="item in fundManagerDataArray">
                                <p style="font-size: 18px;font-family: '微软雅黑';line-height: 24px;">
                                    {{item.managerName}}</p>
                                <ul style="font-size: 14px;font-family: '微软雅黑';">
                                    <li>从业时间：{{item.managerWorkTime}}天({{fundBaseDataItem.fundLastNAVDate}})</li>
                                    <li>现任基金资产规模：{{item.currentAssets}}</li>
                                    <li>现任最佳基金：{{item.currentFundMaxIncomeName}}[{{item.currentFundMaxIncomeCode}}]</li>
                                    <li>现任最佳基金回报：{{item.currentFundMaxIncome}}</li>
                                    <li>从业以来最佳回报：{{item.managerWorkTimeMaxIncome}}</li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <!--第二列第二行结束-->
                </div>
            </div>
        </div>
    </div>
</template>
<script>
    var echarts = require('echarts/dist/echarts');

    export default {
        data() {
            return {
                //从上一个路由传入的数据，
                fundBaseDataItem: this.$route.params.item,
                //查询到的基金业绩数据
                fundPerformanceDataItem: "",
                //传入的基金代码
                fundCode: this.$route.params.item.fundCode,
                //传入的基金代码
                fundName: this.$route.params.item.fundName,
                //查询到的历史累计净值
                dataList: [],
                //当前基金的基金经理数据
                fundManagerDataArray: [],
                //当前基金已经添加到数据回测的标志，默认为false，即未添加
                alreadyAddElementToFundNameAndCodeArray: false,
                //是否出现搜索信息提示，默认不显示
                searchMsgTipShow: false,
                //信息提示，提示参比基金不能超过3个
                searchMsgTip: ""
            };
        },
        mounted() {
            //描绘当前基金的所有累计净值图表
            this.SingleFundNAVChartAndTableShow(this.fundCode);
            //获取当前基金的业绩数据
            this.GetFundPerformanceData(this.fundCode);
            //获取当前基金的基金经理数据
            this.GetFundManagerData(this.fundCode, this.fundBaseDataItem.fundLastNAVDate);
            //判断this.$store.getters.GetFundNameAndCodeArray中是否存在当前基金
            let existElementFlag = this.$store.getters.GetFundNameAndCodeArray.some((existItem, index) => {
                return this.fundCode === existItem.fundCode;
            });
            //若没有该基金，不动作，保持alreadyAddElementToFundNameAndCodeArray初始状态false，按钮显示“添加到数据回测”；
            //若已经存在该基金，修改alreadyAddElementToFundNameAndCodeArray为true，按钮显示“已添加”
            if (existElementFlag === true) {
                this.$nextTick(() => {
                    this.alreadyAddElementToFundNameAndCodeArray = true;
                });
            }
        },
        methods: {
            SingleFundNAVChartAndTableShow(fundCode) {
                //初始化图表实例
                var myChart = echarts.init(document.getElementById('SingleFundChart'), 'light');
                //显示数据载入图标
                myChart.showLoading();
                //拆分出来，保存日期的数组
                let fundDateArray = [];
                //拆分出来，保存净值的数组
                let fundValueArray = [];
                $.ajax({
                    type: "POST",
                    url: "SingleFundNAVChartAndTableShow.do",
                    data: "{\"fundCode\": \"" + fundCode + "\"}",
                    contentType: "application/json",
                    dataType: "json",
                    success: (data) => {
                        let valueGrowthRate = "-";
                        $.each(data, (index, item) => {
                            fundDateArray.push(item.valueDate);
                            fundValueArray.push(item.cumulativeNAV);
                            //从第二个净值起计算增长率才有意义
                            if (index > 0) {
                                valueGrowthRate = ((fundValueArray[index] / fundValueArray[index - 1] - 1) * 100).toFixed(2) + "%";
                            }
                            item.dailyGrowthRate = valueGrowthRate;
                            if (item.subscribeStatus === "开放申购") {
                                item.subscribeStatus = "可申购";
                            }
                            if (item.redemptionStatus === "开放赎回") {
                                item.redemptionStatus = "可赎回";
                            }
                            if (item.melonCutting === "") {
                                item.melonCutting = "-";
                            }
                            this.dataList.push(item);
                        });
                        //隐藏数据载入图标
                        myChart.hideLoading();
                        //配置项
                        myChart.setOption({
                            dataZoom: [{
                                type: 'inside',
                                start: 50,
                                end: 100
                            }, {
                                start: 50,
                                end: 100,
                                // handleIcon: '',
                                handleSize: '80%',
                                handleStyle: {
                                    color: '#fff',
                                    shadowBlur: 3,
                                    shadowColor: 'rgba(0, 0, 0, 0.6)',
                                    shadowOffsetX: 2,
                                    shadowOffsetY: 2
                                }
                            }],
                            xAxis: {
                                type: 'category',
                                boundaryGap: false,
                                data: fundDateArray
                            },
                            yAxis: {
                                type: 'value',
                                min: function (value) {
                                    return value.min;
                                }
                            },
                            series: [{
                                data: fundValueArray,
                                type: 'line',
                            }]
                        });
                    },
                    error: () => {
                        //隐藏数据载入图标
                        myChart.hideLoading();
                        alert("载入图表失败");
                    }
                });
            },
            GetFundPerformanceData(fundCode) {
                $.ajax({
                    type: "POST",
                    url: "GetFundPerformanceData.do",
                    data: "{\"fundCode\": \"" + fundCode + "\"}",
                    contentType: "application/json",
                    dataType: "json",
                    success: (data) => {
                        //返回只有一个元素的对象数组
                        this.fundPerformanceDataItem = data[0];
                    },
                    error: () => {
                        alert("GetFundPerformanceData请求失败！");
                    }
                });
            },
            GetFundManagerData(fundCode, fundLastNAVDate) {
                $.ajax({
                    type: "POST",
                    url: "GetFundManagerData.do",
                    data: "{\"fundCode\":\"" + fundCode + "\",\"fundLastNAVDate\":\"" + fundLastNAVDate + "\"}",
                    contentType: "application/json",
                    dataType: "json",
                    success: (data) => {
                        $.each(data, (index, item) => {
                            this.fundManagerDataArray.push(item);
                        });
                    },
                    error: () => {
                        alert("GetFundManagerData请求失败！");
                    }
                });
            },
            AddElementToFundNameAndCodeArray(fundBaseDataItem) {
                //判断this.$store.getters.GetFundNameAndCodeArray是否存在当前基金，则添加，存在则移除
                //注意：some的返回值，当数组为空或没有满足条件时，返回false；当满足条件返回true
                //existElementFlag，vuex中存在该基金的标志：
                //当this.$store.getters.GetFundNameAndCodeArray为空或不存在该基金时，值为false，即添加当前基金
                //当this.$store.getters.GetFundNameAndCodeArray有重复时，值为true，即移除该基金
                //当前基金在vuex出现重复时的下标
                let delElementIndex;
                let existElementFlag = this.$store.getters.GetFundNameAndCodeArray.some((existItem, index) => {
                    delElementIndex = index;
                    return fundBaseDataItem.fundCode === existItem.fundCode;
                });
                //已经存在该基金，移除
                //注意：因为这里的逻辑是存在则删除，所以该if语句块必须放在参比基金数量上限检测之前。若当前参比基金数量达到上限，并且包含了当前基金，先做了删除之后就不会误报超数量上限
                if (existElementFlag === true) {
                    this.$store.commit("DelItemFromFundNameAndCodeArray", delElementIndex);
                }
                //判断当前参比基金数量，最多3支
                if (this.$store.getters.GetFundNameAndCodeArray.length >= 3) {
                    this.$nextTick(() => {
                        this.searchMsgTipShow = true;
                        this.searchMsgTip = "参比基金数量达到上限！";
                    });
                    return;
                }
                //没有该基金，添加
                if (existElementFlag === false) {
                    this.$store.commit("AddItemToFundNameAndCodeArray", fundBaseDataItem);
                }
                //按钮状态初始状态显示“添加到数据回测”，
                //当按钮显示“添加到数据回测”时：点击后修改显示为“已添加”，修改alreadyAddElementToFundNameAndCodeArray为true，添加当前基金到this.$store.getters.GetFundNameAndCodeArray
                //当按钮显示“已添加”时：点击后修改显示为“添加到数据回测”，修改alreadyAddElementToFundNameAndCodeArray为false，将当前基金从this.$store.getters.GetFundNameAndCodeArray移除
                this.alreadyAddElementToFundNameAndCodeArray = !this.alreadyAddElementToFundNameAndCodeArray;
            }
        },
        computed: {
            GetFundType() {
                let typeResultStr = "";
                if (this.fundBaseDataItem.fundType.search("gp") != -1) {
                    typeResultStr = "股票基金";
                }
                if (this.fundBaseDataItem.fundType.search("hh") != -1) {
                    typeResultStr = "债券基金";
                }
                if (this.fundBaseDataItem.fundType.search("zq") != -1) {
                    typeResultStr = "债券基金";
                }
                if (this.fundBaseDataItem.fundType.search("bb") != -1) {
                    typeResultStr = "保本基金";
                }
                if (this.fundBaseDataItem.fundType.search("qdii") != -1) {
                    typeResultStr = "QDII基金";
                }
                if (this.fundBaseDataItem.fundType.search("zs") != -1) {
                    typeResultStr += "、指数跟踪";
                }
                if (this.fundBaseDataItem.fundType.search("lof") != -1) {
                    typeResultStr += "、场内交易";
                }
                return typeResultStr;
            },
            //根据alreadyAddElementToFundNameAndCodeArray返回按钮的显示文本
            GetAddElementToFundNameAndCodeArrayBtnStr() {
                if (this.alreadyAddElementToFundNameAndCodeArray === false) {
                    return "添加到数据回测";
                }
                else {
                    return "已添加";
                }
            },
            //返回搜索信息提示，仅提示“参比基金数量最多为3”
            GetSearchMsgTip() {
                return this.searchMsgTip;
            },
        }
    };
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
