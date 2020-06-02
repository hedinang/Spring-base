package com.example.demo.model.rabbitMq;

public class Message<T> {
    String tableName;
    String dbName;
    public T data;

    public Message(String tableName, String dbName) {
        this.tableName = tableName;
        this.dbName = dbName;
    }

    public Message() {
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }
}
