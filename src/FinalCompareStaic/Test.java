package FinalCompareStaic;

/**
 * @author 重新做人idea基础学习
 * @date 2020-10-11
 */
public class Test {
    public   int value=99;
    private  final  int a = value;
    private  static  int b=10;////竟然不能赋值变量！！！！
    private  int c=value;


    public int getA() {
        return a;
    }

    public static int getB() {
        return b;
    }

    public static void setB(int b) {
        Test.b = b;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }
}
