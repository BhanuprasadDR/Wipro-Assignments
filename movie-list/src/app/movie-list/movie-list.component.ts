import { Component, computed, signal } from '@angular/core';
import { CommonModule, NgFor } from '@angular/common';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatSelectModule } from '@angular/material/select';
import { MovieCardComponent } from '../movie-card/movie-card.component';

interface Movie {
  id: number;
  title: string;
  genre: string;
  rating: number;
  description: string;
  posterUrl: string;
}

const MOVIES: Movie[] = [
  {
    id: 1,
    title: '3 Idiots',
    genre: 'Drama',
    rating: 4.8,
    description: 'A brilliant story about friendship.',
    posterUrl: 'assets/images/Three_idiots.webp'   // ✅ local asset
  },
  {
    id: 2,
    title: 'Return of Dragon',
    genre: 'Drama',
    rating: 4.2,
    description: 'Story of honesty and career.',
    posterUrl: 'assets/images/return_of_dragon.avif'  // ✅ local asset
  },
  {
    id: 3,
    title: 'Bahubali',
    genre: 'Action',
    rating: 4.6,
    description: 'An elite unit faces an impossible covert mission.',
    posterUrl: 'assets/images/bahubali.jpeg'   // ✅ local asset
  },
  {
    id: 4,
    title: 'RRR',
    genre: 'Drama',
    rating: 4.9,
    description: 'A prodigy grapples with the cost of perfection.',
    posterUrl: 'assets/images/rrr.jpeg'   // ✅ local asset
  }
];


@Component({
  selector: 'app-movie-list',
  standalone: true,
  imports: [CommonModule, NgFor, MatFormFieldModule, MatSelectModule, MovieCardComponent],
  templateUrl: './movie-list.component.html',
  styleUrls: ['./movie-list.component.css']
})
export class MovieListComponent {
  movies = signal<Movie[]>(MOVIES);
  selectedGenre = signal<string>('');

  genres = computed(() => Array.from(new Set(this.movies().map(m => m.genre))));

  filtered = computed(() => {
    const g = this.selectedGenre();
    return g ? this.movies().filter(m => m.genre === g) : this.movies();
  });

  onGenreChange(value: string) {
    this.selectedGenre.set(value);
  }
}
