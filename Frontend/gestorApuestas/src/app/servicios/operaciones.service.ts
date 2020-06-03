import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Respuesta } from '../entidades/respuesta';
import { Persona } from '../entidades/persona';
import { Tarjeta } from '../entidades/tarjeta';
import { RegistrodatosService } from '../entidades/registrodatos';
import { RespuestaP } from '../entidades/respuestaP';

@Injectable({
  providedIn: 'root'
})
export class OperacionesService {


  rutaservicio = 'http://localhost:8080/ServAuten/app/operacion/login';
  rutaservicioversion = 'http://172.20.74.124:8080/ServAuten/app/operacion/login';
  rutaservicioRegistro = 'http://localhost:8080/ServAuten/app/serviciosregistro/ingresarregistro';
  rutasserviciosModificacion = 'http://localhost:8080/ServAuten/app/serviciosregistro/modificarregistro';
  rutaservicioTarjeta = 'http://localhost:8080/servRegistrarTarjeta/app/operacion/registrarTarjeta';
  rutaservDarTarjeta = 'http://localhost:8080/servRegistrarTarjeta/app/operacion/darTarjeta';
  rutaRecargarTarjeta = 'http://localhost:8080/servRegistrarTarjeta/app/operacion/recargar';
  rutaListaPartidos = 'http://localhost:8080/servPartidos/app/operacion/partidosfutbol';
  rutaRealizarApuesta = 'http://localhost:8080/servPartidos/app/operacion/realizarapuesta';

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

  ingresarregistro(cedula: number, nombre: string, apellido: string, correo: string, contrasena: string): Promise<Respuesta> {
    const info = {
      cedula,
      nombre,
      apellido,
      correo,
      contrasena,
    };
    return this.http.post<Respuesta>(`${this.rutaservicioRegistro}`, info).toPromise();
  }

  modificarregistro(cedula: number, nombre: string, apellido: string, correo: string, contrasena: string): Promise<Respuesta> {
    const info = {
      cedula,
      nombre,
      apellido,
      correo,
      contrasena,
    };
    return this.http.put<Respuesta>(`${this.rutasserviciosModificacion}`, info).toPromise();
  }

 registrarTarjeta(numero_tarjeta: number, cv: number, fecha_ven: string, dinero: number ): Promise<RespuestaP> {
   const info = {
    numero_tarjeta,
    cv,
    cedula_jugador: sessionStorage.getItem('Cedula'),
    fecha_ven,
    dinero
   };
   return this.http.post<RespuestaP>(`${this.rutaservicioTarjeta}`, info).toPromise();
 }

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

 servListaPartidos(): Promise<RespuestaP> {
  return this.http.get<RespuestaP>(`${this.rutaListaPartidos}`).toPromise();
}

servRealizarApuesta( idPartido: number, dinero: number, porcentaje: number, idEquipo: number): Promise<RespuestaP> {
const info = {
  cedula_jugador: sessionStorage.getItem('Cedula'),
  id_partido: idPartido,
  dinero,
  porcentaje,
  id_equipo: idEquipo,
};
return this.http.post<RespuestaP>(`${this.rutaRealizarApuesta}`, info).toPromise();
}

}
