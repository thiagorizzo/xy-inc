import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { PointOfInterest } from './point-of-interest';
import { PointOfInterestService } from './point-of-interest-service';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-point-of-interest-create',
  templateUrl: './point-of-interest-create.component.html',
  styleUrls: ['./point-of-interest-create.component.css']
})
export class PointOfInterestCreateComponent implements OnInit {

  private pointOfInterest = <PointOfInterest> { };
  private error = undefined;

  constructor(private pointOfInterestService : PointOfInterestService, private toastr: ToastrService) { }

  ngOnInit() {
  }

  registerPointOfInterest() : void {
    this.pointOfInterestService.registerPointsOfInterest(this.pointOfInterest)
                               .subscribe(
                                  pointOfInterest => { this.pointOfInterest = pointOfInterest; this.toastr.success("Point of interest registered.") },
                                  error => { this.toastr.error(error.message); }
                               )
  };
}
