package war;

import junit.framework.Assert;
import org.junit.Test;
import app.Dog;

public class DogTest {
    @Test
    public void setNameForDog() {
        Dog dog1 = new Dog();
        String tempName = dog1.getName();
        dog1.setName(""); //try to set empty
        Assert.assertTrue(tempName == dog1.getName());

        dog1.setName("12345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901"); //try to set >101 symbol
        Assert.assertTrue(tempName == dog1.getName());

        dog1.setName("q"); //try to enter min value
        Assert.assertTrue(dog1.getName() == "q");

        dog1.setName("1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890"); //try to enter max value
        Assert.assertTrue(dog1.getName() == "1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890");
    }

    @Test
    public void setDateOfBirth() {
        Dog dog1 = new Dog();
//        String tempDateOfBirth = dog1.getDateOfBirth();
        dog1.setDateOfBirth(""); //try to set empty
        Assert.assertTrue("12.12.2012" == dog1.getName());
    }
}
