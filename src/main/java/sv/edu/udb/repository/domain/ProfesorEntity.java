package sv.edu.udb.repository.domain;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "profesor", schema = "centro_escolar")
@NamedQueries({
        @NamedQuery(name = "ProfesorEntity.findAll", query = "SELECT p FROM ProfesorEntity p"),
        @NamedQuery(name = "ProfesorEntity.isExist", query = "SELECT COUNT(p) FROM ProfesorEntity p WHERE p.carnetProfesor = :carnetProfesor"),
        @NamedQuery(name = "ProfesorEntity.findByCarnetProfesor", query = "SELECT p FROM ProfesorEntity p WHERE p.carnetProfesor = :carnetProfesor"),
        @NamedQuery(name = "ProfesorEntity.findByNombreProfesor", query = "SELECT p FROM ProfesorEntity p WHERE p.nombreProfesor = :nombreProfesor"),
        @NamedQuery(name = "ProfesorEntity.findByApellidoProfesor", query = "SELECT p FROM ProfesorEntity p WHERE p.apellidoProfesor = :apellidoProfesor"),
        @NamedQuery(name = "ProfesorEntity.findByTelefono", query = "SELECT p FROM ProfesorEntity p WHERE p.telefono = :telefono"),
        @NamedQuery(name = "ProfesorEntity.findByCorreo", query = "SELECT p FROM ProfesorEntity p WHERE p.correo = :correo"),
        @NamedQuery(name = "ProfesorEntity.findByFechaNacimiento", query = "SELECT p FROM ProfesorEntity p WHERE p.fechaNacimiento = :fechaNacimiento"),
        @NamedQuery(name = "ProfesorEntity.findByIdEstadoProfesor", query = "SELECT p FROM ProfesorEntity p WHERE p.idEstadoProfesor = :idEstadoProfesor")
})

public class ProfesorEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_profesor", nullable = false)
    private int idProfesor;
    @Basic
    @Column(name = "carnet_profesor", nullable = false, length = 8)
    private String carnetProfesor;
    @Basic
    @Column(name = "nombre_profesor", nullable = false, length = 150)
    private String nombreProfesor;
    @Basic
    @Column(name = "apellido_profesor", nullable = false, length = 150)
    private String apellidoProfesor;
    @Basic
    @Column(name = "telefono", nullable = false, length = 9)
    private String telefono;
    @Basic
    @Column(name = "correo", nullable = false, length = 150)
    private String correo;
    @Basic
    @Column(name = "fecha_nacimiento", nullable = false)
    private Date fechaNacimiento;
    @Basic
    @Column(name = "id_estado_profesor", nullable = true)
    private Integer idEstadoProfesor;

    public int getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(int idProfesor) {
        this.idProfesor = idProfesor;
    }

    public String getCarnetProfesor() {
        return carnetProfesor;
    }

    public void setCarnetProfesor(String carnetProfesor) {
        this.carnetProfesor = carnetProfesor;
    }

    public String getNombreProfesor() {
        return nombreProfesor;
    }

    public void setNombreProfesor(String nombreProfesor) {
        this.nombreProfesor = nombreProfesor;
    }

    public String getApellidoProfesor() {
        return apellidoProfesor;
    }

    public void setApellidoProfesor(String apellidoProfesor) {
        this.apellidoProfesor = apellidoProfesor;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Integer getIdEstadoProfesor() {
        return idEstadoProfesor;
    }

    public void setIdEstadoProfesor(Integer idEstadoProfesor) {
        this.idEstadoProfesor = idEstadoProfesor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProfesorEntity that = (ProfesorEntity) o;

        if (idProfesor != that.idProfesor) return false;
        if (carnetProfesor != null ? !carnetProfesor.equals(that.carnetProfesor) : that.carnetProfesor != null)
            return false;
        if (nombreProfesor != null ? !nombreProfesor.equals(that.nombreProfesor) : that.nombreProfesor != null)
            return false;
        if (apellidoProfesor != null ? !apellidoProfesor.equals(that.apellidoProfesor) : that.apellidoProfesor != null)
            return false;
        if (telefono != null ? !telefono.equals(that.telefono) : that.telefono != null) return false;
        if (correo != null ? !correo.equals(that.correo) : that.correo != null) return false;
        if (fechaNacimiento != null ? !fechaNacimiento.equals(that.fechaNacimiento) : that.fechaNacimiento != null)
            return false;
        if (idEstadoProfesor != null ? !idEstadoProfesor.equals(that.idEstadoProfesor) : that.idEstadoProfesor != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idProfesor;
        result = 31 * result + (carnetProfesor != null ? carnetProfesor.hashCode() : 0);
        result = 31 * result + (nombreProfesor != null ? nombreProfesor.hashCode() : 0);
        result = 31 * result + (apellidoProfesor != null ? apellidoProfesor.hashCode() : 0);
        result = 31 * result + (telefono != null ? telefono.hashCode() : 0);
        result = 31 * result + (correo != null ? correo.hashCode() : 0);
        result = 31 * result + (fechaNacimiento != null ? fechaNacimiento.hashCode() : 0);
        result = 31 * result + (idEstadoProfesor != null ? idEstadoProfesor.hashCode() : 0);
        return result;
    }
}
