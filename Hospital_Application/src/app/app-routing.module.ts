import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { DoctorComponent } from './doctor/doctor.component';
import { PatientComponent } from './patient/patient.component';
import { DashboardComponent } from './component/dashboard/dashboard.component';
import { ShowDoctorInfoComponent } from './show-doctor-info/show-doctor-info.component';
import { ShowPatientinfoComponent } from './show-patientinfo/show-patientinfo.component';

const routes: Routes = [
  {path:'',redirectTo:"/home",pathMatch:'full'},
  {path: 'dashboard', component: DashboardComponent},
  {path: 'home', component: HomeComponent },
  {path:'patients',component: PatientComponent, pathMatch: 'full'},
  {path:'doctors',component: DoctorComponent},
  {path:'showdoctorsinfo',component:  ShowDoctorInfoComponent},
  {path:'showpatientsinfo',component:  ShowPatientinfoComponent},
  {path:'**',component: HomeComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
