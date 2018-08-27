import { Component, OnInit } from '@angular/core';
import { PointOfInterestService } from './point-of-interest-service';
import { PointOfInterest } from './point-of-interest';
import { Input } from '@angular/core';
import { SimpleChanges } from '@angular/core';
import { SimpleChange } from '@angular/core';

@Component({
  selector: 'app-point-of-interest-list',
  templateUrl: './point-of-interest-list.component.html',
  styleUrls: ['./point-of-interest-list.component.css']
})
export class PointOfInterestListComponent implements OnInit {

  private pointsOfInterest : PointOfInterest[];

  constructor(private pointOfInterestService : PointOfInterestService) { }
  
  @Input()
  event: Event;

  ngOnChanges(changes: SimpleChanges) {
    this.refreshPointsOfInterest();
  }

  ngOnInit() {
    this.refreshPointsOfInterest();
  }

  refreshPointsOfInterest() : void {
    this.pointOfInterestService.getPointsOfInterest()
    .subscribe(
       pointsOfInterest => this.pointsOfInterest = pointsOfInterest
    );
  }
}
