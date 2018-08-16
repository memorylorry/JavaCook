# Try-Catch-Finally代码块返回值不敬人意
在使用try-catch-finally块的时候，经常只考虑，捕捉到异常后该怎么处理。下面把关注点放在返回值上，看如下代码:
```
public static int test(){
   try {
        return 1;
   }catch (Exception e){
        
   }finally {
        return 3;
   }
}
```
这里返回值是1还是3呢？正如平常知道的，当函数遇到return时，函数就执行完毕。这样想答案就是1。
然而现实情况返回值3，这是为啥呢？下面把代码编译成字节码查看：
```
public static int test();
    descriptor: ()I
    flags: ACC_PUBLIC, ACC_STATIC
    Code:
      stack=1, locals=2, args_size=0
         0: iconst_1   //把整数1存入operand stack
         1: istore_0   //pop出operand stack顶部的值，存入本地变量数组
         2: iconst_3   //把整数3存入operand stack
         3: ireturn
         4: astore_0
         5: iconst_3
         6: ireturn
         7: astore_1
         8: iconst_3
         9: ireturn
      Exception table:
         from    to  target type
             0     2     4   Class java/lang/Exception
             0     2     7   any
      LineNumberTable:
        line 7: 0
        line 11: 2
        line 8: 4
        line 11: 5
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
      StackMapTable: number_of_entries = 2
        frame_type = 68 /* same_locals_1_stack_item */
          stack = [ class java/lang/Exception ]
        frame_type = 66 /* same_locals_1_stack_item */
          stack = [ class java/lang/Throwable ]
```
异常捕捉的流程是先try然后catch，最后finally。这里的exception table有from、to、target三个状态组成，正常状况从第0行执行到第2行，然后跳到第7行继续执行;若0到2行出现异常，则跳到第4行执行。
这个例子中，不管有无异常，跳到了第4或7行，都有如下2句指令：
```
iconst_3  //将3存入operand stack
ireturn   //弹出3,存入调用这的operand statck
```
所以最终存入被调用函数的操作栈还是finaly中返回的值。还有一点需要注意，可以参考jvm8说明文档的496页，其中有如下一句,指出异步方法、无异常抛出时的方法，在遇到ireturn时的操作：
```
The current method must have return type boolean , byte , short ,
char , or int . The value must be of type int . If the current method
is a synchronized method, the monitor entered or reentered on
invocation of the method is updated and possibly exited as if by
execution of a monitorexit instruction (§monitor exit) in the current
thread. If no exception is thrown, value is popped from the operand
stack of the current frame (§2.6) and pushed onto the operand stack
of the frame of the invoker. Any other values on the operand stack
of the current method are discarded.

The interpreter then returns control to the invoker of the method,
reinstating the frame of the invoker.
```
