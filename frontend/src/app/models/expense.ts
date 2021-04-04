import { ExpenseType } from "./expenseType";

export interface Expense {
    expenseAmount: number;
    expenseDescription: string;
    expenseDate: Date;
    expenseTypeId: number;

}