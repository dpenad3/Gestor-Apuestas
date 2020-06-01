import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { RespuestaP } from '../entidades/respuestaP';
import { Apuesta } from '../entidades/apuesta';

@Injectable({
  providedIn: 'root'
})
export class PartidosService {

  rutaListaPartidos = 'http://localhost:8080/servPartidos/app/operacion/partidosfutbol';
  rutaRealizarApuesta = 'http://localhost:8080/servPartidos/app/operacion/realizarapuesta';
  apuesta: Apuesta;

  constructor(private http: HttpClient) { }

  servListaPartidos(): Promise<RespuestaP> {
      return this.http.get<RespuestaP>(`${this.rutaListaPartidos}`).toPromise();
  }

  servRealizarApuesta( idPartido: number, dinero: number, porcentaje: number, idEquipo: number): Promise<RespuestaP> {
    const info = {
      cedula_jugador: 1007228578,
      id_partido: idPartido,
      dinero,
      porcentaje,
      id_equipo: idEquipo,
    };
    return this.http.post<RespuestaP>(`${this.rutaRealizarApuesta}`, info).toPromise();
  }

  realizarApuesta(idPartido: number, Porcentaje: number, idEquipo: number) {
    // this.apuesta.cedula_jugador = 1007228578;
    this.apuesta.id_partido = idPartido;
    this.apuesta.id_equipo = idEquipo;
    this.apuesta.porcentaje = Porcentaje;
  }

  darApuesta(): Apuesta {
    return this.apuesta;
  }
}
