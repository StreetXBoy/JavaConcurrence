package FinalCompareStaic;


/**
 * @author 重新做人idea基础学习
 * @date 2020-10-11
 */

//　在使用final修饰类的时候，要注意谨慎选择，除非这个类真的在以后不会用来继承或者出于安全的考虑，尽量不要将类设计为final类。


//对于一个final变量，如果是基本数据类型的变量，则其数值一旦在初始化之后便不能更改；如果是引用类型的变量，则在对其初始化之后便不能再让其指向另一个// 对象。

//对于static理解：
//    static方法就是没有this的方法。在static方法内部不能调用非静态方法，
//    反过来是可以的。而且可以在没有创建任何对象的前提下，仅仅通过类本身来调用static方法。这实际上正是static方法的主要用途。
//    static是不允许用来修饰局部变量


public class TestABC {
    public static void main(String[] args) {
        Test test= new Test();
        test.value=99999;
        //这的99999999无效的因为 new obje时已经完成赋值！！！

        // test.setA(1123);  看finalA 没有set方法！！！！

        System.out.println("FinalA: "+test.getA());
        System.out.println("FinalB: "+Test.getB());
        System.out.println("FinalC: "+test.getC());

    }
}
