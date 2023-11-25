import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { CrisisListComponent } from './crisis-list/crisis-list.component';
import { HeroesListComponent } from './heroes-list/heroes-list.component';
import { RouterOutlet, provideRouter } from '@angular/router';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { routes } from './app.routes';

@NgModule({
  declarations: [
    CrisisListComponent,
    HeroesListComponent,
    PageNotFoundComponent
  ],
  imports: [
    BrowserModule,
    RouterOutlet,
  ],
  providers: [provideRouter(routes)]
})
export class AppModule { }
