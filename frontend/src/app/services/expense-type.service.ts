import { HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ExpenseType } from '../models/expenseType';
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
    return this.apiService.get(`/api/v1/expense-type/id/${expenseTypeId}`)
  }

  getExpenseTypeByDescription(description: string) {
    return this.apiService.get(`/api/v1/expense-type/description/${description}`)
  }

  saveExpenseType(expenseType: ExpenseType){
    return this.apiService.post('/api/v1/expense-type', expenseType)
  }
}
