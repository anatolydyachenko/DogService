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
        if (dateOfBirth != null) {
            return simpleDateFormat.format(dateOfBirth);
        }
        else return null;
    }

    public void setDateOfBirth(String dateOfBirthString) {
        DateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Date currentDate = new Date();
        try {
            if (simpleDateFormat.parse(dateOfBirthString).after(currentDate)) {
                this.dateOfBirth = simpleDateFormat.parse(dateOfBirthString);
            } else {
                System.out.println("DateOfBirth can not be earlier, than current date");
            }

        } catch (ParseException e) {
            System.out.println("Date has incorrect format. It should be dd.MM.yyyy");
//            System.out.println(e);
        }
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
        dog.setDateOfBirth("11.03.2017");
        String s = dog.getDateOfBirth();
        System.out.println(s);
    }
}

