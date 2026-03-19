package org.example.ExoCommand;

public class RemoveSongCommand implements Command{
    public Playlist playlist;
    private String song;

    public RemoveSongCommand(Playlist playlist, String song) {
        this.playlist = playlist;
        this.song = song;
    }

    @Override
    public void execute() {
        playlist.removeSong(song);
    }
}
