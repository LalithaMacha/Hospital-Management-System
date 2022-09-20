import { Component, OnInit } from '@angular/core';
import { HospitalService } from '../hospital.service';
import { Router } from '@angular/router';
import { Doctor } from '../model/doctor';


@Component({
  selector: 'app-doctor',
  templateUrl: './doctor.component.html',
  styleUrls: ['./doctor.component.css']
})
export class DoctorComponent implements OnInit {

  public doctor:Doctor=new Doctor();
  constructor(private service: HospitalService,private router:Router) { }

  ngOnInit(): void {

  }
  saveDoctor(){
    console.log(this.doctor);
    this.service.postDoctorInfo(this.doctor).subscribe();
    this.router.navigate(['/']);
  }

}
