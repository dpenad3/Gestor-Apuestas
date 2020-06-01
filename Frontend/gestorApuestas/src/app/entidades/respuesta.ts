import { Persona } from './persona';
import { RegistrodatosService } from './registrodatos';
export interface Respuesta {
    cedula: number;
    contrasena: string;
    mensajeE: string;
    codigo: number;
    info: Persona;
    nombre ?: string;
    apellido ?: string;
    correo ?: string;


}
