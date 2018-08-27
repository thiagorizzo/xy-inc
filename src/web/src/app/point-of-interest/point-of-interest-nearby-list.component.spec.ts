import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PointOfInterestNearbyListComponent } from './point-of-interest-nearby-list.component';

describe('PointOfInterestNearbyListComponent', () => {
  let component: PointOfInterestNearbyListComponent;
  let fixture: ComponentFixture<PointOfInterestNearbyListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PointOfInterestNearbyListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PointOfInterestNearbyListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
