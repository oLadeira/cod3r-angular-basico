import { Observable } from 'rxjs';
import { Supplier } from './supplier.model';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SupplierService {

  baseUrl = "http://localhost:8080/fornecedores";

  constructor(private http: HttpClient) { }

  readSuppliers(){
    this.http.get<Supplier[]>(this.baseUrl);
  }

}
