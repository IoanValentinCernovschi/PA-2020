public class AlbumController {
    private DatabaseConnection databaseConnection;

    public AlbumController(DatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    public void create(String name, int artistId, int releaseYear) {
        databaseConnection.addAlbum(name, artistId, releaseYear);
    }

    public void findByArtist(int artistId) {
        databaseConnection.findByArtist(artistId);
    }

}
