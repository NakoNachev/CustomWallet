import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { environment } from 'src/environments/environment';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  constructor(private http: HttpClient) { }

  get(path: string, params: HttpParams = new HttpParams(), headers = new HttpHeaders()): Observable<any> {
    return this.http.get(`${environment.api_url}${path}`, {params, headers}).pipe(catchError(this.formatErrors));
  }

  getPromise(path: string, params: HttpParams = new HttpParams()): Promise<any> {
    return this.http.get(`${environment.api_url}${path}`, {params}).pipe(catchError(this.formatErrors)).toPromise();
  }


  post(path: string, data: any, options?: any): Observable<any> {
    return this.http.post(`${environment.api_url}${path}`, data, options)
      .pipe(
        catchError(this.formatErrors),
      );
  }

  put(path: string, data: any, options?: any) {
    return this.http.put(`${environment.api_url}${path}`, data, options).pipe(catchError(this.formatErrors));
  }

  delete(path: string, options?: any) {
    return this.http.delete(`${environment.api_url}${path}`, options).pipe(catchError(this.formatErrors));
  }

  private formatErrors(error: any) {
    return throwError((typeof error.error === 'string' || error.error instanceof String) ? JSON.parse(error.error) : error.error);
  }
}
