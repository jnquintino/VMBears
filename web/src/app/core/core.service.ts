import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { catchError, tap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root',
})
export class CoreService<T> {
  static apiUrl = 'http://localhost:8080';

  isLoadingCount = 0;

  constructor(private http: HttpClient) { }

  private queryString(query: any = {}) {
    let queryString = '';
    const keys = Object.keys(query);
    for (const key of keys) {
      queryString += (queryString ? '&' : '?') + key + '=' + query[key];
    }
    return queryString;
  }

  post<T>(url: string, data: any = {}, token: any = undefined): Observable<T | null> {
    this.isLoadingCount++;
    return this.http.post<T>(CoreService.apiUrl + url, data)
      .pipe(tap(() => this.isLoadingCount--), catchError(() => {
        this.isLoadingCount--;
        return of(null);
      }));
  }

  get<T>(url: string, query: any = {}, token: any = undefined): Observable<T | null> {
    this.isLoadingCount++;
    return this.http.get<T>(CoreService.apiUrl + url + this.queryString(query))
      .pipe(tap(() => this.isLoadingCount--), catchError(() => {
        this.isLoadingCount--;
        return of(null);
      }));
  }

  put<T>(url: string, data: any = {}, token: any = undefined): Observable<T | null> {
    this.isLoadingCount++;
    return this.http.put<T>(CoreService.apiUrl + url, data)
      .pipe(tap(() => this.isLoadingCount--), catchError(() => {
        this.isLoadingCount--;
        return of(null);
      }));
  }

  delete<T>(url: string, query: any = {}, token: any = undefined): Observable<T | null> {
    this.isLoadingCount++;
    return this.http.delete<T>(CoreService.apiUrl + url + this.queryString(query))
      .pipe(tap(() => this.isLoadingCount--), catchError(() => {
        this.isLoadingCount--;
        return of(null);
      }));
  }

}
