package com.ibmcloud;

import javax.ejb.EJB;
import javax.json.Json;
import javax.json.JsonArrayBuilder;

import com.ibmcloud.data.Operation;
import com.ibmcloud.data.ToDo;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.servlet.http.HttpServlet;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@javax.ejb.Stateless
@Path("/ToDoREST")
public class ToDoREST extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private ToDoBean toDoBean;
	
	@GET
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public JsonObject getMethod(String name) {
		return this.listToDo(name).build();
	}
	
	private JsonObjectBuilder listToDo(String name) {
		JsonObjectBuilder jsonBuild = Json.createObjectBuilder();
		Operation op = toDoBean.listToDo(name);
		jsonBuild.add("rc",op.getRC());
		jsonBuild.add("message", op.getMessage());
		JsonArrayBuilder todoList = Json.createArrayBuilder();
		if (op.getRC() == 0) {
			ToDo[] results = (ToDo[])op.getResults();
			for (int ii = 0; ii<results.length; ii++) {
				ToDo curToDo = results[ii];
				JsonObjectBuilder todoItem = Json.createObjectBuilder();
				todoItem.add("name", curToDo.getName());
				todoItem.add("id", curToDo.getId());
				todoItem.add("category", curToDo.getCategory());
				todoItem.add("description", curToDo.getDescription());
				todoList.add(todoItem);
			}
		}
		jsonBuild.add("results",todoList);
		
		return jsonBuild;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public JsonObject postMethod(JsonObject input) {
		String action = input.getString("action");
		JsonObjectBuilder jsonBuild = Json.createObjectBuilder();
		if (action.equals("addUser")) {
			String name = input.getString("name");
			String pass = input.getString("password");
			Operation op = toDoBean.addUser(name, pass); 
			jsonBuild.add("rc",op.getRC());
			jsonBuild.add("message", op.getMessage());
			if (op.getRC() == 0) {
				JsonObject resObj = Json.createObjectBuilder().add("name", ((com.ibmcloud.data.User)op.getResult()).getName()).add("password",((com.ibmcloud.data.User)op.getResult()).getPassword()).build();
				jsonBuild.add("result", resObj);
			} 
		} else if (action.equals("delUser")) {
			String name = input.getString("name");
			Operation op = toDoBean.delUser(name); 
			jsonBuild.add("rc",op.getRC());
			jsonBuild.add("message", op.getMessage());
		} else if (action.equals("authUser")) {
			String name = input.getString("name");
			String pass = input.getString("password");
			Operation op = toDoBean.authUser(name, pass); 
			jsonBuild.add("rc",op.getRC());
			jsonBuild.add("message", op.getMessage());
			if (op.getRC() == 0) {
				JsonObject resObj = Json.createObjectBuilder().add("name", ((com.ibmcloud.data.User)op.getResult()).getName()).add("password",((com.ibmcloud.data.User)op.getResult()).getPassword()).build();
				jsonBuild.add("result", resObj);
			} 
		} else if (action.equals("listToDo")) {
			String name = input.getString("name");
			jsonBuild = this.listToDo(name);
		} else if (action.equals("addToDo")) {
			String name = input.getString("name");
			String cat = input.getString("category");
			String desc = input.getString("description");
			Operation op = toDoBean.addToDo(name, cat, desc); 
			jsonBuild.add("rc",op.getRC());
			jsonBuild.add("message", op.getMessage());
			if (op.getRC() == 0) {
				JsonObject resObj = Json.createObjectBuilder().add("name", ((com.ibmcloud.data.ToDo)op.getResult()).getName())
						.add("id",((com.ibmcloud.data.ToDo)op.getResult()).getId())
						.add("category",((com.ibmcloud.data.ToDo)op.getResult()).getCategory())
						.add("description",((com.ibmcloud.data.ToDo)op.getResult()).getDescription())
						.build();
				jsonBuild.add("result", resObj);
			} 
		} else if (action.equals("delToDo")) {
			String name = input.getString("name");
			int id = input.getInt("id");
			String cat = input.getString("category");
			String desc = input.getString("description");
			Operation op = toDoBean.delToDo(name, id, cat, desc); 
			jsonBuild.add("rc",op.getRC());
			jsonBuild.add("message", op.getMessage());
		}
		JsonObject result = jsonBuild.build();
		return result;
	}
}
