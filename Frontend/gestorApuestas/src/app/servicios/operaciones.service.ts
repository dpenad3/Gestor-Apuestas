import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Respuesta } from '../entidades/respuesta';
import { Persona } from '../entidades/persona';
import { Tarjeta } from '../entidades/tarjeta';
import { ResTarjeta } from '../entidades/resTarjeta';
import { RegistrodatosService } from '../entidades/registrodatos';

@Injectable({
  providedIn: 'root'
})
export class OperacionesService {

  rutaservicio = 'http://localhost:8080/ServAuten/app/operacion/login';
  rutaservicioversion = 'http://172.20.74.124:8080/ServAuten/app/operacion/login';
  rutaservicioTarjeta = 'http://172.20.74.124:8080/ServAuten/app/operacion/autenticar';
  rutaservicioRegistro = 'http://localhost:8080/ServAuten/app/serviciosregistro/ingresarregistro';
  rutasserviciosModificacion = "http://localhost:8080/ServAuten/app/serviciosregistro/modificarregistro";
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

}
