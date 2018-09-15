<template>
    <div id="FundMsgTable" class="row">
        <div class="col-xs-12">

            <div class="row">
                <div class="col-xs-12">
                    <table class="table table-striped" style="margin-bottom: 0;">
                        <thead>
                            <tr style="background-color:#eef7fd;color:#7eabc9;">
                                <th style="width:10%;text-align:center;vertical-align:middle;">基金代码</th>
                                <th style="width:18%;text-align:center;vertical-align:middle;">基金名称</th>
                                <th style="width:10%;text-align:center;vertical-align:middle;">净值日期</th>
                                <th style="width:10%;text-align:center;vertical-align:middle;">单位净值</th>
                                <th style="width:10%;text-align:center;vertical-align:middle;">累计净值</th>
                                <th style="width:10%;text-align:center;vertical-align:middle;">单位净值近3月增长率</th>
                                <th style="width:10%;text-align:center;vertical-align:middle;">单位净值近6月增长率</th>
                                <th style="width:10%;text-align:center;vertical-align:middle;">单位净值近1年增长率</th>
                            </tr>
                        </thead>
                    </table>

                    <div style="overflow:auto;height:666px;border: #cce0ff solid 1px">
                        <table class="table table-striped"
                               v-infinite-scroll="LoadMore"
                               infinite-scroll-disabled="loading"
                               infinite-scroll-distance="5"
                               style="table-layout: fixed;word-break: break-all;word-wrap: break-word;">
                            <tbody>
                                <tr v-for="item in dataList">
                                    <td style="width:10%;text-align:center;vertical-align:middle;">
                                        <a @click="ShowSingleFundMsg(item)"
                                           style="cursor: pointer;">{{item.fundCode}}</a>
                                    </td>
                                    <td style="width:20%;vertical-align:middle;">
                                        <a @click="ShowSingleFundMsg(item)"
                                           style="cursor: pointer;">{{item.fundName}}</a>
                                    </td>
                                    <td style="width:10%;text-align:center;vertical-align:middle;">
                                        {{item.fundLastNAVDate}}
                                    </td>
                                    <td style="width:10%;text-align:center;vertical-align:middle;">
                                        {{item.fundLastNAV}}
                                    </td>
                                    <td style="width:10%;text-align:center;vertical-align:middle;">
                                        {{item.fundCumulativeNAV}}
                                    </td>
                                    <td style="width:10%;text-align:center;vertical-align:middle;">
                                        {{item.fundIncomeRateThreeMonth}}
                                    </td>
                                    <td style="width:10%;text-align:center;vertical-align:middle;">
                                        {{item.fundIncomeRateSixMonth}}
                                    </td>
                                    <td style="width:10%;text-align:center;vertical-align:middle;">
                                        {{item.fundIncomeRateOneYear}}
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>
<script>
    export default {
        data() {
            return {
                dataList: [],
                fundType: this.$route.query.fundType,
                startIndex: 0,
                //每次载入的数据量
                dataNum: 20,
                //停止无限滚动标志，infinite-scroll-disabled：true为停止，false为启用
                loading: false,
                //停止响应无限滚动事件
                stopInfiniteScrollFlag: false,
            };
        },
        methods: {
            LoadMore() {
                //若数据全部载入完成，不再响应
                if (this.stopInfiniteScrollFlag === true) {
                    return;
                }
                this.GetFundBaseDataFromAjax(this.fundType, this.startIndex, this.dataNum);
                this.startIndex = this.dataNum + this.startIndex;
                //停止无限滚动
                this.loading = true;
                //过1500ms后再恢复无限滚动
                this.timerFlag = setTimeout(() => {
                    this.loading = false;
                }, 1500);
            },
            GetFundBaseDataFromAjax(fundType, startIndex, dataNum) {
                let ajax = $.ajax({
                    type: "POST",
                    url: "GetFundBaseData.do",
                    data: "{\"fundType\":\"" + fundType + "\",\"startIndex\":\"" + startIndex + "\",\"dataNum\":\"" + dataNum + "\"}",
                    contentType: "application/json",
                    dataType: "json",
                    success: (data) => {
                        $.each(data, (index, item) => {
                            this.dataList.push(item);
                        });
                    },
                    error: (XMLHttpRequest, textStatus) => {
                        //若数据全部载入完成，后端返回空集合，此时报500错误，将stopInfiniteScrollFlag标志置为true，防止重复发送ajax请求
                        this.stopInfiniteScrollFlag = true;
                    }
                });
            },
            ShowSingleFundMsg(item) {
                this.$router.push({
                    name: 'singleFundMsg',
                    params: {
                        "item": item
                    }
                });
            }
        }
    };
</script>
