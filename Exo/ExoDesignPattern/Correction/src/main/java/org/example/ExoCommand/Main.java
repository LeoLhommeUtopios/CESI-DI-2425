package org.example.ExoCommand;

public class Main {
    public static void main(String[] args) {
        Playlist playlist = new Playlist();
        Command addSong =new AddSongCommand(playlist,"Song 1");
        Command addSong2 =new AddSongCommand(playlist,"Song 2");
        Command removeSong =new RemoveSongCommand(playlist,"Song 1");

        addSong.execute();
        addSong2.execute();
        removeSong.execute();

        addSong.execute();

        playlist.showPlaylist();
    }
}
