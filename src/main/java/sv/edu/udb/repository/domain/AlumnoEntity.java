package sv.edu.udb.repository.domain;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "alumno", schema = "centro_escolar")
@NamedQueries({
        @NamedQuery(name = "AlumnoEntity.findAll", query = "SELECT a FROM AlumnoEntity a"),
        @NamedQuery(name = "AlumnoEntity.isExist", query = "SELECT COUNT(a) FROM AlumnoEntity a WHERE a.carnet = :carnet"),
        @NamedQuery(name = "AlumnoEntity.findByCarnet", query = "SELECT a FROM AlumnoEntity a WHERE a.carnet = :carnet"),
        @NamedQuery(name = "AlumnoEntity.findByNombreAlumno", query = "SELECT a FROM AlumnoEntity a WHERE a.nombreAlumno = :nombreAlumno"),
        @NamedQuery(name = "AlumnoEntity.findByApellidoAlumno", query = "SELECT a FROM AlumnoEntity a WHERE a.apellidoAlumno = :apellidoAlumno"),
        @NamedQuery(name = "AlumnoEntity.findByTelefonoContacto", query = "SELECT a FROM AlumnoEntity a WHERE a.telefonoContacto = :telefonoContacto"),
        @NamedQuery(name = "AlumnoEntity.findByNombreResponsable", query = "SELECT a FROM AlumnoEntity a WHERE a.nombreResponsable = :nombreResponsable"),
        @NamedQuery(name = "AlumnoEntity.findByFechaNacimiento", query = "SELECT a FROM AlumnoEntity a WHERE a.fechaNacimiento = :fechaNacimiento"),
        @NamedQuery(name = "AlumnoEntity.findByIdEstadoAlumno", query = "SELECT a FROM AlumnoEntity a WHERE a.idEstadoAlumno = :idEstadoAlumno"),
        @NamedQuery(name = "AlumnoEntity.findByIdTipoAlumno", query = "SELECT a FROM AlumnoEntity a WHERE a.idTipoAlumno = :idTipoAlumno"),
        @NamedQuery(name = "AlumnoEntity.findByIdGradoAcademido", query = "SELECT a FROM AlumnoEntity a WHERE a.idGradoAcademido = :idGradoAcademido")
})


public class AlumnoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_alumno", nullable = false)
    private int idAlumno;
    @Basic
    @Column(name = "carnet", nullable = false, length = 8)
    private String carnet;
    @Basic
    @Column(name = "nombre_alumno", nullable = false, length = 150)
    private String nombreAlumno;
    @Basic
    @Column(name = "apellido_alumno", nullable = false, length = 150)
    private String apellidoAlumno;
    @Basic
    @Column(name = "telefono_contacto", nullable = false, length = 9)
    private String telefonoContacto;
    @Basic
    @Column(name = "nombre_responsable", nullable = false, length = 150)
    private String nombreResponsable;
    @Basic
    @Column(name = "id_estado_alumno", nullable = false)
    private int idEstadoAlumno;
    @Basic
    @Column(name = "id_tipo_alumno", nullable = false)
    private int idTipoAlumno;
    @Basic
    @Column(name = "fecha_nacimiento", nullable = false)
    private Date fechaNacimiento;
    @Basic
    @Column(name = "id_grado_academido", nullable = false)
    private int idGradoAcademido;

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    public String getNombreAlumno() {
        return nombreAlumno;
    }

    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }

    public String getApellidoAlumno() {
        return apellidoAlumno;
    }

    public void setApellidoAlumno(String apellidoAlumno) {
        this.apellidoAlumno = apellidoAlumno;
    }

    public String getTelefonoContacto() {
        return telefonoContacto;
    }

    public void setTelefonoContacto(String telefonoContacto) {
        this.telefonoContacto = telefonoContacto;
    }

    public String getNombreResponsable() {
        return nombreResponsable;
    }

    public void setNombreResponsable(String nombreResponsable) {
        this.nombreResponsable = nombreResponsable;
    }

    public int getIdEstadoAlumno() {
        return idEstadoAlumno;
    }

    public void setIdEstadoAlumno(int idEstadoAlumno) {
        this.idEstadoAlumno = idEstadoAlumno;
    }

    public int getIdTipoAlumno() {
        return idTipoAlumno;
    }

    public void setIdTipoAlumno(int idTipoAlumno) {
        this.idTipoAlumno = idTipoAlumno;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
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

        AlumnoEntity that = (AlumnoEntity) o;

        if (idAlumno != that.idAlumno) return false;
        if (idEstadoAlumno != that.idEstadoAlumno) return false;
        if (idTipoAlumno != that.idTipoAlumno) return false;
        if (idGradoAcademido != that.idGradoAcademido) return false;
        if (carnet != null ? !carnet.equals(that.carnet) : that.carnet != null) return false;
        if (nombreAlumno != null ? !nombreAlumno.equals(that.nombreAlumno) : that.nombreAlumno != null) return false;
        if (apellidoAlumno != null ? !apellidoAlumno.equals(that.apellidoAlumno) : that.apellidoAlumno != null)
            return false;
        if (telefonoContacto != null ? !telefonoContacto.equals(that.telefonoContacto) : that.telefonoContacto != null)
            return false;
        if (nombreResponsable != null ? !nombreResponsable.equals(that.nombreResponsable) : that.nombreResponsable != null)
            return false;
        if (fechaNacimiento != null ? !fechaNacimiento.equals(that.fechaNacimiento) : that.fechaNacimiento != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idAlumno;
        result = 31 * result + (carnet != null ? carnet.hashCode() : 0);
        result = 31 * result + (nombreAlumno != null ? nombreAlumno.hashCode() : 0);
        result = 31 * result + (apellidoAlumno != null ? apellidoAlumno.hashCode() : 0);
        result = 31 * result + (telefonoContacto != null ? telefonoContacto.hashCode() : 0);
        result = 31 * result + (nombreResponsable != null ? nombreResponsable.hashCode() : 0);
        result = 31 * result + idEstadoAlumno;
        result = 31 * result + idTipoAlumno;
        result = 31 * result + (fechaNacimiento != null ? fechaNacimiento.hashCode() : 0);
        result = 31 * result + idGradoAcademido;
        return result;
    }
}
