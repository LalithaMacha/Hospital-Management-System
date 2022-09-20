import { Injectable } from '@angular/core';
import { Doctor } from './model/doctor';
import {Patient} from './model/patient';
import { catchError, empty, Observable, throwError } from 'rxjs';
import {HttpClient, HttpHeaders} from "@angular/common/http"

@Injectable({
  providedIn: 'root'
})
export class HospitalService {

  constructor(private http: HttpClient) {
    
  }

  //post doctor data
   postDoctorInfo(data?: Doctor): Observable<Object>{
    return this.http.post<Object>("http://localhost:9191/doctor/post", data)
   }

   //get all doctors
   getAllDoctors(): Observable<Doctor[]>{
    return this.http.get<any>("http://localhost:9191/doctor/get");
  }

  //get doctor by name
  getDoctorByName(name: any): Observable<Doctor>{
    return this.http.get<any>("http://localhost:9191/doctor/get/${name}");
 }

  //get all patients
  getAllPatients(): Observable<Patient[]>{
    return this.http.get<any>("http://localhost:9393/pat/get");
  }

  //post patient data
  postPatientInfo(patient?: Patient): Observable<Object>{
    return this.http.post<Object>("http://localhost:9393/pat/post", patient);
  }

  //get patient by id
  getPatient(id:number): Observable<Patient>{
    return this.http.get<any>("http://localhost:9393/pat/get/${id}");
  }

}
