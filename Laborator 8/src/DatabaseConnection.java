import java.sql.*;

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

    public void findByName(String name) {
        try {
            String query = "SELECT country FROM artists WHERE name = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                System.out.println("The artist " + name + " is from " + resultSet.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void findByArtist(int artistId) {
        try {
            String query = "SELECT name, release_year FROM albums WHERE artist_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, artistId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                System.out.println("The album " + resultSet.getString(1) + " was released in " + resultSet.getInt(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
