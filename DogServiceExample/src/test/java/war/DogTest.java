package war;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import junit.framework.Assert;
import org.junit.Test;
import app.Dog;

public class DogTest {
    DateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
    Calendar c = Calendar.getInstance();
    String dateToSubmit;

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
    public void setDateOfBirthForDog() {
        Dog dog1 = new Dog();
        dog1.setDateOfBirth(""); //try to set empty
        Assert.assertTrue(dog1.getDateOfBirth() == null);

        // check day before today
        c.setTime(new Date());
        c.add(Calendar.DATE,-1);
        dateToSubmit = simpleDateFormat.format(c.getTime());
        dog1.setDateOfBirth(dateToSubmit);
        Assert.assertTrue(dog1.getDateOfBirth()==null);

        // check today date
        dateToSubmit = simpleDateFormat.format(new Date());
        dog1.setDateOfBirth(dateToSubmit);
        Assert.assertTrue(dog1.getDateOfBirth()==null);

        // check day after today
        c.setTime(new Date());
        c.add(Calendar.DATE,1);
        dateToSubmit = simpleDateFormat.format(c.getTime());
        dog1.setDateOfBirth(dateToSubmit);
        Assert.assertTrue(dog1.getDateOfBirth().equals(dateToSubmit));

    }
}
