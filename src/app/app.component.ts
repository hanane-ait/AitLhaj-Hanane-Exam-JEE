import { Component } from '@angular/core';
import { RouterOutlet, RouterLink } from '@angular/router';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, RouterLink],
  template: `
    <nav>
      <a routerLink="/vehicles">Vehicles</a> |
      <a routerLink="/agencies">Agencies</a> |
      <a routerLink="/locations">Locations</a>
    </nav>

    <hr>

    <router-outlet></router-outlet>
  `
})
export class AppComponent {}
