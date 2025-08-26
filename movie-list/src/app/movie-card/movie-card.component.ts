import { Component, Input } from '@angular/core';
import { MatCardModule } from '@angular/material/card';
import { MatIconModule } from '@angular/material/icon';
import { CommonModule } from '@angular/common';

interface Movie {
  id: number;
  title: string;
  genre: string;
  rating: number;
  description: string;
  posterUrl: string;
  
}

@Component({
  selector: 'app-movie-card',
  standalone: true,
  imports: [CommonModule, MatCardModule, MatIconModule],
  templateUrl: './movie-card.component.html',
  styleUrls: ['./movie-card.component.css']
})
export class MovieCardComponent {
  @Input({ required: true }) movie!: Movie;

  get stars() {
    const full = Math.floor(this.movie.rating);
    const half = this.movie.rating - full >= 0.5 ? 1 : 0;
    const empty = 5 - full - half;
    return [
      ...Array(full).fill('star'),
      ...Array(half).fill('star_half'),
      ...Array(empty).fill('star_outline')
    ];
  }
}
