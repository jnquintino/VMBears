import {Injectable} from '@angular/core';
import { CoreService } from '../core/core.service';
import {GenericService} from "../core/generic.service";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root',
})
export class UploadService extends GenericService<any> {
  constructor(private core: CoreService<any>) {
    super();
    this.service = this.core;
    this.url = 'upload';
  }

  upload(file: File): Observable<any> {
    const data: FormData = new FormData();
    data.append('file', file);
    return this.service.post<any>('/' + this.url, data);
  }

}
