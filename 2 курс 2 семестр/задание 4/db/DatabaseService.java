package db;

import model.DataEntity;

import java.util.Map;

public class DatabaseService {
    private DatabaseConnection dbConnection;

    public DatabaseService() {
        this.dbConnection = DatabaseConnection.getInstance();
    }

    public DataEntity fetchData(String id) {
        return dbConnection.getData(id);
    }

    public void updateData(String id, String content) {
        dbConnection.updateData(id, content);
    }

    public Map<String, DataEntity> generateReport() {
        return dbConnection.getAllData();
    }
}