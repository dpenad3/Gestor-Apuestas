import { BrowserModule } from '@angular/platform-browser';
import { NgModule, Component } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { InicioComponent } from './componentes/inicio/inicio.component';
import { NavbarComponent } from './componentes/navbar/navbar.component';
import { SesionComponent } from './componentes/sesion/sesion.component';
import { RegistroComponent } from './componentes/registro/registro.component';
import { TarjetaComponent } from './componentes/tarjeta/tarjeta.component';
import { OperacionesService } from './servicios/operaciones.service';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { Routes, RouterModule } from '@angular/router';
import { ModificarComponent } from './componentes/modificar/modificar.component';

const appRoutes: Routes = [
  {path: '', component: RegistroComponent},
  {path: 'registrar', component: RegistroComponent},
  {path: 'modificar', component: ModificarComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    InicioComponent,
    NavbarComponent,
    SesionComponent,
    RegistroComponent,
    TarjetaComponent,
    ModificarComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterModule.forRoot(appRoutes),
    HttpClientModule,
    FormsModule,
  ],
  providers: [
    OperacionesService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
