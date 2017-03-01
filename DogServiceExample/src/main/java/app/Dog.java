package app;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by adyachenko on 7/22/2016.!
 */
public class Dog {
    private int id;
    private String name;
    private Date dateOfBirth;
    private int height;
    private int weight;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() >= 1 && name.length() <= 100) {
            this.name = name;
        } else {
            System.out.println("Name should has length in range 1-100");
        }

    }

    public String getDateOfBirth() {
        DateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        return simpleDateFormat.format(dateOfBirth);
    }

    public void setDateOfBirth(String dateOfBirthString) {
        DateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        try {
            this.dateOfBirth = simpleDateFormat.parse(dateOfBirthString);
        } catch (ParseException e) {
            System.out.println(e);
        }
//        DateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
//        Date currentDate = new Date();
//        try {
//            dateOfBirth = simpleDateFormat.parse(dateOfBirth);
//        } catch (ParseException e) {
//            //e.printStackTrace();
//            System.out.println("Birth date should fit date formate 'yyyy/MM/dd'. Error message: " + e.getMessage());
//        }
//
//        if (currentDate.after(dateOfBirth)){
//            this.dateOfBirth = dateOfBirth;
//        }
//        else {
//            System.out.println("Date of birth must be before current date");
//        }
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.setDateOfBirth("1990/10/10");
        String s = dog.getDateOfBirth();
        System.out.println(s);
    }
}

