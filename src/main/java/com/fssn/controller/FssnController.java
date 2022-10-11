package com.fssn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fssn.models.Fssn;
import com.fssn.models.Response;
import com.fssn.service.FssnService;

@CrossOrigin("*")
@RestController
@RequestMapping("/fssn")
public class FssnController {

	@Autowired
	private FssnService fssnService;

	public FssnController() {
	}

	public FssnController(FssnService fssnService) {
		super();
		this.fssnService = fssnService;
	}

	@PostMapping(value = "/validate", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })

	public Response validate(@RequestBody Fssn body) throws Exception {

		return fssnService.validate(body);

	}

}