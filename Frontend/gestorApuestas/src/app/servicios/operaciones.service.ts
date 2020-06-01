import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Respuesta } from '../entidades/respuesta';
import { Persona } from '../entidades/persona';
import { Tarjeta } from '../entidades/tarjeta';
<<<<<<< HEAD
import { ResTarjeta } from '../entidades/resTarjeta';
import { RegistrodatosService } from '../entidades/registrodatos';
=======
import { RespuestaP } from '../entidades/respuestaP';
>>>>>>> a75b387b1dd7bd715e08cc0adce4df319c38b2a3

@Injectable({
  providedIn: 'root'
})
export class OperacionesService {

<<<<<<< HEAD
  rutaservicio = 'http://localhost:8080/ServAuten/app/operacion/login';
  rutaservicioversion = 'http://172.20.74.124:8080/ServAuten/app/operacion/login';
  rutaservicioTarjeta = 'http://172.20.74.124:8080/ServAuten/app/operacion/autenticar';
  rutaservicioRegistro = 'http://localhost:8080/ServAuten/app/serviciosregistro/ingresarregistro';
  rutasserviciosModificacion = "http://localhost:8080/ServAuten/app/serviciosregistro/modificarregistro";
=======
  rutaservicio = 'http://localhost:8080/servRegistrarTarjeta/app/operacion/registrarTarjeta';
  rutaservicioversion = 'http://localhost:8080/servRegistrarTarjeta/app/operacion/registrarTarjeta';
  rutaservicioTarjeta = 'http://localhost:8080/servRegistrarTarjeta/app/operacion/registrarTarjeta';
  rutaservDarTarjeta = 'http://localhost:8080/servRegistrarTarjeta/app/operacion/darTarjeta';
  rutaRecargarTarjeta = 'http://localhost:8080/servRegistrarTarjeta/app/operacion/recargar';
>>>>>>> a75b387b1dd7bd715e08cc0adce4df319c38b2a3
  persona: Persona;
  miTarjeta: Tarjeta;
  registrodatos: RegistrodatosService;

  constructor(private http: HttpClient) {
  }

  autenticar(cedula: number, clave: string): Promise<Respuesta> {
    const info = {
      cedula,
      clave
    };
    return this.http.post<Respuesta>(`${this.rutaservicio}`, info).toPromise();
  }

  login(cedula: number, contrasena: string): Promise<Respuesta> {
    const info = {
      cedula,
      contrasena,
    };
<<<<<<< HEAD
    return this.http.post<Respuesta>(`${this.rutaservicio}`, info).toPromise();
  }

  registrarTarjeta(numero_tarjeta: number, cv: number, fecha_ven: string, dinero: number): Promise<ResTarjeta> {
    const info = {
      numero_tarjeta,
      cv,
      cedula_jugador: 1007228578,
      fecha_ven,
      dinero
    };
    return this.http.post<ResTarjeta>(`${this.rutaservicio}`, info).toPromise();
  }

  ingresarregistro(cedula: number, nombre: string, apellido: string, correo: string, contrasena: string): Promise<Respuesta> {
    const info = {
      "cedula" : cedula, 
      "nombre" : nombre, 
      "apellido" : apellido, 
      "correo" : correo, 
      "contrasena" : contrasena, 
    };
    return this.http.post<Respuesta>(`${this.rutaservicioRegistro}`, info).toPromise();
  }

  modificarregistro(cedula: number, nombre: string, apellido: string, correo: string, contrasena: string): Promise<Respuesta>{
    const info = {
      "cedula" : cedula, 
      "nombre" : nombre, 
      "apellido" : apellido, 
      "correo" : correo, 
      "contrasena" : contrasena, 
    };
    return this.http.put<Respuesta>(`${this.rutasserviciosModificacion}`,info).toPromise();
  }
=======
   sessionStorage.Cedula = cedula;
   sessionStorage.contrasena = contrasena;
   return this.http.post<Respuesta>(`${this.rutaservicio}`, info).toPromise();
 }

 registrarTarjeta(numero_tarjeta: number, cv: number, fecha_ven: string, dinero: number ): Promise<RespuestaP> {
   const info = {
    numero_tarjeta,
    cv,
    cedula_jugador: sessionStorage.getItem('Cedula'),
    fecha_ven,
    dinero
   };
   return this.http.post<RespuestaP>(`${this.rutaservicio}`, info).toPromise();
 }
>>>>>>> a75b387b1dd7bd715e08cc0adce4df319c38b2a3

 serDarTarjeta(): Promise<RespuestaP> {
    const info = {
      cedula_jugador: sessionStorage.getItem('Cedula')
    };
    return this.http.post<RespuestaP>(`${this.rutaservDarTarjeta}`, info).toPromise();
 }

 serRecargarTarjeta(dinero: number): Promise<RespuestaP> {
    const info = {
      cedula_jugador: sessionStorage.getItem('Cedula'),
      dinero
    };
    return this.http.post<RespuestaP>(`${this.rutaRecargarTarjeta}`, info).toPromise();
 }
 
}
