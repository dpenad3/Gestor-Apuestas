import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { InicioComponent } from './componentes/inicio/inicio.component';
import { SesionComponent } from './componentes/sesion/sesion.component';
import { RegistroComponent } from './componentes/registro/registro.component';
import { TarjetaComponent } from './componentes/tarjeta/tarjeta.component';
import {ModificarComponent} from './componentes/modificar/modificar.component';
import { PartidosComponent } from './componentes/partidos/partidos.component';

const routes: Routes = [
  { path: 'inicio', component: InicioComponent},
  { path: 'inicioSesion', component: SesionComponent},
  { path: 'registro', component: RegistroComponent},
  { path: 'tarjeta', component: TarjetaComponent},
  { path: 'modificar', component: ModificarComponent},
  { path: 'partidosF', component: PartidosComponent},
  { path: '**', redirectTo: 'inicio'},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
