package com.blogapp.data;

import com.blogapp.data.base.GenericRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class GenericRepositoryImpl<T> implements GenericRepository<T> {
    private static List<Object> items;

    static {
        items = new ArrayList<>();
    }

    @Override
    public List<T> list() {
        return (List<T>) items;
    }

    @Override
    public Stream<T> modelStream() {
        return ((List<T>) items).stream();
    }

    @Override
    public T create(T model) {
        return null;
    }

    @Override
    public T update(int id, T newModel) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
