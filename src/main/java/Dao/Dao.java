package Dao;

import Entities.Department;
import net.bytebuddy.dynamic.DynamicType;

import java.util.List;


public interface Dao<T> {
    DynamicType.Builder.FieldDefinition.Optional<T> get(long id);
    List<T> getAll();
    void Save(T t);
    void update(T t, String[] params);
    void delete(T t);
}
