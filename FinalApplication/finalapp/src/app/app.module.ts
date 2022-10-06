import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { GenserviceService } from './service/genservice.service';
import { AdminHomeComponent } from './ADMIN/admin-home/admin-home.component';
import { TeacherHomeComponent } from './TEACHER/teacher-home/teacher-home.component';
import { StudentHomeComponent } from './STUDENT/student-home/student-home.component';
import { AdminHeaderComponent } from './ADMIN/admin-header/admin-header.component';
import { AdminSidebarComponent } from './ADMIN/admin-sidebar/admin-sidebar.component';
import { AdminFooterComponent } from './ADMIN/admin-footer/admin-footer.component';
import { StudentHeaderComponent } from './STUDENT/student-header/student-header.component';
import { StudentSidebarComponent } from './STUDENT/student-sidebar/student-sidebar.component';
import { StudentFooterComponent } from './STUDENT/student-footer/student-footer.component';
import { TeacherHeaderComponent } from './TEACHER/teacher-header/teacher-header.component';
import { TeacherSidebarComponent } from './TEACHER/teacher-sidebar/teacher-sidebar.component';
import { TeacherFooterComponent } from './TEACHER/teacher-footer/teacher-footer.component';
import { CreateTeacherComponent } from './ADMIN/create-teacher/create-teacher.component';
import { CreateStudentComponent } from './ADMIN/create-student/create-student.component';
import { AddMarksComponent } from './TEACHER/add-marks/add-marks.component';
import { MyInterceptorService } from './service/my-interceptor.service';
import { ShowResultComponent } from './STUDENT/show-result/show-result.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    AdminHomeComponent,
    TeacherHomeComponent,
    StudentHomeComponent,
    AdminHeaderComponent,
    AdminSidebarComponent,
    AdminFooterComponent,
    StudentHeaderComponent,
    StudentSidebarComponent,
    StudentFooterComponent,
    TeacherHeaderComponent,
    TeacherSidebarComponent,
    TeacherFooterComponent,
    CreateTeacherComponent,
    CreateStudentComponent,
    AddMarksComponent,
    ShowResultComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [GenserviceService,
    { provide: HTTP_INTERCEPTORS, useClass: MyInterceptorService, multi: true }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
