import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-add-expense',
  templateUrl: './add-expense.component.html',
  styleUrls: ['./add-expense.component.css']
})
export class AddExpenseComponent implements OnInit {

  public title: string = "Kosten hinzufügen";
  public expenseTypes: string[] = ["Miete","Fitness"];

  constructor() { }

  ngOnInit(): void {
  }

}
