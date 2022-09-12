import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { HomeComponent } from './admin/home/home.component';
import { HeaderComponent } from './admin/header/header.component';
import { FooterComponent } from './admin/footer/footer.component';
import { SidebarComponent } from './admin/sidebar/sidebar.component';
import { GetAllStudentsComponent } from './admin/get-all-students/get-all-students.component';
import { TeacherHeaderComponent } from './TEACHER/teacher-header/teacher-header.component';
import { TeacherFooterComponent } from './TEACHER/teacher-footer/teacher-footer.component';
import { TeacherSidebarComponent } from './TEACHER/teacher-sidebar/teacher-sidebar.component';
import { TeacherHomeComponent } from './TEACHER/teacher-home/teacher-home.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent,
    HeaderComponent,
    FooterComponent,
    SidebarComponent,
    GetAllStudentsComponent,
    TeacherHeaderComponent,
    TeacherFooterComponent,
    TeacherSidebarComponent,
    TeacherHomeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
