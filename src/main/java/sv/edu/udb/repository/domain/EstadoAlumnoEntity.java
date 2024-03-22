package sv.edu.udb.repository.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "estado_alumno", schema = "centro_escolar")
public class EstadoAlumnoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_estado_alumno", nullable = false)
    private int idEstadoAlumno;
    @Basic
    @Column(name = "estado_alumno", nullable = false, length = 150)
    private String estadoAlumno;

    public int getIdEstadoAlumno() {
        return idEstadoAlumno;
    }

    public void setIdEstadoAlumno(int idEstadoAlumno) {
        this.idEstadoAlumno = idEstadoAlumno;
    }

    public String getEstadoAlumno() {
        return estadoAlumno;
    }

    public void setEstadoAlumno(String estadoAlumno) {
        this.estadoAlumno = estadoAlumno;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EstadoAlumnoEntity that = (EstadoAlumnoEntity) o;

        if (idEstadoAlumno != that.idEstadoAlumno) return false;
        if (estadoAlumno != null ? !estadoAlumno.equals(that.estadoAlumno) : that.estadoAlumno != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idEstadoAlumno;
        result = 31 * result + (estadoAlumno != null ? estadoAlumno.hashCode() : 0);
        return result;
    }
}
