import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { VehicleService } from '../../services/vehicle.service';

@Component({
  selector: 'app-vehicles',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './vehicles.component.html'
})
export class VehiclesComponent implements OnInit {

  vehicles: any;

  constructor(private service: VehicleService) {}

  ngOnInit(): void {
    this.loadVehicles();
  }

  loadVehicles() {
    this.service.getAll().subscribe(data => {
      this.vehicles = data;
    });
  }

  delete(id: number) {
    this.service.delete(id).subscribe(() => {
      this.loadVehicles();
    });
  }
}
