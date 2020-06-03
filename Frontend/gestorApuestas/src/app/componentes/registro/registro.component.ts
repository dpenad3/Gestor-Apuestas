import { Component, OnInit } from '@angular/core';
import { OperacionesService } from 'src/app/servicios/operaciones.service';
import { Router } from '@angular/router';
import { RegistrodatosService } from 'src/app/entidades/registrodatos';
import { Respuesta } from 'src/app/entidades/respuesta';


@Component({
  selector: 'app-registro',
  templateUrl: './registro.component.html',
  styleUrls: ['./registro.component.css']
})
export class RegistroComponent implements OnInit {
  cedula?: number; // pk
  nombre?: string;
  apellido?: string;
  correo?: string;
  contrasena?: string;

  mensajeE: string;
  codigo: number;
  miRegistro: RegistrodatosService;
  miRespuesta: Respuesta;
  constructor(private servicio: OperacionesService, private router: Router) { }

  ngOnInit() {
  }
  ingresarregistro() {
    if (this.cedula === undefined || this.nombre === undefined || this.apellido === undefined ||
        this.correo === undefined || this.contrasena === undefined) {
      alert('Los datos estan vacios');
      return;
    }
    const x: Promise<RegistrodatosService> = this.servicio.ingresarregistro(
      this.cedula, this.nombre, this.apellido, this.correo, this.contrasena);

    x.then((value: Respuesta) => {
      this.miRespuesta = value;
      if (this.miRespuesta.mensajeE === 'Valores validos') {
        this.miRegistro = this.miRespuesta.info;
        this.servicio.persona = this.miRegistro;
      } else {
        alert('el usuario fue agregado exitosamente ');
        this.router.navigate(['sesion']);
      }

    });
  }

  crear(): void {
    this.router.navigate(['registrarse']);
  }
}
