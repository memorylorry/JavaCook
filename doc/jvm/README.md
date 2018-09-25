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
## JVM
1. Java虚拟机概述和基本概念
2. 堆、栈、方法区
3. 了解虚拟机参数 (work)
4. 垃圾回收概念和算法、及对象的分代转换
5. 垃圾收集器  (work)
6. Tomcat性能影响实验 (work)
7. 性能监控工具 (work)

1.1 java虚拟机的原理
虚拟机是一台虚拟的机器，它是一款软件，用来执行一系列虚拟计算机指令，大体可分为系统虚拟机和程序虚拟机。如VMware和Visual Box属于系统虚拟机，它们完全模仿真机，提供了一个可运行完整操作系统的软件平台。程序虚拟机有Java虚拟机，它专门用来执行单个计算机程序而设计，在Java虚拟机中执行的指令，我们称为Java字节码指令。无论是系统虚拟机还是程序虚拟机，在上面运行的软件都被限制于虚拟机提供的资源中。Java发展至今，出现过很多虚拟机，最初Sun使用的一款叫Classic的Java虚拟机，到现在引用最广泛的是HotSpot虚拟机，除了Sun之外，还有BEA和JRockit，目前JRockit和HotSport都被Oracle收入旗下，大有整合的趋势。

