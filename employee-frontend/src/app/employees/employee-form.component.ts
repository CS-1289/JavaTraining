import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, Router, RouterLink } from '@angular/router';
import { EmployeeService } from './employee.service';
import { Employee } from './employee';

@Component({
  standalone: true,
  imports: [CommonModule, FormsModule, RouterLink],
  template: `
    <section class="form-card"><a routerLink="/employees" class="back">← Back to employees</a><p class="eyebrow">EMPLOYEE MANAGEMENT</p><h1>{{ editing ? 'Edit employee' : 'Add employee' }}</h1><p class="subtitle">Keep your employee directory accurate and up to date.</p><p *ngIf="error" class="error">{{ error }}</p>
      <form (ngSubmit)="save()"><label>Name<input name="empName" [(ngModel)]="employee.empName" required></label><label>Department<input name="department" [(ngModel)]="employee.department" required></label><label>Salary<input name="salary" type="number" min="0" [(ngModel)]="employee.salary" required></label><div class="actions"><a routerLink="/employees">Cancel</a><button [disabled]="saving">{{ saving ? 'Saving...' : 'Save employee' }}</button></div></form>
    </section>
  `,
  styles: [`
    .form-card{max-width:580px;background:#fff;padding:32px;border-radius:16px;box-shadow:0 10px 28px #0f172a14}.back{display:inline-block;margin-bottom:26px;text-decoration:none;color:#2563eb;font-weight:600}.eyebrow{color:#2563eb;font-size:.75rem;font-weight:800;letter-spacing:.09em;margin:0}.form-card h1{margin:6px 0}.subtitle{color:#64748b;margin:0 0 24px}label{display:block;margin-top:18px;font-weight:700;color:#334155}input{display:block;width:100%;box-sizing:border-box;margin-top:7px;padding:11px 12px;border:1px solid #cbd5e1;border-radius:8px;outline:none}input:focus{border-color:#2563eb;box-shadow:0 0 0 3px #dbeafe}.actions{display:flex;justify-content:space-between;align-items:center;margin-top:28px}.actions a{color:#475569;text-decoration:none}.actions button{padding:11px 16px;border:0;border-radius:8px;background:#2563eb;color:#fff;font-weight:700;cursor:pointer}.actions button:disabled{opacity:.65}.error{color:#b91c1c;background:#fef2f2;padding:10px 12px;border-radius:8px}
  `]
})
export class EmployeeFormComponent implements OnInit {
  employee: Employee = { empName: '', department: '', salary: 0 }; editing = false; saving = false; error = ''; private id?: number;
  constructor(private route: ActivatedRoute, private router: Router, private employeesApi: EmployeeService) {}
  ngOnInit(): void { const rawId = this.route.snapshot.paramMap.get('id'); if (rawId) { this.id = Number(rawId); this.editing = true; this.employeesApi.getById(this.id).subscribe({ next: e => this.employee = e, error: () => this.error = 'Employee not found.' }); } }
  save(): void { this.saving = true; const request = this.editing && this.id ? this.employeesApi.update(this.id, this.employee) : this.employeesApi.create(this.employee); request.subscribe({ next: () => this.router.navigateByUrl('/employees'), error: () => { this.error = 'Save failed.'; this.saving = false; } }); }
}
