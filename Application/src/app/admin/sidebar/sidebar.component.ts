import { Component, OnInit } from '@angular/core';
import { GenericService } from 'src/app/service/generic.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css']
})
export class SidebarComponent implements OnInit {

  constructor(private gen:GenericService,private router:Router) { }
  ngOnInit() {
  }


  logout()
  {
    this.gen.logOut();
    this.router.navigate(['login']);
  }

}
