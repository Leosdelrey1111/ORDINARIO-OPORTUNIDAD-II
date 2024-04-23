package mx.utng.session26.model.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class ReservaHotel {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 30)
    private String fechaI;


    @Column(length = 30)
    private String fechaF;


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getFechaI() {
        return fechaI;
    }


    public void setFechaI(String fechaI) {
        this.fechaI = fechaI;
    }


    public String getFechaF() {
        return fechaF;
    }


    public void setFechaF(String fechaF) {
        this.fechaF = fechaF;
    }
   



}
