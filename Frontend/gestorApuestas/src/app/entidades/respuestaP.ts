import { Partido } from './partidos';
import { Tarjeta } from './tarjeta';

export interface RespuestaP {
    codigo?: number;
    mensajeE?: string;
    partidos?: Partido[];
    info?: Tarjeta;
}
