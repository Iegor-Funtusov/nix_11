import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {map, Observable} from "rxjs";

import { environment } from "src/environments/environment";
import { UserModel } from "../models/user.model";

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private baseUrl = environment.baseUrl + '/users';

  constructor(private _http: HttpClient) { }

  findAllUsers(): Observable<UserModel[]> {
    return this._http.get(this.baseUrl, this._getOptions()).
    pipe(map((res: any) => {
        return res
      })
    )
  }

  create(user: UserModel): Observable<boolean> {
    return this._http.post(this.baseUrl, user, this._getOptions()).pipe(
      map((res: any) => {
        return res
      })
    );
  }

  private _getOptions(): any {
    return {
      headers: new HttpHeaders({})
    };
  }
}
