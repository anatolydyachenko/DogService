package com.common.war;

import java.util.Calendar;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.junit.Assert;
import org.junit.Test;
import com.common.app.Dog;

public class DogTest {
    public static final String MAX_NAME = "1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890";

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
    public void setName() {
        Dog dog1 = new Dog();
        //try to enter min value
        dog1.setName("q");
        Assert.assertEquals(dog1.getName(), "q");

        //try to enter max value
        dog1.setName(MAX_NAME);
        Assert.assertEquals(dog1.getName(), MAX_NAME);
    }

    @Test (expected = RuntimeException.class)
    public void setNameEmpty() throws RuntimeException{
        Dog dog1 = new Dog();
        //try to set empty
        dog1.setName("");
    }

    @Test (expected = RuntimeException.class)
    public void setNameBig() throws RuntimeException {
        Dog dog1 = new Dog();
        //try to set 101 symbol
        dog1.setName(MAX_NAME + 1);
    }

    @Test(expected = RuntimeException.class)
    public void setDateOfBirthEmpty() throws RuntimeException {
        Dog dog1 = new Dog();
        //try to set empty
        dog1.setDateOfBirth("");
    }

    @Test(expected = RuntimeException.class)
    public void setDateOfBirthIncorrectFormat() throws RuntimeException {
        Dog dog1 = new Dog();
        //try to set incorrect format
        dog1.setDateOfBirth("qwerty");
    }

    @Test(expected = RuntimeException.class)
    public void setDateOfBirthAfterToday() throws RuntimeException {
        Dog dog1 = new Dog();
        // check day after today
        c.setTime(new Date());
        c.add(Calendar.DATE, 1);
        dateToSubmit = simpleDateFormat.format(c.getTime());
        dog1.setDateOfBirth(dateToSubmit);
    }

    @Test(expected = RuntimeException.class)
    public void setDateOfBirthToday() throws RuntimeException {
        Dog dog1 = new Dog();
        // check today date
        dateToSubmit = simpleDateFormat.format(new Date());
        dog1.setDateOfBirth(dateToSubmit);
    }

    @Test
    public void setDateOfBirthBeforeToday() {
        Dog dog1 = new Dog();
        // check day before today
        c.setTime(new Date());
        c.add(Calendar.DATE, -1);
        dateToSubmit = simpleDateFormat.format(c.getTime());
        dog1.setDateOfBirth(dateToSubmit);
        Assert.assertEquals(dog1.getDateOfBirth(), dateToSubmit);
    }

    @Test(expected = RuntimeException.class)
    public void setHeightForDogNegative() throws RuntimeException {
        Dog dog1 = new Dog();
        int tmpHeight = dog1.getHeight();
        dog1.setHeight(-5); //how to check, that even when exception was thrown, that value was not changed?
//        Assert.assertEquals(dog1.getHeight(), tmpHeight);
    }

    @Test(expected = RuntimeException.class)
    public void setHeightForDogZero() throws RuntimeException {
        Dog dog1 = new Dog();
        int tmpHeight = dog1.getHeight();
        dog1.setHeight(0);
//        Assert.assertEquals(dog1.getHeight(), tmpHeight);
    }

    @Test
    public void setHeightForDogPositive() {
        Dog dog1 = new Dog();
        dog1.setHeight(1);
        Assert.assertEquals(dog1.getHeight(), 1);
    }

    @Test(expected = RuntimeException.class)
    public void setWeightForDogNegative() throws RuntimeException {
        Dog dog1 = new Dog();
        int tmpWeight = dog1.getWeight();
        dog1.setWeight(-5);
    }

    @Test(expected = RuntimeException.class)
    public void setWeightForDogZero() throws RuntimeException {
        Dog dog1 = new Dog();
        dog1.setWeight(0);
    }

    @Test
    public void setWeightForDogPositive() {
        Dog dog1 = new Dog();
        dog1.setWeight(1);
        Assert.assertEquals(dog1.getWeight(), 1);
    }


    @Test
    public void getForDog() {
        Dog dog1 = new Dog(10, "TestName", "25.05.2010", 15, 25);
        Assert.assertEquals(dog1.getId(), 10);
        Assert.assertEquals(dog1.getName(), "TestName");
        Assert.assertEquals(dog1.getDateOfBirth(), "25.05.2010");
        Assert.assertEquals(dog1.getHeight(), 15);
        Assert.assertEquals(dog1.getWeight(), 25);

    }
}
