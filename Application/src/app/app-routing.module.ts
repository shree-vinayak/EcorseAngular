import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './admin/home/home.component';
import { GetAllStudentsComponent } from './admin/get-all-students/get-all-students.component';
import { TeacherHomeComponent } from './TEACHER/teacher-home/teacher-home.component';


const routes: Routes = [
  {path:'',redirectTo:'login',pathMatch:'full'},
  {path:'login',component:LoginComponent},
  {path:'home',component:HomeComponent},
  {
    path:'get-students',component:GetAllStudentsComponent
  },

  //TEACHER
  {path:'teacher-home',component:TeacherHomeComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
