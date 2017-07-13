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

    static {
        Dog dog0 = new Dog(id, "Rex", "08.11.2013", 40, 8);
        incrementDogId();
        dogs.put(dog0.getId(), dog0);

        Dog dog1 = new Dog(id, "Bobik", "05.10.2011", 20, 3);
        incrementDogId();
        dogs.put(dog1.getId(), dog1);
    }

    public static void incrementDogId() {
        id++;
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
    public Response printDog(@PathParam("id") String id) {
        int idInt = Integer.valueOf(id);
        if (dogs.containsKey(idInt)) {
            String result = JsonHelper.mapToJson(dogs.get(idInt));
            return Response.status(200).entity(result).build();
        }
        return Response.status(404).build();
    }

    @POST
    @Path("dog")
    @Consumes("application/json")
    public Response createNewDog(String dogJson) {

        JsonElement jelement = new JsonParser().parse(dogJson);
        JsonObject jobject = jelement.getAsJsonObject();
        JsonObject jsonObject = jobject.getAsJsonObject();

        String idOfNewDog = id.toString();
        String nameOfNewDog = jsonObject.get("name").getAsString();
        String dateOfBirthOfNewDog = jsonObject.get("dateOfBirth").getAsString();
        Integer heightOfNewDog = jsonObject.get("height").getAsInt();
        Integer weightOfNewDog = jsonObject.get("weight").getAsInt();

        Dog dog = new Dog(id, nameOfNewDog, dateOfBirthOfNewDog, heightOfNewDog, weightOfNewDog);
        incrementDogId();
        dogs.put(dog.getId(), dog);

        String outputMessage = "Dog has been created. Id = " + idOfNewDog;

        return Response.status(200).entity(outputMessage).build();
    }

    @PUT
    @Path("dog")
    @Consumes("application/json")
    public Response updateTheDog(String dogJson) {

        JsonElement jelement = new JsonParser().parse(dogJson);
        JsonObject jobject = jelement.getAsJsonObject();
        JsonObject jsonObject = jobject.getAsJsonObject();

        int idOfNewDog = jsonObject.get("id").getAsInt();
        String nameOfNewDog = jsonObject.get("name").getAsString();
        String dateOfBirthOfNewDog = jsonObject.get("dateOfBirth").getAsString();
        Integer heightOfNewDog = jsonObject.get("height").getAsInt();
        Integer weightOfNewDog = jsonObject.get("weight").getAsInt();

        Dog dog = new Dog(idOfNewDog, nameOfNewDog, dateOfBirthOfNewDog, heightOfNewDog, weightOfNewDog);
        if (idOfNewDog >= id) incrementDogId();
        dogs.put(dog.getId(), dog);

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
}