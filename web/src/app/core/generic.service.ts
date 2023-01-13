import {CoreService} from './core.service';
import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class GenericService<T> {
  // @ts-ignore
  service: CoreService<T>;
  url = '';

  get(id: string, token: any = undefined): Observable<T | null> {
    return this.service.get<T>('/' + this.url, {id}, token);
  }

  list(token: any = undefined): Observable<T[] | null> {
    return this.service.get<T[]>('/' + this.url + '/list', {}, token);
  }

  create(obj: T, token: any = undefined): Observable<T | null> {
    return this.service.post<T>('/' + this.url, obj, token);
  }

  update(obj: T, token: any = undefined): Observable<T | null> {
    return this.service.put<T>('/' + this.url, obj, token);
  }

  delete(id: string, token: any = undefined): Observable<T | null> {
    return this.service.delete<T>('/' + this.url, {id}, token);
  }
}
