import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { AuthService } from 'src/app/services/Auth/auth.service';

@Component({
  selector: 'app-auth',
  templateUrl: './auth.component.html',
  styleUrls: ['./auth.component.css'] 
})
export class AuthComponent {
  isRegister= false;

  constructor(public authService:AuthService){
  }

  registrationForm = new FormGroup({
    fullName: new FormControl("",[Validators.required]),
    email: new FormControl("",[Validators.required,Validators.email]),
    password: new FormControl("",[Validators.required,Validators.minLength(6)])
  })

  loginForm = new FormGroup({
    email: new FormControl("",[Validators.required,Validators.email]),
    password: new FormControl("",[Validators.required])
  })

  handleRegister(){
    console.log("register", this.registrationForm.value);
    this.authService.register(this.registrationForm.value).subscribe({
      next:(response)=>{
        localStorage.setItem("jwt", response.jwt);
        this.authService.getUserProfile().subscribe();
        console.log("signup success",response)
      }
    })
  }
  
  handleLogin(){
    console.log("login", this.loginForm.value)
    this.authService.login(this.loginForm.value).subscribe({
      next:(response)=>{
        localStorage.setItem("jwt", response.jwt);
        this.authService.getUserProfile().subscribe();
        console.log("login success",response)
      }
    })
  }

  togglePanel(){
    this.isRegister = !this.isRegister;
  }
}
