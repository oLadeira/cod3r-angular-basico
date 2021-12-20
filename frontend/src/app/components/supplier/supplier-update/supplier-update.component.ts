import { Router, ActivatedRoute } from '@angular/router';
import { SupplierService } from './../supplier.service';
import { Supplier } from './../supplier.model';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-supplier-update',
  templateUrl: './supplier-update.component.html',
  styleUrls: ['./supplier-update.component.css']
})
export class SupplierUpdateComponent implements OnInit {

  supplier!: Supplier;

  constructor(private supplierService: SupplierService, private router: Router, private route: ActivatedRoute) { }

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    this.supplierService.readById(id!).subscribe(supplier => {
      this.supplier = supplier;
    })
  }

  updateSupplier():void{
    this.supplierService.updateSupplier(this.supplier).subscribe(()=>{
      this.supplierService.showMessage("Fornecedor Atualizado!");
      this.cancel();
    });
  }

  cancel():void{
    this.router.navigate(["/suppliers"])
  }

}
