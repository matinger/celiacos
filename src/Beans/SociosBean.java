package Beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import Celiacos.Pago;
import Celiacos.Perfil;
import Celiacos.Producto;
import Celiacos.Restaurante;
import Servicios.BarServicio;
import Servicios.ProductoServicio;
import Servicios.SocioServicio;

@ManagedBean
@SessionScoped
public class SociosBean {
	
		public List<Restaurante> getListaBares(){
			BarServicio b = new BarServicio();
			return b.getListaBares();
		
	}
		public List<Producto> getListaProductos(){
			ProductoServicio p = new ProductoServicio();
			return p.getListaProductos();
		}
		
		public List<Pago> getPagos(){
			FacesContext context = FacesContext.getCurrentInstance();
			Perfil p = (Perfil) context.getExternalContext().getSessionMap().get("perfil");
			SocioServicio s=new SocioServicio();
			return s.getPagos(p.getId());
		}
}