package basic.common;

public class Operate {
    //与
    public static void test1(){
        //整数是32 bit的
        //37 ：00000 0000 0010 0101
        //61 ：00000 0000 0011 1101
        //&    00000 0000 0010 0101 => 37
        System.out.println(37&61);
    }
    //或
    public static void test2(){
        //37 ：00000 0000 0010 0101
        //61 ：00000 0000 0011 1101
        //|    00000 0000 0011 1101 => 61
        System.out.println(37|61);
    }
    //非
    public static void test3(){
        //Java默认是以补码方式存储的
        //8的补码: 0000 0000 0000 1000
        //8的原码: 0000 0000 0000 0111
        //~:      1111 1111 1111 1001
        System.out.println(~8);
    }
    //异或
    public static void test4(){
        //37 ：00000 0000 0010 0101
        //61 ：00000 0000 0011 1101
        //^    00000 0000 0001 1000 => 24
        System.out.println(37^61);
    }
    //同或
    public static void test5(){
        //37 ：00000 0000 0010 0101
        //61 ：00000 0000 0011 1101
        //同或 11111 1111 1110 0111 => -2147483623
        System.out.println(~(37^61));
    }
    public static void main(String arg[]){
        test1();
        test2();
        test3();
        test4();
        test5();
    }
}
