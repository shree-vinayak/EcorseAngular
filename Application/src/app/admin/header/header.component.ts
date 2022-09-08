import { Component, OnInit } from '@angular/core';
import { GenericService } from 'src/app/service/generic.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

 
  constructor(private gen:GenericService,private router:Router) { }
  ngOnInit() {
  }


  logout()
  {
    this.gen.logOut();
    this.router.navigate(['login']);
  }
  
}
 