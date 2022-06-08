package org.proyectofinal.OnFieldTBS.domains.dtos;

import org.proyectofinal.OnFieldTBS.domains.models.Company;
import org.proyectofinal.OnFieldTBS.domains.models.Incidence;

import java.util.List;
import java.util.stream.Collectors;

import static org.proyectofinal.OnFieldTBS.domains.models.IncidenceStatus.CLOSED;

public class ResponseGeocoding {

    public String status;
    public List<Result> results;


    public static ResponseLocation getLocation(String companyName, ResponseGeocoding responseGeocoding){
        ResponseLocation responseLocation = new ResponseLocation();
        responseLocation.companyName = companyName;
        for ( Result result:responseGeocoding.results ) {
            responseLocation.location.lat = result.geometry.location.lat;
            responseLocation.location.lng= result.geometry.location.lng;
        }
        return responseLocation;
    }

    public static ResponseLocation getCompanyInfo(Company company, ResponseGeocoding responseGeocoding){
        ResponseLocation responseLocation = new ResponseLocation();
        responseLocation.companyName = company.getName();
        responseLocation.address = company.getAddress();
        responseLocation.incidencesList = company.getIncidences().stream()
                .filter(comp -> !comp.getStatus().equals(CLOSED))
                .map(Incidence::getId)
                .collect(Collectors.toSet());
        for ( Result result:responseGeocoding.results ) {
            responseLocation.location.lat = result.geometry.location.lat;
            responseLocation.location.lng= result.geometry.location.lng;
        }
        return responseLocation;
    }
}

class Result{
    public Geometry geometry;
}

class Geometry{
    public Location location;
}

class  Location {
    public Double lat;
    public Double lng;
}