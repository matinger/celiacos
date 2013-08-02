package Beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import Servicios.GestionSociosServicio;

import Celiacos.PerfilSocio;

@ManagedBean
@SessionScoped
public class GestionSociosBean {
	public List<PerfilSocio> getListaSocios(){
		GestionSociosServicio g = new GestionSociosServicio();
		return g.getListaPersonas();
	}
}
