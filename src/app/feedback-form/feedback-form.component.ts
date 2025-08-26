import { Component } from '@angular/core';
import { ReactiveFormsModule, FormBuilder, Validators, FormControl, FormGroup } from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { CommonModule } from '@angular/common';

interface FeedbackForm {
  name: FormControl<string>;
  email: FormControl<string>;
  subject: FormControl<string>;
  comments: FormControl<string>;
}

@Component({
  selector: 'app-feedback-form',
  standalone: true,
  imports: [
    ReactiveFormsModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule,
    CommonModule
  ],
  templateUrl: './feedback-form.component.html',
  styleUrls: ['./feedback-form.component.css'],
})
export class FeedbackFormComponent {
  submitted = false;
  feedbackForm: FormGroup<FeedbackForm>;

  constructor(private fb: FormBuilder) {
    this.feedbackForm = this.fb.group<FeedbackForm>({
      name: this.fb.control('', {
        nonNullable: true,
        validators: [Validators.required, Validators.minLength(2)],
      }),
      email: this.fb.control('', {
        nonNullable: true,
        validators: [Validators.required, Validators.email],
      }),
      subject: this.fb.control('', {
        nonNullable: true,
        validators: [Validators.required, Validators.maxLength(40)],
      }),
      comments: this.fb.control('', {
        nonNullable: true,
        validators: [Validators.required, Validators.maxLength(350)],
      }),
    });
  }

  get f() {
    return this.feedbackForm.controls;
  }

  onSubmit(): void {
    if (this.feedbackForm.invalid) return;
    this.submitted = true;
    console.log('Submitted:', this.feedbackForm.getRawValue());
    this.feedbackForm.reset();
  }
}
