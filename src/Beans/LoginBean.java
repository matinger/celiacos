package Beans;

import java.io.IOException;
import java.util.List;

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
			List<Perfil> perfiles = u.getPerfiles();
			FacesContext context = FacesContext.getCurrentInstance();
			if (perfiles.size() == 1){
				Perfil p = perfiles.get(0);			
				context.getExternalContext().getSessionMap().put("perfil", p);				
				return p.getClass().getName();
			}else{			
				context.getExternalContext().getSessionMap().put("perfiles", perfiles);				
				return "perfiles";
			}
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
			    ctx.redirect(ctxPath + "/faces/login/login.xhtml");
			  } catch (IOException ex) {
			    ex.printStackTrace();
			  }
	}
}
