package com.common.rest;

import com.common.json.JsonHelper;
import com.common.app.Dog;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;


@Path("/")
public class DogService {

    private static Integer id = 0;
    private static Map<Integer, Dog> dogs = new HashMap<Integer, Dog>();
    // todo read about DAO/DTO/Service separation

    static {
        Dog dog0 = makeNewDog(new Dog(id, "Rex", "08.11.2013", 40, 8));
        dogs.put(dog0.getId(), dog0);

        Dog dog1 = makeNewDog(new Dog(id, "Bobik", "05.10.2011", 20, 3));
        dogs.put(dog1.getId(), dog1);
    }
    
    private static Dog makeNewDog(Dog dog) {
        dog.setId(id++);
        return dog;
    }

    @GET
    @Path("dogs")
    @Produces("application/json")
    public Response printDogs() {
        return Response.status(200).entity(JsonHelper.mapToJson(dogs)).build();
    }

    @GET
    @Path("dog/{id}")
    @Produces("application/json")
    public Response printDog(@PathParam("id") int id) {
        //int idInt = Integer.valueOf(id);
        if (dogs.containsKey(id)) {
            String result = JsonHelper.mapToJson(dogs.get(id));
            return Response.status(200).entity(result).build();
        }
        return Response.status(404).build(); // todo throw DogNotFound
    }

    @POST
    @Path("dog")
    @Consumes("application/json")
    public Response createNewDog(String dogJson) {

        JsonElement jelement = new JsonParser().parse(dogJson); // todo automatic parsing
        JsonObject jsonObject = jelement.getAsJsonObject();

        String idOfNewDog = id.toString();
        String nameOfNewDog = jsonObject.get("name").getAsString();
        String dateOfBirthOfNewDog = jsonObject.get("dateOfBirth").getAsString();
        Integer heightOfNewDog = jsonObject.get("height").getAsInt();
        Integer weightOfNewDog = jsonObject.get("weight").getAsInt();

        Dog dog = makeNewDog(new Dog(id, nameOfNewDog, dateOfBirthOfNewDog, heightOfNewDog, weightOfNewDog));
        dogs.put(dog.getId(), dog);

        String outputMessage = "Dog has been created. Id = " + idOfNewDog;

        return Response.status(200).entity(outputMessage).build();
    }

    @PUT
    @Path("dog")
    @Consumes("application/json")
    public Response updateTheDog(String dogJson) {

        JsonElement jelement = new JsonParser().parse(dogJson);
        JsonObject jsonObject = jelement.getAsJsonObject();

        int idOfNewDog = jsonObject.get("id").getAsInt();
        String nameOfNewDog = jsonObject.get("name").getAsString();
        String dateOfBirthOfNewDog = jsonObject.get("dateOfBirth").getAsString();
        Integer heightOfNewDog = jsonObject.get("height").getAsInt();
        Integer weightOfNewDog = jsonObject.get("weight").getAsInt();

        Dog dog = dogs.get(idOfNewDog);
        if(dog == null) throw new DogNotFoundException("No dog with id" + idOfNewDog);
        
        dog.setName(nameOfNewDog);
        dog.setDateOfBirth(dateOfBirthOfNewDog);
        dog.setHeight(heightOfNewDog);
        dog.setWeight(weightOfNewDog);

        String outputMessage = "Dog has been updated. Id =  " + idOfNewDog;

        return Response.status(200).entity(outputMessage).build();
    }

    @DELETE
    @Path("dog/{id}")
    @Consumes("application/json")
    public Response deleteTheDog(@PathParam("id") String id) {

        int idOfDog = Integer.valueOf(id);
        dogs.remove(idOfDog);
        String outputMessage = "Dog has been removed. Id = " + idOfDog;
        return Response.status(200).entity(outputMessage).build();
    }
    
    private class DogNotFoundException extends RuntimeException {
        DogNotFoundException(String message) {
            super(message);
        }
    }
}