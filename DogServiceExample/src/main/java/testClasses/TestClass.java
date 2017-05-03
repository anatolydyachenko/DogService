package testClasses;

/**
 * Created by adyachenko on 4/26/2017.
 */
public class TestClass {
    int x;

    TestClass(int i) {
        x = i;
    }

    void generate(int i) {
        System.out.println("Created " + i);
        TestClass inst = new TestClass(i);
    }

//    @Override
    protected void finalize() throws Throwable {
        System.out.println("Finalizing " + x);
    }
}
