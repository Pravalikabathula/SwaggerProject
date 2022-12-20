package com.rgt.swagger.SwaggerProject;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.swagger.annotations.Api;

@Component
//@Path("/employee")
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "employee")
@Api(value = "employee details", produces = MediaType.APPLICATION_JSON)
public class EmployeeResourceController {
	@Autowired
	private EmployeeService employeeService;

	@POST
	@Path("/emp2")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response createEmployee(Employee employee) throws URISyntaxException {

		employee = employeeService.createEmployee(employee);
		return Response.status(201).entity("Employee is created successfully with id = " + employee.getId())
				.contentLocation(new URI("/employees/" + employee.getId())).build();
	}

	@PUT
	@Path("{id}")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response updateEmployee(@PathParam("id") int id, Employee employee) throws URISyntaxException {
		boolean isEmployeeExist = employeeService.isEmployeeExist(id);
		if (isEmployeeExist) {
			employee.setId(id);
			employeeService.createEmployee(employee);
			return Response.status(200).entity("Employee is updated successsfully").build();
		} else {
			return Response.status(404).entity("Employee not found").build();
		}
	}

	@GET
	@Path("/all")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Employee> getAllEmployees() {
		// Employee employees = new Employee();
		ArrayList<Employee> employeeList = (ArrayList<Employee>) employeeService.getEmployees();
		return employeeList;
	}

	@GET
	@Path("{id}")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response getEmployeeById(@PathParam("id") int id) throws URISyntaxException {
		boolean isEmployeeExist = employeeService.isEmployeeExist(id);
		if (isEmployeeExist) {
			Employee employee = employeeService.getEmployee(id);
			return Response.status(200).entity(employee).contentLocation(new URI("/employees/" + id)).build();
		} else {
			return Response.status(404).entity("Employee not found").build();
		}
	}

	@DELETE
	@Path("{id}")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response deleteEmployee(@PathParam("id") int id) throws URISyntaxException {
		boolean isEmployeeExist = employeeService.isEmployeeExist(id);
		if (isEmployeeExist) {
			employeeService.deleteEmployee(id);
			return Response.status(200).entity("Employee is deleted successsfully").build();
		} else {
			return Response.status(404).entity("Employee not found").build();
		}
	}

}