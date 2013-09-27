package Servicios;

import java.util.Date;
import java.util.List;

import Celiacos.Perfil;
import Celiacos.Producto;
import Celiacos.TipoUnidad;
import Celiacos.Usuario;
import Dao.FactoryDAO;
import Dao.PerfilDAO;
import Dao.ProductoDAO;
import Dao.UsuarioDAO;

public class ProductoServicio {
	ProductoDAO dao = FactoryDAO.getProductoDAO();	
	public List<Producto> getListaProductos() {
	
		
		List<Producto> productos = dao.listar();
		return productos;
	}
	
	public boolean eliminar(int id){
		System.out.println("El id a eliminar es: " + id);
		dao.eliminarPorId(id);
		return true;
	}
	
	public boolean modificar(Producto p){
		System.out.println("El id a editar es: " + p.getId());
		dao.modificar(p);
		
		return true;
	}
	
	public boolean crearProducto(String nombre, String marca,  String descripcion, Date fechaAlta, Date fechaCertificado, String rne, String rnpa, String empresa ) {
		
		Producto p = new Producto(nombre,marca,descripcion,rnpa,empresa,rne,fechaAlta,fechaCertificado);
		//Guarda los productos
		ProductoDAO productodao = FactoryDAO.getProductoDAO();
		productodao.guardar(p);
		
		return false;
	}
}
