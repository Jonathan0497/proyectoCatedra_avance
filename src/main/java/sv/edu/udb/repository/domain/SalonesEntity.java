package sv.edu.udb.repository.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "salones", schema = "centro_escolar")
@NamedQueries({
        @NamedQuery(name = "SalonesEntity.findAll", query = "SELECT s FROM SalonesEntity s"),
        @NamedQuery(name = "SalonesEntity.findById", query = "SELECT s FROM SalonesEntity s WHERE s.idSalon = :idSalon"),
        @NamedQuery(name = "SalonesEntity.findByNombreSalon", query = "SELECT s FROM SalonesEntity s WHERE s.nombreSalon = :nombreSalon"),
        @NamedQuery(name = "SalonesEntity.isExist", query = "SELECT COUNT(s) FROM SalonesEntity s WHERE s.idSalon = :idSalon")
})
public class SalonesEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_salon", nullable = false)
    private int idSalon;
    @Basic
    @Column(name = "nombre_salon", nullable = false, length = 150)
    private String nombreSalon;

    public int getIdSalon() {
        return idSalon;
    }

    public void setIdSalon(int idSalon) {
        this.idSalon = idSalon;
    }

    public String getNombreSalon() {
        return nombreSalon;
    }

    public void setNombreSalon(String nombreSalon) {
        this.nombreSalon = nombreSalon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SalonesEntity that = (SalonesEntity) o;

        if (idSalon != that.idSalon) return false;
        if (nombreSalon != null ? !nombreSalon.equals(that.nombreSalon) : that.nombreSalon != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idSalon;
        result = 31 * result + (nombreSalon != null ? nombreSalon.hashCode() : 0);
        return result;
    }
}
