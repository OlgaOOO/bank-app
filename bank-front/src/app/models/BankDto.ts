export class BankDto {
    name: string | null;
    target: number;
    months: number;
    risk: number;
    percent: number;
  
    constructor() {
      this.name = null;
      this.target = 0;
      this.months = 0;
      this.risk = 0;
      this.percent = 0;
    }
  }