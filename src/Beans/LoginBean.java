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
import Dao.FactoryDAO;
import Dao.ProductoDAO;
import Dao.UsuarioDAO;
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

			HttpSession session =  (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
            
			List<Perfil> perfiles = u.getPerfiles();
			FacesContext context = FacesContext.getCurrentInstance();
			Perfil p = perfiles.get(0);			            
			session.setAttribute("perfil", p);
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
		ctx.getSessionMap().remove(ctx.getSessionMap().get("perfil"));
			  String ctxPath = ((ServletContext) ctx.getContext()).getContextPath();
			  try {
			    // Usar el contexto de JSF para invalidar la sesión,
			    // NO EL DE SERVLETS (nada de HttpServletRequest)
			    ((HttpSession) ctx.getSession(false)).invalidate();

			    // Redirección de nuevo con el contexto de JSF,
			    // si se usa una HttpServletResponse fallará.
			    // Sin embargo, como ya está fuera del ciclo de vida 
			    // de JSF se debe usar la ruta completa -_-U
			    ctx.redirect(ctxPath);
			  } catch (IOException ex) {
			    ex.printStackTrace();
			  }
	}
	public void modificar(){
		UsuarioServicio us = new UsuarioServicio();
		//Usuario u = us.validarUsuario(this.getUsername(), this.getPassword());
		
		HttpSession session =  (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		Perfil p=(Perfil) session.getAttribute("perfil");
		Usuario usu= p.getUsuario();
		usu.setUsuario(this.getUsername());
		usu.setPassword(this.getPassword());
		if(us.esValido(usu.getUsuario())){
			System.out.println("El usuario es: "+usu.getUsuario());
			System.out.println("La contraseña es: "+usu.getPassword());
		UsuarioDAO dao = FactoryDAO.getUsuarioDAO();	
		dao.modificar(usu);
		}
		else {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage("El usuario ya existe");
		context.addMessage("perfilform", message);
		}
	}
	
}
