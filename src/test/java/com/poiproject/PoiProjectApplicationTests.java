package com.poiproject;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;

import com.poiproject.domain.PointOfInterest;
import com.poiproject.domain.PointOfInterestService;

@RunWith(SpringRunner.class)
@Transactional
@ContextConfiguration(classes = {PoiProjectApplication.class})
public class PoiProjectApplicationTests {

    @Autowired
    private PointOfInterestService pointOfInterestService;	

    @Before
	public void setup() {
		PointOfInterest poi1 = new PointOfInterest();
		poi1.setName("Lanchonete");
		poi1.setX(27);
		poi1.setY(12);
		
		PointOfInterest poi2 = new PointOfInterest();
		poi2.setName("Posto");
		poi2.setX(31);
		poi2.setY(18);
		
		PointOfInterest poi3 = new PointOfInterest();
		poi3.setName("Joalheria");
		poi3.setX(15);
		poi3.setY(12);
		
		PointOfInterest poi4 = new PointOfInterest();
		poi4.setName("Floricultura");
		poi4.setX(12);
		poi4.setY(21);
		
		PointOfInterest poi5 = new PointOfInterest();
		poi5.setName("Pub");
		poi5.setX(12);
		poi5.setY(8);
		
		PointOfInterest poi6 = new PointOfInterest();
		poi6.setName("Supermercado");
		poi6.setX(23);
		poi6.setY(6);
		
		PointOfInterest poi7 = new PointOfInterest();
		poi7.setName("Churrascaria");
		poi7.setX(28);
		poi7.setY(2);
		
		pointOfInterestService.registerPointOfInterest(poi1.getX(), poi1.getY(), poi1.getName());
		pointOfInterestService.registerPointOfInterest(poi2.getX(), poi2.getY(), poi2.getName());
		pointOfInterestService.registerPointOfInterest(poi3.getX(), poi3.getY(), poi3.getName());
		pointOfInterestService.registerPointOfInterest(poi4.getX(), poi4.getY(), poi4.getName());
		pointOfInterestService.registerPointOfInterest(poi5.getX(), poi5.getY(), poi5.getName());
		pointOfInterestService.registerPointOfInterest(poi6.getX(), poi6.getY(), poi6.getName());
		pointOfInterestService.registerPointOfInterest(poi7.getX(), poi7.getY(), poi7.getName());
   }
   
	@Test
	public void ListPoi() throws Exception {
		List<PointOfInterest> pois = pointOfInterestService.listPointsOfInterest();
		assertEquals(pois.size(), 7);
		assertEquals(pois.stream().filter(poi -> poi.getName() == "Lanchonete").findFirst().isPresent(), true);
		assertEquals(pois.stream().filter(poi -> poi.getName() == "Joalheria").findFirst().isPresent(), true);
		assertEquals(pois.stream().filter(poi -> poi.getName() == "Pub").findFirst().isPresent(), true);
		assertEquals(pois.stream().filter(poi -> poi.getName() == "Supermercado").findFirst().isPresent(), true);
		assertEquals(pois.stream().filter(poi -> poi.getName() == "Posto").findFirst().isPresent(), true);
		assertEquals(pois.stream().filter(poi -> poi.getName() == "Floricultura").findFirst().isPresent(), true);
		assertEquals(pois.stream().filter(poi -> poi.getName() == "Churrascaria").findFirst().isPresent(), true);
	}
	
	@Test
	public void NearbyPoi() throws Exception {
		List<PointOfInterest> nearbyPois = pointOfInterestService.getNearbyPointsOfInterest(20, 10, 10);
		assertEquals(nearbyPois.size(), 4);
		assertEquals(nearbyPois.stream().filter(poi -> poi.getName() == "Lanchonete").findFirst().isPresent(), true);
		assertEquals(nearbyPois.stream().filter(poi -> poi.getName() == "Joalheria").findFirst().isPresent(), true);
		assertEquals(nearbyPois.stream().filter(poi -> poi.getName() == "Pub").findFirst().isPresent(), true);
		assertEquals(nearbyPois.stream().filter(poi -> poi.getName() == "Supermercado").findFirst().isPresent(), true);
	}	
	
}
