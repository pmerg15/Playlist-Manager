import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class playlist {

    private Queue<Song> songQueue;
    private Stack<Song> history;

    public playlist() {
        songQueue = new LinkedList<>();
        history = new Stack<>();
    }

    // ---------------------
    // AESTHETIC PURPLE POPUP
    // ---------------------
    public void showPopup(String message) {
        JFrame frame = new JFrame("💜 Playlist Notification 💜");
        frame.setSize(350, 180);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        java.awt.Color lavender = new java.awt.Color(230, 220, 255);
        java.awt.Color purpleText = new java.awt.Color(90, 60, 150);

        JLabel label = new JLabel("<html><center>" + message + "</center></html>", SwingConstants.CENTER);
        label.setOpaque(true);
        label.setBackground(lavender);
        label.setForeground(purpleText);
        label.setFont(new java.awt.Font("Serif", java.awt.Font.BOLD, 18));
        label.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));

        frame.getContentPane().setBackground(lavender);
        frame.add(label);

        frame.setVisible(true);
    }

    // ADD SONG
    public void addSong(Song song) {
        songQueue.offer(song);
        System.out.println("Song added: " + song.getTitle());
        showPopup("Added Song:<br>" + song.getTitle());
    }

    // PLAY NEXT SONG
    public Song playNext() {
        if (songQueue.isEmpty()) {
            showPopup("No songs left to play! 🎶");
            System.out.println("No songs in playlist.");
            return null;
        }

        Song nextSong = songQueue.poll();
        history.push(nextSong);

        System.out.println("Now playing: " + nextSong);
        showPopup("Now Playing:<br>" + nextSong.getTitle());

        return nextSong;
    }

    // PLAY PREVIOUS SONG
    public Song playPrevious() {
        if (history.size() <= 1) {
            showPopup("No previous song available. 💜");
            return null;
        }

        Song current = history.pop();
        Song previous = history.peek();

        System.out.println("Replaying: " + previous);
        showPopup("Replaying:<br>" + previous.getTitle());

        ((LinkedList<Song>) songQueue).addFirst(current);

        return previous;
    }

    // SHOW UPCOMING
    public void showPlaylist() {
        if (songQueue.isEmpty()) {
            System.out.println("Playlist is empty.");
            return;
        }

        System.out.println("\nUpcoming Songs:");
        for (Song song : songQueue) {
            System.out.println("- " + song);
        }
    }

    // SHOW HISTORY
    public void showHistory() {
        if (history.isEmpty()) {
            System.out.println("No songs in history.");
            return;
        }

        System.out.println("\nSong History:");
        for (Song song : history) {
            System.out.println("- " + song);
        }
    }
}
