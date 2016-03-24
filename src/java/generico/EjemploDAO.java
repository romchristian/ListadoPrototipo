/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generico;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.Query;

/**
 *
 * @author Christian
 */
@Stateless

@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class EjemploDAO implements IEjemploDAO {

    @EJB(beanName = "ABMServiceBean")
    private ABMService abmService;

    @Override
    public Ejemplo create(Ejemplo entity, String usuario) {
        return abmService.create(entity, usuario);
    }

    @Override
    public Ejemplo edit(Ejemplo entity, String usuario) {
        return abmService.update(entity, usuario);
    }

    @Override
    public Ejemplo find(Object id) {
        return abmService.find(id, Ejemplo.class);
    }

    @Override
    public List<Ejemplo> findAll() {
        return Ejemplo.getMockList();
    }

    @Override
    public List<Ejemplo> findAll(String query, QueryParameter params) {
        return abmService.getEM().createQuery("select obj from Ejemplo obj").getResultList();
    }

    @Override
    public void remove(Ejemplo entity, String usuario) {
        abmService.delete(entity, usuario);
    }

    @Override
    public List<Ejemplo> findAllActive() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Ejemplo> findAllActive(String query, QueryParameter params) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Ejemplo> findFilter(String filter) {
        System.out.println("Filters: " + filter);
        Query query = abmService.getEM().createNativeQuery("SELECT * FROM ejemplo " + filter, Ejemplo.class);
        List<Ejemplo> items = (List<Ejemplo>) query.getResultList();
        return items;
    }

}
