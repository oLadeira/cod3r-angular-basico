import { Router } from '@angular/router';
import { SupplierService } from './../supplier.service';
import { Component, OnInit } from '@angular/core';
import { Supplier } from '../supplier.model';

@Component({
  selector: 'app-supplier-create',
  templateUrl: './supplier-create.component.html',
  styleUrls: ['./supplier-create.component.css']
})
export class SupplierCreateComponent implements OnInit {

  supplier: Supplier={
    tradingName: '',
    cnpj: ''
  }

  constructor(private supplierService: SupplierService, private router: Router) { }

  ngOnInit(): void {
  }

  createSupplier():void{
    this.supplierService.createSupplier(this.supplier).subscribe(() => {
      this.supplierService.showMessage("Fornecedor criado!")
    });
    this.cancel();
    console.log(this.supplier);
  }



  cancel():void{
    this.router.navigate(["/suppliers"]);
  }

}
