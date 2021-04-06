import { Injectable } from '@angular/core';
import { Expense } from '../models/expense';
import { ApiService } from './api.service';

@Injectable({
  providedIn: 'root'
})
export class ExpenseService {

  constructor(private apiService: ApiService) { }

  public getExpenses() {
    return this.apiService.get("/api/v1/expense")
  }

  public getExpensesWithExpenseTypeDescription() {
    return this.apiService.get("/api/v1/expense/mappedExpenseTypeDescription")
  }

  public saveExpense(expense: Expense) {
    return this.apiService.post("/api/v1/expense", expense)
  }

  public deleteExpenseById(expenseId: string) {
    return this.apiService.delete(`/api/v1/expense/${expenseId}`)
  }
}
