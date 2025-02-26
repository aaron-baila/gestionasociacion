import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class MiembrosService {
  private apiUrl = 'http://localhost:8080/miembros';

  constructor(private http: HttpClient) {}

  getMiembros(): Observable<any[]> {
    return this.http.get<any[]>(this.apiUrl).pipe(
      catchError(error => {
        console.error('Error obteniendo miembros:', error);
        return throwError(() => new Error('Error al cargar miembros'));
      })
    );
  }
}
