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

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    AdminHomeComponent,
    TeacherHomeComponent,
    StudentHomeComponent
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
