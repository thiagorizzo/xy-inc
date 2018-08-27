import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PointOfInterestListComponent } from './point-of-interest-list.component';

describe('PointOfInterestListComponent', () => {
  let component: PointOfInterestListComponent;
  let fixture: ComponentFixture<PointOfInterestListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PointOfInterestListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PointOfInterestListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
