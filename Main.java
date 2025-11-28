import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        playlist playlist = new playlist();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n----- PLAYLIST MENU -----");
            System.out.println("1. Add Song");
            System.out.println("2. Play Next");
            System.out.println("3. Play Previous");
            System.out.println("4. View Upcoming Playlist");
            System.out.println("5. View History");
            System.out.println("6. Exit");
            System.out.print("Choose: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consumes leftover newline

            switch (choice) {
                case 1:
                    System.out.print("Song title: ");
                    String title = sc.nextLine();
                    System.out.print("Artist: ");
                    String artist = sc.nextLine();
                    playlist.addSong(new Song(title, artist));
                    break;

                case 2:
                    playlist.playNext();
                    break;

                case 3:
                    playlist.playPrevious();
                    break;

                case 4:
                    playlist.showPlaylist();
                    break;

                case 5:
                    playlist.showHistory();
                    break;

                case 6:
                    System.out.println("Goodbye!");
                    return;

                default:
                    System.out.println("Invalid option!");
            }
        }
    }
}
