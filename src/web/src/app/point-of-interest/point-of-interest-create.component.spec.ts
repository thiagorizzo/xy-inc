import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PointOfInterestCreateComponent } from './point-of-interest-create.component';

describe('PointOfInterestCreateComponent', () => {
  let component: PointOfInterestCreateComponent;
  let fixture: ComponentFixture<PointOfInterestCreateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PointOfInterestCreateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PointOfInterestCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
