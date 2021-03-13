import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

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
  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  login(){
    this.router.navigate(['/home'])
  }

}
