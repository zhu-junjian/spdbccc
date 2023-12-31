  随着中台架构的崛起，如何快速的包装服务能力以应对复杂的需求环境，实现高内聚、低耦合的代码，微服务成为落地中台架构的首选，如何进行微服务的拆分使之符合高可用，复用性强，灵活性高的应用，领域驱动设计（DDD）作为一门工程设计思想，在问世之后的十余年后随着微服务架构的崛起火热了起来，今天我们就来聊聊传统的三层、五层架构与领域驱动设计的差异。
## 领域驱动设计（Domain Driven Design）的核心转变
* 1、贫血模型转变为充血模型
* 2、设计思路由数据表驱动向凝练领域能力的转变
* 3、聚合、聚合根、实体、值对象、领域服务带来的业务流程内敛的转变
* 4、仓储、持久层、防腐层屏蔽底层具体实现与上层业务调用
* 5、限界上下文、领域模型等关键业务边界的界定
## DDD使用落地流程
* 事件风暴、统一语言、抓住核心流程、识别事件、识别命令、初步界定领域边界、识别实体、识别值对象、合并聚合、抓住聚合根、注意聚合边界、仓储、防腐层设计
* 刷墙
> 事件风暴过程中，根据事件（命令）、实体、动作三方面将核心业务流程梳理

以事件驱动划分后的领域作为单个微服务是不符合实际应用场景的，粒度太细、不便于维护等反而带来了更多的运维成本。实际场景中，通过领域之间的依赖关系，将相互依赖的领域放在相同的限界上下文似乎更合理，这样不仅减少了微服务数量带来的重复工作，同时也在某些场景避免了分布式事务，减少不必要的过度设计。
### 如何划分上下文
以领域作为微服务进行划分粒度太细，将具有重度依赖关系的领域放在一个上下文内，可以有助于业务和程序的发展。例如：在一个对人脸进行布控的场景下，按照业务流程的走向可以分为：抓拍、布控、报警、消息中心这4个领域。其中布控与报警存在必然的相互依赖，布控依赖抓拍但抓拍不依赖布控；抓拍依赖消息中心但消息中心不依赖抓拍。所以可以将抓拍域作为核心子域单独作为一个微服务，布控、报警合并为一个布控报警上下文；消息中心上下文作为一个支撑域
![](https://www.imgcc.cloud/image/w92j)

### 识别聚合
聚合包括了聚合根、实体、值对象和边界。
作为领域能力的出口，屏蔽具体业务细节，避免业务逻辑外泄，统一向上层应用层暴露API
识别聚合首选需要找到聚合根，聚合根往往是业务流程的起点，并伴有唯一性，例如微信转账场景的微信账号。在聚合根之后由业务场景决定是否有或者多个实体、值对象，边界代表业务场景的终点，相同的聚合、实体和值对象在特定的场景中相互隔离，边界就是隔离的墙。

### 应用层
应用层就是对领域层能力的编排，例如：新增案件场景，案件名称、所属部门、负责警员，同时勾选创建布控，对应用层而言首先案件新增，其次新增布控，布控还要下发响应的人脸特征值分析等。
