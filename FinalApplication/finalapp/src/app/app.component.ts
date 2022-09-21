import { Component } from '@angular/core';
import { GenserviceService } from './service/genservice.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'finalapp';

  constructor(private gen:GenserviceService)
  {
    
  }
}
