
package com.rgt.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.rgt.swagger.SwaggerProject.Employee;
import com.rgt.swagger.SwaggerProject.EmployeeRepository;
import com.rgt.swagger.SwaggerProject.EmployeeService;

@SpringBootTest(classes = { com.rgt.swagger.SwaggerProject.SwaggerProjectApplication.class })
public class AppTest {

	@Autowired
	EmployeeService employeeService;

	@MockBean
	EmployeeRepository employeeRepository;

	@Test
	public void getemployeeListTest() {
		when(employeeRepository.findAll())
				.thenReturn(Stream.of(new Employee(1, 24, "sony", 30000)).collect(Collectors.toList()));
		assertEquals(1, employeeService.getEmployees().size());
	}

	@Test
	public void createEmployeeTest() {
		Employee employees = new Employee(2, 25, "Sahi", 20000);
		when(employeeRepository.save(employees)).thenReturn(employees);
		assertEquals(employees, employeeService.createEmployee(employees));
	}
	
	@Test
	public void updateEmployeeTest() {
		Employee employees = new Employee(2, 24, "Sai", 25000);
		when(employeeRepository.save(employees)).thenReturn(employees);
		assertEquals(employees, employeeService.createEmployee(employees));
	}

	/*
	 * @Test public void getemployeeByNameTest() { String employeeName = "Sony";
	 * when(employeeRepository.findByName(employeeName)) .thenReturn(Stream.of(new
	 * Employee(1, 24, "Sony", 30000)).collect(Collectors.toList()));
	 * assertEquals(1, employeeService.getEmployee(employeeName));
	 * 
	 * }
	 */

	@Test
	public void deleteEmployeeTest() {
		Employee employee = new Employee(20, 26, "Ramya", 25000);
		employeeService.deleteEmployee(20);
		verify(employeeRepository,times(1)).deleteById(20);
		//Mockito.verify(employeeRepository, times(1)).delete(employee);
		
		
	}
} 
  

/*
 * }
 * 
 * @BeforeAll public static void setuOnce() {
 * System.out.println("from onetime Setup"); }
 * 
 * @BeforeEach public void setUp() { System.out.println("From Setup"); }
 * 
 * @Test
 * 
 * @Tag("QA") // @DisplayName("Product save") public void testSave() {
 * System.out.println("save-hello");
 * 
 * }
 * 
 * @Test
 * 
 * @Tag("DEV") public void testUpdate() { System.out.println("Update-hello"); }
 * 
 * @Test
 * 
 * @Disabled public void testDelete() { System.out.println("Delete-hello"); }
 * 
 * @AfterEach public void clean() { System.out.println("clean data"); }
 * 
 * public static void closeAll() { System.out.println("Once At End"); }
 * 
 * }
 */