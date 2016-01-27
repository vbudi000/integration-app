package com.ibmcloud.ws;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.naming.InitialContext;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

import com.ibmcloud.ToDoBean;
import com.ibmcloud.data.Operation;

@WebService
@XmlRootElement
@XmlSeeAlso({com.ibmcloud.data.User.class,com.ibmcloud.data.ToDo.class,com.ibmcloud.data.Operation.class})
public class ToDoWebServices {
	@EJB(name="ejb/ToDoBean",beanName="ToDoBean")
	private ToDoBean todo;
	
	@WebMethod(operationName="addUser")
	public Operation addUser(String name, String password) {
		try {
			InitialContext c = new InitialContext();
			todo = (ToDoBean) c.lookup("java:comp/env/ejb/ToDoBean");
		} catch (javax.naming.NameNotFoundException e) {
		} catch (Exception e) {
		}
		return todo.addUser(name, password);
	}
	
	@WebMethod(operationName="authUser")
	public Operation authUser(String name, String password) {
		try {
			InitialContext c = new InitialContext();
			todo = (ToDoBean) c.lookup("java:comp/env/ejb/ToDoBean");
		} catch (javax.naming.NameNotFoundException e) {
		} catch (Exception e) {
		}
		return todo.authUser(name, password);
	}
	
	@WebMethod(operationName="addToDo")
	public Operation addToDo(String name, String category, String description) {
		try {
			InitialContext c = new InitialContext();
			todo = (ToDoBean) c.lookup("java:comp/env/ejb/ToDoBean");
		} catch (javax.naming.NameNotFoundException e) {
		} catch (Exception e) {
		}
		return todo.addToDo(name, category, description);
	}
	
	@WebMethod(operationName="delToDo")
	public Operation delToDo(String name, int id, String category, String description) {
		try {
			InitialContext c = new InitialContext();
			todo = (ToDoBean) c.lookup("java:comp/env/ejb/ToDoBean");
		} catch (javax.naming.NameNotFoundException e) {
		} catch (Exception e) {
		}
		return todo.delToDo(name, id, category, description);
	}
	
	@WebMethod(operationName="listToDo")
	public Operation listToDo(String name) {
		try {
			InitialContext c = new InitialContext();
			todo = (ToDoBean) c.lookup("java:comp/env/ejb/ToDoBean");
		} catch (javax.naming.NameNotFoundException e) {
		} catch (Exception e) {
		}
		return todo.listToDo(name);
	}
}