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

## C++

### 结构体(struct)

结构体属于聚合数据类型的一类，它将不同的数据类型整合在一起构成一个新的类型，相当于数据库中一条记录，比如学生结构体，整合了学号，姓名等等信息。结构体的好处就是可以对这些信息进行整体管理操作，类似面向对象中类的属性，有了结构体，我就可以更好抽象描述一个类别，个人感觉类就是由结构体发展而来的。在C/C++中，结构体声明的关键字为struct。

基本语法：
```
struct [name] { 
  type var_name;
  ...
  type var_name;
}
//例子
struct student{
    int age;
    int weight;
}
//实例化方法：
struct student s;
s.age = 1;
s.weight = 2;
```
这样初始化，在使用过程中，特别是重复使用该结构体时，会有些麻烦。这里可以结合`typedef`关键字简化使用：
```
struct student{
    int age;
    int weight;
};
typedef struct student Stu;
//当然也可以合起来写，写成：
typedef struct student{
    int age;
    int weight;
}Stu;
//实例化
Stu s;
s.age = 3;
```

### 参数传递

(1)将变量名作为实参和形参。这时传给形参的是变量的值，
传递是单向的。如果在执行函数期间形参的值发生变
化，并不传回给实参。因为在调用函数时，形参和实参
不是同一个存储单元。


(2) 传递变量的指针。形参是指针变量，实参是一个变量的
地址，调用函数时，形参(指针变量)指向实参变量单元。
这种通过形参指针可以改变实参的值。


(3) C++提供了 传递变量的引用。形参是引用变量，和实参是
一个变量，调用函数时，形参(引用变量)指向实参变量
单元。这种通过形参引用可以改变实参的值。

```
//传值(原值不变)
void test(int a){a=1;}
//传指针(原值变)
void test(int* a){(*a)=1;}
//传变量的引用(原值变)
void test(int &a){a=1;}
//main
int main(){
	int z = 3;
	test1(z);
	cout<<z<<endl;
	
	test2(&z);
	cout<<z<<endl;
	
	test3(z);
	cout<<z<<endl;
}

```

### 动态分配

```
#include <iostream>
//需要引入该头文件
#include<malloc.h>
using namespace std;

typedef struct snode{
	int data;
	struct snode* next = NULL;
}Node; 
typedef Node* Stack;

//使用malloc动态分配Node长度的空间，然后转成Stack类型
Stack n = (Stack)malloc(sizeof(Node));

```

### 函数实现与声明分离

为了分离函数实现，这里采用头文件形式，提供给外部使用。
```c++
//core.h
#ifndef _TEST_
#define _TEST_

#include<iostream>
#include<malloc.h>

typedef struct snode{
	int data;
	struct snode* next = NULL;
}Node; 
typedef Node* Stack;

Stack initStack(); 
void push(Stack& stack,int e);
bool pop(Stack& stack,int& e);
bool isEmpty(Stack stack);
int len(Stack stack); 

#endif
```
头文件定义的函数声明，可以在另一个cpp文件中，只要include进该头文件，并实现所有方法。

```c++
#include "core.h"
using namespace std;

Stack initStack(){
	return NULL;
}

void push(Stack& stack,int e){
	Stack n = (Stack)malloc(sizeof(Node));
	n->data = e;
	n->next = NULL; 
	
	if(stack==NULL){
		stack = n;
		return;
	}
	
	n->next = stack;
	stack = n;
}

bool pop(Stack& stack,int& e){
	if(stack==NULL)return false;
	
	e = stack->data;
	stack = stack->next;
	return true;
}


bool isEmpty(Stack stack){
	if(stack==NULL)return true;
	return false ;
}
int len(Stack stack){
	if(stack==NULL)return 0;
	
	Stack p = stack;
	int len = 1;
	while(p->next!=NULL){
		p = p->next;
		len ++;
	} 
	return len;
}

```
这样就可以在include这个头文件的cpp代码中，使用这些函数。
```
#include "core.h"
using namespace std;

int main() {
	Stack s = initStack();
	
	
	int a = 3;
	push(s,a);

	int b = 5;
	push(s,b);	
	
	int r = 0;
	//pop(s,r);
	//pop(s,r);
	
	cout<<r<<endl;
	return 0;
}
```
