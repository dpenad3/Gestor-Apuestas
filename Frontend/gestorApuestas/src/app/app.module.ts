import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
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
import { PartidosComponent } from './componentes/partidos/partidos.component';
import { TableModule } from 'primeng/table';
import { CardModule } from 'primeng/card';
import {DialogModule} from 'primeng/dialog';
import { ModificarComponent } from './componentes/modificar/modificar.component';

@NgModule({
  declarations: [
    AppComponent,
    InicioComponent,
    NavbarComponent,
    SesionComponent,
    RegistroComponent,
    TarjetaComponent,
    ModificarComponent,
    PartidosComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    TableModule,
    CardModule,
    DialogModule,
    BrowserAnimationsModule,
  ],
  providers: [
    OperacionesService,
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
