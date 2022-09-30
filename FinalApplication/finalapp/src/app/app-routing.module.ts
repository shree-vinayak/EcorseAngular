import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AdminHomeComponent } from './ADMIN/admin-home/admin-home.component';
import { CreateStudentComponent } from './ADMIN/create-student/create-student.component';
import { CreateTeacherComponent } from './ADMIN/create-teacher/create-teacher.component';
import { LoginComponent } from './login/login.component';
import { StudentHomeComponent } from './STUDENT/student-home/student-home.component';
import { AddMarksComponent } from './TEACHER/add-marks/add-marks.component';
import { TeacherHomeComponent } from './TEACHER/teacher-home/teacher-home.component';


const routes: Routes = [
  { path: '', redirectTo: 'login', pathMatch: 'full' },
  { path: 'login', component: LoginComponent },

  //ADMIN ROLE 
  { path: 'admin-home', component: AdminHomeComponent },
  { path: 'create-teacher', component: CreateTeacherComponent },
  { path: 'create-student', component: CreateStudentComponent },


  //TEACHER ROLE
  { path: 'teacher-home', component: TeacherHomeComponent },
  { path: 'add-marks', component: AddMarksComponent },

  //STUDENT ROLE
  { path: 'student-home', component: StudentHomeComponent },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
