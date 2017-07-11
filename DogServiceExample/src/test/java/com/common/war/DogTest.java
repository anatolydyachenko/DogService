package com.common.war;

import java.util.Calendar;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import junit.framework.Assert;
import org.junit.Test;
import com.common.app.Dog;

public class DogTest {
    DateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
    Calendar c = Calendar.getInstance();
    String dateToSubmit;

    @Test
    public void setIdForDog() {
        Dog dog1 = new Dog();
        dog1.setId(-2);
        Assert.assertEquals(dog1.getId(), -2);

        dog1.setId(0);
        Assert.assertEquals(dog1.getId(), 0);

        dog1.setId(5);
        Assert.assertEquals(dog1.getId(), 5);
    }

    @Test
    public void setNameForDog() {
        Dog dog1 = new Dog();
        String tempName = dog1.getName();
        dog1.setName(""); //try to set empty
        Assert.assertEquals(tempName, dog1.getName());

        dog1.setName("12345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901"); //try to set >101 symbol
        Assert.assertEquals(tempName, dog1.getName());

        dog1.setName("q"); //try to enter min value
        Assert.assertEquals(dog1.getName(), "q");

        dog1.setName("1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890"); //try to enter max value
        Assert.assertEquals(dog1.getName(), "1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890");
    }

    @Test
    public void setDateOfBirthForDog() {
        Dog dog1 = new Dog();
        //try to set empty
        dog1.setDateOfBirth("");
        Assert.assertNull(dog1.getDateOfBirth());

        //try to set incorrect format
        dog1.setDateOfBirth("qwerty");
        Assert.assertNull(dog1.getDateOfBirth());

        // check day after today
        c.setTime(new Date());
        c.add(Calendar.DATE, 1);
        dateToSubmit = simpleDateFormat.format(c.getTime());
        dog1.setDateOfBirth(dateToSubmit);
        Assert.assertNull(dog1.getDateOfBirth());

        // check today date
        dateToSubmit = simpleDateFormat.format(new Date());
        dog1.setDateOfBirth(dateToSubmit);
        Assert.assertNull(null);

        // check day before today
        c.setTime(new Date());
        c.add(Calendar.DATE, -1);
        dateToSubmit = simpleDateFormat.format(c.getTime());
        dog1.setDateOfBirth(dateToSubmit);
        Assert.assertEquals(dog1.getDateOfBirth(), dateToSubmit);

    }

    @Test
    public void setHeightForDog() {
        Dog dog1 = new Dog();
        int tmpHeight = dog1.getHeight();
        dog1.setHeight(-5);
        Assert.assertEquals(dog1.getHeight(), tmpHeight);

        dog1.setHeight(0);
        Assert.assertEquals(dog1.getHeight(), tmpHeight);

        dog1.setHeight(1);
        Assert.assertEquals(dog1.getHeight(), 1);
    }

    @Test
    public void setWeightForDog() {
        Dog dog1 = new Dog();
        int tmpWeight = dog1.getWeight();
        dog1.setWeight(-5);
        Assert.assertEquals(dog1.getWeight(), tmpWeight);

        dog1.setWeight(0);
        Assert.assertEquals(dog1.getWeight(), tmpWeight);

        dog1.setWeight(1);
        Assert.assertEquals(dog1.getWeight(), 1);
    }

    @Test
    public void getForDog() {
        Dog dog1 = new Dog(10, "TestName", "25.05.2010", 15, 25, true);
        Assert.assertEquals(dog1.getId(), 10);
        Assert.assertEquals(dog1.getName(), "TestName");
        Assert.assertEquals(dog1.getDateOfBirth(), "25.05.2010");
        Assert.assertEquals(dog1.getHeight(), 15);
        Assert.assertEquals(dog1.getWeight(), 25);

    }
}
