import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Taskbar } from './components/taskbar/taskbar';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, Taskbar],
  template: `
          <main>
          <section>
            <app-taskbar></app-taskbar>
            <router-outlet/>
          </section>
        </main>
     `
     
    })
export class App {
  protected readonly title = signal('client');
}
