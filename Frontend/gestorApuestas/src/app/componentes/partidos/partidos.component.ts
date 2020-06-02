import { Component, OnInit, ViewChild } from '@angular/core';
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
  dialogo = false;
  equipo: string;
  idEquipo: number;
  porcentaje: number;
  dinero: number;
  idPartido: number;

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

  realizarApuesta(idPartido: number, dinero: number, porcentaje: number, idEquipo: number) {
    if (this.dinero === undefined) {
      alert('Diligencia la cantidad de dinero a apostar');
      return;
    }
    const x: Promise<RespuestaP> = this.servicio.servRealizarApuesta(idPartido, dinero, porcentaje, idEquipo);
    x.then((value: RespuestaP) => {
      this.miRespuesta = value;
      if  (this.miRespuesta.codigo === 0) {
        alert(this.miRespuesta.mensajeE);
        this.cerrarDialogo();
      } else {
        alert(this.miRespuesta.mensajeE);
      }
    });
  }

  abrirDialogo(idPartido: number, porcentaje: number, idEquipo: number, equipo: string) {
    this.idPartido = idPartido;
    this.porcentaje = porcentaje;
    this.idEquipo = idEquipo;
    this.equipo = equipo;
    this.dialogo = true;
  }

  cerrarDialogo() {
    this.dialogo = false;
  }
}
