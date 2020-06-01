import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})

export class RegistrodatosService {
  cedula ?: number; //pk
  nombre ?: string;
  apellido ?: string;
  correo ?: string;
  contrasena ?: string;

  //mensajeE: string;
  //codigo: number;
  //info: RegistrodatosService;
}
