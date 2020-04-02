import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Respuesta } from '../entidades/respuesta';
import { Persona } from '../entidades/persona';
import { Tarjeta } from '../entidades/tarjeta';
import { ResTarjeta } from '../entidades/resTarjeta';

@Injectable({
  providedIn: 'root'
})
export class OperacionesService {

  rutaservicio = 'http://localhost:8080/ServAuten/app/operacion/login';
  rutaservicioversion = 'http://172.20.74.124:8080/ServAuten/app/operacion/login';
  rutaservicioTarjeta = 'http://172.20.74.124:8080/ServAuten/app/operacion/autenticar';
  persona: Persona;
  miTarjeta: Tarjeta;

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

}
