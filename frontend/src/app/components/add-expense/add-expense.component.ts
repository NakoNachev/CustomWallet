import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Expense } from 'src/app/models/expense';
import { ExpenseType } from 'src/app/models/expenseType';
import { ExpenseTypeService } from 'src/app/services/expense-type.service';
import { ExpenseService } from 'src/app/services/expense.service';

@Component({
  selector: 'app-add-expense',
  templateUrl: './add-expense.component.html',
  styleUrls: ['./add-expense.component.css']
})
export class AddExpenseComponent implements OnInit {

  public title: string = "Add expense";
  public expenseTypes: string[] = [];
  expenseForm: FormGroup
  expenseTypeForm: FormGroup

  constructor(
    private expenseTypeService: ExpenseTypeService,
    private expenseService: ExpenseService,
    private fb: FormBuilder
    ) {

    this.expenseForm = this.fb.group({
      amount: ['', [Validators.required, Validators.min(0)]],
      description: ['', Validators.required],
      date: ['', Validators.required],
      type: ['', Validators.required]
    });

    this.expenseTypeForm = this.fb.group({
      expenseTypeDescription:  ['', Validators.required]
    })
   }

  ngOnInit(): void {
    this.expenseTypeService.getExpenseTypes().subscribe((data) =>{
      if (data){
        data.forEach(element => {
          this.expenseTypes.push(element.expenseTypeDescription)
        });
      }
    })
  }

  async submitExpenseForm(){
    if (this.expenseForm.valid) {
      let newExpense: Expense = {expenseAmount: 0, expenseDescription: "", expenseDate: new Date(), expenseTypeId: null}
      
      newExpense.expenseAmount = this.expenseForm.value.amount
      newExpense.expenseDescription = this.expenseForm.value.description
      newExpense.expenseDate = this.expenseForm.value.date
      await this.expenseTypeService.getExpenseTypeByDescription(this.expenseForm.value.type).toPromise().then((data) =>{
        if (data) {
          newExpense.expenseTypeId = data.expenseTypeId
        } else {
          newExpense.expenseTypeId = null
        }
      })
      console.log("newExpense", newExpense)
      this.expenseService.saveExpense(newExpense).subscribe((res) => {
        console.log("response", res)
      })
    }
  }

  async submitExpenseTypeForm(){
    if (this.expenseTypeForm.valid) {
      console.log("valid")
      let newExpenseType: ExpenseType = {expenseTypeDescription: ""}
      console.log("vlaiue", this.expenseTypeForm.value)
      newExpenseType.expenseTypeDescription = this.expenseTypeForm.value.expenseTypeDescription
      this.expenseTypeService.saveExpenseType(newExpenseType).subscribe()
    }
  }

}
