package mx.utng.session26.model.service;

import mx.utng.session26.model.entity.GaleriaArte;
import java.util.List;

public interface IGaleriaArteService {
    List<GaleriaArte> list();
    void save(GaleriaArte galeria);
    GaleriaArte getById(Long id);
    void delete(Long id);
}
