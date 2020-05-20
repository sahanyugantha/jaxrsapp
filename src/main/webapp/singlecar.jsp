<%@page import="java.io.BufferedWriter"%>
<%@page import="java.io.OutputStreamWriter"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="com.google.gson.JsonObject"%>
<%@page import="com.google.gson.JsonParser"%>
<%@page import="com.google.gson.JsonArray"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.HttpURLConnection"%>
<%@page import="java.net.URL"%>
<html>
<head>
	<title>Car Application</title>
	<link rel="stylesheet" type="text/css" href="css/style.css" />
	
</head>
<body>
    <h2>Solent Cohort 01</h2>
    <h2>This is a good batch</h2>
    <h2>Solent Cohort 01 @BCAS CITY CAMPUS</h2>
    <h3>These are car details</h3>
    
   
    <!-- I'm just creating <ul> and put values. -->
    
	<div>
		<ul>
   			<% 
   				
   			  	final String API_URL = "http://localhost:8080/jaxrsapp/carapi/cars/"+request.getParameter("id");
   				//Fetching data from API.
   				try{
					URL url = new URL(API_URL);
					HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
					httpURLConnection.setRequestMethod("GET"); // Change this to "POST" for POST requests.
					httpURLConnection.setDoInput(true); //Downloads.
					httpURLConnection.setDoOutput(false);//Uploads. 
					

					System.out.println("REACH code : "+httpURLConnection.getResponseCode());
					
					if(httpURLConnection.getResponseCode() == 200){
						InputStream inputStream = (InputStream)httpURLConnection.getInputStream();
						InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
						BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
						
						System.out.println("REACH here");
						
						//Reading the file line by line.
						
						String line = "";
						StringBuilder sb = new StringBuilder();
						
						while((line = bufferedReader.readLine()) != null){
							sb.append(line);
						}
						
						String jsonString = sb.toString();
						System.out.println("jsonString : "+jsonString);
						
						JsonObject jsonObject = JsonParser.parseString(jsonString).getAsJsonObject();
						
						System.out.println("NAME : "+jsonObject.get("model").getAsString());
						%>
							<li>BRAND -<% out.print(jsonObject.get("brand").getAsString());%></li>
							<li>MODEL -<% out.print(jsonObject.get("model").getAsString());%></li>
							<li>YEAR -<% out.print(jsonObject.get("year").getAsString());%></li>
						<% 
						
					}
					httpURLConnection.disconnect();
   					
   				}catch(Exception e){
   					e.printStackTrace();
   					
   					out.print("Error : "+e.getMessage());
   				}
   			%>
   		</ul>	
   	</div>
    
</body>
</html>
