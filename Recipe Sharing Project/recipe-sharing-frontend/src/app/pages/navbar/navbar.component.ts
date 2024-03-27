import { Component } from '@angular/core';
import { AuthService } from 'src/app/services/Auth/auth.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent {

  constructor(private authService:AuthService){

  }
  
  user:any=null;
  
  ngOnInit(): void {
    this.authService.authSubject.subscribe((auth) => {
      console.log('auth object value', auth);
      this.user = auth.user;
    });
  }

  handleLogout(){
    this.authService.logout();
  }
}
