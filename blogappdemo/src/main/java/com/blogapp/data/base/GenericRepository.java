package com.blogapp.data.base;

import java.util.List;
import java.util.stream.Stream;

public interface GenericRepository<T> {
    List<T> list();

    Stream<T> modelStream();

    T create(T model);

    T update(int id, T newModel);

    boolean delete(int id);

}
