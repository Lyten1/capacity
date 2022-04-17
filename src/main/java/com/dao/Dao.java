package com.dao;

import java.util.ArrayList;

public interface Dao<T> {
    void save(T data) ;

    T get(String pattern) ;

    ArrayList<T> getAll() ;

    void delete(String pattern) ;

    void update(T data, String pattern) ;
}
