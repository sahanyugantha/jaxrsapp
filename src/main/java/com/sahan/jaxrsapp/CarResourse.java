package com.sahan.jaxrsapp;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;
import com.sahan.jaxrsapp.model.Car;
import com.sahan.jaxrsapp.dao.CarDao;

@Path("cars")
public class CarResourse {
	
	
//	@GET
//	@Produces(MediaType.TEXT_PLAIN)
//	public String test() {
//		return "Yes Working!";
//	}
	
	private static Logger logger = LogManager.getLogger(CarResourse.class);
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll() {
		//Jackson
		//GSON
		
		
		Object object = CarDao.getInstance().getAll();
		
		Gson gson = new Gson();
		
		if(object instanceof List<?>) { //Data type  checking.
			
			@SuppressWarnings("unchecked")
			List<Car> cars = (List<Car>)object; //Casting.
			
			String jsonString = gson.toJson(cars);
			
			
			logger.trace("T-- Fetch all cars successfully");
			logger.debug("D--Fetch all cars successfully");
			logger.info("I--Fetch all cars successfully");
			logger.warn("W--Fetch all cars successfully");
			logger.error("E--Fetch all cars successfully");
			logger.fatal("F--Fetch all cars successfully");
			
			
			return Response
					.status(200)
					.entity(jsonString)
					.build();
						
		} else {
			@SuppressWarnings("unchecked")
			Map<String, String> errMsg = (Map<String, String>)object; //Casting.
			
			String jsonString = gson.toJson(errMsg);
			
			logger.error("Couldn't fetch all cars");
			
			return Response
					.status(200)
					.entity(jsonString)
					.build();
		}
		
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getACar(@PathParam("id") String id) {
		
		int carid = Integer.parseInt(id);
		
		Car car = CarDao.getInstance().get(carid);
		
		Gson gson = new Gson();
		String jsonString = gson.toJson(car);
		
		return Response
				.status(200)
				.entity(jsonString)
				.build();
		
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public void addCar(@FormParam("model") String model,
							@FormParam("brand") String brand,
							@FormParam("year") int year,
							@FormParam("color") String color,
							@FormParam("type") String type) throws ClassNotFoundException, SQLException {
		
		Car car= new Car();
		
		car.setModel(model);
		car.setBrand(brand);
		car.setYear(year);
		car.setColor(color);
		car.setType(type);
		
		//boolean result = CarDao.getInstance().add(car);
	
	}

}
