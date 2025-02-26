import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-root',
  standalone: true,
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  imports: []
})
export class AppComponent implements OnInit {

  mensaje: string = '';

  constructor(private http: HttpClient) {}

  ngOnInit(): void {
    this.http.get('http://localhost:8080/api/hello', { responseType: 'text' })
      .subscribe(
        response => {
          console.log('Respuesta del backend:', response);
          this.mensaje = response;
        },
        error => console.error('Error al conectar con el backend:', error)
      );
  }
}
