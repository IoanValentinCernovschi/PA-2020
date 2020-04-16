package util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashMap;
import java.util.Map;

public class PersistenceUtil {
    private static EntityManagerFactory entityManagerFactoryInstance = null;

    private PersistenceUtil() {
        entityManagerFactoryInstance.createEntityManager();
    }

    public static EntityManagerFactory getInstance() {
        if (entityManagerFactoryInstance == null || !entityManagerFactoryInstance.isOpen()) {
            Map<String, String> properties = new HashMap<String, String>();
            properties.put("javax.persistence.transactionType", "JTA");
            properties.put("javax.persistence.jdbc.driver", "com.mysql.jdbc.Driver");
            properties.put("javax.persistence.jdbc.url", "jdbc:mysql://localhost:3306/MusicAlbums");
            properties.put("javax.persistence.jdbc.database", "MusicAlbums");
            properties.put("javax.persistence.jdbc.user", "dba");
            properties.put("javax.persistence.jdbc.password", "sql0");

            entityManagerFactoryInstance = Persistence.createEntityManagerFactory("MusicAlbumsPU", properties);
        }
        return entityManagerFactoryInstance;
    }
}