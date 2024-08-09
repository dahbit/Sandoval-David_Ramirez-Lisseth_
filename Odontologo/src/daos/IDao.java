package daos;

import java.util.List;

public interface IDao<T> {

    //CRUD
    public T guardar(T t);
    public List<T> ListarTodo();
}
