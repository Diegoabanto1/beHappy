package entities.gestionStock;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

public class MovimientoStock {
    private int idMovimientoStock;
    private Integer idVenta;
    private Timestamp fechaHora;


    public int getIdMovimientoStock() {
        return idMovimientoStock;
    }

    public void setIdMovimientoStock(int idMovimientoStock) {
        this.idMovimientoStock = idMovimientoStock;
    }


    public Integer getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Integer idVenta) {
        this.idVenta = idVenta;
    }


    public Timestamp getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Timestamp fechaHora) {
        this.fechaHora = fechaHora;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovimientoStock that = (MovimientoStock) o;
        return idMovimientoStock == that.idMovimientoStock &&
                Objects.equals(idVenta, that.idVenta) &&
                Objects.equals(fechaHora, that.fechaHora);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idMovimientoStock, idVenta, fechaHora);
    }
}
