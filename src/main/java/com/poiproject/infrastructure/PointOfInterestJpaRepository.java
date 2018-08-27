package com.poiproject.infrastructure;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poiproject.domain.PointOfInterest;
import com.poiproject.domain.imports.PointOfInterestRepository;
import com.poiproject.infrastructure.imports.ImportedPointOfInterestJpaRepository;

@Service
public class PointOfInterestJpaRepository implements PointOfInterestRepository {

	private ImportedPointOfInterestJpaRepository poiRepositoryImpl;
	
	@Autowired
	public PointOfInterestJpaRepository(final ImportedPointOfInterestJpaRepository poiRepositoryImpl) {
		this.poiRepositoryImpl = poiRepositoryImpl;
	}
	
	@Override
	public List<PointOfInterest> findAll() {
		return this.poiRepositoryImpl.findAll();
	}
	
	@Override
	public Optional<PointOfInterest> findById(Long id) {
		return this.poiRepositoryImpl.findById(id);
	}

	@Override
	public PointOfInterest save(PointOfInterest pointOfInterest) {
		return this.poiRepositoryImpl.save(pointOfInterest);
	}
}
