package org.proyectofinal.OnFieldTBS.controllers;

import org.proyectofinal.OnFieldTBS.domains.dtos.RequestAddress;
import org.proyectofinal.OnFieldTBS.domains.dtos.ResponseLocation;
import org.proyectofinal.OnFieldTBS.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/location")
public class LocationController {

    private final LocationService service;

    @Autowired
    public LocationController(LocationService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<ResponseLocation>getLocation(@RequestBody RequestAddress requestAddress){
        return ResponseEntity.ok(service.getLocation(requestAddress.address));
    }
}


