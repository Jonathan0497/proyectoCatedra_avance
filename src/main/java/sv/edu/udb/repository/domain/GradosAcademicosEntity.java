package sv.edu.udb.repository.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "grados_academicos", schema = "centro_escolar")
public class GradosAcademicosEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_grado_academico", nullable = false)
    private int idGradoAcademico;
    @Basic
    @Column(name = "nombre_grado", nullable = false, length = 100)
    private String nombreGrado;

    public int getIdGradoAcademico() {
        return idGradoAcademico;
    }

    public void setIdGradoAcademico(int idGradoAcademico) {
        this.idGradoAcademico = idGradoAcademico;
    }

    public String getNombreGrado() {
        return nombreGrado;
    }

    public void setNombreGrado(String nombreGrado) {
        this.nombreGrado = nombreGrado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GradosAcademicosEntity that = (GradosAcademicosEntity) o;

        if (idGradoAcademico != that.idGradoAcademico) return false;
        if (nombreGrado != null ? !nombreGrado.equals(that.nombreGrado) : that.nombreGrado != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idGradoAcademico;
        result = 31 * result + (nombreGrado != null ? nombreGrado.hashCode() : 0);
        return result;
    }
}
