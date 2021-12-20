import { Supplier } from './../supplier.model';
import { SupplierService } from './../supplier.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-supplier-read',
  templateUrl: './supplier-read.component.html',
  styleUrls: ['./supplier-read.component.css']
})
export class SupplierReadComponent implements OnInit {

  suppliers: Supplier[] = [];

  displayedColumns = ['id', 'tradingName', 'cnpj', 'action'];

  constructor(private supplierService: SupplierService) { }

  ngOnInit(): void {
    this.supplierService.readSuppliers().subscribe(suppliers => {
      this.suppliers = suppliers;
    });
  }

}
