package sv.edu.udb.repository.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "grupos", schema = "centro_escolar")
@NamedQueries({
        @NamedQuery(name = "GrupoEntity.findAll", query = "SELECT g FROM GruposEntity g"),
        @NamedQuery(name = "GrupoEntity.findById", query = "SELECT g FROM GruposEntity g WHERE g.idGrupo = :idGrupo"),
        @NamedQuery(name = "GrupoEntity.findByAlumno", query = "SELECT g FROM GruposEntity g WHERE g.idAlumno = :idAlumno"),
        @NamedQuery(name = "GrupoEntity.findByProfesor", query = "SELECT g FROM GruposEntity g WHERE g.idProfesor = :idProfesor"),
        @NamedQuery(name = "GrupoEntity.findBySalon", query = "SELECT g FROM GruposEntity g WHERE g.idSalon = :idSalon"),
        @NamedQuery(name = "GrupoEntity.isExist", query = "SELECT COUNT(g) FROM GruposEntity g WHERE g.idGrupo = :idGrupo")
})
public class GruposEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_grupo", nullable = false)
    private int idGrupo;
    @Basic
    @Column(name = "id_alumno", nullable = false)
    private int idAlumno;
    @Basic
    @Column(name = "id_profesor", nullable = false)
    private int idProfesor;
    @Basic
    @Column(name = "id_salon", nullable = false)
    private int idSalon;

    public int getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(int idGrupo) {
        this.idGrupo = idGrupo;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public int getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(int idProfesor) {
        this.idProfesor = idProfesor;
    }

    public int getIdSalon() {
        return idSalon;
    }

    public void setIdSalon(int idSalon) {
        this.idSalon = idSalon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GruposEntity that = (GruposEntity) o;

        if (idGrupo != that.idGrupo) return false;
        if (idAlumno != that.idAlumno) return false;
        if (idProfesor != that.idProfesor) return false;
        if (idSalon != that.idSalon) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idGrupo;
        result = 31 * result + idAlumno;
        result = 31 * result + idProfesor;
        result = 31 * result + idSalon;
        return result;
    }
}
