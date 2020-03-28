import { Component, OnInit } from '@angular/core';
import { OperacionesService } from '../../servicios/operaciones.service';
import { Tarjeta } from '../../entidades/tarjeta';
import { ResTarjeta } from '../../entidades/resTarjeta';

@Component({
  selector: 'app-tarjeta',
  templateUrl: './tarjeta.component.html',
  styleUrls: ['./tarjeta.component.css']
})
export class TarjetaComponent implements OnInit {

  'cv': number;
  'numeroTarjeta': number;
  'fechaVen': string;
  'dinero': number;

  miRespuesta: ResTarjeta;
  miTarjeta: Tarjeta;

  constructor(private servicio: OperacionesService) {
  }
  ngOnInit() {
  }

  tarjeta() {
    if (this.numeroTarjeta === undefined || this.cv === undefined || this.fechaVen === undefined || this.dinero === undefined) {
      alert('Los datos estan vacios');
      return ;
    }
    const x: Promise<ResTarjeta> =  this.servicio.registrarTarjeta(this.numeroTarjeta, this.cv, this.fechaVen, this.dinero);

    x.then((value: ResTarjeta) => {
      this.miRespuesta = value;
      if  (this.miRespuesta.codigo === 1) {
        this.miTarjeta = this.miRespuesta.info;
        this.servicio.miTarjeta = this.miTarjeta;
      } else {
        alert ('Error al registar tarjeta');
      }

    });
  }
}
