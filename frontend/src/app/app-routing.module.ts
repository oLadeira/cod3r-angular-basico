import { SupplierDeleteComponent } from './components/supplier/supplier-delete/supplier-delete.component';
import { SupplierUpdateComponent } from './components/supplier/supplier-update/supplier-update.component';
import { SupplierCreateComponent } from './components/supplier/supplier-create/supplier-create.component';
import { SupplierCrudComponent } from './views/supplier-crud/supplier-crud/supplier-crud.component';
import { ProductDeleteComponent } from './components/product/product-delete/product-delete.component';
import { ProductUpdateComponent } from './components/product/product-update/product-update.component';
import { ProductReadComponent } from './components/product/product-read/product-read.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { ProductCreateComponent } from './components/product/product-create/product-create.component';
import { HomeComponent } from './views/home/home.component';
import { ProductCrudComponent } from './views/product-crud/product-crud.component';
import { supportsPassiveEventListeners } from '@angular/cdk/platform';

const routes: Routes = [
  {
    path: "",
    component: HomeComponent
  },
  {
    path: "products",
    component: ProductCrudComponent
  },
  { 
    path: "products/create",
    component: ProductCreateComponent
  },
  {
    path: "products/update/:id",
    component: ProductUpdateComponent
  },
  {
    path: "products/delete/:id",
    component: ProductDeleteComponent
  },
  {
    path: "suppliers",
    component: SupplierCrudComponent
  },
  {
    path: "suppliers/create",
    component: SupplierCreateComponent
  },
  {
    path: "suppliers/update/:id",
    component: SupplierUpdateComponent
  },
  {
    path: "suppliers/delete/:id",
    component: SupplierDeleteComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
