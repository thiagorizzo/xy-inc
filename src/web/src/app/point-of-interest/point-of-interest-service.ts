import { Injectable } from "@angular/core";
import { PointOfInterest } from "./point-of-interest";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { ConfigService } from "../config/config.service";
import { NearbyInput } from "./nearby-input";
import { URLSearchParams } from "@angular/http";

@Injectable()
export class PointOfInterestService {
    private pointsOfInterestUrl : string = "http://localhost:8080/pointsofinterest";

    constructor(private http : HttpClient, private config : ConfigService) { }

    getPointsOfInterest() : Observable<PointOfInterest[]> {
        return this.http.get<PointOfInterest[]>(this.pointsOfInterestUrl);
    };

    registerPointsOfInterest(pointOfInterest : PointOfInterest) : Observable<PointOfInterest> {
        return this.http.post<PointOfInterest>(this.pointsOfInterestUrl, pointOfInterest);
    };

    getNearbyPointsOfInterest(nearbyInput : NearbyInput) : Observable<PointOfInterest[]> {
        let params = new URLSearchParams();
        for(let key in nearbyInput){
            params.set(key, nearbyInput[key]) 
        }
        return this.http.get<PointOfInterest[]>(this.pointsOfInterestUrl + "/nearby?" + params.toString());
    };
}