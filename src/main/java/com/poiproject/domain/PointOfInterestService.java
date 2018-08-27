package com.poiproject.domain;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poiproject.domain.imports.PointOfInterestRepository;

@Service
public class PointOfInterestService {
	
    private final PointOfInterestRepository pointOfInterestRepository;
    
    @Autowired
    public PointOfInterestService(final PointOfInterestRepository pointOfInterestRepository) {
    	this.pointOfInterestRepository = pointOfInterestRepository;
    }

    public PointOfInterest registerPointOfInterest(final int x, final int y, final String name) {
        final PointOfInterest pointOfInterest = pointOfInterestRepository.save(new PointOfInterest(x, y, name));
        return pointOfInterest;
    }
    
    public List<PointOfInterest> listPointsOfInterest() {
        return pointOfInterestRepository.findAll();
    }     
    
    public List<PointOfInterest> getNearbyPointsOfInterest(final int x, final int y, final int dmax) {
    	final List<PointOfInterest> nearbyPointsOfInterest = 
    			pointOfInterestRepository.findAll()
    									 .stream()
    									 .filter(poi -> this.getDistance(poi, x, y) <= dmax)
    									 .collect(Collectors.toList());
    	return nearbyPointsOfInterest;
    }
    
    public double getDistance(final PointOfInterest pointOfInterest, final int x, final int y) {
    	return Math.hypot(x - pointOfInterest.getX(), y - pointOfInterest.getY());
    }
}
