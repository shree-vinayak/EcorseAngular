import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AdminHomeComponent } from './ADMIN/admin-home/admin-home.component';
import { LoginComponent } from './login/login.component';
import { StudentHomeComponent } from './STUDENT/student-home/student-home.component';
import { TeacherHomeComponent } from './TEACHER/teacher-home/teacher-home.component';


const routes: Routes = [
  { path: '', redirectTo: 'login', pathMatch: 'full' },
  { path: 'login', component: LoginComponent },

  //ADMIN ROLE 
  { path: 'admin-home', component: AdminHomeComponent },

  //TEACHER ROLE
  { path: 'teacher-home', component: TeacherHomeComponent },

  //STUDENT ROLE
  { path: 'student-home', component: StudentHomeComponent },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
