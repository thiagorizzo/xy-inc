import { Component, OnInit } from '@angular/core';
import { PointOfInterest } from './point-of-interest';
import { PointOfInterestService } from './point-of-interest-service';
import { NearbyInput } from './nearby-input';

@Component({
  selector: 'app-point-of-interest-nearby-list',
  templateUrl: './point-of-interest-nearby-list.component.html',
  styleUrls: ['./point-of-interest-nearby-list.component.css']
})
export class PointOfInterestNearbyListComponent implements OnInit {

  private nearbyInput = <NearbyInput> { };

  private pointsOfInterest : PointOfInterest[];

  constructor(private pointOfInterestService : PointOfInterestService) { }

  ngOnInit() {

  }

  listNearbyPointsOfInterest() : void {
    this.pointOfInterestService.getNearbyPointsOfInterest(this.nearbyInput)
    .subscribe(
      pointsOfInterest => this.pointsOfInterest = pointsOfInterest
    );
  }

}
