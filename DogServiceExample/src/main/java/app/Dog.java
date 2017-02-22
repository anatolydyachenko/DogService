package app;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by adyachenko on 7/22/2016.!
 */
public class Dog {
    private String name, dateOfBirthString;
    private Number height, weight;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length()>=1 && name.length()<=100){
            this.name = name;
        }
        else {
            System.out.println("Name should has length in range 1-100");
        }

    }

    public String getdateOfBirthString() {
        return dateOfBirthString;
    }

    public void setDateOfBirthString(String dateOfBirthString) {
        DateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date currentDate = new Date();
        Date dateOfBirth = new Date();
        try {
            dateOfBirth = simpleDateFormat.parse(dateOfBirthString);
        } catch (ParseException e) {
            //e.printStackTrace();
            System.out.println("Birth date should fit date formate 'yyyy/MM/dd'. Error message: " + e.getMessage());
        }

        if (currentDate.after(dateOfBirth)){
            this.dateOfBirthString = dateOfBirthString;
        }
        else {
            System.out.println("Date of birth must be before current date");
        }
    }

    public Number getHeight() {
        return height;
    }

    public void setHeight(Number height) {
        this.height = height;
    }

    public Number getWeight() {
        return weight;
    }

    public void setWeight(Number weight) {
        this.weight = weight;
    }

    public static void main(String[] args){
        Dog dog = new Dog();
        dog.setDateOfBirthString("");
        System.out.println(dog.getdateOfBirthString());
    }
}

