package mx.utng.session26.model.dao;
import java.util.List;
import mx.utng.session26.model.entity.ListaDeseos;

public interface IListaDeseosDao {
    List<ListaDeseos> list();
    void save(ListaDeseos deseo);
    ListaDeseos getById(Long id);
    void delete(Long id);
    
}