import { Component } from '@angular/core';
import { RouterLink, RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, RouterLink],
  template: `
    <header class="topbar">
      <div class="nav-content"><a routerLink="/" class="brand">PeopleFlow</a><nav><a routerLink="/">Employees</a><a routerLink="/employees/new" class="add-link">+ Add employee</a></nav></div>
    </header>
    <main class="content"><router-outlet /></main>
  `,
  styles: [`
    .topbar{background:linear-gradient(135deg,#0f4c81,#2563eb);box-shadow:0 3px 14px #0f172a24}.nav-content{max-width:1100px;height:64px;margin:auto;padding:0 24px;display:flex;align-items:center;justify-content:space-between}.brand{color:#fff;font-size:1.2rem;font-weight:800;text-decoration:none;letter-spacing:-.02em}nav{display:flex;align-items:center;gap:18px}nav a{color:#dbeafe;text-decoration:none;font-weight:600}.add-link{border:1px solid #93c5fd;border-radius:7px;padding:8px 11px;color:#fff}.content{max-width:1100px;margin:0 auto;padding:40px 24px}@media(max-width:560px){.nav-content{padding:0 16px}.content{padding:28px 16px}nav>a:first-child{display:none}}
  `]
})
export class AppComponent {}
