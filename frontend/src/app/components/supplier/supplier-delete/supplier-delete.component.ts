import { ActivatedRoute, Router } from '@angular/router';
import { SupplierService } from './../supplier.service';
import { Supplier } from './../supplier.model';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-supplier-delete',
  templateUrl: './supplier-delete.component.html',
  styleUrls: ['./supplier-delete.component.css']
})
export class SupplierDeleteComponent implements OnInit {

  supplier!: Supplier;

  constructor(private supplierService: SupplierService, private router: Router ,private route: ActivatedRoute) { }

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get("id");
    this.supplierService.readById(id!).subscribe(supplier => {
      this.supplier = supplier;
    })
  }

  deleteSupplier(): void{
    this.supplierService.deleteSupplier(this.supplier.id!).subscribe(() => {
      this.supplierService.showMessage("Fornecedor Deletado!");
      this.cancel();
    })
  }

  cancel(): void{
    this.router.navigate(["/suppliers"]);
  }

}
