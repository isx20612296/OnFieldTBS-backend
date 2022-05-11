package org.proyectofinal.OnFieldTBS.domains.dtos;

import java.util.List;

public class ResponseGeocoding {

    public String status;
    public List<Result> results;


    public static ResponseLocation getLocation( ResponseGeocoding responseGeocoding){
        ResponseLocation responseLocation = new ResponseLocation();
        for ( Result result:responseGeocoding.results ) {
            responseLocation.latitude = result.geometry.location.lat;
            responseLocation.longitude= result.geometry.location.lng;
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