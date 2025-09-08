import { Component } from '@angular/core';
import { RouterLink, RouterLinkActive } from '@angular/router';

@Component({
  selector: 'app-taskbar',
  imports: [ RouterLink, RouterLinkActive],
  template: `
    <div class="bg-black text-white">
      <h3>Anime List Application</h3>
      <nav class=" space-x-10 mr-10 flex justify-end">
        <a routerLink="/home" routerLinkActive="underline">Home</a>
        <a routerLink="/list" routerLinkActive="underline">List</a>
      </nav>
    </div>
  `,
  styles: ``
})
export class Taskbar {

}
