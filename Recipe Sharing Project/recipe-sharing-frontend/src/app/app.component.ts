import { Component, OnInit } from '@angular/core';
import { AuthService } from './services/Auth/auth.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'recipe-sharing-frontend';

  constructor(public authService:AuthService){

  }

  user:any;

  ngOnInit(): void {
    this.authService.getUserProfile().subscribe({
      next: (data) => console.log('req user', data),
      error: (error) => console.log('error', error),
    });
    this.authService.authSubject.subscribe((auth) => {
      console.log('auth object value', auth);
      this.user = auth.user;
    });
  }
}
