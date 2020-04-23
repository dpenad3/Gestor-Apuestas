import { Component, OnInit } from '@angular/core';
import { PartidosService } from '../../servicios/partidos.service';
import { Router } from '@angular/router';
import { Partido } from '../../entidades/partidos';
import { RespuestaP } from '../../entidades/respuestaP';

@Component({
  selector: 'app-partidos',
  templateUrl: './partidos.component.html',
  styleUrls: ['./partidos.component.css']
})
export class PartidosComponent implements OnInit {

  partidos: Partido[];
  miRespuesta: RespuestaP;
  cols: any[];

  constructor(private servicio: PartidosService, private router: Router) { this.listaPartidos(); }

  ngOnInit() {
    this.cols = [
      { field: 'fecha', header: 'Fecha' },
      { field: 'local', header: 'Local' },
      { field: 'visitante', header: 'Visitante' },
    ];
  }

  listaPartidos() {
    const x: Promise<RespuestaP> = this.servicio.servListaPartidos();
    x.then((value: RespuestaP) => {
      this.miRespuesta = value;
      if  (this.miRespuesta.codigo === 0) {
        this.partidos = this.miRespuesta.partidos;
        console.log(this.miRespuesta.mensajeE);
      } else {
        alert (this.miRespuesta.mensajeE);
      }

    });

  }
}
