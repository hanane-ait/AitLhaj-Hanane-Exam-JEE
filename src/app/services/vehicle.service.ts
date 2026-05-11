import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({ providedIn: 'root' })
export class VehicleService {

  api = "http://localhost:8085/api/vehicles";

  constructor(private http: HttpClient) {}

  getAll() {
    return this.http.get(this.api);
  }

  delete(id: number) {
    return this.http.delete(`${this.api}/${id}`);
  }
}
