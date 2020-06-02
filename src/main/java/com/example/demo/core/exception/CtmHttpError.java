package com.example.demo.core.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CtmHttpError {
    public Timestamp timestamp;
    public Integer status;
    public String error;
    public String message;
    public String path;
}