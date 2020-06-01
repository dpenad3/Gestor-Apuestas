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
  correcto: boolean;
  mensaje: string;

  constructor(private servicio: OperacionesService, private router: Router) { }

  ngOnInit(): void {
  }

  registrar() {

    if (this.numero === undefined || this.cv === undefined || this.fecha === undefined || this.dinero === undefined) {
      this.correcto = false;
      this.mensaje = 'Por favor rellene todos los campos';
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
        this.correcto = false;
        this.mensaje = 'Datos ingresados incorrectos';
      }
    });

  }
}
