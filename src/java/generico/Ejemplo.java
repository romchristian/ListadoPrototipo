/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generico;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Christian
 */
@Entity
public class Ejemplo implements Serializable{
    @Id
    @Listado(mostrar = false)
    private Long id;
    @Listado(descripcion = "Nombre",mostrar = true)
    private String nombre;
    @Listado(descripcion = "Monto",mostrar = true)
    private Double monto;
    @Listado(descripcion = "Fecha",mostrar = true)
    private Date fecha;

    public Ejemplo(Long id, String nombre, Double monto, Date fecha) {
        this.id = id;
        this.nombre = nombre;
        this.monto = monto;
        this.fecha = fecha;
    }

    public Ejemplo() {
    }

    
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    
    public static List<Ejemplo> getMockList(){
        List<Ejemplo> R = new ArrayList<>();
        R.add(new Ejemplo(1L, "Nombre1", 10000.0, new Date()));
        R.add(new Ejemplo(2L, "Nombre2", 20000.0, new Date()));
        R.add(new Ejemplo(3L, "Nombre3", 30000.0, new Date()));
        R.add(new Ejemplo(4L, "Nombre4", 40000.0, new Date()));
        R.add(new Ejemplo(5L, "Nombre5", 50000.0, new Date()));
        R.add(new Ejemplo(6L, "Nombre6", 60000.0, new Date()));
        
        return R;
    }
    
}
