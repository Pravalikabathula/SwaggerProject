package com.rgt.swagger.SwaggerProject;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.rgt.swagger.SwaggerProject.DepartmentService;

import io.swagger.annotations.Api;

@Component
@Path("/department")
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "department")
@Api(value = "Department details", produces = MediaType.APPLICATION_JSON)
public class DepartmentController {
	@Autowired
	private DepartmentService departmentService;

	@POST
	@Path("/emp2")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Department saveDepartment(@RequestBody Department department) {
		return departmentService.saveDepartment(department);
	}

	@GET
	@Path("/all")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Department> fetchDepartmentList() {
		return departmentService.fetchDepartmentList();
	}

	@PUT
	@Path("{id}")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Department updateDepartment(@RequestBody Department department, @PathVariable("id") Integer departmentId) {
		return departmentService.updateDepartment(department, departmentId);
	}

	@DELETE
	@Path("{id}")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public String deleteDepartmentById(@PathVariable("id") Integer departmentId) {
		departmentService.deleteDepartmentById(departmentId);
		return "Deleted Successfully";
	}

}
