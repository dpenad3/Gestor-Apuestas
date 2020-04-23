import { Component, OnInit } from '@angular/core';
import { OperacionesService } from '../../servicios/operaciones.service';
import { Router } from '@angular/router';
import { RespuestaP } from '../../entidades/respuestaP';
import { Tarjeta } from '../../entidades/tarjeta';

@Component({
  selector: 'app-info-tarjeta',
  templateUrl: './info-tarjeta.component.html',
  styleUrls: ['./info-tarjeta.component.css']
})
export class InfoTarjetaComponent implements OnInit {

  miRespuesta: RespuestaP;
  miTarjeta: Tarjeta;

  constructor(private servicio: OperacionesService, private router: Router) { 
    this.infoTarjeta();
  }

  ngOnInit() {
  }

  infoTarjeta() {
    const x: Promise<RespuestaP> = this.servicio.serDarTarjeta();
    x.then((value: RespuestaP) => {
      this.miRespuesta = value;
      if  (this.miRespuesta.codigo === 0) {
        this.miTarjeta = this.miRespuesta.info;
        console.log(this.miRespuesta.mensajeE);
      } else {
        alert (this.miRespuesta.mensajeE);
      }
    });
  }

}
