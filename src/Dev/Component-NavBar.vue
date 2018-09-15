<template>
    <div class="row">
        <div class="col-xs-12">
            <!--该行展示Logo标志-->
            <div class="row" style="margin-top: 20px;margin-bottom: 20px">
                <div class="col-xs-4">
                    <div style="width:210px;height:96px;background-image:url('./Pic/Logo.jpg');background-size:cover;"></div>
                </div>
            </div>
            <!--导航条-->
            <div class="row">
                <div class="col-xs-12 navStyle" style="margin-top: 0px;margin-bottom: 10px;background-color: #cce0ff">
                    <ul class="nav navbar-nav" style="font-family: 微软雅黑;font-size: 20px;">
                        <li>
                            <router-link to="/mainPage">首页</router-link>
                        </li>
                        <li>
                            <router-link to="/fundValueNav">净值数据</router-link>
                        </li>
                        <li>
                            <router-link to="/economicTerms">名词解释</router-link>
                        </li>
                        <li>
                            <router-link to="/dataBackTesting">数据回测</router-link>
                        </li>
                        <li>
                            <a href="#" style="color: #787878">*基金要闻</a>
                        </li>
                        <li>
                            <a href="#" style="color: #787878">*投资札记</a>
                        </li>
                        <li>
                            <router-link to="/aboutMsg">关于</router-link>
                        </li>
                    </ul>
                </div>
            </div>
            <!--路由展示区-->
            <div class="row">
                <div class="col-xs-12 navStyle" style="margin-top: 0px;margin-bottom: 10px;">
                    <router-view></router-view>
                </div>
            </div>
        </div>
    </div>
</template>