import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { GenserviceService } from 'src/app/service/genservice.service';

@Component({
  selector: 'app-admin-sidebar',
  templateUrl: './admin-sidebar.component.html',
  styleUrls: ['./admin-sidebar.component.css']
})
export class AdminSidebarComponent implements OnInit {

  constructor(private gen:GenserviceService,private router:Router) { }

  ngOnInit() {
  }

  logout()
  {
    this.gen.logOut();
    this.router.navigate(['login']);
  }

}
