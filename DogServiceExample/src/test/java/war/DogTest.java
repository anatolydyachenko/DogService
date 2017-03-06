package war;

import junit.framework.Assert;
import org.junit.Test;
import app.Dog;

public class DogTest {
    @Test(timeout = 10)
    public void testCase1(){
        Dog dog1 = new Dog();

        Assert.assertTrue(false);
    }
}
