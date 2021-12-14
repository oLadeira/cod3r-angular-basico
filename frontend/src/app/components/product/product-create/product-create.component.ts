import { ProductService } from './../product.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Product } from '../product.model';
import { isNull } from '@angular/compiler/src/output/output_ast';

@Component({
  selector: 'app-product-create',
  templateUrl: './product-create.component.html',
  styleUrls: ['./product-create.component.css']
})
export class ProductCreateComponent implements OnInit {

  product: Product = {
    name: '',
    price: 0.00,
    supplier: 1
  }

  constructor(private productService: ProductService, private router: Router ) { }

  ngOnInit(): void {
  }
  
  createProduct():void{
    this.productService.create(this.product).subscribe(() => {this.productService.showMessage("Produto criado!")});
    this.cancel();
  }

  cancel(): void{
    this.router.navigate(["/products"]);
  }
}
