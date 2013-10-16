package Filters;
 
import java.io.IOException;
import java.util.Hashtable;
 
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Celiacos.Perfil;

/**
 * Filter checks if LoginBean has loginIn property set to true.
 * If it is not set then request is being redirected to the login.xhml page.
 *
 * @author itcuties
 *
 */
public class AuthFilter implements Filter {
 
    /**
     * Checks if user is logged in. If not it redirects to the login.xhtml page.
     */
	
	private Hashtable roles = new Hashtable();
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        // check whether session variable is set
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession ses = req.getSession(false);
        
        if (ses == null || ses.getAttribute("perfil") == null ) {     	
            String contextPath = ((HttpServletRequest)request).getContextPath();
            ((HttpServletResponse)response).sendRedirect(contextPath + "");
        }else{     	
				String matchUri = (String) roles.get( ((Perfil)ses.getAttribute("perfil")).getClass().getName() );
				String reqURI = req.getRequestURI();

	           	if (!reqURI.contains(matchUri)){
	                   String contextPath = ((HttpServletRequest)request).getContextPath();
	                   ((HttpServletResponse)response).sendRedirect(contextPath + "/error.xhtml");
	           	}else{
	        		chain.doFilter(request, response);
	           	}
      		
        }
                
    } 
    public void init(FilterConfig config) throws ServletException {
        roles.put("Celiacos.PerfilAdministradorUnidad" , "/Celiacos/faces/adminunidad/");
        roles.put("Celiacos.PerfilAdministradorCentral" , "/Celiacos/faces/admincentral/");
        roles.put("Celiacos.PerfilOperadorUnidad" , "/Celiacos/faces/operadorunidad/");
        roles.put("Celiacos.PerfilOperadorCentral" , "/Celiacos/faces/operadorcentral/");
        roles.put("Celiacos.PerfilSocio" , "/Celiacos/faces/socio/");
    }
 
    public void destroy() {
        // Nothing to do here!
    }  
     
}