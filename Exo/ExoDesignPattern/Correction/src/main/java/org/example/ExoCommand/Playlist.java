package org.example.ExoCommand;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private List<String> songs = new ArrayList<>();

    public void addSong(String song){
        songs.add(song);
        System.out.println("Added : "+song);
    }

    public void removeSong(String song){
        songs.remove(song);
        System.out.println("Removed : "+song);
    }

    public void showPlaylist(){
        System.out.println("Playlist : "+songs);
    }
}
