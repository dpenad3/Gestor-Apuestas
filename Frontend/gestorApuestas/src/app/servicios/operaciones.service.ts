import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Respuesta } from '../entidades/respuesta';
import { Persona } from '../entidades/persona';
import { Tarjeta } from '../entidades/tarjeta';
import { RespuestaP } from '../entidades/respuestaP';

@Injectable({
  providedIn: 'root'
})
export class OperacionesService {

  rutaservicio = 'http://localhost:8080/servRegistrarTarjeta/app/operacion/registrarTarjeta';
  rutaservicioversion = 'http://localhost:8080/servRegistrarTarjeta/app/operacion/registrarTarjeta';
  rutaservicioTarjeta = 'http://localhost:8080/servRegistrarTarjeta/app/operacion/registrarTarjeta';
  rutaservDarTarjeta = 'http://localhost:8080/servRegistrarTarjeta/app/operacion/darTarjeta';
  persona: Persona;
  miTarjeta: Tarjeta;

  constructor(private http: HttpClient) {
  }

 autenticar(nombre: string, clave: string): Promise<Respuesta> {
   const info = {
    nombre,
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

 registrarTarjeta(numero_tarjeta: number, cv: number, fecha_ven: string, dinero: number ): Promise<RespuestaP> {
   const info = {
    numero_tarjeta,
    cv,
    cedula_jugador: 1007228578,
    fecha_ven,
    dinero
   };
   return this.http.post<RespuestaP>(`${this.rutaservicio}`, info).toPromise();
 }

 serDarTarjeta(): Promise<RespuestaP> {
    const info = {
      cedula_jugador: 1007228578
    };
    return this.http.post<RespuestaP>(`${this.rutaservDarTarjeta}`, info).toPromise();
 }
}
