import { Supplier } from './../supplier/supplier.model';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { SupplierService } from '../supplier/supplier.service';

@Injectable({
  providedIn: 'root'
})
export class DropdownService {

  baseUrl = "http://localhost:8080/fornecedores";

  constructor(private http: HttpClient) { }


  readFornecedores(){
    return this.http.get<Supplier[]>(this.baseUrl);
  }

}
