
package com.tienda.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name = "producto")
public class Producto implements Serializable {
    
    //Version de serialización
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "id_categoria")
    //private Long idCategoria; // id_categoria
    @Column(name = "id_producto")
    private Long idProducto; // id_categoria
    private String descripcion;
    private String detalle;
    private String precio;
    private int existencias;
    private String rutaImagen; //ruta_imagen
    private boolean activo;
    
    @ManyToOne
    @JoinColumn(name= "id_categoria")
    private Categoria categoria;
    
    public Producto(){
    
    }

    public Producto( String descripcion, String detalle, String precio, int existencias, String rutaImagen, boolean activo) {

        this.descripcion = descripcion;
        this.detalle = detalle;
        this.precio = precio;
        this.existencias = existencias;
        this.rutaImagen = rutaImagen;
        this.activo = activo;
    }
    
}
