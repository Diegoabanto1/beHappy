package entities.gestionStock.controllers;

import entities.gestionStock.DetalleMovimientoStock;
import entities.gestionStock.Insumo;
import entities.gestionStock.MovimientoStock;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class MovimientoStockController {
    @PersistenceContext(name = "beFruitPersistenceUnit")
    EntityManager entityManager;

    //Se debe devolver el movimiento solicitado junto con sus correspondientes detalles
    //Ver que el metodo siguiente lo cumpla
    public MovimientoStock find(int id) {
        MovimientoStock actual = entityManager.find(MovimientoStock.class, id);
        List<DetalleMovimientoStock> detalles = buscarDetalles(actual.getIdMovimientoStock());

        for (DetalleMovimientoStock d: detalles) {
            actual.addDetalle(d);
        }
        return actual;
    }

    private List<DetalleMovimientoStock> buscarDetalles(int idMovimiento){
        Query q = entityManager.createQuery("SELECT i FROM DetalleMovimientoStock i WHERE i.idMovimiento = :idMov")
                .setParameter("idMov", idMovimiento);
        return  q.getResultList();
    }

    //Se deben devolver los movimientos junto con sus correspondientes detalles
    //Ver que el metodo siguiente lo cumpla
    public List<MovimientoStock> findAll() {
        List<MovimientoStock> movimientos = entityManager.createQuery("SELECT i FROM MovimientoStock i").getResultList();
        for (MovimientoStock m: movimientos) {
            List<DetalleMovimientoStock> detalles = buscarDetalles(m.getIdMovimientoStock());
            for (DetalleMovimientoStock d: detalles) {
                m.addDetalle(d);
            }
        }
        return movimientos;
    }

    //Cuando se creen los movimientos tambien se deben crear sus detalles
    public void create(MovimientoStock i) {
        if (entityManager.find(MovimientoStock.class, i.getIdMovimientoStock()) == null)
            entityManager.persist(i);
    }
    
    //Cambiar para que el remove haga un set con la fecha actual a la columna FechaAnulacion y que recorran todos los detalles
    //Cuando se recorren los detalles se debe deshacer el movimiento, para eso se ve si el movimiento es una entrada o salida
    public void remove(int id) {
        Insumo x = entityManager.find(Insumo.class, id);
        if (x != null) entityManager.remove(x);
    }
}
