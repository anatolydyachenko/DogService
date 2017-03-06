package rest;

import Json.JsonHelper;
import app.Dog;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.json.simple.parser.ParseException;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;


@Path("/")
public class DogService {

    private static Integer id = 0;
    private static Map<Integer, Dog> dogs = new HashMap<Integer, Dog>();

    static {
        Dog dog0 = new Dog();
        dog0.setId(id);
        id++;
        dog0.setName("Loly");
        dog0.setDateOfBirth("08.11.2013");
        dog0.setHeight(50);
        dog0.setWeight(7);
        dogs.put(dog0.getId(), dog0);

		Dog dog1 = new Dog();
		dog1.setId(id);
		id++;
		dog1.setName("Pony");
		dog1.setDateOfBirth("05.10.2011");
		dog1.setHeight(50);
		dog1.setWeight(7);
		dogs.put(dog1.getId(), dog1);

//		Dog dog2 = new Dog();
//		dog2.setId(String.valueOf(id));
//		id++;
//		dog2.setName("Rainbow");
//		dog2.setDateOfBirth("08.12.2015");
//		dog2.setHeight(61);
//		dog2.setWeight(12);
//		dogs.put(dog2.getId(), dog2);
    }

    @GET
    @Path("dogs")
    @Produces("application/json")
    public Response printMessage() {
        return Response.status(200).entity(JsonHelper.mapToJson(dogs)).build();
    }


	@GET
	@Path("dog/{id}")
	@Produces("application/json")
	public Response printMessage(@PathParam("id") String id) {
		JsonElement jelement = new JsonParser().parse(JsonHelper.mapToJson(dogs));
		JsonObject jobject = jelement.getAsJsonObject();
		JsonObject result = jobject.getAsJsonObject(id);

		return Response.status(200).entity(result.toString()).build();
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

		Dog dog = new Dog();
		dog.setId(id);
		id++;
		dog.setName(nameOfNewDog);
		dog.setDateOfBirth(dateOfBirthOfNewDog);
		dog.setHeight(heightOfNewDog);
		dog.setWeight(weightOfNewDog);
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

		Dog dog = new Dog();
		dog.setId(idOfNewDog);
		dog.setName(nameOfNewDog);
		dog.setDateOfBirth(dateOfBirthOfNewDog);
		dog.setHeight(heightOfNewDog);
		dog.setWeight(weightOfNewDog);
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