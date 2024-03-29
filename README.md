### 项目介绍
- 优基网（<http://www.excellentfund.online>）为个人版金融数据、信息门户网站，主要面向基金市场中五大类约数千支公募基金公开数据的业绩评价。
### 主要板块
-  **首页**：展示最能够代表市场环境的指数K线图表，透过市场主要指数走势，可以了解当前市场风格、偏好和趋势。同时，该板块下的市场主要指数也可以作为基金风格的参照依据。
- **净值数据**：展示市场上几大类基金产品（股票基金、债券基金、混合基金、保本基金、QDII基金）的基本净值信息，每种分类下的基金还可能具有指数跟踪、场内交易（LOF）两种属性。在该板块下，可进一步查看单只基金的详细信息，包括净值区间增长率、业绩数据等。
- **名词解释**：包含以下几部分内容。
  - 证券市场中常见名词术语及概念，包括：（1）部分市场指数的定义；（2）部分市场指数的成分股选择策略，成分股的选择直接决定了指数风格。
  - 基金业中常见名词术语及概念，包括基金的分类、交易规则等等。
  - 统计学中常见名词术语及概念。统计学是建立数学模型、构建算法的理论依据，对结果判断具有指导性意义。开展基金业绩评价时，可参考统计学中成熟的理论成果，再结合自身需求建立数学模型或构建算法，避免重复造轮子。
- **数据回测**：通过基金历史总回报，与相关业绩基准进行比较，观察基金过往业绩情况，业绩基准可选取市场指数、市场指数组合。可单基金对比，也可以构成FOF组合通过调校组合参数进行对比。
- **基金要闻**：摘录主流媒体有关基金市场环境、政策等报道。
- **投资札记**：记录投资策略及组合构建方法的板块。
- **关于**：介绍网站理念、各主要板块的概述。

### 其他事项
- 记录数据库连接信息的`.properties`文件应更名为`DataBase.properties`，必要时可修改默认内容。
- 项目使用的数据库结构已经给出sql文件。

### 开发环境
- JDK 1.8
- Spring 5.0.4.RELEASE
- SpringMVC 5.0.4.RELEASE
- MyBatis 3.4.5
- MySQL 5.1.40
- Vue 2.5.16
- Webpack 4.15.1

### 运行环境
![运行环境](src/main/webapp/Pic/support.png)

### License
- Licensed under the Apache License, Version 2.0 (the "License"); you may not use these file except in compliance with the License.
- You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
- Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
- See the License for the specific language governing permissions and limitations under the License.
