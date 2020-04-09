public class ArtistController {
    private DatabaseConnection databaseConnection;

    public ArtistController(DatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }
    public void create(String name, String country) {
        databaseConnection.addArtist(name, country);
    }
    public void findByName(String name) {
        databaseConnection.findByName(name);
    }
}
