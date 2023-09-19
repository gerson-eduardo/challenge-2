package br.com.ms.b.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/scholar/", consumes = MediaType.APPLICATION_JSON_VALUE)
public class msBController {

}
