package Beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import Celiacos.Restaurante;
import Servicios.BarServicio;

@ManagedBean
@SessionScoped
public class BaresBean {
	
		public List<Restaurante> getListaBares(){
			BarServicio b = new BarServicio();
			return b.getListaBares();
		
	}
}
