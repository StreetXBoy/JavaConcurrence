package FinalCompareStaic;

/**
 * @author 重新做人idea基础学习
 * @date 2020-10-11
 */
//先加载static 然后构造器！！！



public class ExampleforStatic {
        Person person = new Person("Test");
        static{
            System.out.println("test static");
        }

        public ExampleforStatic() {
            System.out.println("test constructor");
        }

        public static void main(String[] args) {
            new MyClass();
        }
    }

    class Person{
        static{
            System.out.println("person static");
        }
        public Person(String str) {
            System.out.println("person "+str);
        }
    }


    class MyClass extends Test {
        Person person = new Person("MyClass");
        static{
            System.out.println("myclass static");
        }

        public MyClass() {
            System.out.println("myclass constructor");
        }
    }


