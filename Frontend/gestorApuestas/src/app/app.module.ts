import { BrowserModule } from '@angular/platform-browser';
<<<<<<< HEAD
import { NgModule, Component } from '@angular/core';

=======
import { NgModule } from '@angular/core';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
>>>>>>> a75b387b1dd7bd715e08cc0adce4df319c38b2a3
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
<<<<<<< HEAD
import { Routes, RouterModule } from '@angular/router';
import { ModificarComponent } from './componentes/modificar/modificar.component';

const appRoutes: Routes = [
  {path: '', component: RegistroComponent},
  {path: 'registrar', component: RegistroComponent},
  {path: 'modificar', component: ModificarComponent}
];
=======
import { PartidosComponent } from './componentes/partidos/partidos.component';
import { TableModule } from 'primeng/table';
import { PartidosService } from './servicios/partidos.service';
import { ApuestaComponent } from './componentes/apuesta/apuesta.component';
import { InfoTarjetaComponent } from './componentes/info-tarjeta/info-tarjeta.component';
import { CardModule } from 'primeng/card';
import {DialogModule} from 'primeng/dialog';
>>>>>>> a75b387b1dd7bd715e08cc0adce4df319c38b2a3

@NgModule({
  declarations: [
    AppComponent,
    InicioComponent,
    NavbarComponent,
    SesionComponent,
    RegistroComponent,
    TarjetaComponent,
<<<<<<< HEAD
    ModificarComponent,
=======
    PartidosComponent,
    ApuestaComponent,
    InfoTarjetaComponent,
>>>>>>> a75b387b1dd7bd715e08cc0adce4df319c38b2a3
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterModule.forRoot(appRoutes),
    HttpClientModule,
    FormsModule,
    TableModule,
    CardModule,
    DialogModule,
    BrowserAnimationsModule,
  ],
  providers: [
    OperacionesService,
    PartidosService,
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
