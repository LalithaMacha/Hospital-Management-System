import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HospitalService } from '../hospital.service';
import { Doctor } from '../model/doctor';
import { Patient } from '../model/patient';
import { FormsModule, Validators } from '@angular/forms';
import { FormGroup,FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-patient',
  templateUrl: './patient.component.html',
  styleUrls: ['./patient.component.css']
})
export class PatientComponent implements OnInit {
  
 doctors: Doctor[]=[];
 patient: Patient=new Patient();
constructor(private service:HospitalService,private router:Router){}

ngOnInit():void{
  this.service.getAllDoctors().subscribe({
    next: (data)=>{
       this.doctors=data;
    }
  })
}
savePatient(){
  console.log(this.patient);
  this.service.postPatientInfo(this.patient).subscribe();
  this.router.navigate(['/']);
}

}