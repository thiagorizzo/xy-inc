package com.poiproject.domain.imports;

import com.poiproject.domain.PointOfInterest;

import java.util.List;
import java.util.Optional;

public interface PointOfInterestRepository {

	Optional<PointOfInterest> findById(Long id);
	
	List<PointOfInterest> findAll();

	PointOfInterest save(PointOfInterest pointOfInterest);
		
}
