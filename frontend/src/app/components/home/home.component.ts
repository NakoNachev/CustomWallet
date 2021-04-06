import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  navLinks = [
    {
      name: 'Expense Control',
      link: 'add-expense',
      icon: 'build'
    },
    {
      name: 'Expense History',
      link: 'review',
      icon: 'history'
    },
    {
      name: 'Analytics',
      link: 'review',
      icon: 'analytics'
    }
  ];
  constructor() { }

  ngOnInit(): void {
  }

}
