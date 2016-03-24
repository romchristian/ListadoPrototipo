/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generico;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Christian
 */
@Named
@ViewScoped
public class EjemploConsultaBean extends ConsultaGenerico<Ejemplo> implements Serializable {

    @EJB
    private IEjemploDAO ejb;

    @Override
    public Class<Ejemplo> getClazz() {
        return Ejemplo.class;
    }

    @Override
    public AbstractDAO<Ejemplo> getEjb() {
        return ejb;
    }

}
