package Beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import Servicios.ProductoServicio;
import Celiacos.Producto;



@ManagedBean
@SessionScoped
public class ProductosBean {

	public List<Producto> getListaProductos(){
		ProductoServicio p = new ProductoServicio();
		return p.getListaProductos();
	
}
}
