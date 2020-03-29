import { Component, OnInit } from '@angular/core';
import { OperacionesService } from '../../servicios/operaciones.service';
import { Tarjeta } from '../../entidades/tarjeta';
import { ResTarjeta } from '../../entidades/resTarjeta';
import { Router } from '@angular/router';

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
  miRespuesta: ResTarjeta;

  constructor(private servicio: OperacionesService, private router: Router) { }

  ngOnInit(): void {
  }

  registrar() {

    if (this.numero === undefined || this.cv === undefined || this.fecha === undefined || this.dinero === undefined) {
      alert('Por favor completar el formulario');
      return ;
    }
    this.fecha = this.fecha + '-31';
    const x: Promise<ResTarjeta> =  this.servicio.registrarTarjeta(this.numero, this.cv, this.fecha, this.dinero);

    x.then((value: ResTarjeta) => {
      this.miRespuesta = value;
      if  (this.miRespuesta.codigo === 1) {
        this.miTarjeta =  this.miRespuesta.info;
        this.servicio.miTarjeta = this.miTarjeta;

        this.router.navigate(['inicio']);
      } else {
        alert ('Error al registrar la tarjeta');
      }

    });

  }
}
