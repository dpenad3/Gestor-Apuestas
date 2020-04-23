import { Component, OnInit } from '@angular/core';
import { OperacionesService } from '../../servicios/operaciones.service';
import { Tarjeta } from '../../entidades/tarjeta';
import { Router } from '@angular/router';
import { RespuestaP } from '../../entidades/respuestaP';

@Component({
  selector: 'app-tarjeta',
  templateUrl: './tarjeta.component.html',
  styleUrls: ['./tarjeta.component.css']
})
export class TarjetaComponent implements OnInit {

  numero: number;
  cv: number;
  fecha: string;
  dinero: number;

  miTarjeta: Tarjeta;
  miRespuesta: RespuestaP;

  constructor(private servicio: OperacionesService, private router: Router) { }

  ngOnInit(): void {
  }

  registrar() {

    if (this.numero === undefined || this.cv === undefined || this.fecha === undefined || this.dinero === undefined) {
      alert('Por favor completar el formulario');
      return ;
    }
    const x: Promise<RespuestaP> =  this.servicio.registrarTarjeta(this.numero, this.cv, this.fecha, this.dinero);

    x.then((value: RespuestaP) => {
      this.miRespuesta = value;
      if  (this.miRespuesta.codigo === 0) {
        this.miTarjeta =  this.miRespuesta.info;
        this.servicio.miTarjeta = this.miTarjeta;
        this.router.navigate(['infoTarjeta']);
      } else {
        alert (this.miRespuesta.mensajeE);
      }
    });

  }
}
