package sv.edu.udb.repository.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "estado_profesor", schema = "centro_escolar")
public class EstadoProfesorEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_estado_profesor", nullable = false)
    private int idEstadoProfesor;
    @Basic
    @Column(name = "estado_profesor", nullable = false, length = 150)
    private String estadoProfesor;

    public int getIdEstadoProfesor() {
        return idEstadoProfesor;
    }

    public void setIdEstadoProfesor(int idEstadoProfesor) {
        this.idEstadoProfesor = idEstadoProfesor;
    }

    public String getEstadoProfesor() {
        return estadoProfesor;
    }

    public void setEstadoProfesor(String estadoProfesor) {
        this.estadoProfesor = estadoProfesor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EstadoProfesorEntity that = (EstadoProfesorEntity) o;

        if (idEstadoProfesor != that.idEstadoProfesor) return false;
        if (estadoProfesor != null ? !estadoProfesor.equals(that.estadoProfesor) : that.estadoProfesor != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idEstadoProfesor;
        result = 31 * result + (estadoProfesor != null ? estadoProfesor.hashCode() : 0);
        return result;
    }
}
