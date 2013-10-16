package Filters;

import java.io.IOException;

import javax.faces.context.FacesContext;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Celiacos.Perfil;
import Celiacos.PerfilSocio;
import Dao.FactoryDAO;

/**
 * Servlet Filter implementation class Socio
 */

public class Socio implements Filter {

    /**
     * Default constructor. 
     */
    public Socio() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        // check whether session variable is set
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession ses = req.getSession(false);
             	
        	FacesContext context = FacesContext.getCurrentInstance();
    		PerfilSocio p = (PerfilSocio) context.getExternalContext().getSessionMap().get("perfil");
    		
    		if (!p.isBeneficio() ){
                String contextPath = ((HttpServletRequest)request).getContextPath();
                ((HttpServletResponse)response).sendRedirect(contextPath + "/error");
        	}
        
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
