import { Supplier } from './../supplier/supplier.model';
export interface Product{
    id?: number,
    name: string,
    price?: number,
    supplier?: number
    //supplier: Supplier
}