import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { RespuestaP } from '../entidades/respuestaP';

@Injectable({
  providedIn: 'root'
})
export class PartidosService {

  rutaListaPartidos = 'http://localhost:8080/servPartidos/app/operacion/partidosfutbol';
  rutaRealizarApuesta = 'http://localhost:8080/servPartidos/app/operacion/realizarapuesta';

  constructor(private http: HttpClient) { }

  servListaPartidos(): Promise<RespuestaP> {
      return this.http.get<RespuestaP>(`${this.rutaListaPartidos}`).toPromise();
  }

  servRealizarApuesta( id_partido: number, dinero: number, porcentaje: number): Promise<RespuestaP> {
    const info = {
      cedula_jugador: 1007228578,
      id_partido,
      dinero,
      porcentaje
    };
    return this.http.post<RespuestaP>(`${this.rutaRealizarApuesta}`, info).toPromise();
  }
}
