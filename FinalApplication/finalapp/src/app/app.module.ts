import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
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
    CreateTeacherComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [GenserviceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
