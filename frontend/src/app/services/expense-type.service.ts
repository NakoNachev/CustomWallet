import { HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ApiService } from './api.service';

@Injectable({
  providedIn: 'root'
})
export class ExpenseTypeService {

  constructor(private apiService: ApiService) { }

  getExpenseTypes(){
    return this.apiService.get('/api/v1/expense-type/')
  }

  getExpenseTypeById(expenseTypeId: string) {

    let params: HttpParams = new HttpParams()
    params.set("expenseTypeId",expenseTypeId)
    return this.apiService.get('/api/v1/expense-type/id/', params)
  }

  getExpenseTypeByDescription(description: string) {
    return this.apiService.get(`/api/v1/expense-type/description/${description}`)
  }
}
