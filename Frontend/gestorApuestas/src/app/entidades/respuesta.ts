import { Persona } from './persona';

export interface Respuesta {
    cedula: number;
    contrasena: string;
    mensajeE: string;
    codigo: number;
    info: Persona;

}
