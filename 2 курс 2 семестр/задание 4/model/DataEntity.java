package model;

public class DataEntity {
    private String id;
    private String content;
    private DataType type;
    private long lastUpdated;

    public DataEntity(String id, String content, DataType type) {
        this.id = id;
        this.content = content;
        this.type = type;
        this.lastUpdated = System.currentTimeMillis();
    }

    // Геттеры и сеттеры
    public String getId() { return id; }
    public String getContent() { return content; }
    public DataType getType() { return type; }
    public long getLastUpdated() { return lastUpdated; }

    public void setContent(String content) {
        this.content = content;
        this.lastUpdated = System.currentTimeMillis();
    }
}