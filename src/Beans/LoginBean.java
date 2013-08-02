package Beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import Celiacos.Perfil;
import Celiacos.Usuario;
import Servicios.UsuarioServicio;

@ManagedBean
@SessionScoped
public class LoginBean {
	
	String username;
	String password;
	
	public LoginBean() {}
	public String getUsername() { return this.username; }
	public void setUsername(String data) { this.username = data; }
	public String getPassword() { return password; }
	public void setPassword(String data) {this.password = data; }
	
	public String login() {
		UsuarioServicio us = new UsuarioServicio();
		Usuario u = us.validarUsuario(username, password);
		if ( u != null) {
			Perfil p = u.getPerfiles().get(0);
			return p.getClass().getName();
		} else {
			FacesContext context = FacesContext.getCurrentInstance();
			FacesMessage message = new FacesMessage("Invalid Username and/or Password");
			context.addMessage("loginForm", message);
			return "failure";
		}
	}
}
