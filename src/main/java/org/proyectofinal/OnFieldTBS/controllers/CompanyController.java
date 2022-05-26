package org.proyectofinal.OnFieldTBS.controllers;


import org.proyectofinal.OnFieldTBS.domains.dtos.RequestLocation;
import org.proyectofinal.OnFieldTBS.domains.dtos.ResponseLocation;
import org.proyectofinal.OnFieldTBS.domains.models.projections.CompanyStandard;
import org.proyectofinal.OnFieldTBS.services.CompanyService;
import org.proyectofinal.OnFieldTBS.services.LocationService;
import org.proyectofinal.OnFieldTBS.utils.ListResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    private final CompanyService service;


    public CompanyController(CompanyService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<ListResult> listAllCompanies(){
        List<CompanyStandard> allCompanies = service.getAllCompanies();
        return ResponseEntity.ok().body(ListResult.list(allCompanies));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompanyStandard>getCompanyById(@PathVariable UUID id){
        Optional<CompanyStandard> searchCompany = service.getCompanyById(id);
        return searchCompany.map(company -> ResponseEntity.ok().body(company))
                .orElseGet(() ->ResponseEntity.notFound().build());
    }


    // Location
    @PostMapping("/location")
    public ResponseEntity<ListResult> getLocation(@RequestBody List<RequestLocation> addresses){
        return ResponseEntity.ok().body(ListResult.list(service.getLocation(addresses)));
    }


}
