package rest;

import app.Dog;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

import static Json.JsonHelper.mapStringStringToJson;

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
//
//		Dog dog1 = new Dog();
//		dog1.setId(String.valueOf(id));
//		id++;
//		dog1.setName("Pony");
//		dog1.setDateOfBirth("05.10.2011");
//		dog1.setHeight(50);
//		dog1.setWeight(7);
//		dogs.put(dog1.getId(), dog1);
//
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
		String jsonResponse = mapStringStringToJson(dogs);

		return Response.status(200).entity(jsonResponse).build();
	}

//	@GET
//	@Path("dogs/{id}")
//	@Produces("application/json")
//	public Response printMessage(@PathParam("id") String id) throws ParseException {
//		JsonElement jelement = new JsonParser().parse(mapStringStringToJson(dogs));
//		JsonObject jobject = jelement.getAsJsonObject();
//		JsonObject result = jobject.getAsJsonObject(id);
//
//		return Response.status(200).entity(result.toString()).build();
//	}
//
//	@POST
//	@Path("dogs/dog")
//	@Consumes("application/json")
//	public Response createNewDog(String dogParametersInJson) {
//
//		JsonElement jelement = new JsonParser().parse(dogParametersInJson);
//		JsonObject jobject = jelement.getAsJsonObject();
//		JsonObject jsonObject = jobject.getAsJsonObject();
//
//		String idOfNewDog = id.toString();
//		String nameOfNewDog = jsonObject.get("name").getAsString();
//		String dateOfBirthOfNewDog = jsonObject.get("dateOfBirth").getAsString();
//		Integer heightOfNewDog = jsonObject.get("height").getAsInt();
//		Integer weightOfNewDog = jsonObject.get("weight").getAsInt();
//
//		Dog dog = new Dog();
//		dog.setId(String.valueOf(id));
//		id++;
//		dog.setName(nameOfNewDog);
//		dog.setDateOfBirth(dateOfBirthOfNewDog);
//		dog.setHeight(heightOfNewDog);
//		dog.setWeight(weightOfNewDog);
//		dogs.put(dog.getId(), dog);
//
//		String outputMessage = "Dog with id " + idOfNewDog + " has been created";
//
//		return Response.status(200).entity(outputMessage).build();
//	}
//
//	@PUT
//	@Path("dogs/dog")
//	@Consumes("application/json")
//	public Response updateTheDog(String dogParametersInJson) {
//
//		JsonElement jelement = new JsonParser().parse(dogParametersInJson);
//		JsonObject jobject = jelement.getAsJsonObject();
//		JsonObject jsonObject = jobject.getAsJsonObject();
//
//		String idOfNewDog = jsonObject.get("id").getAsString();
//		String nameOfNewDog = jsonObject.get("name").getAsString();
//		String dateOfBirthOfNewDog = jsonObject.get("dateOfBirth").getAsString();
//		Integer heightOfNewDog = jsonObject.get("height").getAsInt();
//		Integer weightOfNewDog = jsonObject.get("weight").getAsInt();
//
//		Dog dog = new Dog();
//		dog.setId(idOfNewDog);
//		dog.setName(nameOfNewDog);
//		dog.setDateOfBirth(dateOfBirthOfNewDog);
//		dog.setHeight(heightOfNewDog);
//		dog.setWeight(weightOfNewDog);
//		dogs.put(dog.getId(), dog);
//
//		String outputMessage = "Dog with id " + idOfNewDog + " has been updated";
//
//		return Response.status(200).entity(outputMessage).build();
//	}
//
//	@DELETE
//	@Path("dogs/dog")
//	@Consumes("application/json")
//	public Response deleteTheDog(String dogParametersInJson) {
//
//		JsonElement jelement = new JsonParser().parse(dogParametersInJson);
//		JsonObject jobject = jelement.getAsJsonObject();
//		JsonObject jsonObject = jobject.getAsJsonObject();
//
//		String idOfNewDog = jsonObject.get("id").getAsString();
//
//		dogs.remove(idOfNewDog);
//
//		String outputMessage = "Dog with id " + idOfNewDog + " has been removed";
//
//		return Response.status(200).entity(outputMessage).build();
//	}
}