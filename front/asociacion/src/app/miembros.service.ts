import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MiembrosService {

  private apiUrl = 'http://localhost:8080/miembros'; // Cambia esto según tu endpoint en Spring Boot
 
  constructor(private http: HttpClient) { }

  getMiembros(): Observable<any> {
    return this.http.get(this.apiUrl);
  }
}
