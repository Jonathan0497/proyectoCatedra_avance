package sv.edu.udb.repository.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "materia", schema = "centro_escolar")

@NamedQueries({
        @NamedQuery(name = "MateriaEntity.findAll", query = "SELECT m FROM MateriaEntity m"),
        @NamedQuery(name = "MateriaEntity.findById", query = "SELECT m FROM MateriaEntity m WHERE m.idMateria = :idMateria"),
        @NamedQuery(name = "MateriaEntity.findByNombreMateria", query = "SELECT m FROM MateriaEntity m WHERE m.nombreMateria = :nombreMateria"),
        @NamedQuery(name = "MateriaEntity.findByIdGradoAcademido", query = "SELECT m FROM MateriaEntity m WHERE m.idGradoAcademido = :idGradoAcademido"),
        @NamedQuery(name = "MateriaEntity.isExist", query = "SELECT COUNT(m) FROM MateriaEntity m WHERE m.idMateria = :idMateria")
})

public class MateriaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_materia", nullable = false)
    private int idMateria;
    @Basic
    @Column(name = "nombre_materia", nullable = false, length = 150)
    private String nombreMateria;
    @Basic
    @Column(name = "id_grado_academido", nullable = false)
    private int idGradoAcademido;

    public int getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }

    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    public int getIdGradoAcademido() {
        return idGradoAcademido;
    }

    public void setIdGradoAcademido(int idGradoAcademido) {
        this.idGradoAcademido = idGradoAcademido;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MateriaEntity that = (MateriaEntity) o;

        if (idMateria != that.idMateria) return false;
        if (idGradoAcademido != that.idGradoAcademido) return false;
        if (nombreMateria != null ? !nombreMateria.equals(that.nombreMateria) : that.nombreMateria != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idMateria;
        result = 31 * result + (nombreMateria != null ? nombreMateria.hashCode() : 0);
        result = 31 * result + idGradoAcademido;
        return result;
    }
}
