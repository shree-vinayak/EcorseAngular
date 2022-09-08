import { Component, OnInit } from '@angular/core';
import { GenericService } from './service/generic.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'Application';
  constructor(private gen:GenericService,private router:Router) { }

  ngOnInit() {

  }
}
