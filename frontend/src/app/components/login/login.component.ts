import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  public username: String;
  public password: String;
  public hide:boolean = true;
  public title: String = "Login";
  constructor() { }

  ngOnInit(): void {
  }

}
