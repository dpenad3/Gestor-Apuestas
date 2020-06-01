import { Component, OnInit} from '@angular/core';
import { PartidosService } from '../../servicios/partidos.service';
import { Router } from '@angular/router';
import { RespuestaP } from '../../entidades/respuestaP';
import { Apuesta } from '../../entidades/apuesta';

@Component({
  selector: 'app-apuesta',
  templateUrl: './apuesta.component.html',
  styleUrls: ['./apuesta.component.css']
})
export class ApuestaComponent implements OnInit {

  miRespuesta: RespuestaP;
  miApuesta: Apuesta;
  dinero: number;

  constructor(private servicio: PartidosService, private router: Router) {
    this.darApuesta();
   }

  ngOnInit() {
  }

  darApuesta() {
    this.miApuesta = this.servicio.darApuesta();
  }

  realizarApuesta() {
    if (this.dinero === undefined) {
      alert('Por favor ingresar dinero de la apuesta');
      return ;
    }
    const x: Promise<RespuestaP> = this.servicio.servRealizarApuesta(
      this.miApuesta.id_partido, this.dinero, this.miApuesta.porcentaje, this.miApuesta.id_equipo);
    if  (this.miRespuesta.codigo === 0) {
      alert (this.miRespuesta.mensajeE);
    } else {
      alert (this.miRespuesta.mensajeE);
    }
  }
}
