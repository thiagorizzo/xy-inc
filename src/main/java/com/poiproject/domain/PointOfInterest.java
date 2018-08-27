package com.poiproject.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import com.poiproject.domain.base.EntityBase;

@Entity
public class PointOfInterest extends EntityBase<PointOfInterest> {
	
	@Column(name = "x", nullable=false)
	@Min(0)
	private int x;
	
    @Column(name = "y", nullable=false)
    @Min(0)
	private int y;
		
    @Column(name = "name", nullable=false)
    @Size(min = 1, max = 100)
	private String name;
	
    public PointOfInterest() { }
    
	public PointOfInterest(int x, int y, String name) {
		this.x = x;
		this.y = y;
		this.name = name;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
