package mx.utng.session26.model.service;
import mx.utng.session26.model.entity.ListaDeseos;
import java.util.List;

public interface IListaDeseosService {
    List<ListaDeseos> list();
    void save(ListaDeseos deseo);
    ListaDeseos getById(Long id);
    void delete(Long id);
}