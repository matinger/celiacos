package Servlets;

import java.io.IOException;
import java.util.Hashtable;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Celiacos.Usuario;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Hashtable usuarios;
    /**
     * Default constructor. 
     */
    public Login() {
        // TODO Auto-generated constructor stub
    }
	public void init(ServletConfig config) throws ServletException {
		
		usuarios= new Hashtable();
		Usuario u1,u2,u3,u4,u5,u6;
		/*
		u1 = new Usuario("socio","socio","socio");
		u2 = new Usuario("operadorunidad","operadorunidad","operadorunidad");
		u3 = new Usuario("adminunidad","adminunidad","adminunidad");
		u4 = new Usuario("sociovirtual","sociovirtual","sociovirtual");
		u5 = new Usuario("operadorcentral","operadorcentral","operadorcentral");
		u6 = new Usuario("admincentral","admincentral","admincentral");

		usuarios.put(u1.getUsuario(),u1);
		usuarios.put(u2.getUsuario(),u2);
		usuarios.put(u3.getUsuario(),u3);
		usuarios.put(u4.getUsuario(),u4);
		usuarios.put(u5.getUsuario(),u5);
		usuarios.put(u6.getUsuario(),u6);
*/
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected boolean validar(String usuario, String password){
		boolean ok = false;
		if(usuarios.containsKey(usuario)){
			ok = (((Usuario)usuarios.get(usuario)).getPassword().equals(password));
		}
		return ok;
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String u= request.getParameter("username");
		if (validar(u,request.getParameter("password"))){
			//response.sendRedirect(((Usuario)usuarios.get(u)).getPerfil() + ".html");
		}else{
			response.sendRedirect("index.html");
		}
	}

}
