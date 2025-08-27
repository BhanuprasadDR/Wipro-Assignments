import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-todo',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './todo.component.html',
  styleUrls: ['./todo.component.css']
})
export class TodoComponent {
  newTask: string = '';
  tasks: { name: string, completed: boolean }[] = [];

  // Add a new task
  addTask() {
    if (this.newTask.trim() !== '') {
      this.tasks.push({ name: this.newTask, completed: false });
      this.newTask = '';
    }
  }

  // Mark as done/undo
  toggleTask(index: number) {
    this.tasks[index].completed = !this.tasks[index].completed;
  }

  // Delete a task
  deleteTask(index: number) {
    this.tasks.splice(index, 1);
  }
}
