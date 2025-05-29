package db;

import model.DataEntity;
import model.DataType;

import java.util.HashMap;
import java.util.Map;

public class DatabaseConnection {
    private static DatabaseConnection instance;
    private Map<String, DataEntity> database;

    private DatabaseConnection() {
        database = new HashMap<>();
        // Инициализация тестовых данных
        database.put("1", new DataEntity("1", "Read-only data 1", DataType.READ_ONLY));
        database.put("2", new DataEntity("2", "Read-only data 2", DataType.READ_ONLY));
        database.put("3", new DataEntity("3", "Writable data 1", DataType.READ_WRITE));
    }

    public static synchronized DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public DataEntity getData(String id) {
        return database.get(id);
    }

    public void updateData(String id, String content) {
        DataEntity entity = database.get(id);
        if (entity != null && entity.getType() == DataType.READ_WRITE) {
            entity.setContent(content);
        }
    }

    public Map<String, DataEntity> getAllData() {
        return new HashMap<>(database);
    }
}