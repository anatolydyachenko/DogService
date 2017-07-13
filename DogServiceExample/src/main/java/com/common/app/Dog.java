package com.common.app;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by adyachenko on 7/22/2016.!
 */
public class Dog {
    private static final String DATE_FORMAT = "dd.MM.yyyy";

    private int id;
    private String name;
    private String dateOfBirth;
    private int height;
    private int weight;

    public Dog() {
        id = -1;
        name = null;
        dateOfBirth = null;
        height = -1;
        weight = -1;
    }

    public Dog(int id, String name, String dateOfBirth, int height, int weight) {
        this.setId(id);
        this.setName(name);
        this.setDateOfBirth(dateOfBirth);
        this.setHeight(height);
        this.setWeight(weight);
    }

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
            System.out.println("Name should has length in range 1-100. Value is not updated to next one: " + name);
        }

    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        DateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT);
        try {
            Date currentDate = simpleDateFormat.parse(simpleDateFormat.format(new Date()));
            Date dateOfBirthDate = simpleDateFormat.parse(dateOfBirth);

            if (dateOfBirthDate.before(currentDate)) {
                this.dateOfBirth = dateOfBirth;
            } else {
                System.out.println("DateOfBirth should be before current date. Value is not updated. DateOfBirth date: " + dateOfBirth + ". Current date: " + simpleDateFormat.format(new Date()));
            }

        } catch (ParseException e) {
            throw new RuntimeException("Date has incorrect format. It should be dd.MM.yyyy", e); // todo create Validation exception, use for all setters
            //System.out.println("Date has incorrect format. It should be dd.MM.yyyy, but it is: \"" + dateOfBirth + "\". Value is not updated.");
//            System.out.println(e);
        }
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        if (height > 0) {
            this.height = height;
        } else {
            System.out.println("Height should be positive: " + height + ". Value is not updated");
        }
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        if (weight > 0) {
            this.weight = weight;
        } else {
            System.out.println("Weight should be positive: " + weight + ". Value is not updated");
        }
    }
}

