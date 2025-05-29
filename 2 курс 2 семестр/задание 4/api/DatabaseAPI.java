package api;

import db.DatabaseService;
import model.DataEntity;

public class DatabaseAPI {
    private DatabaseService dbService;
    private CacheManager cacheManager;

    public DatabaseAPI() {
        this.dbService = new DatabaseService();
        this.cacheManager = CacheManager.getInstance();
    }

    public DataEntity getData(String id) {
        // Проверяем кэш для read-only данных
        DataEntity cached = cacheManager.getFromCache(id);
        if (cached != null) {
            System.out.println("Returning data from cache for ID: " + id);
            return cached;
        }

        // Получаем данные из БД
        DataEntity entity = dbService.fetchData(id);
        if (entity != null && entity.getType() == model.DataType.READ_ONLY) {
            cacheManager.putToCache(entity);
        }

        return entity;
    }

    public void updateData(String id, String content) {
        dbService.updateData(id, content);
    }

    public Map<String, DataEntity> generateReport() {
        return dbService.generateReport();
    }
}