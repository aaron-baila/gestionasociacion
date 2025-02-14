import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-miembros',
  standalone: true,  // 🎯 Componente independiente
  imports: [CommonModule],
  templateUrl: './miembros.component.html',
  styleUrls: ['./miembros.component.css']
})
export class MiembrosComponent {
  miembros = [
    { nombre: 'Juan Pérez', rol: 'Presidente' },
    { nombre: 'María López', rol: 'Secretaria' },
    { nombre: 'Carlos Gómez', rol: 'Tesorero' },
    { nombre: 'Ana Ruiz', rol: 'Vocal' }
  ];
}
