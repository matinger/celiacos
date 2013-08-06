package Beans;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

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
			
			FacesContext context = FacesContext.getCurrentInstance();
			context.getExternalContext().getSessionMap().put("perfil", p);
			
			return p.getClass().getName();
		} else {
			FacesContext context = FacesContext.getCurrentInstance();
			FacesMessage message = new FacesMessage("Invalid Username and/or Password");
			context.addMessage("loginForm", message);
			return "failure";
		}
	}
	public void logout() {
		ExternalContext ctx = FacesContext.getCurrentInstance().getExternalContext();
			  String ctxPath = ((ServletContext) ctx.getContext()).getContextPath();

			  try {
			    // Usar el contexto de JSF para invalidar la sesión,
			    // NO EL DE SERVLETS (nada de HttpServletRequest)
			    ((HttpSession) ctx.getSession(false)).invalidate();

			    // Redirección de nuevo con el contexto de JSF,
			    // si se usa una HttpServletResponse fallará.
			    // Sin embargo, como ya está fuera del ciclo de vida 
			    // de JSF se debe usar la ruta completa -_-U
			    ctx.redirect(ctxPath + "/faces/login.xhtml");
			  } catch (IOException ex) {
			    ex.printStackTrace();
			  }
	}
}
