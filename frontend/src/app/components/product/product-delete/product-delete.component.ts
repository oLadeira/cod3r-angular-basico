import { Observable } from 'rxjs';
import { ProductService } from './../product.service';
import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Product } from '../product.model';

@Component({
  selector: 'app-product-delete',
  templateUrl: './product-delete.component.html',
  styleUrls: ['./product-delete.component.css']
})
export class ProductDeleteComponent implements OnInit {

  product!: Product

  constructor(private productService: ProductService, private router: Router, private route: ActivatedRoute) { }

  ngOnInit(): void {
    const url = this.route.snapshot.paramMap.get('id')
    this.productService.readById(url!).subscribe(product => {
      this.product = product
    });
  }

  deleteProduct(): void{
    this.productService.delete(this.product.id!).subscribe(() => {
      this.productService.showMessage("Produto Deletado!")
      this.cancel();
    });
  }

  cancel(): void{
    this.router.navigate(["/products"]);
  }

}
