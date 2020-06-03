import { Component, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { Partido } from '../../entidades/partidos';
import { RespuestaP } from '../../entidades/respuestaP';
import { Tarjeta } from '../../entidades/tarjeta';
import { OperacionesService } from '../../servicios/operaciones.service';

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
  miTarjeta: Tarjeta;

  constructor(private servicio: OperacionesService, private router: Router) { this.infoTarjeta(); this.listaPartidos(); }

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
        this.infoTarjeta();
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

  infoTarjeta() {
    const x: Promise<RespuestaP> = this.servicio.serDarTarjeta();
    x.then((value: RespuestaP) => {
      this.miRespuesta = value;
      if  (this.miRespuesta.codigo === 0) {
        this.miTarjeta = this.miRespuesta.info;
        console.log(this.miRespuesta.mensajeE);
      } else {
        alert ('No se encuentra tarjeta registrada en el sistema');
        this.router.navigate(['tarjeta']);
      }
    });
  }

  recargar() {
    if (this.dinero === undefined) {
      alert('Especificar monto de recarga');
      return ;
    }
    const x: Promise<RespuestaP> = this.servicio.serRecargarTarjeta(this.dinero);
    x.then((value: RespuestaP) => {
      this.miRespuesta = value;
      if  (this.miRespuesta.codigo === 0) {
          alert(this.miRespuesta.mensajeE);
          this.infoTarjeta();
      } else {
        alert(this.miRespuesta.mensajeE);
      }
    });
  }
}
