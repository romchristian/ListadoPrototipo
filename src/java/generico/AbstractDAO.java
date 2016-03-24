/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package generico;

import java.util.List;

/**
 *
 * @author christian
 */
public interface AbstractDAO<T> {

    public abstract T create(T entity,String usuario);

    public abstract T edit(T entity,String usuario);

    public abstract void remove(T entity,String usuario);

    public abstract T find(Object id);

    public abstract List<T> findAll();
    
    public abstract List<T> findFilter(String filter);

    public abstract List<T> findAll(String query, QueryParameter params);
    
    public abstract List<T> findAllActive();
    
    public abstract List<T> findAllActive(String query, QueryParameter params);
}
