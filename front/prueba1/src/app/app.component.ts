import { Component, signal, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { catchError, of } from 'rxjs';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  imports: []
})
export class AppComponent implements OnInit {

  mensaje = signal<string>('Cargando...'); // Usamos signal en lugar de una variable normal

  constructor(private http: HttpClient) {}

  ngOnInit(): void {
    this.http.get('http://localhost:8080/api/hello', { responseType: 'text' })
      .pipe(
        catchError(error => {
          console.error('Error al conectar con el backend:', error);
          return of('Error al obtener el mensaje');
        })
      )
      .subscribe(this.mensaje.set); // Actualiza el signal automáticamente
  }
}
