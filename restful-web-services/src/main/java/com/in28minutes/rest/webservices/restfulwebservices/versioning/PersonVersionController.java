package com.in28minutes.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersionController {
	
	@GetMapping("/v1/person")
	public PersonV1 personV1() {
		return new PersonV1("Bob Charley");
	}
	
	@GetMapping("/v2/person")
	public PersonV2 personV2() {
		return new PersonV2(new Name("Bob", "Charley"));
	}

	@GetMapping(value="/person/param",params = "version=1")
	public PersonV1 paramv1() {
		return new PersonV1("Bob Charley");
	}
	//as a path param
	@GetMapping(value="/person/param",params = "version=2")
	public PersonV2 paramv2() {
		return new PersonV2(new Name("Bob", "Charley"));
	}
	
	@GetMapping(value="/person/header",headers ="X-API-VERSION=1")
	public PersonV1 headerv1() {
		return new PersonV1("Bob Charley");
	}
	
	//X-API-VERSION header
	@GetMapping(value="/person/header",headers = "X-API-VERSION=2")
	public PersonV2 headerV2() {
		return new PersonV2(new Name("Bob", "Charley"));
	}
	
	//accept -header
	@GetMapping(value="/person/produces",produces="application/vnd.company.app-v1+json")
	public PersonV1 producesv1() {
		return new PersonV1("Bob Charley");
	}
	
	@GetMapping(value="/person/produces",produces ="application/vnd.company.app-v2+json")
	public PersonV2 producesV2() {
		return new PersonV2(new Name("Bob", "Charley"));
	}
	
}
