package com.poiproject.rest.resources;

import com.poiproject.domain.PointOfInterest;

public class PointOfInterestResource {

	public Long id;

    public String name;

    public int x;
    
    public int y;

    public Double distance;
    
	public PointOfInterestResource() {}

    public PointOfInterestResource(final PointOfInterest entity, double distance) {
    	this.id = entity.getId();
        this.name = entity.getName();
        this.x = entity.getX();
        this.y = entity.getY();
        this.distance = distance;
    }	
	
    public PointOfInterestResource(final PointOfInterest entity) {
    	this.id = entity.getId();
        this.name = entity.getName();
        this.x = entity.getX();
        this.y = entity.getY();
    }
}
