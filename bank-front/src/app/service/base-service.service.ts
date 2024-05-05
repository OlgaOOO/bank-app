import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { BankDto } from '../models/BankDto';

@Injectable({
  providedIn: 'root'
})
export class BaseServiceService {

  constructor(private http: HttpClient) { }

  getDeposit(calcDto: BankDto): Observable<BankDto[]> {
    var url = `bank/deposit`;
    return this.http.post<BankDto[]>( url, calcDto );
  }

  getAllDeposit(): Observable<BankDto[]> {
    var url = `bank/deposit`;
    return this.http.get<BankDto[]>( url );
  }

}

