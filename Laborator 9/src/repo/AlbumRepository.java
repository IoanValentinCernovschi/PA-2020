package repo;

import entity.AlbumsEntity;

import java.util.List;

public class AlbumRepository {
    private DatabaseConnection databaseConnection;

    public AlbumRepository(DatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    public void create(String name, int artistId, int releaseYear) {
        databaseConnection.addAlbum(name, artistId, releaseYear);
    }

    public void findByArtist(int artistId) {
        List<AlbumsEntity> albumsEntities = databaseConnection.findByArtist(artistId);
        for(AlbumsEntity albumsEntity : albumsEntities) {
            System.out.println(albumsEntity);
        }
    }

    public void findByIdAlbum(int id) {
        AlbumsEntity albumsEntity = databaseConnection.findByIdAlbum(id);
        System.out.println(albumsEntity);
    }

    public void findByName(String name) {
        List albumsEntities = databaseConnection.findByNameAlbum(name);
        for(Object albumsEntity : albumsEntities) {
            System.out.println(albumsEntity);
        }
    }
}

