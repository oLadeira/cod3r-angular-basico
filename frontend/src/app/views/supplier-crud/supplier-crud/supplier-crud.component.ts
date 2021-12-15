import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-supplier-crud',
  templateUrl: './supplier-crud.component.html',
  styleUrls: ['./supplier-crud.component.css']
})
export class SupplierCrudComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  navigateToSupplierCreate(){
    this.router.navigate(["/suppliers/create"]);
  }

}
