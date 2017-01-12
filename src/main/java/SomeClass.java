/**
 * Created by ruslan.
 */
public class SomeClass {

    public static void main(String[] args) {
        method1();
        method2();
        method3();
    }

    // this method create in master branch
    public static void method1() {
        System.out.println("Do something");
    }

    public static void method2() {
        method1();
    }

    public static void method3() {
        method2();
    }
}
