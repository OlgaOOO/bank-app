import { Component } from '@angular/core';
import { BankDto } from './models/BankDto';
import { BaseServiceService } from './service/base-service.service';
// import { MatTableDataSource } from '@angular/material/table';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  bankDto: BankDto = new BankDto();

  target: number = 4;
  months: number = 7;
  risk: number = 4;
  percent: number = 14;

  allDeposits: BankDto[] = [];
  deposits: BankDto[] = [];

  constructor(private baseService: BaseServiceService) {
    this.baseService.getAllDeposit().subscribe((results: BankDto[]) => {
      if (results) {
        this.allDeposits = results;
      }
    });
  }

  getGame() {
    this.bankDto.target = this.target;
    this.bankDto.months = this.months;
    this.bankDto.risk = this.risk;
    this.bankDto.percent = this.percent;
    this.baseService.getDeposit(this.bankDto).subscribe((results: BankDto[]) => {
      this.deposits = results;
    });
  }

}
