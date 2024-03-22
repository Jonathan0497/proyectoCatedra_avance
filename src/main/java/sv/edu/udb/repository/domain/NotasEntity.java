package sv.edu.udb.repository.domain;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "notas", schema = "centro_escolar")
@NamedQueries({
        @NamedQuery(name = "NotasEntity.findAll", query = "SELECT n FROM NotasEntity n"),
        @NamedQuery(name = "NotasEntity.findById", query = "SELECT n FROM NotasEntity n WHERE n.idNotas = :idNotas"),
        @NamedQuery(name = "NotasEntity.findByAlumno", query = "SELECT n FROM NotasEntity n WHERE n.idAlumno = :idAlumno"),
        @NamedQuery(name = "NotasEntity.findByProfesorMateria", query = "SELECT n FROM NotasEntity n WHERE n.idProfesorMateria = :idProfesorMateria"),
        @NamedQuery(name = "NotasEntity.findNotaByAlumnoAndProfesorMateria", query = "SELECT n FROM NotasEntity n WHERE n.idAlumno = :idAlumno AND n.idProfesorMateria = :idProfesorMateria"),
        @NamedQuery(name = "NotasEntity.isExist", query = "SELECT COUNT(n) FROM NotasEntity n WHERE n.idNotas = :idNotas")
})

public class NotasEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_notas", nullable = false)
    private int idNotas;
    @Basic
    @Column(name = "id_alumno", nullable = false)
    private int idAlumno;
    @Basic
    @Column(name = "id_profesor_materia", nullable = false)
    private int idProfesorMateria;
    @Basic
    @Column(name = "nota", nullable = true, precision = 2)
    private BigDecimal nota;

    public int getIdNotas() {
        return idNotas;
    }

    public void setIdNotas(int idNotas) {
        this.idNotas = idNotas;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public int getIdProfesorMateria() {
        return idProfesorMateria;
    }

    public void setIdProfesorMateria(int idProfesorMateria) {
        this.idProfesorMateria = idProfesorMateria;
    }

    public BigDecimal getNota() {
        return nota;
    }

    public void setNota(BigDecimal nota) {
        this.nota = nota;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NotasEntity that = (NotasEntity) o;

        if (idNotas != that.idNotas) return false;
        if (idAlumno != that.idAlumno) return false;
        if (idProfesorMateria != that.idProfesorMateria) return false;
        if (nota != null ? !nota.equals(that.nota) : that.nota != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idNotas;
        result = 31 * result + idAlumno;
        result = 31 * result + idProfesorMateria;
        result = 31 * result + (nota != null ? nota.hashCode() : 0);
        return result;
    }
}
