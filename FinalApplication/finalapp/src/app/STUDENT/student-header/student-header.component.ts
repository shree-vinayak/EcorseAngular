import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { GenserviceService } from 'src/app/service/genservice.service';

@Component({
  selector: 'app-student-header',
  templateUrl: './student-header.component.html',
  styleUrls: ['./student-header.component.css']
})
export class StudentHeaderComponent implements OnInit {
  constructor(private gen:GenserviceService,private router:Router) { }

  ngOnInit() {
  }

  logout()
  {
    this.gen.logOut();
    this.router.navigate(['login']);
  }
}
