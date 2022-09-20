import { Component, OnInit } from '@angular/core';
import { Doctor } from '../model/doctor';
import { HospitalService } from '../hospital.service';

@Component({
  selector: 'app-show-doctor-info',
  templateUrl: './show-doctor-info.component.html',
  styleUrls: ['./show-doctor-info.component.css']
})
export class ShowDoctorInfoComponent implements OnInit {

  public doctor: Doctor={} as Doctor;
  public name: any;
  public errorMessage: string | null=null;
  public doctors: Doctor[]=[];

  constructor(private service:HospitalService) { }

  ngOnInit(): void {
    this.service.getAllDoctors().subscribe({
      next: (data)=>{
        this.doctors=data;
      }
    });
  }
  search(){
    if(this.name==""){
      this.ngOnInit();
        }else {
          this.doctors=this.doctors.filter(res=>{
            return res.name.toLocaleLowerCase().match(this.name.toLocaleLowerCase());
          });
        }
        
    }
  }
     

