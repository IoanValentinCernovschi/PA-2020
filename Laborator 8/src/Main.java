import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        DatabaseConnection databaseConnection = DatabaseConnection.getInstance();
        AlbumController albumController = new AlbumController(databaseConnection);
        ArtistController artistController = new ArtistController(databaseConnection);

        artistController.create("Eminem", "SUA");
        artistController.create("2Pac", "SUA");
        albumController.create("Music To Be Murdered By", 1, 2020);
        albumController.create("All Eyez on me", 2, 1996);

        artistController.findByName("Eminem");
        albumController.findByArtist(2);
    }
}
