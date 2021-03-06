package com.ibmcloud.ws;

import com.ibmcloud.data.Operation;
import javax.jws.WebService;


@WebService (targetNamespace="http://ws.ibmcloud.com/", serviceName="ToDoWebServicesService", portName="ToDoWebServicesPort", wsdlLocation="WEB-INF/wsdl/ToDoWebServicesService.wsdl")
public class ToDoWebServicesDelegate{

    com.ibmcloud.ws.ToDoWebServices _toDoWebServices = null;

    public Operation addUser (String name, String password) {
        return _toDoWebServices.addUser(name,password);
    }

    public Operation authUser (String name, String password) {
        return _toDoWebServices.authUser(name,password);
    }

    public Operation addToDo (String name, String category, String description) {
        return _toDoWebServices.addToDo(name,category,description);
    }

    public Operation delToDo (String name, int id, String category, String description) {
        return _toDoWebServices.delToDo(name,id,category,description);
    }

    public Operation listToDo (String name) {
        return _toDoWebServices.listToDo(name);
    }

    public ToDoWebServicesDelegate() {
        _toDoWebServices = new com.ibmcloud.ws.ToDoWebServices(); }

}