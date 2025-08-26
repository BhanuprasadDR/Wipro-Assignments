import { Injectable } from '@angular/core';
import { Song } from '../models/song.model';


@Injectable({ providedIn: 'root' })
export class SongService {
  private songs: Song[] = [
    { id: 1, name: 'Blinding Lights', artist: 'The Weeknd', album: 'After Hours', duration: '03:20', rating: 4.8 },
    { id: 2, name: 'Levitating', artist: 'Dua Lipa', album: 'Future Nostalgia', duration: '03:23', rating: 4.6 },
    { id: 3, name: 'As It Was', artist: 'Harry Styles', album: 'Harry’s House', duration: '02:45', rating: 4.4 },
    { id: 4, name: 'Save Your Tears', artist: 'The Weeknd', album: 'After Hours', duration: '03:35', rating: 4.7 },
    { id: 5, name: 'Heat Waves', artist: 'Glass Animals', album: 'Dreamland', duration: '03:58', rating: 4.3 },
    { id: 6, name: 'Anti-Hero', artist: 'Taylor Swift', album: 'Midnights', duration: '03:20', rating: 4.9 },
    { id: 7, name: 'Viva La Vida', artist: 'Coldplay', album: 'Viva La Vida', duration: '04:02', rating: 4.2 },
    { id: 8, name: 'Starboy', artist: 'The Weeknd', album: 'Starboy', duration: '03:50', rating: 4.5 },
    { id: 9, name: 'Don’t Start Now', artist: 'Dua Lipa', album: 'Future Nostalgia', duration: '03:03', rating: 4.1 },
    { id: 10, name: 'Peaches', artist: 'Justin Bieber', album: 'Justice', duration: '03:18', rating: 3.9 }
  ];

  getAll(): Song[] {
    return this.songs.map(s => ({ ...s }));
  }
}
