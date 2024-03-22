package sv.edu.udb.repository.domain;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name = "pago_alumno", schema = "centro_escolar", catalog = "")
public class PagoAlumnoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_pago", nullable = false)
    private int idPago;
    @Basic
    @Column(name = "id_alumno", nullable = false)
    private int idAlumno;
    @Basic
    @Column(name = "monto_pago", nullable = false, precision = 2)
    private BigDecimal montoPago;
    @Basic
    @Column(name = "fecha_vencimiento", nullable = false)
    private Date fechaVencimiento;
    @Basic
    @Column(name = "fecha_pago", nullable = true)
    private Date fechaPago;
    @Basic
    @Column(name = "mora", nullable = true, precision = 2)
    private BigDecimal mora;
    @Basic
    @Column(name = "concepto", nullable = false, length = 100)
    private String concepto;
    @Basic
    @Column(name = "id_estado_pago", nullable = false)
    private int idEstadoPago;

    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public BigDecimal getMontoPago() {
        return montoPago;
    }

    public void setMontoPago(BigDecimal montoPago) {
        this.montoPago = montoPago;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public BigDecimal getMora() {
        return mora;
    }

    public void setMora(BigDecimal mora) {
        this.mora = mora;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public int getIdEstadoPago() {
        return idEstadoPago;
    }

    public void setIdEstadoPago(int idEstadoPago) {
        this.idEstadoPago = idEstadoPago;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PagoAlumnoEntity that = (PagoAlumnoEntity) o;

        if (idPago != that.idPago) return false;
        if (idAlumno != that.idAlumno) return false;
        if (idEstadoPago != that.idEstadoPago) return false;
        if (montoPago != null ? !montoPago.equals(that.montoPago) : that.montoPago != null) return false;
        if (fechaVencimiento != null ? !fechaVencimiento.equals(that.fechaVencimiento) : that.fechaVencimiento != null)
            return false;
        if (fechaPago != null ? !fechaPago.equals(that.fechaPago) : that.fechaPago != null) return false;
        if (mora != null ? !mora.equals(that.mora) : that.mora != null) return false;
        if (concepto != null ? !concepto.equals(that.concepto) : that.concepto != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idPago;
        result = 31 * result + idAlumno;
        result = 31 * result + (montoPago != null ? montoPago.hashCode() : 0);
        result = 31 * result + (fechaVencimiento != null ? fechaVencimiento.hashCode() : 0);
        result = 31 * result + (fechaPago != null ? fechaPago.hashCode() : 0);
        result = 31 * result + (mora != null ? mora.hashCode() : 0);
        result = 31 * result + (concepto != null ? concepto.hashCode() : 0);
        result = 31 * result + idEstadoPago;
        return result;
    }
}
