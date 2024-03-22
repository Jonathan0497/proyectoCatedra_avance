package sv.edu.udb.repository.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "tipo_alumno", schema = "centro_escolar", catalog = "")
public class TipoAlumnoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_tipo_alumno", nullable = false)
    private int idTipoAlumno;
    @Basic
    @Column(name = "tipo_alumno", nullable = false, length = 150)
    private String tipoAlumno;

    public int getIdTipoAlumno() {
        return idTipoAlumno;
    }

    public void setIdTipoAlumno(int idTipoAlumno) {
        this.idTipoAlumno = idTipoAlumno;
    }

    public String getTipoAlumno() {
        return tipoAlumno;
    }

    public void setTipoAlumno(String tipoAlumno) {
        this.tipoAlumno = tipoAlumno;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TipoAlumnoEntity that = (TipoAlumnoEntity) o;

        if (idTipoAlumno != that.idTipoAlumno) return false;
        if (tipoAlumno != null ? !tipoAlumno.equals(that.tipoAlumno) : that.tipoAlumno != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idTipoAlumno;
        result = 31 * result + (tipoAlumno != null ? tipoAlumno.hashCode() : 0);
        return result;
    }
}
