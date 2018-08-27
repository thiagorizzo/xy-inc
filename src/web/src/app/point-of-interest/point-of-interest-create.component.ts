import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { PointOfInterest } from './point-of-interest';
import { PointOfInterestService } from './point-of-interest-service';
import { ToastrService } from 'ngx-toastr';
import { Output } from '@angular/core';
import { EventEmitter } from '@angular/core';

@Component({
  selector: 'app-point-of-interest-create',
  templateUrl: './point-of-interest-create.component.html',
  styleUrls: ['./point-of-interest-create.component.css']
})
export class PointOfInterestCreateComponent implements OnInit {

  private pointOfInterest = <PointOfInterest> { };
  private error = undefined;

  @Output()
  pointOfInterestCreatedEvent = new EventEmitter<Event>();

  constructor(private pointOfInterestService : PointOfInterestService, private toastr: ToastrService) { }

  ngOnInit() {
  }

  registerPointOfInterest(event : Event) : void {
    this.pointOfInterestService.registerPointsOfInterest(this.pointOfInterest)
                               .subscribe(
                                  pointOfInterest => { 
                                    this.pointOfInterest = pointOfInterest;
                                    this.toastr.success("Point of interest registered.");
                                    this.pointOfInterestCreatedEvent.emit(event)
                                  },
                                  error => { this.toastr.error(error.message); }
                               )
  };
}
