import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({ providedIn: 'root' })
export class AgencyService {

  api = "http://localhost:8085/api/agencies";

  constructor(private http: HttpClient) {}

  getAll() {
    return this.http.get(this.api);
  }
}
