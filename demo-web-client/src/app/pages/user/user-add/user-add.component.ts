import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from "@angular/forms";
import { UserService } from "../../../services/user.service";
import { ActivatedRoute, Router } from "@angular/router";

@Component({
  selector: 'app-user-add',
  templateUrl: './user-add.component.html',
  styleUrls: ['./user-add.component.scss']
})
export class UserAddComponent implements OnInit {

  user = new FormGroup({
    firstName: new FormControl(''),
    lastName: new FormControl('')
  });

  constructor(private _userService: UserService, private _router: Router, private _route: ActivatedRoute) { }

  ngOnInit(): void {
  }

  create(): void {
    this._userService.create(this.user.value).subscribe(() => {
        this._router.navigate(['/'], { relativeTo: this._route });
    })
  }
}
