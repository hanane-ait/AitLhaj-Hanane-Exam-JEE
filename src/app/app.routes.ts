import { Routes } from '@angular/router';
import { VehiclesComponent } from './components/vehicles/vehicles.component';
import { AgenciesComponent } from './components/agencies/agencies.component';
import { LocationsComponent } from './components/locations/locations.component';

export const routes: Routes = [
  { path: '', redirectTo: 'vehicles', pathMatch: 'full' },
  { path: 'vehicles', component: VehiclesComponent },
  { path: 'agencies', component: AgenciesComponent },
  { path: 'locations', component: LocationsComponent }
];
