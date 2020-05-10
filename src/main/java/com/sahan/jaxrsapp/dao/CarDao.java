package com.sahan.jaxrsapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sahan.jaxrsapp.model.Car;

public class CarDao {
	
	private static CarDao newInstance = new CarDao();
	
	public static CarDao getInstance() {
		return newInstance;
	}
	
	private CarDao() {
		
	}
	

	
	//Fetching data from database.
	public Object getAll(){
		List<Car> carList = new ArrayList<Car>();
		
		
		try {
			
			Connection conn = Configs.getDbConnection();
			
			String sql = "SELECT * FROM tbl_car";//Query to be execute
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			
			ResultSet resultSet = preparedStatement.executeQuery(); //Query execution.
			
			while(resultSet.next()) {
				Car car = new Car();
				
				car.setId(resultSet.getInt("id"));
				car.setModel(resultSet.getString("model"));
				car.setBrand(resultSet.getString("brand"));
				car.setYear(resultSet.getInt("year"));
				car.setColor(resultSet.getString("color"));
				car.setType(resultSet.getString("type"));
				
				carList.add(car);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error : "+e.getMessage());
			
			Map<String, String> errMsg = new HashMap<String, String>();
			errMsg.put("Error",  e.getMessage());
			
			return errMsg;
			
		}
		
		return carList;
		
	}
	
	//Fetching a single data from database.
	public Car get(int id){
		Car car = new Car();
		
		
		try {
			
			Connection conn = Configs.getDbConnection();
			
			String sql = "SELECT * FROM tbl_car WHERE id = ?";//Query to be execute
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, id); //binding the parameter value, 1 is for specify first parameter.
			
			ResultSet resultSet = preparedStatement.executeQuery(); //Query execution.
			
			while(resultSet.next()) {
				
				car.setId(resultSet.getInt("id"));
				car.setModel(resultSet.getString("model"));
				car.setBrand(resultSet.getString("brand"));
				car.setYear(resultSet.getInt("year"));
				car.setColor(resultSet.getString("color"));
				car.setType(resultSet.getString("type"));
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error : "+e.getMessage());
		}
		
		return car;
		
	}
	
	public boolean add(Car car) throws ClassNotFoundException, SQLException {
		
		if(car != null) {
			
			Connection connection = Configs.getDbConnection();
			String sql = "INSERT INTO `tbl_car` (`model`,`brand`, `year`, `color`, `type`) " + 
						"VALUES (?,?,?,?,?)";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, car.getModel());
			stmt.setString(2, car.getBrand());
			stmt.setInt(3, car.getYear());
			stmt.setString(4, car.getColor());
			stmt.setString(5, car.getType());
			
			int count = stmt.executeUpdate();
			
			if(count > 0) {
				System.out.println("Successfull Added");
				return true;
			} else {
				System.out.println("Error occured");
			}
							
		}
		
		return false;
		
	}

}
