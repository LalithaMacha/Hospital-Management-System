import { Component, OnInit } from '@angular/core';
import { HospitalService } from '../hospital.service';
import { Patient } from '../model/patient';

@Component({
  selector: 'app-show-patientinfo',
  templateUrl: './show-patientinfo.component.html',
  styleUrls: ['./show-patientinfo.component.css']
})
export class ShowPatientinfoComponent implements OnInit {

  patients: Patient[]=[];
  id: number |null=null;

  constructor(private service:HospitalService) { }

  ngOnInit(): void {
    this.service.getAllPatients().subscribe({
      next: (data)=>{
        this.patients=data;
      }
    });
  }

  search(){
    if(this.id == 0){
      this.ngOnInit();
      alert("No such id is available in the database")
    }else {
       this.patients=this.patients.filter(res=>{
         return this.id==res.id;
       });
    }
  }

}
