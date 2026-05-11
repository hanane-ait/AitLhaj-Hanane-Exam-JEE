import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({ providedIn: 'root' })
export class LocationService {

  api = "http://localhost:8085/api/locations";

  constructor(private http: HttpClient) {}

  getAll() {
    return this.http.get(this.api);
  }
}
