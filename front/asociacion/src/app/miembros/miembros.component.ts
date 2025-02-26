import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MiembrosService } from '../miembros.service';
import { Observable } from 'rxjs';
import { FormsModule } from '@angular/forms';


@Component({
  selector: 'app-miembros',
  imports: [CommonModule,FormsModule],
  templateUrl: './miembros.component.html',
  styleUrls: ['./miembros.component.css']
})
export class MiembrosComponent {
  miembros$: Observable<any[]> = new Observable()
  
  constructor(private miembrosService: MiembrosService) { }

  ngOnInit(): void {
    this.miembros$ = this.miembrosService.getMiembros();
  }
  
}
