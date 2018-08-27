import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { PointOfInterestListComponent } from './point-of-interest/point-of-interest-list.component';
import { ConfigComponent } from './config/config.component';
import { PointOfInterestService } from './point-of-interest/point-of-interest-service';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { PointOfInterestCreateComponent } from './point-of-interest/point-of-interest-create.component';
import { PointOfInterestNearbyListComponent } from './point-of-interest/point-of-interest-nearby-list.component';
import { ReactiveFormsModule } from '@angular/forms';
import { TabsModule, AlertModule } from 'ngx-bootstrap';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ToastrModule } from 'ngx-toastr';

@NgModule({
  declarations: [
    AppComponent,
    PointOfInterestListComponent,
    ConfigComponent,
    PointOfInterestCreateComponent,
    PointOfInterestNearbyListComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    TabsModule.forRoot(),
    AlertModule.forRoot(),
    BrowserAnimationsModule,
    ToastrModule.forRoot()
  ],
  providers: [PointOfInterestService],
  bootstrap: [AppComponent]
})
export class AppModule { }
