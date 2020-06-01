import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { InicioComponent } from './componentes/inicio/inicio.component';
import { SesionComponent } from './componentes/sesion/sesion.component';
import { RegistroComponent } from './componentes/registro/registro.component';
import { TarjetaComponent } from './componentes/tarjeta/tarjeta.component';
<<<<<<< HEAD
import {ModificarComponent} from './componentes/modificar/modificar.component';
=======
import { PartidosComponent } from './componentes/partidos/partidos.component';
import { InfoTarjetaComponent } from './componentes/info-tarjeta/info-tarjeta.component';
import { ApuestaComponent } from './componentes/apuesta/apuesta.component';
>>>>>>> a75b387b1dd7bd715e08cc0adce4df319c38b2a3


const routes: Routes = [
  { path: 'inicio', component: InicioComponent},
  { path: 'inicioSesion', component: SesionComponent},
  { path: 'registro', component: RegistroComponent},
  { path: 'tarjeta', component: TarjetaComponent},
<<<<<<< HEAD
  { path: 'modificar', component: ModificarComponent},
  { path: '**', redirectTo: 'tarjeta'},
=======
  { path: 'partidosF', component: PartidosComponent},
  { path: 'infoTarjeta', component: InfoTarjetaComponent},
  { path: 'apuesta', component: ApuestaComponent},
  { path: '**', redirectTo: 'inicio'},
>>>>>>> a75b387b1dd7bd715e08cc0adce4df319c38b2a3
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
