package com.ibmcloud;

import java.util.*;
import javax.ws.rs.ApplicationPath;

@ApplicationPath("/ToDoRESTApp")
public class ToDoRESTApp extends javax.ws.rs.core.Application {
	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> classes = new HashSet<Class<?>>();
		classes.add(ToDoREST.class);
		return classes;
	}
}
