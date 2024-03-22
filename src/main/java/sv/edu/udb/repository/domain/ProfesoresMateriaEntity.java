package sv.edu.udb.repository.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "profesores_materia", schema = "centro_escolar")
@NamedQueries({
        @NamedQuery(name = "ProfesorMateriaEntity.findAll", query = "SELECT pm FROM ProfesoresMateriaEntity pm"),
        @NamedQuery(name = "ProfesorMateriaEntity.findById", query = "SELECT pm FROM ProfesoresMateriaEntity pm WHERE pm.idProfesorMateria = :idProfesorMateria"),
        @NamedQuery(name = "ProfesorMateriaEntity.findByProfesor", query = "SELECT pm FROM ProfesoresMateriaEntity pm WHERE pm.idProfesor = :idProfesor"),
        @NamedQuery(name = "ProfesorMateriaEntity.findByMateria", query = "SELECT pm FROM ProfesoresMateriaEntity pm WHERE pm.idMateria = :idMateria"),
        @NamedQuery(name = "ProfesorMateriaEntity.isExist", query = "SELECT COUNT(pm) FROM ProfesoresMateriaEntity pm WHERE pm.idProfesorMateria = :idProfesorMateria")
})
public class ProfesoresMateriaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_profesor_materia", nullable = false)
    private int idProfesorMateria;
    @Basic
    @Column(name = "id_profesor", nullable = false)
    private int idProfesor;
    @Basic
    @Column(name = "id_materia", nullable = false)
    private int idMateria;

    public int getIdProfesorMateria() {
        return idProfesorMateria;
    }

    public void setIdProfesorMateria(int idProfesorMateria) {
        this.idProfesorMateria = idProfesorMateria;
    }

    public int getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(int idProfesor) {
        this.idProfesor = idProfesor;
    }

    public int getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProfesoresMateriaEntity that = (ProfesoresMateriaEntity) o;

        if (idProfesorMateria != that.idProfesorMateria) return false;
        if (idProfesor != that.idProfesor) return false;
        if (idMateria != that.idMateria) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idProfesorMateria;
        result = 31 * result + idProfesor;
        result = 31 * result + idMateria;
        return result;
    }
}
