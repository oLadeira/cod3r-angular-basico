import { DropdownService } from './../dropdown.service';
import { ActivatedRoute, Router } from '@angular/router';
import { ProductService } from './../product.service';
import { Component, OnInit } from '@angular/core';
import { Product } from '../product.model';
import { Supplier } from '../../supplier/supplier.model';


@Component({
  selector: 'app-product-update',
  templateUrl: './product-update.component.html',
  styleUrls: ['./product-update.component.css']
})
export class ProductUpdateComponent implements OnInit {

  product!: Product;

  suppliers!: Supplier[];

  constructor(private productService: ProductService, private dropdownService: DropdownService , private router: Router, private route: ActivatedRoute) { }

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    this.productService.readById(id!).subscribe(product => {
      this.product = product
    });

    this.dropdownService.readFornecedores().subscribe(dados => {
      this.suppliers = dados;
    })
  }

  updateProduct(): void{
    this.productService.update(this.product).subscribe(() => {
      this.productService.showMessage("Produto Atualizado!");
      this.cancel()
    });
  }

  cancel(): void{
    this.router.navigate(["/products"]);
  }

}
