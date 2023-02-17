package com.gk.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gk.restapi.model.Employee;
import com.gk.restapi.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
public class EmployeeController {
	
//	@Value("${app.name}")
//	private String appName;
//	
//	@Value("${app.version}")
//	private String appVersion;
	
	@Autowired
	private EmployeeService eService;
	
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getEmployees(@RequestParam Integer pageNumber, @RequestParam Integer pageSize) {
		
		return new ResponseEntity<List <Employee>>(eService.getEmployees(pageNumber, pageSize), HttpStatus.OK);
	
	}
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable Long id) {
		
		return new ResponseEntity<Employee>(eService.getSingleEmployee(id), HttpStatus.OK);
	
	}
	
	@DeleteMapping("/employees")
	public ResponseEntity<HttpStatus>deleteEmployee(@RequestParam Long id) {
		
		return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
		
	}
	
	@PostMapping("/employees")
	public ResponseEntity<Employee> saveEmployee(@Valid @RequestBody Employee employee) {
		
		return new ResponseEntity<Employee>(eService.saveEmployee(employee), HttpStatus.CREATED);
		
	}
	
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
		
		employee.setId(id);
		return new ResponseEntity<Employee>(eService.updateEmployee(employee), HttpStatus.OK);
		
	}
	
	@GetMapping("/employees/filterByName")
	public ResponseEntity<List<Employee>> getEmployeesByName(@RequestParam String name){
		
		return new ResponseEntity<List<Employee>>(eService.getEmployeesByName(name), HttpStatus.OK);
		
	}
	
	@GetMapping("/employees/filterByNameAndLocation")
	public ResponseEntity<List<Employee>> getEmployeesByNameAndLocation(@RequestParam String name, @RequestParam String location){
		
		return new ResponseEntity<List<Employee>>(eService.getEmployeesByNameAndLocation(name, location), HttpStatus.OK);
		
	}
	
	@GetMapping("/employees/filterByKeyword")
	public ResponseEntity<List<Employee>> getEmployeesByKeyword(@RequestParam String name){
		
		return new ResponseEntity<List<Employee>>(eService.getEmployeesByKeyword(name), HttpStatus.OK);
		
	}
	
	@GetMapping("/employees/{name}/{location}")
	public ResponseEntity<List<Employee>> getEmployeesByNameOrLocation(@PathVariable String name, @PathVariable String location){
		
		return new ResponseEntity<List<Employee>>(eService.getEmployeesByNameOrLocation(name, location), HttpStatus.OK);
		
	}
	
	@DeleteMapping("/employees/delete/{name}")
	public ResponseEntity<String> getEmployeesByNameOrLocation(@PathVariable String name){
		
		return new ResponseEntity<String>(eService.deleteByEmployeeName(name) + " is number of records deleted", HttpStatus.OK);
		
	}
	
}
