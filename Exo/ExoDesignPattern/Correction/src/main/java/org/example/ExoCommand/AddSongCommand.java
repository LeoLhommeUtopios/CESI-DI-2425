package org.example.ExoCommand;

public class AddSongCommand implements Command{

    public Playlist playlist;
    private String song;

    public AddSongCommand(Playlist playlist, String song) {
        this.playlist = playlist;
        this.song = song;
    }

    @Override
    public void execute() {
        playlist.addSong(song);
    }
}
