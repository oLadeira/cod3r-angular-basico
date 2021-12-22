import { catchError, Observable, throwError } from 'rxjs';
import { Supplier } from './supplier.model';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
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

  readById(id: string): Observable<Supplier>{
    const url = `${this.baseUrl}/${id}`;
    return this.http.get<Supplier>(url);
  }

  createSupplier(supplier: Supplier): Observable<Supplier>{
    return this.http.post<Supplier>(this.baseUrl, supplier);
  }

  updateSupplier(supplier: Supplier): Observable<Supplier>{
    const url = `${this.baseUrl}/${supplier.id}`;
    return this.http.put<Supplier>(url, supplier);
  }

  deleteSupplier(id: number): Observable<Supplier>{
    const url = `${this.baseUrl}/${id}`;
    return this.http.delete<Supplier>(url);
  }

}
