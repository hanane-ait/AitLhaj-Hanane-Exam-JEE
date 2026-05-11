import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AgencyService } from '../../services/agency.service';

@Component({
  selector: 'app-agencies',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './agencies.component.html'
})
export class AgenciesComponent implements OnInit {

  agencies: any;

  constructor(private service: AgencyService) {}

  ngOnInit(): void {
    this.load();
  }

  load() {
    this.service.getAll().subscribe(data => {
      this.agencies = data;
    });
  }
}
