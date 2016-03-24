/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generico;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Christian
 */
public abstract class ConsultaGenerico<T> {

    private List<FiltroGenerico> filterOptions;
    private List<T> lista;

    public List<T> getLista() {
        return lista;
    }

    public void setLista(List<T> lista) {
        this.lista = lista;
    }

    public List<FiltroGenerico> getFilterOptions() {
        if (filterOptions == null) {
            loadFields();
        }
        return filterOptions;
    }

    public void setFilterOptions(List<FiltroGenerico> filterOptions) {
        this.filterOptions = filterOptions;
    }

    public abstract Class<T> getClazz();

    public void loadFields() {
        Field[] fields = getClazz().getDeclaredFields();
        filterOptions = new ArrayList<>();

        for (Field f : fields) {
            System.out.println("Nombre: " + f.getName());
            System.out.println("Tipo: " + f.getGenericType().getTypeName());
            if (f.getAnnotation(Listado.class) != null && f.getAnnotation(Listado.class).mostrar()) {
                String descripcion = f.getAnnotation(Listado.class).descripcion();
                filterOptions.add(new FiltroGenerico(descripcion, f.getName(), f.getGenericType().getTypeName()));
            }
        }

    }

    public void buscar() {
        construyeConsulta();
    }

    public List<T> findAll() {
        return getEjb().findAll();
    }

    public abstract AbstractDAO<T> getEjb();

    private void construyeConsulta() {
        lista = getEjb().findFilter(construyeFilters());
    }
    
    private String construyeFilters(){
        StringBuilder sb = new StringBuilder(" WHERE 1 = 1 ");
        for(FiltroGenerico f: filterOptions){
            if(f.tieneValor()){
                sb.append(f.getCadenaFiltro());
            }
        }
        
        return sb.toString();
    }
    
    

}
