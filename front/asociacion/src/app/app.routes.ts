import { Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { MiembrosComponent } from './miembros/miembros.component';
import { EventosComponent } from './eventos/eventos.component';

export const routes: Routes = [
  { path: '', component: HomeComponent }, // Página de inicio
  { path: 'miembros', component: MiembrosComponent },
  { path: 'eventos', component: EventosComponent },
  { path: '**', redirectTo: '', pathMatch: 'full' } // Redirección en caso de ruta desconocida
];
