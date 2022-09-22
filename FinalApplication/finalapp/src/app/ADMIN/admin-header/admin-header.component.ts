import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { GenserviceService } from 'src/app/service/genservice.service';

@Component({
  selector: 'app-admin-header',
  templateUrl: './admin-header.component.html',
  styleUrls: ['./admin-header.component.css']
})
export class AdminHeaderComponent implements OnInit {

  constructor(private gen:GenserviceService,private router:Router) { }

  ngOnInit() {
  }

  logout()
  {
    this.gen.logOut();
    this.router.navigate(['login']);
  }
  


}
