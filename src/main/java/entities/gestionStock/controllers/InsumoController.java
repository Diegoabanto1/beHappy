package entities.gestionStock.controllers;

import daos.gestionStockDAO.repositorios.RepositorioStock;
import entities.gestionStock.Insumo;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@ApplicationScoped
public class InsumoController {
    @PersistenceContext(name = "beFruitPersistenceUnit")
    RepositorioStock rs;

    //Hay que mostrar el insumo con su unidad de medida
    public Insumo find(int id) {
        return rs.buscarInsumo(id);
    }

    public List<Insumo> findAll() {
        return rs.buscarInsumos();
    }

    public void create(Insumo i) {
        rs.crearInsumo(i);
    }

    public void update(int id, Insumo i) {
        rs.modificarInsumo(id, i);
    }

    public void remove(int id) {
        rs.eliminarInsumo(id);
    }
}
