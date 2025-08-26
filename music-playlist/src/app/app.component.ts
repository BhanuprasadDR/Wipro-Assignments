import { Component, computed, signal } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule, FormControl } from '@angular/forms';

import { MatToolbarModule } from '@angular/material/toolbar';
import { MatCardModule } from '@angular/material/card';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatSelectModule } from '@angular/material/select';

import { SongService } from './services/song.service';
import { Song } from './models/song.model';

// ✅ Needed to make FormControl reactive with signals
import { toSignal } from '@angular/core/rxjs-interop';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    CommonModule, FormsModule, ReactiveFormsModule,
    MatToolbarModule, MatCardModule, MatIconModule, MatButtonModule,
    MatFormFieldModule, MatSelectModule
  ],
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Music Playlist';

  private allSongs = signal<Song[]>([]);

  artistCtrl = new FormControl<string | null>(null);
  albumCtrl  = new FormControl<string | null>(null);

  // ✅ Convert FormControl valueChanges → signals
  artist = toSignal(this.artistCtrl.valueChanges, { initialValue: null });
  album  = toSignal(this.albumCtrl.valueChanges, { initialValue: null });

  artists = computed(() =>
    Array.from(new Set(this.allSongs().map(s => s.artist))).sort()
  );
  albums = computed(() =>
    Array.from(new Set(this.allSongs().map(s => s.album))).sort()
  );

  filteredSongs = computed(() => {
    const artist = this.artist();
    const album  = this.album();

    return this.allSongs().filter(s =>
      (!artist || s.artist === artist) &&
      (!album  || s.album === album)
    );
  });

  constructor(private songService: SongService) {
    this.allSongs.set(this.songService.getAll());
  }

  clearFilters(): void {
    this.artistCtrl.setValue(null);
    this.albumCtrl.setValue(null);
  }

  isTopRated(song: Song): boolean {
    return song.rating >= 4.6;
  }
}
