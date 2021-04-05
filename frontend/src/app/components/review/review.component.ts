import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { Expense } from 'src/app/models/expense';
import { ExpenseService } from 'src/app/services/expense.service';

@Component({
  selector: 'app-review',
  templateUrl: './review.component.html',
  styleUrls: ['./review.component.css']
})
export class ReviewComponent implements OnInit {

  displayedColumns: string[] = ['expenseAmount', 'expenseDescription', 'expenseDate', 'expenseTypeId', 'test'];
  dataSource: MatTableDataSource<Expense>;
  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  constructor(private expenseService: ExpenseService) {

   }

 ngOnInit(): void {
  this.expenseService.getExpenses().toPromise().then((data) =>{
    if (data) {
      console.log("data", data)
      this.dataSource = new MatTableDataSource(data)
      this.dataSource.paginator = this.paginator;
      this.dataSource.sort = this.sort;
    }
  })
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }

  private async deleteExpense(expenseId) {
    await this.expenseService.deleteExpenseById(expenseId).toPromise().then((res) => {
      location.reload()
    })
  }


}
