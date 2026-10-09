import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';
import { EmployeeService } from './employee.service';
import { Employee } from './employee';

@Component({
  standalone: true,
  imports: [CommonModule, RouterLink],
  template: `
    <section class="page-header"><div><p class="eyebrow">TEAM DIRECTORY</p><h1>Employees</h1><p>View and manage everyone in your organisation.</p></div><a routerLink="/employees/new" class="primary">+ Add employee</a></section>
    <p *ngIf="error" class="error">{{ error }}</p><p *ngIf="loading" class="status">Loading employees...</p>
    <div class="table-wrap" *ngIf="!loading && !error"><table><thead><tr><th>ID</th><th>Employee</th><th>Department</th><th>Salary</th><th class="actions-heading">Actions</th></tr></thead><tbody>
      <tr *ngFor="let employee of employees"><td><span class="id-chip">#{{ employee.empId }}</span></td><td class="name">{{ employee.empName }}</td><td>{{ employee.department }}</td><td>{{ employee.salary | currency:'INR':'symbol':'1.2-2' }}</td><td class="actions"><a [routerLink]="['/employees', employee.empId, 'edit']">Edit</a><button class="delete" (click)="remove(employee)">Delete</button></td></tr>
      <tr *ngIf="employees.length === 0"><td colspan="5" class="empty">No employees found. Add your first employee to get started.</td></tr>
    </tbody></table></div>
  `,
  styles: [`
    .page-header{display:flex;justify-content:space-between;align-items:end;gap:16px;margin-bottom:28px}.eyebrow{margin:0;color:#2563eb;font-size:.75rem;font-weight:800;letter-spacing:.09em}.page-header h1{margin:5px 0;font-size:2rem;letter-spacing:-.04em}.page-header p:not(.eyebrow){margin:0;color:#64748b}.primary{background:#2563eb;color:#fff;padding:11px 15px;border-radius:8px;text-decoration:none;font-weight:700;white-space:nowrap;box-shadow:0 4px 10px #2563eb33}.table-wrap{background:#fff;border:1px solid #e2e8f0;border-radius:14px;overflow:auto;box-shadow:0 8px 24px #0f172a0d}table{width:100%;border-collapse:collapse}th,td{padding:16px;text-align:left;border-bottom:1px solid #e2e8f0}th{background:#f8fafc;color:#475569;font-size:.75rem;letter-spacing:.04em;text-transform:uppercase}.name{font-weight:700}.id-chip{font-size:.8rem;background:#eff6ff;color:#1d4ed8;padding:5px 8px;border-radius:99px}.actions-heading,.actions{text-align:right}.actions a,.delete{font:inherit;font-weight:600;text-decoration:none;color:#2563eb;background:none;border:0;cursor:pointer}.delete{margin-left:16px;color:#dc2626}.empty{text-align:center;color:#64748b;padding:36px}.error{color:#b91c1c;background:#fef2f2;padding:12px;border-radius:8px}.status{color:#64748b}@media(max-width:600px){.page-header{align-items:start;flex-direction:column}.actions-heading,.actions{text-align:left}}
  `]
})
export class EmployeeListComponent implements OnInit {
  employees: Employee[] = []; loading = true; error = '';
  constructor(private employeesApi: EmployeeService) {}
  ngOnInit(): void { this.load(); }
  load(): void { this.loading = true; this.employeesApi.getAll().subscribe({ next: employees => { this.employees = employees; this.loading = false; }, error: () => { this.error = 'Could not reach the API. Start employeeapi on port 8091.'; this.loading = false; } }); }
  remove(employee: Employee): void { if (employee.empId && confirm(`Delete ${employee.empName}?`)) this.employeesApi.delete(employee.empId).subscribe({ next: () => this.load(), error: () => this.error = 'Delete failed.' }); }
}
