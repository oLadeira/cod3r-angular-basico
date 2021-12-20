import { Observable } from 'rxjs';
import { Supplier } from './supplier.model';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';

@Injectable({
  providedIn: 'root'
})
export class SupplierService {

  baseUrl = "http://localhost:8080/fornecedores/";

  constructor(private snackBar: MatSnackBar, private http: HttpClient) { }

  showMessage(msg: string, isError: boolean = false): void{
    this.snackBar.open(msg, "X", {
      duration: 3000,
      horizontalPosition: "right",
      verticalPosition: "top",
      panelClass: isError ? ['msg-error'] : ['msg-success'] //classe css    
    });
  }

  readSuppliers(): Observable<Supplier[]>{
    return this.http.get<Supplier[]>(this.baseUrl);
  }

  createSupplier(supplier: Supplier): Observable<Supplier>{
    return this.http.post<Supplier>(this.baseUrl, supplier);
  }

}
