package entities.gestionFranquicia;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Franquicias", schema = "BeFruit", catalog = "")
public class Franquicia {
    private int idFranquicia;
    private int cuit;
    private String direccion;
    private String nombreDueno;
    private String eMailDueno;
    private String apellidoDueno;

    @Id
    @Column(name = "idFranquicia")
    public int getIdFranquicia() {
        return idFranquicia;
    }

    public void setIdFranquicia(int idFranquicia) {
        this.idFranquicia = idFranquicia;
    }

    @Basic
    @Column(name = "CUIT")
    public int getCuit() {
        return cuit;
    }

    public void setCuit(int cuit) {
        this.cuit = cuit;
    }

    @Basic
    @Column(name = "direccion")
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Basic
    @Column(name = "nombreDueno")
    public String getNombreDueno() {
        return nombreDueno;
    }

    public void setNombreDueno(String nombreDueno) {
        this.nombreDueno = nombreDueno;
    }

    @Basic
    @Column(name = "eMailDueno")
    public String geteMailDueno() {
        return eMailDueno;
    }

    public void seteMailDueno(String eMailDueno) {
        this.eMailDueno = eMailDueno;
    }

    @Basic
    @Column(name = "apellidoDueno")
    public String getApellidoDueno() {
        return apellidoDueno;
    }

    public void setApellidoDueno(String apellidoDueno) {
        this.apellidoDueno = apellidoDueno;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Franquicia that = (Franquicia) o;
        return idFranquicia == that.idFranquicia &&
                cuit == that.cuit &&
                Objects.equals(direccion, that.direccion) &&
                Objects.equals(nombreDueno, that.nombreDueno) &&
                Objects.equals(eMailDueno, that.eMailDueno) &&
                Objects.equals(apellidoDueno, that.apellidoDueno);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idFranquicia, cuit, direccion, nombreDueno, eMailDueno, apellidoDueno);
    }
}
