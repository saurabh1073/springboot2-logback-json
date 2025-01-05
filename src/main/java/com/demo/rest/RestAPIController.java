package com.demo.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/test", produces = MediaType.APPLICATION_JSON_VALUE)
public class RestAPIController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RestAPIController.class);

    @GetMapping(path = "/id/{id}")
    public ResponseEntity<String> getIdSuccess(@PathVariable(name = "id") String id) {
        LOGGER.info("GET endpoint received path variable={}", id);
        return ResponseEntity.ok("Xyz resource corresponding to id: " + id);
    }
    @GetMapping(path = "/failid/{id}")
    public ResponseEntity<String> getIdFailure(@PathVariable(name = "id") String id) {
        LOGGER.error("GET endpoint failed condition with id received path variable={}", id);
        return ResponseEntity.internalServerError().build();
    }
    @GetMapping(path = "/name/{name}")
    public ResponseEntity<String> getNameSuccess(@PathVariable(name = "name") String name) {
        LOGGER.info("GET endpoint received path variable={}", name);
        return ResponseEntity.ok("Xyz resource corresponding to id: " + name);
    }
    @GetMapping(path = "/failname/{name}")
    public ResponseEntity<String> getNameFailure(@PathVariable(name = "name") String name) {
        LOGGER.error("GET endpoint failed condition with name received path variable={}", name);
        return ResponseEntity.badRequest().build();
    }
    

}
