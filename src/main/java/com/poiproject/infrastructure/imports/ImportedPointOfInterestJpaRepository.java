package com.poiproject.infrastructure.imports;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poiproject.domain.PointOfInterest;

public interface ImportedPointOfInterestJpaRepository extends JpaRepository<PointOfInterest, Long> {

	List<PointOfInterest> findAll();
	
	Optional<PointOfInterest> findById(Long id);
	
}
