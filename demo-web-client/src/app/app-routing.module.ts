import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UserListComponent } from "./pages/user/user-list/user-list.component";
import { UserAddComponent } from "./pages/user/user-add/user-add.component";

const routes: Routes = [
  {
    path: '', pathMatch: 'full', redirectTo: 'users'
  },
  {
    path: 'users', component: UserListComponent
  },
  {
    path: 'users/add', component: UserAddComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
