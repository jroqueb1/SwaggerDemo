package com.appsdeveloperblog.app.ws.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.appsdeveloperblog.app.ws.models.request.UpdateUserRequestModel;
import com.appsdeveloperblog.app.ws.models.request.UserDetailRequestModel;
import com.appsdeveloperblog.app.ws.models.response.UserRest;
import com.appsdeveloperblog.app.ws.service.user.UserService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/v1/users")
public class UserController {

	Map<String, UserRest> users;
	
	@Autowired
	UserService userService;
	
	
	@ApiOperation(value="Retorna la informacion de un usuario determinado.",
			notes = "Debe indicarse el ID del usuario a consultar."			
			)	
	@GetMapping(path = "/{userId}", 			
			produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserRest> getUser(@PathVariable String userId) {
		
		if(users.containsKey(userId)) {
			return new ResponseEntity<UserRest>(users.get(userId), HttpStatus.OK);
		}else {
			return new ResponseEntity<UserRest>(HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping
	public String getUsers(@RequestParam(value="page", required=false, defaultValue="1") int page, 
							@RequestParam(value="limit", required = false, defaultValue = "50") 
								int limit) {
		
		return String.format("Get users was called -> page: %s, limit: %s", page, limit);
	}	
	
	@PostMapping(
			consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },
			produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserRest> createUser(
							@Valid @RequestBody UserDetailRequestModel userDetail) {
		UserRest user = userService.createUser(userDetail);
//		return new ResponseEntity<UserRest>(user, HttpStatus.OK);
		return ResponseEntity.ok(user);
	}

	@PutMapping(
			path = "/{userId}", 			
			consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },
			produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserRest> updateUser(@PathVariable String userId,
			@Valid @RequestBody UpdateUserRequestModel userDetail) {
		if(users.containsKey(userId)) {
			UserRest user = users.get(userId);
			user.setFirstName(userDetail.getFirstName());
			user.setLastName(userDetail.getLastName());
			users.put(userId, user);
			
			return new ResponseEntity<UserRest>(users.get(userId), HttpStatus.OK);
		}else {
			return new ResponseEntity<UserRest>(HttpStatus.NO_CONTENT);
		}
	}
	
	@DeleteMapping
	public ResponseEntity<Void> deleteUser(@PathVariable String userId) {
		if(users.containsKey(userId)) {
			users.remove(userId);
			return new ResponseEntity<Void>(HttpStatus.OK);	
		}else {
			return ResponseEntity.noContent().build();
		}		
	}
	
}
