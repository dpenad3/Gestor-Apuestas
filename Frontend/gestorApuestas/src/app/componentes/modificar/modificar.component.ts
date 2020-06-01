
import { Component, OnInit } from '@angular/core';
import { OperacionesService } from 'src/app/servicios/operaciones.service';
import { Router } from '@angular/router';
import { RegistrodatosService } from 'src/app/entidades/registrodatos';
import { Respuesta } from 'src/app/entidades/respuesta';


@Component({
  selector: 'app-modificar',
  templateUrl: './modificar.component.html',
  styleUrls: ['./modificar.component.css']
})
export class ModificarComponent implements OnInit {
  cedula?: number; //pk
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

  modificarregistro(){
    if (this.cedula === undefined || this.nombre === undefined || this.apellido === undefined || this.correo === undefined || this.contrasena === undefined) {
      alert('Los datos estan vacios');
      return;
    }
    const x: Promise<RegistrodatosService> = this.servicio.modificarregistro(this.cedula, this.nombre, this.apellido, this.correo, this.contrasena);
    
    x.then((value: Respuesta) => {
      this.miRespuesta = value;
      if  (this.miRespuesta !== undefined && this.miRespuesta.mensajeE === 'Valores validos' ) {
        alert ('MODIFICADO CORRECTAMENTE ');
      } else {
        alert ('NO SE PUDO MODIFICAR');
      }


    });
  }

}
