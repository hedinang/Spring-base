package com.example.demo.core.sql;

import java.io.Serializable;
import java.sql.Timestamp;

public class Entity<ID extends Serializable> implements Serializable {
    public ID id;
    public boolean delete;
    public Long userCreate;
    public Long userLastUpdate;
    public Timestamp timeCreate;
    public Timestamp timeLastUpdate;
}
