package com.sahan.jaxrsapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.sahan.jaxrsapp.model.User;

@Path("users")
public class UserResourse {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON) //Header Type
	public Response getUsers() {
		
		List<User> users = fetchUsers();
		Gson gson = new Gson();
		
		String jsonString = gson.toJson(users);
		
		return Response
				.status(200)
				.entity(jsonString)
				.build();
	}
	
	@GET
	@Path("id/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAUser(@PathParam("id") int id) {
		try {
			
			List<User> users = fetchUsers();
			
			User user = users.get(id);
			
			Gson gson = new Gson();
			
			String jsonString = gson.toJson(user);
			
			return Response
					.status(200)
					.entity(jsonString)
					.build();
			

		} catch (Exception e) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("MESSAGE", "No value found  - "+e.getMessage());
			
			Gson gson = new Gson();
			String jsonString = gson.toJson(map);
			
			return Response
					.status(200)
					.entity(jsonString)
					.build();
		}
		
		
	}
	
	
	public List<User> fetchUsers(){
		List<User> userList = new ArrayList<User>();
		
		User user = new User(1, "Jon", "jon@bcas.lk", "123", "ADMIN");
		userList.add(user);
		
		User user1 = new User(2, "Anne", "anne@bcas.lk", "123", "STANDARD");
		userList.add(user1);
		
		User user2 = new User(3, "Sam", "sam@bcas.lk", "123", "STANDARD");
		userList.add(user2);
		
		return userList;
		
	}

}
