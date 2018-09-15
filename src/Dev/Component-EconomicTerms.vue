<template>
    <div class="row">
        <div class="col-xs-3" style="margin-top: 20px;margin-bottom: 20px;">
            <div class="box">
                <ul class="nav nav-pills nav-stacked nav-pills-stacked-example">
                    <li role="presentation" class="ExplanationSelectTab active" style="cursor: pointer;"
                        @click="SetTermsShow('all')">
                        <a>
                            <span style="display:block;font-family: 微软雅黑;font-size: 18px">全部</span>
                        </a>
                    </li>
                    <li role="presentation" class="ExplanationSelectTab" style="cursor: pointer;"
                        @click="SetTermsShow(0)">
                        <a>
                            <span style="display:block;font-family: 微软雅黑;font-size: 18px">市场指数</span>
                            <span style="display:inline-block;font-family: 微软雅黑;font-size: 14px;color: #0D0D0D">例举部分市场指数，在衡量基金业绩时，这部分股票指数可能会参与模型建立。</span>
                        </a>
                    </li>
                    <li role="presentation" class="ExplanationSelectTab" style="cursor: pointer;"
                        @click="SetTermsShow(1)">
                        <a>
                            <span style="display:block;font-family: 微软雅黑;font-size: 18px">统计学</span>
                            <span style="display:inline-block;font-family: 微软雅黑;font-size: 14px;color: #0D0D0D">常见统计学概念</span>
                        </a>
                    </li>
                    <li role="presentation" class="ExplanationSelectTab" style="cursor: pointer;"
                        @click="SetTermsShow(2)">
                        <a>
                            <span style="display:block;font-family: 微软雅黑;font-size: 18px">基金术语</span>
                            <span style="display:inline-block;font-family: 微软雅黑;font-size: 14px;color: #0D0D0D">基金业常用名词及概念</span>
                        </a>
                    </li>
                    <li role="presentation" class="ExplanationSelectTab" style="cursor: pointer;"
                        @click="SetTermsShow(3)">
                        <a>
                            <span style="display:block;font-family: 微软雅黑;font-size: 18px">业绩指标</span>
                            <span style="display:inline-block;font-family: 微软雅黑;font-size: 14px;color: #0D0D0D">常用业绩指标，并以此为基准调整</span>
                        </a>
                    </li>
                </ul>
            </div>
        </div>

        <div class="col-xs-9" style="margin-top: 20px;margin-bottom: 20px;border: #cce0ff solid 1px">
            <div class="box">
                <ul class="nav nav-pills nav-stacked nav-pills-stacked-example">
                    <li role="presentation" class="ExplainTextLine" v-show="economicTermsShowFlagArray[0]"
                        style="cursor: pointer;">
                        <a>
                            <span class="title-normal">沪深300（000300）</span>
                            <span class="detail-hidden"
                                  style="margin-top:6px;width: 14px;height: 10px;background-image:url('./Pic/ArrowUp.png');display: inline-block;float: right"/>
                            <span class="detail-show"
                                  style="margin-top:6px;width: 14px;height: 10px;background-image:url('./Pic/ArrowDown.png');display: none;float: right"/>
                        </a>
                        <div class="Detail mainBody-normal" style="display: none">
                            <p>
                                由上海和深圳证券市场中选取300只A股作为样本编制而成的成份股指数。沪深300指数样本覆盖了沪深市场六成左右的市值，具有良好的市场代表性。沪深300指数是沪深证券交易所第一次联合发布的反映A股市场整体走势的指数。</p>
                        </div>
                    </li>
                    <li role="presentation" class="ExplainTextLine" v-show="economicTermsShowFlagArray[0]"
                        style="cursor: pointer;">
                        <a>
                            <span class="title-normal">沪深300风格指数</span>
                            <span class="detail-hidden"
                                  style="margin-top:6px;width: 14px;height: 10px;background-image:url('./Pic/ArrowUp.png');display: inline-block;float: right"/>
                            <span class="detail-show"
                                  style="margin-top:6px;width: 14px;height: 10px;background-image:url('./Pic/ArrowDown.png');display: none;float: right"/>
                        </a>
                        <div class="Detail mainBody-normal" style="display: none">
                            <p>沪深 300 风格指数以沪深 300 指数为样本空间，根据成长因子和价值因子计算风格评分，分别选取成长得分与价值得分最高的 100
                                只股票构成沪深 300 成长指数与沪深 300 价值指数。另外，沪深 300 成长指数与沪深 300 价值指数分别与样本空间剩余股票组成沪深 300 相对成长指数与沪深 300
                                相对价值指数。4种指数从风格特征的角度进一步刻画沪深 300 指数，为投资者提供更具多元化风险收益特征的投资标的。</p>
                            <p>沪深 300 风格指数系列以 2004 年 12 月 31 日为基日，以 1000 点为基点。</p>
                            <p>沪深 300 成长指数与沪深 300 价值指数的样本股数量一般为 100 只，沪深 300相对成长指数与沪深 300
                                相对价值指数的成分股数量是不定的。</p>
                            <p>（1）沪深300成长指数（000918/399918）</p>
                            <p>选取成长评分最高的 100 只股票作为沪深 300 成长指数的样本股；</p>
                            <p>（2）沪深300价值指数（000919/399919）</p>
                            <p>选取价值评分最高的 100 只股票作为沪深 300 价值指数的样本股；</p>
                            <p>（3）沪深300相对成长指数（000920/399920）</p>
                            <p>选取成长评分最高的 100 只股票以及价值评分处于前 100 名之外的股票作为沪深 300 相对成长指数的样本股；</p>
                            <p>（4）沪深300相对价值指数（000921/399921）</p>
                            <p>选取价值评分最高的 100 只股票以及成长评分处于前 100 名之外的股票作为沪深 300 相对价值指数的样本股。</p>
                        </div>
                    </li>
                    <li role="presentation" class="ExplainTextLine" v-show="economicTermsShowFlagArray[0]"
                        style="cursor: pointer;">
                        <a>
                            <span class="title-normal">中证500（000905）</span>
                            <span class="detail-hidden"
                                  style="margin-top:6px;width: 14px;height: 10px;background-image:url('./Pic/ArrowUp.png');display: inline-block;float: right"/>
                            <span class="detail-show"
                                  style="margin-top:6px;width: 14px;height: 10px;background-image:url('./Pic/ArrowDown.png');display: none;float: right"/>
                        </a>
                        <div class="Detail mainBody-normal" style="display: none">
                            <p>
                                扣除沪深300指数样本股及最近一年日均总市值排名前300名的股票，剩余股票按照最近一年（新股为上市以来）的日均成交金额由高到低排名，剔除排名后20%的股票，然后将剩余股票按照日均总市值由高到低进行排名，选取排名在前500名的股票作为中证500指数样本股。中证500指数综合反映沪深证券市场内小市值公司的整体状况。</p>
                        </div>
                    </li>
                    <li role="presentation" class="ExplainTextLine" v-show="economicTermsShowFlagArray[0]"
                        style="cursor: pointer;">
                        <a>
                            <span class="title-normal">中证1000（000852） </span>
                            <span class="detail-hidden"
                                  style="margin-top:6px;width: 14px;height: 10px;background-image:url('./Pic/ArrowUp.png');display: inline-block;float: right"/>
                            <span class="detail-show"
                                  style="margin-top:6px;width: 14px;height: 10px;background-image:url('./Pic/ArrowDown.png');display: none;float: right"/>
                        </a>
                        <div class="Detail mainBody-normal" style="display: none">
                            <p>选择中证800指数样本股之外规模偏小且流动性好的1000只股票组成指数样本，与沪深300和中证500等指数形成互补。</p>
                        </div>
                    </li>
                    <li role="presentation" class="ExplainTextLine" v-show="economicTermsShowFlagArray[0]"
                        style="cursor: pointer;">
                        <a>
                            <span class="title-normal">上证50（000016）</span>
                            <span class="detail-hidden"
                                  style="margin-top:6px;width: 14px;height: 10px;background-image:url('./Pic/ArrowUp.png');display: inline-block;float: right"/>
                            <span class="detail-show"
                                  style="margin-top:6px;width: 14px;height: 10px;background-image:url('./Pic/ArrowDown.png');display: none;float: right"/>
                        </a>
                        <div class="Detail mainBody-normal" style="display: none">
                            <p>
                                根据科学客观的方法，挑选上海证券市场规模大、流动性好的最具代表性的50只股票组成样本股，以便综合反映上海证券市场最具市场影响力的一批龙头企业的整体状况。上证50指数自2004年1月2日起正式发布。其目标是建立一个成交活跃、规模较大、主要作为衍生金融工具基础的投资指数。</p>
                        </div>
                    </li>
                    <li role="presentation" class="ExplainTextLine" v-show="economicTermsShowFlagArray[0]"
                        style="cursor: pointer;">
                        <a>
                            <span class="title-normal">上证180（000010）</span>
                            <span class="detail-hidden"
                                  style="margin-top:6px;width: 14px;height: 10px;background-image:url('./Pic/ArrowUp.png');display: inline-block;float: right"/>
                            <span class="detail-show"
                                  style="margin-top:6px;width: 14px;height: 10px;background-image:url('./Pic/ArrowDown.png');display: none;float: right"/>
                        </a>
                        <div class="Detail mainBody-normal" style="display: none">
                            <p>
                                上证成份指数（简称上证180指数）是上海证券交易所对原上证30指数进行了调整并更名而成的，其样本股是在所有A股股票中抽取最具市场代表性的180种样本股票，自2002年7月1日起正式发布。作为上证指数系列核心的上证180指数的编制方案，目的在于建立一个反映上海证券市场的概貌和运行状况、具有可操作性和投资性、能够作为投资评价尺度及金融衍生产品基础的基准指数。</p>
                        </div>
                    </li>
                    <li role="presentation" class="ExplainTextLine" v-show="economicTermsShowFlagArray[0]"
                        style="cursor: pointer;">
                        <a>
                            <span class="title-normal">上证380（000009）</span>
                            <span class="detail-hidden"
                                  style="margin-top:6px;width: 14px;height: 10px;background-image:url('./Pic/ArrowUp.png');display: inline-block;float: right"/>
                            <span class="detail-show"
                                  style="margin-top:6px;width: 14px;height: 10px;background-image:url('./Pic/ArrowDown.png');display: none;float: right"/>
                        </a>
                        <div class="Detail mainBody-normal" style="display: none">
                            <p>由380家规模适中、成长性好、盈利能力强公司组成，以综合反映上交所一批新兴蓝筹公司整体表现。</p>
                        </div>
                    </li>
                    <li role="presentation" class="ExplainTextLine" v-show="economicTermsShowFlagArray[0]"
                        style="cursor: pointer;">
                        <a>
                            <span class="title-normal">上证中盘指数（000044）</span>
                            <span class="detail-hidden"
                                  style="margin-top:6px;width: 14px;height: 10px;background-image:url('./Pic/ArrowUp.png');display: inline-block;float: right"/>
                            <span class="detail-show"
                                  style="margin-top:6px;width: 14px;height: 10px;background-image:url('./Pic/ArrowDown.png');display: none;float: right"/>
                        </a>
                        <div class="Detail mainBody-normal" style="display: none">
                            <p>由上证180指数成份股中剔除50只上证50指数成份股后剩余的130家成份股构成，以综合反映沪市中盘公司的整体状况。</p>
                        </div>
                    </li>
                    <li role="presentation" class="ExplainTextLine" v-show="economicTermsShowFlagArray[0]"
                        style="cursor: pointer;">
                        <a>
                            <span class="title-normal">上证小盘指数（000045）</span>
                            <span class="detail-hidden"
                                  style="margin-top:6px;width: 14px;height: 10px;background-image:url('./Pic/ArrowUp.png');display: inline-block;float: right"/>
                            <span class="detail-show"
                                  style="margin-top:6px;width: 14px;height: 10px;background-image:url('./Pic/ArrowDown.png');display: none;float: right"/>
                        </a>
                        <div class="Detail mainBody-normal" style="display: none">
                            <p>
                                样本空间剔除180只上证180指数成份股后的剩余股票，根据总市值、成交金额进行综合排名，选取排名靠前320只股票组成样本，以综合反映沪市小盘公司的整体状况。</p>
                        </div>
                    </li>
                    <li role="presentation" class="ExplainTextLine" v-show="economicTermsShowFlagArray[0]"
                        style="cursor: pointer;">
                        <a>
                            <span class="title-normal">上证中小盘指数（000046）</span>
                            <span class="detail-hidden"
                                  style="margin-top:6px;width: 14px;height: 10px;background-image:url('./Pic/ArrowUp.png');display: inline-block;float: right"/>
                            <span class="detail-show"
                                  style="margin-top:6px;width: 14px;height: 10px;background-image:url('./Pic/ArrowDown.png');display: none;float: right"/>
                        </a>
                        <div class="Detail mainBody-normal" style="display: none">
                            <p>由上证中盘指数和上证小盘指数成份股一起构成，以综合反映沪市中小盘公司的整体状况。</p>
                        </div>
                    </li>
                    <li role="presentation" class="ExplainTextLine" v-show="economicTermsShowFlagArray[0]"
                        style="cursor: pointer;">
                        <a>
                            <span class="title-normal">上证全指（000047）</span>
                            <span class="detail-hidden"
                                  style="margin-top:6px;width: 14px;height: 10px;background-image:url('./Pic/ArrowUp.png');display: inline-block;float: right"/>
                            <span class="detail-show"
                                  style="margin-top:6px;width: 14px;height: 10px;background-image:url('./Pic/ArrowDown.png');display: none;float: right"/>
                        </a>
                        <div class="Detail mainBody-normal" style="display: none">
                            <p>由上证180和上证小盘指数成份股一起构成，以综合反映沪市大中小盘公司的整体状况。</p>
                        </div>
                    </li>
                    <li role="presentation" class="ExplainTextLine" v-show="economicTermsShowFlagArray[0]"
                        style="cursor: pointer;">
                        <a>
                            <span class="title-normal">上证市值百强指数（000155）</span>
                            <span class="detail-hidden"
                                  style="margin-top:6px;width: 14px;height: 10px;background-image:url('./Pic/ArrowUp.png');display: inline-block;float: right"/>
                            <span class="detail-show"
                                  style="margin-top:6px;width: 14px;height: 10px;background-image:url('./Pic/ArrowDown.png');display: none;float: right"/>
                        </a>
                        <div class="Detail mainBody-normal" style="display: none">
                            <p>从市值管理角度反映上证全指中市值最大、成交最活跃的100只股票的整体表现。</p>
                        </div>
                    </li>
                    <li role="presentation" class="ExplainTextLine" v-show="economicTermsShowFlagArray[1]"
                        style="cursor: pointer;">
                        <a>
                            <span class="title-normal">中位数</span>
                            <span class="detail-hidden"
                                  style="margin-top:6px;width: 14px;height: 10px;background-image:url('./Pic/ArrowUp.png');display: inline-block;float: right"/>
                            <span class="detail-show"
                                  style="margin-top:6px;width: 14px;height: 10px;background-image:url('./Pic/ArrowDown.png');display: none;float: right"/>
                        </a>
                        <div class="Detail mainBody-normal" style="display: none">
                            <p>（1）概念</p>
                            <p>
                                代表一个样本、种群或概率分布中的一个数值，其可将数值集合划分为相等的上下两部分。</p>
                            <p>
                                对于有限的数集，可以通过把所有观察值高低排序后找出正中间的一个作为中位数。如果观察值有偶数个，通常取最中间的两个数值的平均数作为中位数。</p>
                            <p>（2）算术平均数与中位数比较</p>
                            <p>
                                中位数趋于数据集合的中间，是所有数据的代表值，它不受分布数列的极大或极小值影响，对极大极小值不敏感，一定程度上提高了中位数对分布数列的代表性。有些离散型变量的单项式数列，当次数分布偏态时，中位数的代表性会受到影响。</p>
                            <p>
                                中位数的作用与算术平均数相近，也是作为数据的代表值。在一个等差数列或一个正态分布数列中，中位数就等于算术平均数。</p>
                            <p>（3）使用</p>
                            <p>在一组数据中，如果个别数据有很大的变动，选择中位数表示这组数据的“集中趋势”就比较适合。</p>
                            <p>在数列中出现了极端值的情况下，用中位数作为代表值比算术平均数更好。如果研究的目的是为了反映中间水平，应该用中位数。</p>
                        </div>
                    </li>
                    <li role="presentation" class="ExplainTextLine" v-show="economicTermsShowFlagArray[1]"
                        style="cursor: pointer;">
                        <a>
                            <span class="title-normal">众数</span>
                            <span class="detail-hidden"
                                  style="margin-top:6px;margin-top:6px;width: 14px;height: 10px;background-image:url('./Pic/ArrowUp.png');display: inline-block;float: right"/>
                            <span class="detail-show"
                                  style="margin-top:6px;width: 14px;height: 10px;background-image:url('./Pic/ArrowDown.png');display: none;float: right"/>
                        </a>
                        <div class="Detail mainBody-normal" style="display: none">
                            <p>（1）概念</p>
                            <p>
                                是一组数据中出现频率最多的数。用众数代表一组数据，适合于数据量较多时使用，且众数不受极端数据的影响。当数值或被观察者没有明显次序（如非数值性资料）时特别有用，此时无法良好定义算术平均数和中位数。一组数据可能没有众数或有多个众数。在正态分布中，众数位于峰值。</p>
                            <p>（2）使用</p>
                            <p>众数主要用于分类数据，也可用于顺序数据和数值型数据。</p>
                        </div>
                    </li>
                    <li role="presentation" class="ExplainTextLine" v-show="economicTermsShowFlagArray[1]"
                        style="cursor: pointer">
                        <a>
                            <span class="title-normal">数学期望</span>
                            <span class="detail-hidden"
                                  style="margin-top:6px;width: 14px;height: 10px;background-image:url('./Pic/ArrowUp.png');display: inline-block;float: right"/>
                            <span class="detail-show"
                                  style="margin-top:6px;width: 14px;height: 10px;background-image:url('./Pic/ArrowDown.png');display: none;float: right"/>
                        </a>
                        <div class="Detail mainBody-normal" style="display: none">
                            <p>（1）概念</p>
                            <p>随机变量X的期望衡量了X取值的平均水平，它是对X所有可能取值按照其发生概率大小加权后得到的平均值。</p>
                            <p class="mainBody-normal text-center"><img
                                    style="width: 253px;height: 62px;display: inline-block;background-image:url('./Pic/image001.png')"/>
                            </p>
                            <p>变量含义：</p>
                            <p><img
                                    style="width: 28px;height: 21px;display: inline-block;background-image:url('./Pic/image002.png')"/>
                                数学期望</p>
                            <p><img
                                    style="width: 15px;height: 21px;display: inline-block;background-image:url('./Pic/image003.png')"/>
                                离散型随机变量X的取值</p>
                            <p><img
                                    style="width: 15px;height: 21px;display: inline-block;background-image:url('./Pic/image004.png')"/>
                                离散型随机变量X对应取值的概率</p>
                            <p>当X的分布未知时，可以抽取样本的算术平均数（样本均值）<img
                                    style="width: 79px;height: 42px;display: inline-block;background-image:url('./Pic/image005.png')"/>作为<img
                                    style="width: 28px;height: 21px;display: inline-block;background-image:url('./Pic/image002.png')"/>的估计值。
                            </p>
                        </div>
                    </li>
                    <li role="presentation" class="ExplainTextLine" v-show="economicTermsShowFlagArray[1]"
                        style="cursor: pointer;">
                        <a>
                            <span class="title-normal">正态分布（高斯分布）</span>
                            <span class="detail-hidden"
                                  style="margin-top:6px;width: 14px;height: 10px;background-image:url('./Pic/ArrowUp.png');display: inline-block;float: right"/>
                            <span class="detail-show"
                                  style="margin-top:6px;width: 14px;height: 10px;background-image:url('./Pic/ArrowDown.png');display: none;float: right"/>
                        </a>
                        <div class="Detail mainBody-normal" style="display: none">
                            <p>（1）图形特征</p>
                            <p>集中性：正态曲线的高峰位于正中央，即均数所在的位置。</p>
                            <p>对称性：正态曲线以均数为中心，左右对称，曲线两端永远不与横轴相交。</p>
                            <p>均匀变动性：正态曲线由均数所在处开始，分别向左右两侧逐渐均匀下降。</p>
                            <p>曲线与横轴间的面积总等于1，相当于概率密度函数的函数从正无穷到负无穷积分的概率为1。即频率的总和为100%</p>
                            <p class="mainBody-normal text-center"><img
                                    style="width: 411px;height: 189px;display: inline-block;background-image:url('./Pic/image006.png')"/>
                            </p>
                            <p>（2）观点</p>
                            <p>
                                统计2010年至2018年上证指数收盘价数据如下，如果将时间区间拉足够长或区间选取适当，可以形成类似钟型曲线的正态分布样。 </p>
                            <p class="mainBody-normal text-center"><img
                                    style="width: 463px;height: 263px;display: inline-block;background-image:url('./Pic/image007.png')"/>
                            </p>
                        </div>
                    </li>
                    <li role="presentation" class="ExplainTextLine" v-show="economicTermsShowFlagArray[2]"
                        style="cursor: pointer;">
                        <a>
                            <span class="title-normal">基金的类型及分类依据</span>
                            <span class="detail-hidden"
                                  style="margin-top:6px;width: 14px;height: 10px;background-image:url('./Pic/ArrowUp.png');display: inline-block;float: right"/>
                            <span class="detail-show"
                                  style="margin-top:6px;width: 14px;height: 10px;background-image:url('./Pic/ArrowDown.png');display: none;float: right"/>
                        </a>
                        <div class="Detail mainBody-normal" style="display: none">
                            <p>《公开募集证券投资基金运作管理办法》（证监会令第104号）有如下规定：</p>
                            <p>第三十条 基金合同和基金招募说明书应当按照下列规定载明基金的类别：</p>
                            <p>（一）百分之八十以上的基金资产投资于股票的，为股票基金；</p>
                            <p>（二）百分之八十以上的基金资产投资于债券的，为债券基金；</p>
                            <p>（三）仅投资于货币市场工具的，为货币市场基金；</p>
                            <p>（四）百分之八十以上的基金资产投资于其他基金份额的，为基金中基金；</p>
                            <p>（五）投资于股票、债券、货币市场工具或其他基金份额，并且股票投资、债券投资、基金投资的比例不符合第（一）项、第（二）项、第（四）项规定的，为混合基金；</p>
                        </div>
                    </li>
                    <li role="presentation" class="ExplainTextLine" v-show="economicTermsShowFlagArray[2]"
                        style="cursor: pointer;">
                        <a>
                            <span class="title-normal">认购</span>
                            <span class="detail-hidden"
                                  style="margin-top:6px;width: 14px;height: 10px;background-image:url('./Pic/ArrowUp.png');display: inline-block;float: right"/>
                            <span class="detail-show"
                                  style="margin-top:6px;width: 14px;height: 10px;background-image:url('./Pic/ArrowDown.png');display: none;float: right"/>
                        </a>
                        <div class="Detail mainBody-normal" style="display: none">
                            <p>指在基金募集期内，投资人根据基金合同和招募说明书的规定申请购买基金份额的行为</p>
                        </div>
                    </li>
                    <li role="presentation" class="ExplainTextLine" v-show="economicTermsShowFlagArray[2]"
                        style="cursor: pointer;">
                        <a>
                            <span class="title-normal">申购</span>
                            <span class="detail-hidden"
                                  style="margin-top:6px;width: 14px;height: 10px;background-image:url('./Pic/ArrowUp.png');display: inline-block;float: right"/>
                            <span class="detail-show"
                                  style="margin-top:6px;width: 14px;height: 10px;background-image:url('./Pic/ArrowDown.png');display: none;float: right"/>
                        </a>
                        <div class="Detail mainBody-normal" style="display: none">
                            <p>指基金合同生效后，投资人根据基金合同和招募说明书的规定申请购买基金份额的行为</p>
                        </div>
                    </li>
                    <li role="presentation" class="ExplainTextLine" v-show="economicTermsShowFlagArray[2]"
                        style="cursor: pointer;">
                        <a>
                            <span class="title-normal">赎回</span>
                            <span class="detail-hidden"
                                  style="margin-top:6px;width: 14px;height: 10px;background-image:url('./Pic/ArrowUp.png');display: inline-block;float: right"/>
                            <span class="detail-show"
                                  style="margin-top:6px;width: 14px;height: 10px;background-image:url('./Pic/ArrowDown.png');display: none;float: right"/>
                        </a>
                        <div class="Detail mainBody-normal" style="display: none">
                            <p>指基金合同生效后，基金份额持有人按基金合同和招募说明书规定的条件要求将基金份额兑换为现金的行为</p>
                        </div>
                    </li>
                    <li role="presentation" class="ExplainTextLine" v-show="economicTermsShowFlagArray[2]"
                        style="cursor: pointer;">
                        <a>
                            <span class="title-normal">A类基金份额</span>
                            <span class="detail-hidden"
                                  style="margin-top:6px;width: 14px;height: 10px;background-image:url('./Pic/ArrowUp.png');display: inline-block;float: right"/>
                            <span class="detail-show"
                                  style="margin-top:6px;width: 14px;height: 10px;background-image:url('./Pic/ArrowDown.png');display: none;float: right"/>
                        </a>
                        <div class="Detail mainBody-normal" style="display: none">
                            <p>指对投资者收取申购费用、赎回时收取赎回费用的，且不从本类别基金资产中计提销售服务费的基金份额</p>
                        </div>
                    </li>
                    <li role="presentation" class="ExplainTextLine" v-show="economicTermsShowFlagArray[2]"
                        style="cursor: pointer;">
                        <a>
                            <span class="title-normal">C类基金份额</span>
                            <span class="detail-hidden"
                                  style="margin-top:6px;width: 14px;height: 10px;background-image:url('./Pic/ArrowUp.png');display: inline-block;float: right"/>
                            <span class="detail-show"
                                  style="margin-top:6px;width: 14px;height: 10px;background-image:url('./Pic/ArrowDown.png');display: none;float: right"/>
                        </a>
                        <div class="Detail mainBody-normal" style="display: none">
                            <p>指对投资者不收取申购费用、赎回时收取赎回费用的，且从本类别基金资产中计提销售服务费的基金份额</p>
                        </div>
                    </li>
                    <li role="presentation" class="ExplainTextLine" v-show="economicTermsShowFlagArray[2]"
                        style="cursor: pointer;">
                        <a>
                            <span class="title-normal">巨额赎回</span>
                            <span class="detail-hidden"
                                  style="margin-top:6px;width: 14px;height: 10px;background-image:url('./Pic/ArrowUp.png');display: inline-block;float: right"/>
                            <span class="detail-show"
                                  style="margin-top:6px;width: 14px;height: 10px;background-image:url('./Pic/ArrowDown.png');display: none;float: right"/>
                        </a>
                        <div class="Detail mainBody-normal" style="display: none">
                            <p>
                                指本基金单个开放日，基金净赎回申请（赎回申请份额总数加上基金转换中转出申请份额总数后扣除申购申请份额总数及基金转换中转入申请份额总数后的余额）超过上一开放日基金总份额的10%的情形</p>
                        </div>
                    </li>
                    <li role="presentation" class="ExplainTextLine" v-show="economicTermsShowFlagArray[2]"
                        style="cursor: pointer;">
                        <a>
                            <span class="title-normal">基金资产总值</span>
                            <span class="detail-hidden"
                                  style="margin-top:6px;width: 14px;height: 10px;background-image:url('./Pic/ArrowUp.png');display: inline-block;float: right"/>
                            <span class="detail-show"
                                  style="margin-top:6px;width: 14px;height: 10px;background-image:url('./Pic/ArrowDown.png');display: none;float: right"/>
                        </a>
                        <div class="Detail mainBody-normal" style="display: none">
                            <p>指基金拥有的各类有价证券、股指期货合约、银行存款本息、基金应收申购款及其他资产的价值总和</p>
                        </div>
                    </li>
                    <li role="presentation" class="ExplainTextLine" v-show="economicTermsShowFlagArray[2]"
                        style="cursor: pointer;">
                        <a>
                            <span class="title-normal">基金资产净值</span>
                            <span class="detail-hidden"
                                  style="margin-top:6px;width: 14px;height: 10px;background-image:url('./Pic/ArrowUp.png');display: inline-block;float: right"/>
                            <span class="detail-show"
                                  style="margin-top:6px;width: 14px;height: 10px;background-image:url('./Pic/ArrowDown.png');display: none;float: right"/>
                        </a>
                        <div class="Detail mainBody-normal" style="display: none">
                            <p>指基金资产总值减去基金负债后的价值</p>
                        </div>
                    </li>
                    <li role="presentation" class="ExplainTextLine" v-show="economicTermsShowFlagArray[2]"
                        style="cursor: pointer;">
                        <a>
                            <span class="title-normal">基金份额净值（单位净值）</span>
                            <span class="detail-hidden"
                                  style="margin-top:6px;width: 14px;height: 10px;background-image:url('./Pic/ArrowUp.png');display: inline-block;float: right"/>
                            <span class="detail-show"
                                  style="margin-top:6px;width: 14px;height: 10px;background-image:url('./Pic/ArrowDown.png');display: none;float: right"/>
                        </a>
                        <div class="Detail mainBody-normal" style="display: none">
                            <p>指计算日基金资产净值除以计算日基金份额总数</p>
                        </div>
                    </li>
                    <li role="presentation" class="ExplainTextLine" v-show="economicTermsShowFlagArray[2]"
                        style="cursor: pointer;">
                        <a>
                            <span class="title-normal">累计净值</span>
                            <span class="detail-hidden"
                                  style="margin-top:6px;width: 14px;height: 10px;background-image:url('./Pic/ArrowUp.png');display: inline-block;float: right"/>
                            <span class="detail-show"
                                  style="margin-top:6px;width: 14px;height: 10px;background-image:url('./Pic/ArrowDown.png');display: none;float: right"/>
                        </a>
                        <div class="Detail mainBody-normal" style="display: none">
                            <p>基金单位累计净值是基金单位净值与基金成立后历次累计单位派息金额的总和，反映该基金自成立以来的所有收益的数据。</p>
                        </div>
                    </li>
                    <li role="presentation" class="ExplainTextLine" v-show="economicTermsShowFlagArray[3]"
                        style="cursor: pointer;">
                        <a>
                            <span class="title-normal">使用交易日还是自然日</span>
                            <span class="detail-hidden"
                                  style="margin-top:6px;width: 14px;height: 10px;background-image:url('./Pic/ArrowUp.png');display: inline-block;float: right"/>
                            <span class="detail-show"
                                  style="margin-top:6px;width: 14px;height: 10px;background-image:url('./Pic/ArrowDown.png');display: none;float: right"/>
                        </a>
                        <div class="Detail mainBody-normal" style="display: none">
                            <p>
                                使用交易日可以准确刻画基金的运行状态，如2018年1月1日至2018年4月1日的三个月收益率，若采用自然日时间间隔，其中交易日59个，若采用交易日，按每月30天计算，则为90个交易日，将基金收益率与其他产品折算成年化收益比较时，采用交易日更为准确。</p>
                        </div>
                    </li>
                    <li role="presentation" class="ExplainTextLine" v-show="economicTermsShowFlagArray[3]"
                        style="cursor: pointer;">
                        <a>
                            <span class="title-normal">绝对收益</span>
                            <span class="detail-hidden"
                                  style="margin-top:6px;width: 14px;height: 10px;background-image:url('./Pic/ArrowUp.png');display: inline-block;float: right"/>
                            <span class="detail-show"
                                  style="margin-top:6px;width: 14px;height: 10px;background-image:url('./Pic/ArrowDown.png');display: none;float: right"/>
                        </a>
                        <div class="Detail mainBody-normal" style="display: none">
                            <p>
                                绝对收益是证券或投资组合在一定时间区间内所获得的回报，测量证券或投资组合的增值或者贬值，常用百分比表示收益率。绝对收益主要指标有持有区间收益率和基金收益率。</p>
                            <p>（1）持有区间收益率</p>
                            <p>计算方法：</p>
                            <p class="mainBody-normal text-center"><img
                                    style="width: 297px;height: 62px;display: inline-block;background-image:url('./Pic/image008.png')"/>
                            </p>
                            <p>（2）基金收益率</p>
                            <p>和持有区间收益率相比，这种方式考虑了分红的因素，并且前提条件是红利再投资。</p>
                            <p>计算方法：</p>
                            <p class="mainBody-normal text-center"><img
                                    style="width: 490px;height: 42px;display: inline-block;background-image:url('./Pic/image009.png')"/>
                            </p>
                            <p>变量含义：</p>
                            <p><img
                                    style="width: 32px;height: 21px;display: inline-block;background-image:url('./Pic/image010.png')"/>
                                期初份额单位净值</p>
                            <p><img
                                    style="width: 32px;height: 21px;display: inline-block;background-image:url('./Pic/image011.png')"/>、……、<img
                                    style="width: 46px;height: 21px;display: inline-block;background-image:url('./Pic/image012.png')"/>
                                各除息日前一日份额单位净值</p>
                            <p><img
                                    style="width: 32px;height: 21px;display: inline-block;background-image:url('./Pic/image013.png')"/>
                                期末份额单位净值</p>
                            <p><img
                                    style="width: 15px;height: 21px;display: inline-block;background-image:url('./Pic/image014.png')"/>、……、<img
                                    style="width: 16px;height: 21px;display: inline-block;background-image:url('./Pic/image015.png')"/>
                                各期份额分红</p>
                            <p>例如，某基金成立以来分红三次</p>
                            <p>除息日2006-04-25，每份派现金0.0300元，2006-04-24单位净值为1.1257</p>
                            <p>除息日2007-04-24，每份派现金0.0300元，2007-04-23单位净值为3.2675</p>
                            <p>除息日2007-11-21，每份派现金2.8000元，2007-11-20单位净值为4.6728</p>
                            <p>期末最新单位净值为1.6247，期初单位净值为1.00，则成立以来收益率为：</p>
                            <p class="mainBody-normal text-center"><img
                                    style="width: 504px;height: 42px;display: inline-block;background-image:url('./Pic/image016.png')"/>
                            </p>
                            <p>
                                网站中所使用的交易日收益率均采用持有区间收益率，且使用累计净值。可以衡量基金在周期内的走势情况，因为单位净值受分红影响，例如除息日前后单位净值将大幅变动，会干扰最大回撤、标准差等指标。</p>
                        </div>
                    </li>
                    <li role="presentation" class="ExplainTextLine" v-show="economicTermsShowFlagArray[3]"
                        style="cursor: pointer;">
                        <a>
                            <span class="title-normal">相对收益</span>
                            <span class="detail-hidden"
                                  style="margin-top:6px;width: 14px;height: 10px;background-image:url('./Pic/ArrowUp.png');display: inline-block;float: right"/>
                            <span class="detail-show"
                                  style="margin-top:6px;width: 14px;height: 10px;background-image:url('./Pic/ArrowDown.png');display: none;float: right"/>
                        </a>
                        <div class="Detail mainBody-normal" style="display: none">
                            <p>
                                基金相对于指定的业绩比较基准的收益，例如某QDII基金的业绩比较基准：50%×人民币计价的中证海外中国互联网指数收益率+50%×中证移动互联网指数收益率；某混合基金的业绩比较基准：50%×沪深300指数收益率+50%×中证综合债指数收益率。</p>
                        </div>
                    </li>
                    <li role="presentation" class="ExplainTextLine" v-show="economicTermsShowFlagArray[3]"
                        style="cursor: pointer;">
                        <a>
                            <span class="title-normal">最大回撤</span>
                            <span class="detail-hidden"
                                  style="margin-top:6px;width: 14px;height: 10px;background-image:url('./Pic/ArrowUp.png');display: inline-block;float: right"/>
                            <span class="detail-show"
                                  style="margin-top:6px;width: 14px;height: 10px;background-image:url('./Pic/ArrowDown.png');display: none;float: right"/>
                        </a>
                        <div class="Detail mainBody-normal" style="display: none">
                            <p>（1）概念</p>
                            <p>在指定周期内，基金净值从指定时点的净值走到最低点时的回撤幅度。理论上，可用来描述投资者可能面临的的最大亏损。</p>
                        </div>
                    </li>
                    <li role="presentation" class="ExplainTextLine" v-show="economicTermsShowFlagArray[3]"
                        style="cursor: pointer;">
                        <a>
                            <span class="title-normal">标准差</span>
                            <span class="detail-hidden"
                                  style="margin-top:6px;width: 14px;height: 10px;background-image:url('./Pic/ArrowUp.png');display: inline-block;float: right"/>
                            <span class="detail-show"
                                  style="margin-top:6px;width: 14px;height: 10px;background-image:url('./Pic/ArrowDown.png');display: none;float: right"/>
                        </a>
                        <div class="Detail mainBody-normal" style="display: none">
                            <p>（1）概念</p>
                            <p>
                                标准差是一组数据平均值分散程度的一种度量。一个较大的标准差，代表大部分数值和其平均值之间差异较大；一个较小的标准差，代表这些数值较接近平均值。</p>
                            <p>（2）分类</p>
                            <p>
                                一般分为样本标准差和总体标准差。在某些特殊情况下，不然找到一个总体的真实的标准差是不现实的。大多数情况下，总体标准差是通过随机抽取一定量的样本并计算样本标准差估计的。</p>
                            <p>（3）计算方法</p>
                            <p>样本标准差</p>
                            <p class="mainBody-normal text-center"><img
                                    style="width: 146px;height: 83px;display: inline-block;background-image:url('./Pic/image017.png')"/>
                            </p>
                            <p>总体标准差</p>
                            <p class="mainBody-normal text-center"><img
                                    style="width: 122px;height: 83px;display: inline-block;background-image:url('./Pic/image018.png')"/>
                            </p>
                            <p>变量含义：</p>
                            <p><img
                                    style="width: 8px;height: 21px;display: inline-block;background-image:url('./Pic/image019.png')"/>
                                标准差结果</p>
                            <p><img
                                    style="width: 12px;height: 21px;display: inline-block;background-image:url('./Pic/image020.png')"/>
                                数据点</p>
                            <p><img
                                    style="width: 9px;height: 21px;display: inline-block;background-image:url('./Pic/image021.png')"/>
                                算术平均值</p>
                            <p>（4）使用环境和局限</p>
                            <p>
                                对于基金业绩而言，使用标准差可以刻画基金每周（或每月）回报率相对于平均周回报（或月回报）的偏差幅度大小。基金每周回报波动越大，标准差也越大。例如，基金A过去52周每周回报率都是1％，那么其标准差为0。基金B的周回报率是不断变化的，一周为5％，下周为25％，再下周为－7％，那么基金B的标准差大于基金A的标准差。而如果基金C每周都亏损1％，其标准差也同样为0。</p>
                            <p>
                                单只基金本身的标准差无法显示其风险大小水平，投资者应将基金的标准差与同类基金或者业绩评价基准的标准差进行比较。如某只基金的标准差为10％，而同类其他基金的标准差多在5％左右，所以10％的波动水平算是较高了。或者可以发现两只基金的回报相似，但波动水平却有明显差异。</p>
                            <p>
                                另一方面，标准差和贝塔系数所量化的对象是回报的波动，而没有体现基金的下行风险，即亏损的可能性。如上例，尽管基金B的标准差较大，但其风险并不一定比基金C的风险大。换而言之，标准差大的基金可能没有下行风险，而仅仅是收益波动很大。</p>
                        </div>
                    </li>
                    <li role="presentation" class="ExplainTextLine" v-show="economicTermsShowFlagArray[3]"
                        style="cursor: pointer;">
                        <a>
                            <span class="title-normal">下行标准差</span>
                            <span class="detail-hidden"
                                  style="margin-top:6px;width: 14px;height: 10px;background-image:url('./Pic/ArrowUp.png');display: inline-block;float: right"/>
                            <span class="detail-show"
                                  style="margin-top:6px;width: 14px;height: 10px;background-image:url('./Pic/ArrowDown.png');display: none;float: right"/>
                        </a>
                        <div class="Detail mainBody-normal" style="display: none">
                            <p>（1）概念</p>
                            <p>
                                在衡量基金业绩时，标准差存在对所有风险都进行计算的缺陷。相比负偏离算术平均值（趋势下行）的数据点而言，正偏离算术平均值的数据点（趋势上涨）对于投资人是有利的，计算时应区别看待，因此引入了下行标准差。下行偏差忽略“良好”表现，而只计算“不良”风险。</p>
                            <p>（2）计算方法</p>
                            <p class=" text-center"><img
                                    style="width: 197px;height: 83px;display: inline-block;background-image:url('./Pic/image022.png')"/>
                            </p>
                            <p>注：计算方法以样本标准差为基础，可根据实际需求选择总体样本标准差。</p>
                            <p>变量含义：</p>
                            <p>
                                <img style="width: 8px;height: 21px;display: inline-block;background-image:url('./Pic/image019.png')"/>下行标准差结果
                            </p>
                            <p>
                                <img style="width: 12px;height: 21px;display: inline-block;background-image:url('./Pic/image020.png')"/>数据点
                            </p>
                            <p>
                                <img style="width: 9px;height: 21px;display: inline-block;background-image:url('./Pic/image021.png')"/>算术平均值
                            </p>
                        </div>
                    </li>
                    <li role="presentation" class="ExplainTextLine" v-show="economicTermsShowFlagArray[3]"
                        style="cursor: pointer;">
                        <a>
                            <span class="title-normal">夏普比率</span>
                            <span class="detail-hidden"
                                  style="margin-top:6px;width: 14px;height: 10px;background-image:url('./Pic/ArrowUp.png');display: inline-block;float: right"/>
                            <span class="detail-show"
                                  style="margin-top:6px;width: 14px;height: 10px;background-image:url('./Pic/ArrowDown.png');display: none;float: right"/>
                        </a>
                        <div class="Detail mainBody-normal" style="display: none">
                            <p>（1）概念</p>
                            <p>
                                夏普比率目的是计算投资组合每承受一单位总风险，会产生多少的超额报酬。当投资组合内的资产皆为风险性资产时，适用夏普比率。夏普指数代表投资人每多承担一分风险，可以拿到几分超额报酬；若为正值，代表基金报酬率高过波动风险；若为负值，代表基金操作风险大过于报酬率。这样一来，每个投资组合都可以计算投资回报与多冒风险的比例，这个比例越高，投资组合越佳。</p>
                            <p>
                                举例而言，假如国债的回报是3%，投资组合预期回报是15%，投资组合标准偏差是6%，那么用15%－3%,可以得出12%（代表超出无风险投资的回报），再用12%/6%=2，代表投资者风险每增长1%，换来的是2%的多余收益。</p>
                            <p class="mainBody-normal text-center"><img
                                    style="width: 161px;height: 42px;display: inline-block;background-image:url('./Pic/image023.png')"/>
                            </p>
                            <p>变量含义：</p>
                            <p><img
                                    style="width: 38px;height: 21px;display: inline-block;background-image:url('./Pic/image024.png')"/>
                                投资组合预期收益</p>
                            <p><img
                                    style="width: 15px;height: 21px;display: inline-block;background-image:url('./Pic/image025.png')"/>
                                无风险利率</p>
                            <p><img
                                    style="width: 14px;height: 21px;display: inline-block;background-image:url('./Pic/image026.png')"/>
                                投资组合净值标准差</p>
                            <p>（2）夏普比率在运用中应该注意的问题</p>
                            <p>夏普比率在计算上尽管非常简单，但在具体运用中仍需要对夏普比率的适用性加以注意：</p>
                            <p>a）用标准差对收益进行风险调整，其隐含的假设就是所考察的组合构成了投资者投资的全部。因此只有在考虑在众多的基金中选择购买某一只基金时，夏普比率才能够作为一项重要的依据；</p>
                            <p>b）使用标准差作为风险指标也被人们认为不很合适的。</p>
                            <p>c）夏普比率的有效性还依赖于可以以相同的无风险利率借贷的假设；</p>
                            <p>d）夏普比率没有基准点，因此其大小本身没有意义，只有在与其他组合的比较中才有价值；</p>
                            <p>
                                e）夏普比率是线性的，但在有效前沿上，风险与收益之间的变换并不是线性的。因此，夏普指数在对标准差较大的基金的绩效衡量上存在偏误；</p>
                            <p>f）夏普比率未考虑组合之间的相关性，因此纯粹依据夏普值的大小构建组合存在很大问题；</p>
                            <p>g）夏普比率与其他很多指标一样，衡量的是基金的历史表现，因此并不能简单地依据基金的历史表现进行未来操作。</p>
                            <p>h）计算上，夏普指数同样存在一个稳定性问题：夏普指数的计算结果与时间跨度和收益计算的时间间隔的选取有关。</p>
                            <p>（3）其他</p>
                            <p>尽管夏普比率存在上述诸多限制和问题，但它仍以其计算上的简便性和不需要过多的假设条件而在实践中获得了广泛的运用。</p>
                            <p>
                                基金较高的净值增长率可能是在承受较高风险的情况下取得的，因此仅仅根据净值增长率来评价基金的业绩表现并不全面，衡量基金表现必须兼顾收益和风险两个方面，夏普比率就是一个可以同时对收益与风险加以综合考虑的指标。夏普比率又被称为夏普指数，由诺贝尔奖获得者威廉•夏普于1966年最早提出，目前已成为国际上用以衡量基金绩效表现的最为常用的一个标准化指标。</p>
                        </div>
                    </li>
                    <li role="presentation" class="ExplainTextLine" v-show="economicTermsShowFlagArray[3]"
                        style="cursor: pointer;">
                        <a>
                            <span class="title-normal">索提诺比率</span>
                            <span class="detail-hidden"
                                  style="margin-top:6px;width: 14px;height: 10px;background-image:url('./Pic/ArrowUp.png');display: inline-block;float: right"/>
                            <span class="detail-show"
                                  style="margin-top:6px;width: 14px;height: 10px;background-image:url('./Pic/ArrowDown.png');display: none;float: right"/>
                        </a>
                        <div class="Detail mainBody-normal" style="display: none">
                            <p>（1）概念</p>
                            <p>
                                索提诺比率是一种衡量投资组合相对表现的方法，与夏普比率有相似之处，但索提诺比率运用下行标准差而不是总标准差，以区别不利和有利的波动。这一比率越高，表明基金承担相同单位下行风险能获得更高的超额回报率。索提诺比率可以看做是夏普比率在衡量投资组合业绩时的一种修正方式。</p>
                            <p>（2）计算方法</p>
                            <!--<p class="mainBody-normal text-center"><img src="./Pic/image027.png"/></p>-->
                            <p class="mainBody-normal text-center"><img
                                    style="width: 237px;height: 83px;display: inline-block;background-image:url('./Pic/image027.png')"/>
                            </p>
                            <p class="mainBody-normal text-center"><img
                                    style="width: 166px;height: 42px;display: inline-block;background-image:url('./Pic/image028.png')"/>
                            </p>
                            <p class="mainBody-normal text-center"><img
                                    style="width: 276px;height: 21px;display: inline-block;background-image:url('./Pic/image029.png')"/>
                            </p>
                            <!--<p class="mainBody-normal text-center"><img src="./Pic/image028.png"/></p>-->
                            <!--<p class="mainBody-normal text-center"><img src="./Pic/image029.png"/></p>-->
                            <p>变量含义：</p>
                            <!--<p><img src="./Pic/image030.png"/> 表示第i个月的基金总回报率</p>-->
                            <p><img
                                    style="width: 21px;height: 21px;display: inline-block;background-image:url('./Pic/image030.png')"/>
                                表示第i个月的基金总回报率</p>
                            <!--<p><img src="./Pic/image025.png"/> 市场无风险收益率</p>-->
                            <p><img
                                    style="width: 15px;height: 21px;display: inline-block;background-image:url('./Pic/image025.png')"/>
                                市场无风险收益率</p>
                            <!--<p><img src="./Pic/image031.png"/>-->
                            <p><img
                                    style="width: 31px;height: 21px;display: inline-block;background-image:url('./Pic/image031.png')"/>
                                表示基金在计算期内月度超额回报率（月回报率减去同期无风险利率）的平均值</p>
                            <!--表示基金在计算期内月度超额回报率（月回报率减去同期无风险利率）的平均值</p>-->
                            <!--<p><img src="./Pic/image032.png"/> 表示基金在计算期内月度超额回报率的下行标准差</p>-->
                            <p><img
                                    style="width: 33px;height: 21px;display: inline-block;background-image:url('./Pic/image032.png')"/>
                                表示基金在计算期内月度超额回报率的下行标准差</p>
                            <!--<p><img src="./Pic/image033.png"/> 月度索提诺比率</p>-->
                            <p><img
                                    style="width: 115px;height: 21px;display: inline-block;background-image:url('./Pic/image033.png')"/>
                                月度索提诺比率</p>
                            <!--<p><img src="./Pic/image034.png"/> 年度索提诺比率</p>-->
                            <p><img
                                    style="width: 102px;height: 21px;display: inline-block;background-image:url('./Pic/image034.png')"/>
                                年度索提诺比率</p>
                            <p>索提诺比率与夏普比率的区别在于分母不同，夏普指数分母为总的标准差，索定诺的分母为下行的标准差。</p>
                            <p>（3）例子</p>
                            <p>
                                通过一个特殊的例子来比较夏普比率和索提诺比率的区别，为了简化计算，无风险利率设为0%。假设私募基金A和B在2009年伊始的净值均为1.00，且他们每月的净值公布日期均一致。在2009年，私募基金A的每个月的回报各为3%、-5%、-2%、-2%、-2%、2%、-2%、5%、5%、3%、10%、9%；私募基金B
                                在2009年同期每月回报为3%、-1%、1%、-1%、1%、-1%、-1%、-1%、-1%、0%、15%、10%。通过计算，我们得到两个私募基金在2009年的总回报均为24%，但是私募基金A
                                的夏普比率5.08 要略高于私募B 的夏普比率4.64。</p>
                            <p>
                                但如果计算索提诺比率，我们就会发现私募A的索提诺比率（7.5）要远低于私募B的索提诺比率（21.4）。这其中主要的差别就是在计算夏普比率的过程中，私募B因最后两个月的收益突然大幅上涨而导致波动率过大，在计算风险调整时受到了“惩罚”；而在计算索提诺比率过程中，任何高于无风险利率的上涨都不会计入风险调整，因此，私募B在最后两期的上涨并不会导致索提诺比率的降低。和夏普比率相比，索提诺比率这一衡量标准更符合那些对资产价值下跌较为敏感的投资者。</p>
                        </div>
                    </li>
                    <li role="presentation" class="ExplainTextLine" v-show="economicTermsShowFlagArray[3]"
                        style="cursor: pointer;">
                        <a>
                            <span class="title-normal">贝塔系数（β）</span>
                            <span class="detail-hidden"
                                  style="margin-top:6px;width: 14px;height: 10px;background-image:url('./Pic/ArrowUp.png');display: inline-block;float: right"/>
                            <span class="detail-show"
                                  style="margin-top:6px;width: 14px;height: 10px;background-image:url('./Pic/ArrowDown.png');display: none;float: right"/>
                        </a>
                        <div class="Detail mainBody-normal" style="display: none">
                            <p>（1）概念</p>
                            <p>
                                贝塔系数衡量基金收益相对于业绩评价基准收益的总体波动性，是个相对指标。贝塔系数越高，意味着基金相对于业绩基准的波动性越大。贝塔系数大于1，则基金的波动性大于业绩基准的波动性。反之亦然。</p>
                            <p>
                                用一个简单的例子说明如何用贝塔系数衡量波动性的，如果贝塔系数为1，则市场上涨10％，基金上涨10％；市场下滑10％，基金相应下滑10％。贝塔系数为1.1，市场涨10％时，基金涨11％，；市场下滑10％时，基金下滑11％。贝塔系数为0.9，市场涨10％时，基金涨9％；市场下滑10％时，基金下滑9％</p>
                            <p>贝塔系数用皮尔逊相关系数定义</p>
                            <p class="text-center"><img
                                    style="width: 229px;height: 62px;display: inline-block;background-image:url('./Pic/image035.png')"/>
                            </p>
                            <p>变量含义：</p>
                            <p>
                                <img style="width: 23px;height: 21px;display: inline-block;background-image:url('./Pic/image036.png')"/>
                                皮尔逊相关系数</p>
                            <p>
                                <img style="width: 12px;height: 21px;display: inline-block;background-image:url('./Pic/image020.png')"/>
                                数据点</p>
                            <p>
                                <img style="width: 12px;height: 21px;display: inline-block;background-image:url('./Pic/image037.png')"/>
                                数据点</p>
                            <p>
                                <img style="width: 9px;height: 21px;display: inline-block;background-image:url('./Pic/image021.png')"/>
                                数据点平均值</p>
                            <p>
                                <img style="width: 9px;height: 21px;display: inline-block;background-image:url('./Pic/image038.png')"/>
                                数据点平均值</p>
                            <p>（2）皮尔逊相关系数值域为–1≤r≤+1，其性质如下：</p>
                            <p>a）当r>0时，表示两变量正相关，r<0时，两变量为负相关。</p>
                            <p>b）当|r|=1时，表示两变量为完全线性相关，即为函数关系。</p>
                            <p>c）当r=0时，表示两变量间无线性相关关系。</p>
                            <p>
                                d）当0<|r|<1时，表示两变量存在一定程度的线性相关。且|r|越接近1，两变量间线性关系越密切；|r|越接近于0，表示两变量的线性相关越弱。一般可按三级划分：|r|<0.4为低度线性相关；0.4≤|r|<0.7为显著性相关；0.7≤|r|<1为高度线性相关。</p>
                            <p>（3）皮尔逊相关系数的适用范围</p>
                            <p>当两个变量的标准差都不为零时，相关系数才有定义，皮尔逊相关系数适用于：</p>
                            <p>a）两个变量之间是线性关系，都是连续数据。</p>
                            <p>b）两个变量的总体是正态分布，或接近正态的单峰分布。</p>
                            <p>c）两个变量的观测值是成对的，每对观测值之间相互独立。</p>
                            <p>（4）使用注意</p>
                            <p>在实践统计中，一般只输出两个系数，一个是相关系数，也就是计算出来的相关系数大小，在-1到1之间；另一个是独立样本检验系数，用来检验样本一致性。</p>
                        </div>
                    </li>
                    <li role="presentation" class="ExplainTextLine" v-show="economicTermsShowFlagArray[3]"
                        style="cursor: pointer">
                        <a>
                            <span class="title-normal">詹森指数（α）</span>
                            <span class="detail-hidden"
                                  style="margin-top:6px;width: 14px;height: 10px;background-image:url('./Pic/ArrowUp.png');display: inline-block;float: right"/>
                            <span class="detail-show"
                                  style="margin-top:6px;width: 14px;height: 10px;background-image:url('./Pic/ArrowDown.png');display: none;float: right"/>
                        </a>
                        <div class="Detail mainBody-normal" style="display: none">
                            <p>（1）概念</p>
                            <p>詹森指数是测定投资组合经营绩效的一种指标，是投资组合的实际期望收益率与位于证券市场线上的投资组合的期望收益率之差。</p>
                            <p>1968年，美国经济学家迈克尔•詹森（Michael
                                C.Jensen）发表了《1945-1964年间共同基金的业绩》一文，提出了这个以资本资产定价模型（CAPM）为基础的业绩衡量指数，它能评估基金的业绩优于基准的程度，通过比较考察期基金收益率与由定价模型CAPM得出的预期收益率之差，即基金的实际收益超过它所承受风险对应的预期收益的部分来评价基金，此差额部分就是与基金经理业绩直接相关的收益。</p>
                            <p class="text-center"><img
                                    style="width: 181px;height: 21px;display: inline-block;background-image:url('./Pic/image039.png')"/>
                            </p>
                            <p>变量含义：</p>
                            <p>
                                <img style="width: 16px;height: 21px;display: inline-block;background-image:url('./Pic/image040.png')"/>
                                基金收益率</p>
                            <p>
                                <img style="width: 15px;height: 21px;display: inline-block;background-image:url('./Pic/image025.png')"/>
                                无风险收益率</p>
                            <p>
                                <img style="width: 19px;height: 21px;display: inline-block;background-image:url('./Pic/image041.png')"/>
                                业绩基准收益率</p>
                            <p>
                                <img style="width: 15px;height: 21px;display: inline-block;background-image:url('./Pic/image042.png')"/>
                                基金与业绩基准的皮尔逊相关系数</p>
                            <p>（2）改进的詹森指数</p>
                            <p>优基网进行基金业绩评价时，使用改进的詹森指数模型，结合主要指数（沪深300、中证500、中债新综合指数等）形成多因素詹森指数模型。改进后的计算方式如下：</p>
                            <p class="text-center"><img
                                    style="width: 383px;height: 21px;display: inline-block;background-image:url('./Pic/image043.png')"/>
                            </p>
                            <p>变量含义：</p>
                            <p>
                                <img style="width: 16px;height: 21px;display: inline-block;background-image:url('./Pic/image040.png')"/>
                                基金收益率</p>
                            <p>
                                <img style="width: 15px;height: 21px;display: inline-block;background-image:url('./Pic/image025.png')"/>
                                无风险收益率</p>
                            <p>
                                <img style="width: 15px;height: 21px;display: inline-block;background-image:url('./Pic/image044.png')"/>
                                各业绩基准收益率</p>
                            <p>
                                <img style="width: 14px;height: 21px;display: inline-block;background-image:url('./Pic/image045.png')"/>
                                基金与各业绩基准的皮尔逊相关系数</p>
                            <p>改进的詹森指数参考文献：屠新曙等，《经典詹森指数绩效衡量方法的有效性研究及改进–来自中国基金市场的检验》</p>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</template>
<script>
    export default {
        mounted: function () {
            $(function () {
                //左侧主题标签的选中时和未选中时的样式控制
                $("li.ExplanationSelectTab").bind("click", function () {
                    $(this).siblings().removeClass("active");
                    $(this).addClass("active");
                });
                //每个条目在显示详情上下箭头显示控制
                $("li.ExplainTextLine").bind("click", function () {
                    $(this).siblings().removeClass("active");
                    $(this).addClass("active");
                    $(this).find("span.detail-show").toggle();
                    $(this).find("span.detail-hidden").toggle();
                    $(this).find("div.Detail").toggle();
                });
            });
        },
        data() {
            return {
                //0、显示股票指数术语；1、显示统计学术语；2、显示基金业术语；3、显示业绩指标术语
                economicTermsShowFlagArray: [true, true, true, true]
            };
        },
        methods: {
            SetTermsShow(termsIndex) {
                //点击显示全部时，传入all，将economicTermsShowFlagArray值全部重置为true
                if (termsIndex === "all") {
                    for (let arrayIndex = 0; arrayIndex < this.economicTermsShowFlagArray.length; arrayIndex++) {
                        this.economicTermsShowFlagArray.splice(arrayIndex, 1, true);
                    }
                    return;
                }
                //点击其他项目时，传入待显示项序号，将economicTermsShowFlagArray值全部重置为false，结束循环后，再将待显示项重置为true
                for (let arrayIndex = 0; arrayIndex < this.economicTermsShowFlagArray.length; arrayIndex++) {
                    this.economicTermsShowFlagArray.splice(arrayIndex, 1, false);
                }
                this.economicTermsShowFlagArray.splice(termsIndex, 1, true);
            }
        }
    };
</script>
<style scoped>
    /*小标题样式*/
    .title-normal {
        color: #0D0D0D;
        font-weight: bold;
        font-family: 微软雅黑;
        font-size: 16px;
    }
    /*正文普通样式*/
    .mainBody-normal {
        font-family: 黑体;
        font-size: 14px;
        text-indent: 2em;
        margin: 0 auto;
    }
</style>
