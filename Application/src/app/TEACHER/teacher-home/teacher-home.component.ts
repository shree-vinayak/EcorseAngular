import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-teacher-home',
  templateUrl: './teacher-home.component.html',
  styleUrls: ['./teacher-home.component.css']
})
export class TeacherHomeComponent implements OnInit {

  username: string = null;
  constructor() { }

  ngOnInit() {
    this.username = sessionStorage.getItem('emailid');
  }

}
