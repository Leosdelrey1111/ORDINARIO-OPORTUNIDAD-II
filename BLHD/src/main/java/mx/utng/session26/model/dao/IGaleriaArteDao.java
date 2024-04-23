package mx.utng.session26.model.dao;
import java.util.List;
import mx.utng.session26.model.entity.GaleriaArte;

public interface IGaleriaArteDao {
    List<GaleriaArte> list();
    void save(GaleriaArte galeria);
    GaleriaArte getById(Long id);
    void delete(Long id);
}
