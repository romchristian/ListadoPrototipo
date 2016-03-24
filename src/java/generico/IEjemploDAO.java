/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generico;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Christian
 */
@Local
public interface IEjemploDAO extends AbstractDAO<Ejemplo> {

    @Override
    Ejemplo create(Ejemplo entity, String usuario);

    @Override
    Ejemplo edit(Ejemplo entity, String usuario);

    @Override
    Ejemplo find(Object id);

    @Override
    List<Ejemplo> findAll();

    @Override
    List<Ejemplo> findAll(String query, QueryParameter params);

    @Override
    void remove(Ejemplo entity, String usuario);

}
