package api;

import model.DataEntity;
import model.DataType;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class CacheManager {
    private static CacheManager instance;
    private Map<String, DataEntity> cache;
    private Timer cacheRefreshTimer;

    private CacheManager() {
        cache = new HashMap<>();
        startCacheRefreshTimer();
    }

    public static synchronized CacheManager getInstance() {
        if (instance == null) {
            instance = new CacheManager();
        }
        return instance;
    }

    public DataEntity getFromCache(String id) {
        return cache.get(id);
    }

    public void putToCache(DataEntity entity) {
        if (entity.getType() == DataType.READ_ONLY) {
            cache.put(entity.getId(), entity);
        }
    }

    public void refreshCache(Map<String, DataEntity> newData) {
        newData.forEach((id, entity) -> {
            if (entity.getType() == DataType.READ_ONLY) {
                cache.put(id, entity);
            }
        });
    }

    private void startCacheRefreshTimer() {
        cacheRefreshTimer = new Timer();
        cacheRefreshTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                refreshCache(DatabaseConnection.getInstance().getAllData());
                System.out.println("Cache refreshed at: " + System.currentTimeMillis());
            }
        }, 0, 30000); // Обновление кэша каждые 30 секунд
    }

    public void shutdown() {
        if (cacheRefreshTimer != null) {
            cacheRefreshTimer.cancel();
        }
    }
}