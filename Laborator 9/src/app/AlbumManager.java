package app;

import entity.*;
import repo.*;

import java.sql.SQLException;

public class AlbumManager {
    public static void main(String[] args) throws SQLException {
        DatabaseConnection databaseConnection = DatabaseConnection.getInstance();
        ArtistRepository artistRepository = new ArtistRepository(databaseConnection);
        AlbumRepository albumRepository = new AlbumRepository(databaseConnection);
        /*
        artistRepository.create("2Pac", "USA");
        artistRepository.create("Eminem", "USA");
        artistRepository.create("Oliver Tree", "USA");
        albumRepository.create("All Eyez on me", 1, 1996);
        albumRepository.create("Me against the world", 1, 1995);
        albumRepository.create("Better Dayz", 1, 2002);
        albumRepository.create("Music to be murdered by", 2, 2020);
        albumRepository.create("Alien Boy", 3, 2018);
        albumRepository.create("Kamikaze", 2, 2018);
        albumRepository.create("The Marshall Matters", 2, 2000);
         */
        System.out.println("Artistul cu id-ul 3");
        artistRepository.findById(3);
        System.out.println("Albumul cu numele Better Dayz ");
        albumRepository.findByName("Better Dayz");
    }
}
