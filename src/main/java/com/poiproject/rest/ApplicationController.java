package com.poiproject.rest;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.poiproject.domain.PointOfInterest;
import com.poiproject.domain.PointOfInterestService;
import com.poiproject.rest.resources.PointOfInterestResource;

@RestController
@RequestMapping("/pointsofinterest")
@CrossOrigin(origins = "http://localhost:4200")
public class ApplicationController {
    
	private final PointOfInterestService pointOfInterestService;
    
    @Autowired
    public ApplicationController(final PointOfInterestService pointOfInterestService) {
    	this.pointOfInterestService = pointOfInterestService;
	}	
	
    @PostMapping()
    public ResponseEntity<PointOfInterestResource> createPointOfInterest(@RequestBody final PointOfInterestResource pointOfInterestResource) {
		final PointOfInterest pointOfInterest = pointOfInterestService.registerPointOfInterest(pointOfInterestResource.x, pointOfInterestResource.y, pointOfInterestResource.name);
        return new ResponseEntity<>(new PointOfInterestResource(pointOfInterest), HttpStatus.CREATED);
    }
    
    @GetMapping()
    public ResponseEntity<PointOfInterestResource[]> findPointsOfInterest(){
    	final List<PointOfInterest> pointsOfInterest = pointOfInterestService.listPointsOfInterest();
        return pointsOfInterestToResources(pointsOfInterest, null, null);
    }
    
    @GetMapping(path="/nearby")
    public ResponseEntity<PointOfInterestResource[]> getNearbyPointsOfInterest(@RequestParam(name="x") int x, @RequestParam(name="y") int y, @RequestParam(name="dmax") int dmax) {
    	final List<PointOfInterest> pointsOfInterest = pointOfInterestService.getNearbyPointsOfInterest(x, y, dmax);
        return pointsOfInterestToResources(pointsOfInterest, new Integer(x), new Integer(y));
    }      
    
	private ResponseEntity<PointOfInterestResource[]> pointsOfInterestToResources(final List<PointOfInterest> pointsOfInterest, final Integer x, final Integer y) {
		Stream<PointOfInterestResource> result;
		
		if (x != null || y != null)
			 result = pointsOfInterest.stream().map(p -> new PointOfInterestResource(p, pointOfInterestService.getDistance(p, x, y)));
		else
			result = pointsOfInterest.stream().map(p -> new PointOfInterestResource(p));
			
		final PointOfInterestResource[] resultArray = result.toArray(size -> new PointOfInterestResource[size]);
		return new ResponseEntity<>(resultArray, HttpStatus.OK);
	}
}
