package repo;
import entity.*;
import util.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.sql.*;
import java.util.*;

public class DatabaseConnection {
    private static DatabaseConnection databaseInstance = null;
    private Connection connection;
    private Statement statement;
    private DatabaseConnection() {
        try {
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/MusicAlbums", "dba", "sql0");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static DatabaseConnection getInstance() throws SQLException {
        if (databaseInstance == null) {
            databaseInstance = new DatabaseConnection();
        }
        else {
            if(databaseInstance.getConnection().isClosed()) {
                databaseInstance = new DatabaseConnection();
            }
        }
        return databaseInstance;
    }

    public void addAlbum(String name, int artistId, int releaseYear){
        try {
            String query = "INSERT INTO albums (name, artist_id, release_year) VALUES(?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, artistId);
            preparedStatement.setInt(3, releaseYear);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addArtist(String name, String country) {
        try {
            String query = "INSERT INTO artists (name, country) VALUES(?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, country);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<ArtistsEntity> findByNameArtist(String name) {
        List<ArtistsEntity> artistsEntities = new ArrayList<>();
        try {
            String query = "SELECT id, country FROM artists WHERE name = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                ArtistsEntity artistsEntity = new ArtistsEntity();

                artistsEntity.setId(resultSet.getInt(1));
                artistsEntity.setName(name);
                artistsEntity.setCountry(resultSet.getString(2));

                artistsEntities.add(artistsEntity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return artistsEntities;
    }

    public List findByNameAlbum(String name) {
        List<AlbumsEntity> albumsEntities = new ArrayList<>();
        /*
        EntityManagerFactory entityManagerFactory = PersistenceUtil.getInstance();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createNamedQuery("AlbumsEntity.byName");
        query.setParameter("albumName", name);
        return query.getResultList();

         */
        try {
            String query = "SELECT id, artist_id, release_year FROM albums WHERE name = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                AlbumsEntity albumsEntity = new AlbumsEntity();

                albumsEntity.setId(resultSet.getInt(1));
                albumsEntity.setName(name);
                albumsEntity.setArtistId(resultSet.getInt(2));
                albumsEntity.setReleaseYear(resultSet.getInt(3));

                albumsEntities.add(albumsEntity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return albumsEntities;

    }

    public List<AlbumsEntity> findByArtist(int artistId) {
        List<AlbumsEntity> albumsEntities = new ArrayList<>();
        try {
            String query = "SELECT id, name, release_year FROM albums WHERE artist_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, artistId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                AlbumsEntity albumsEntity = new AlbumsEntity();

                albumsEntity.setId(resultSet.getInt(1));
                albumsEntity.setName(resultSet.getString(2));
                albumsEntity.setReleaseYear(resultSet.getInt(3));
                albumsEntity.setArtistId(artistId);

                albumsEntities.add(albumsEntity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return albumsEntities;
    }

    public AlbumsEntity findByIdAlbum(int id) {
        AlbumsEntity albumsEntity = new AlbumsEntity();
        try {
            String query = "SELECT name, artist_id, release_year FROM albums WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                albumsEntity.setArtistId(resultSet.getInt(1));
                albumsEntity.setId(id);
                albumsEntity.setName(resultSet.getString(2));
                albumsEntity.setReleaseYear(resultSet.getInt(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return albumsEntity;
    }

    public ArtistsEntity findByIdArtist(int id) {
        ArtistsEntity artistsEntity = new ArtistsEntity();
        try {
            String query = "SELECT name, country FROM artists WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                artistsEntity.setId(id);
                artistsEntity.setName(resultSet.getString(1));
                artistsEntity.setCountry(resultSet.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return artistsEntity;
    }

}
