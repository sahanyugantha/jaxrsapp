package com.sahan.jaxrsapp;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.sahan.jaxrsapp.dao.UserDao;
import com.sahan.jaxrsapp.model.User;

@Path("users")
public class UserResourse {
	
	
	@POST
	@Path("login")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Response userLogin(@FormParam("email") String email,
								@FormParam("password") String password) throws URISyntaxException  {
		
		User user = UserDao.getInstance().LoginChecker(email, password);
		Gson gson = new Gson();
		
		if(user.getUsername() != null && user.getUsername().length() > 0) {
			String jsonString = gson.toJson(user);
			
			return Response
					.status(200)
					.entity(jsonString)
					.build();
		} else {
//			Map<String, String> map = new HashMap<String, String>();
//			map.put("MESSAGE", "Invalid login details");
//			
//			String jsonString = gson.toJson(map);
//			
//			return Response
//					.status(200)
//					.entity(jsonString)
//					.build();

			return Response
					.seeOther(new URI("http://localhost:8080/jaxrsapp/login.jsp"))
					.build();
		}
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON) //Header Type
	public Response getUsers() {
		
		List<User> users = UserDao.getInstance().getAll();
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
	public Response getAUser(@PathParam("id") int id){
		try {
			
			List<User> users = UserDao.getInstance().getAll();
			
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
//			
			return Response
					.status(200)
					.entity(jsonString)
					.build();
			
		}
		
		
	}
	
	
	
//	public List<User> fetchUsers(){
//		List<User> userList = new ArrayList<User>();
//		
//		User user = new User(1, "Jon", "jon@bcas.lk", "123", USER_ROLES.ADMIN);
//		userList.add(user);
//		
//		User user1 = new User(2, "Anne", "anne@bcas.lk", "123", USER_ROLES.ANONYMOUS);
//		userList.add(user1);
//		
//		User user2 = new User(3, "Sam", "sam@bcas.lk", "123", USER_ROLES.STANDARD);
//		userList.add(user2);
//		
//		return userList;
//		
//	}

}
