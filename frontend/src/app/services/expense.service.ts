import { Injectable } from '@angular/core';
import { Expense } from '../models/expense';
import { ApiService } from './api.service';

@Injectable({
  providedIn: 'root'
})
export class ExpenseService {

  constructor(private apiService: ApiService) { }

  public saveExpense(expense: Expense) {
    return this.apiService.post("/api/v1/expense", expense)
  }
}
