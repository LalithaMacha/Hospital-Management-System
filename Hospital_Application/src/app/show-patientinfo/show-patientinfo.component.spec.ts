import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowPatientinfoComponent } from './show-patientinfo.component';

describe('ShowPatientinfoComponent', () => {
  let component: ShowPatientinfoComponent;
  let fixture: ComponentFixture<ShowPatientinfoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ShowPatientinfoComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ShowPatientinfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
