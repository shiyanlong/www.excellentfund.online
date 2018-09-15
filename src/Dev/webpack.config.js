const path = require('path');
const VueLoaderPlugin = require("vue-loader/lib/plugin");
const htmlWebpackPlugin = require('html-webpack-plugin');
const webpack = require("webpack");

module.exports = {
    // mode: 'development',
    mode: 'production',
    //指定入口
    // entry: path.join(__dirname, "./main.js"),
    //使用babel-polyfill模拟ES6使用的环境，否则在IE使用vuex会出现“vuex requires a Promise polyfill in this browser”错误。
    //目前IE可支持最低版本为IE10
    entry: {
        app: ["babel-polyfill", path.join(__dirname, "./main.js")]
    },
    //输出配置
    output: {
        path: path.join(__dirname, "../main/webapp"), //指定输出目录
        filename: "main.js" //输出文件名称
    },
    module: {
        //模块匹配规则
        rules: [
            //使用babel时排除node_modules
            {test: /\.js$/, use: 'babel-loader', exclude: /node_modules/},
            //读取vue组件
            {test: /\.vue$/, use: 'vue-loader'},
            //读取样式，使用bootstrap时也需要
            {test: /\.css$/, use: ['style-loader', 'css-loader']},
            //使用bootstrap时，额外需要的loader
            {test: /\.(woff|woff2)$/, use: 'url-loader'},
            {test: /\.eot(\?v=\d+\.\d+\.\d+)?$/, use: 'file-loader'},
            {test: /\.ttf(\?v=\d+\.\d+\.\d+)?$/, use: 'url-loader'},
            {test: /\.svg(\?v=\d+\.\d+\.\d+)?$/, use: 'url-loader'}
        ]
    },
    plugins: [
        new VueLoaderPlugin(),
        new htmlWebpackPlugin({
            //模板页面
            template: path.join(__dirname, "../main/webapp/index.html"),
            //生成页面的名称
            filename: 'index.html'
        }),
        new webpack.ProvidePlugin({
            //引入jquery
            $: "jquery",
            jQuery: "jquery",
            "windows.jQuery": "jquery"
        })
    ]
}
