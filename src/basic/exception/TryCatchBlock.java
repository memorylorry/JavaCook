package exception;

public class TryCatchBlock {
    public static void t1(){}
    public static void t2(){}
    public static void t3(){}

    //这个方法调用的时候返回值多少呢？
    public static int test(){
        try {
            return 1;
        }catch (Exception e){

        }finally {
            return 3;
        }
    }

    public static void main(String arg[]){
        System.out.println(test());
    }
}
