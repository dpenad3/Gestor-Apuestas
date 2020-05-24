import { Component, OnInit } from '@angular/core';
import { Respuesta } from '../../entidades/respuesta';
import { Persona } from '../../entidades/persona';
import { OperacionesService } from '../../servicios/operaciones.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-sesion',
  templateUrl: './sesion.component.html',
  styleUrls: ['./sesion.component.css']
})
export class SesionComponent implements OnInit {

  nombre: string;
  correo: string;
  clavew = '123';
  cedula: number;
  contrasenia: string;

  mirespuesta: Respuesta;
  mipersona: Persona;

  constructor(private servicio: OperacionesService, private router: Router) { }

  ngOnInit(): void {
  }
  llamar() {

    if (this.cedula === undefined || this.contrasenia === undefined) {
      alert('Los datos estan vacios');
      return ;
    }
    const x: Promise<Respuesta> =  this.servicio.login(this.cedula, this.contrasenia);

    x.then((value: Respuesta) => {
      this.mirespuesta = value;
      if  (this.mirespuesta.codigo === 1) {
        this.mipersona =  this.mirespuesta.info;
        this.servicio.persona = this.mipersona;

        this.router.navigate(['partidosF']);
      } else {
        alert (' * * * * * * * * * *  *El usuario no existe');
      }

    });

  }
}

