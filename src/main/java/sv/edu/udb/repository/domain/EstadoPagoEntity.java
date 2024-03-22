package sv.edu.udb.repository.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "estado_pago", schema = "centro_escolar")
public class EstadoPagoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_estado_pago", nullable = false)
    private int idEstadoPago;
    @Basic
    @Column(name = "estado_pago", nullable = false, length = 150)
    private String estadoPago;

    public int getIdEstadoPago() {
        return idEstadoPago;
    }

    public void setIdEstadoPago(int idEstadoPago) {
        this.idEstadoPago = idEstadoPago;
    }

    public String getEstadoPago() {
        return estadoPago;
    }

    public void setEstadoPago(String estadoPago) {
        this.estadoPago = estadoPago;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EstadoPagoEntity that = (EstadoPagoEntity) o;

        if (idEstadoPago != that.idEstadoPago) return false;
        if (estadoPago != null ? !estadoPago.equals(that.estadoPago) : that.estadoPago != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idEstadoPago;
        result = 31 * result + (estadoPago != null ? estadoPago.hashCode() : 0);
        return result;
    }
}
