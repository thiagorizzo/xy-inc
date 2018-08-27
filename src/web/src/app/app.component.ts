import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  
  public createdEvent: Event;

  childCreatedEvent(event: Event) {
    this.createdEvent = event;
  }
}
