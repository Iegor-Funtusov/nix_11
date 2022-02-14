import { Component, OnInit } from '@angular/core';
import {UserService} from "../../../services/user.service";
import {UserModel} from "../../../models/user.model";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.scss']
})
export class UserListComponent implements OnInit {

  users: UserModel[] = [];

  constructor(private _userService: UserService, private _router: Router, private _route: ActivatedRoute) { }

  ngOnInit(): void {
    this._userService.findAllUsers().subscribe(users => {
      console.log('users', users);
      this.users = users;
    });
  }

  redirectToNewUser() {
    this._router.navigate(['add'], { relativeTo: this._route });
  }
}
