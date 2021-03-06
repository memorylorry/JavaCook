<link href="/JavaCook/css/common.css" rel="stylesheet">
<link href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
<div class="ml-menu-container">
    <ul class="nav">
        <li>
            <a href="/JavaCook"><img src="/JavaCook/assets/logo.png"  style="vertical-align: text-top;" /></a>
        </li>
        <li class="drop-down">
            <a href="#">JAVA
                <i class="fa fa-sort-desc" aria-hidden="true"></i>
            </a>
            <ul class="drop-down-content">
                <li>
                    <a href="/JavaCook/doc/basic/">Basic</a>
                </li>
                <li>
                    <a href="/JavaCook/doc/jvm/">JVM</a>
                </li>
                <li>
                    <a href="/JavaCook/doc/concurrency/">Concurrency</a>
                </li>
                <li>
                    <a href="/JavaCook/doc/spring/">Spring</a>
                </li>
            </ul>
        </li>
        <li class="drop-down">
            <a href="#">C Algorithms
                <i class="fa fa-sort-desc" aria-hidden="true"></i>
            </a>
            <ul class="drop-down-content">
                <li>
                    <a href="/JavaCook/doc/C_Plus/">Basic</a>
                </li>
            </ul>
        </li>
        <li class="drop-down">
            <a href="#">Big Data
                <i class="fa fa-sort-desc" aria-hidden="true"></i>
            </a>
            <ul class="drop-down-content">
                <li>
                    <a href="/JavaCook/doc/hadoop/">Hadoop</a>
                </li>
                <li>
                    <a href="/JavaCook/doc/kafka/">Kafka</a>
                </li>
                <li>
                    <a href="/JavaCook/doc/spark/">Spark</a>
                </li>
                <li>
                    <a href="/JavaCook/doc/mahout/">Mahout</a>
                </li>
            </ul>
        </li>
        <li>
            <a href="https://github.com/memorylorry/JavaCook">
                <i class="menu-logo fa fa-github" aria-hidden="true"></i>view</a>
        </li>
    </ul>
</div>
## Kafka介绍(<a href="http://kafka.apache.org/" target="_blank">Office Site</a>)

### Kafka是一个分布式流平台。什么意思呢？
流平台的三种特性：
* 像消息队列或企业级信息系统一样，发布和订阅流；
* 存数据，支持高容错；
* 及时处理流(消息来了就开始处理消息)。

Kafka主要用于以下2种场合：
* 在系统或应用之间构建实时流管道；
* 构建实时应用。

为了理解Kafka如何处理这些，我们从0开始深入研究Kafka的功能。

首先，理解一些概念：
* Kafka集群模式可以运行在单节点或多节点的服务器（可以跨越多个数据中心）上；
* Kafka是分类存储每条记录的，这个分类称为主题(topics);
* 每行记录由key、value、timestamp组成。

Kafka有四个核心的API:
* The Producer API允许应用发布流记录到一个或多个Kafka的主题；
* The Consumer API允许应用订阅一个或多个Kafka主题，并处理这些记录；
* The Streams API允许应用像流处理器一样，消费一个或多个主题种的输入流，并高效地改变输入流的形式；
* The Connector API允许构建和运行可重用的producer或则consumers，这些应用可以把Kafka主题连接到已存在的应用或系统。例如，一个和关系型database建立连接的connecter，可以捕获一个表的所有改变。

Kafka的server和client是采用简单的、高性能、无语义的TCP协议实现的。这种协议具有版本，并且兼容先有版本。我们也提供各Kafka的Java客户端，当然也有各种语言的<a href="https://cwiki.apache.org/confluence/display/KAFKA/Clients" target="_blank">客户端</a>。

### 主题(Topics)和日志(Logs)
我们先来了解Kafka为流记录提供的抽象概念——主题(topic)。

一个主题(topic)是一个分类，Kafka的每个记录都存于某个分类。Kafka的主题通常是多订阅者的；就是说，一个主题可以有0个或多个消费者同时订阅并消费数据。

每个主题，Kafka集群为之维护了一哥分区日志，内容如下所示：

<img src="./assets/log_anatomy.png" style="height: 267px;" />

每个分区是有记录构成的有序的，不可修改的队列，记录来了还会继续追加进到这个结构化的日志里面。这些分区里的记录每个都会有各自的偏移量(offset)，这个标识了所有记录在分区中的位置。

Kafka集群会长时间保留发布的记录(无论记录是否被消费过)——采用了一个可配置的保留周期去限定记录的保持时间。例如，如果保留策略设置成2 days，那么一个记录自从发布的2天后，内部会自动清理这些记录的空间。Kafka性能是高效稳定的，所以长时间运行不是问题。

<img src="./assets/log_consumer.png" style="height: 267px;" />

事实上，唯一保留在consumer的元数据是消费日志时的offset。这个offset有consumer控制：通常一个消费者会线性移动它的offset一个个地去读取记录，但事实上，自从位置参数由消费者控制后，消费者可以以任何形式去消费记录。例如，一个消费者重置回一个久的offset去重新处理过去过去的数据，或则跳过一些记录去吃消费现在的记录。

这个特性的结合，意味着Kafka消费者是廉价的——消费者的接入和断开，不会对集群造和其它consumers造成大的影响。例如，你可以用命令行工具"tail"任何topic的内容，并不会影响到已有消费者消费的记录。

日志分区有多个目的。首先，这会允许日志规模增长，这会适合单节点机器。每个独立的分区必须置于各自所属的服务器上，但一个主题会有多个分区去处理任意数量的数据。其次更多关于这点事，分区是平行的。

### 分区(partition) 

主题的分区，可以对主题里面的记录作分类。如我们在需要记录用户使用应用时，浏览过哪些页面，根据这些事件特点进行分类存入不同的分区，这样在消费这些记录时，我们可以安排分区个数的客户端去同时处理，这样可以同时多个客户端去处理一个问题，从而提高了效率。

### 生产者(Producer)<a href="./KafkaProducer" target="_blank">实例参考</a>

生产者(Producer)可以选择性地发布记录，它可以指定把记录存入哪个主题的分区。这个特点将会有效地平衡每个分区的压力。

### 消费者(Consumer)<a href="./KafkaConsumer" target="_blank">实例参考</a>

消费者可以给自己取组名，并且每条记录在每个组中，只会发送给其中一个消费者。消费者可以是一台独立机器上的独立进程。

如果所有消费者进程有相同的组名，那记录将会有效地分发给组中的所有消费者。

如果消费者进程不是同个组的，那么每条记会广播到所有消费者进程。

<img src="./assets/consumer-groups.png" style="height: 267px;" />

