package repo;

import entity.ArtistsEntity;

import java.util.*;

public class ArtistRepository {
    private DatabaseConnection databaseConnection;

    public ArtistRepository(DatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }
    public void create(String name, String country) {
        databaseConnection.addArtist(name, country);
    }
    public void findByName(String name) {
        List<ArtistsEntity> artistsEntities = databaseConnection.findByNameArtist(name);
        for(ArtistsEntity artistsEntity : artistsEntities) {
            System.out.println(artistsEntity);
        }
    }
    public void findById(int id) {
        ArtistsEntity artistsEntity = databaseConnection.findByIdArtist(id);
        System.out.println(artistsEntity);
    }
}
