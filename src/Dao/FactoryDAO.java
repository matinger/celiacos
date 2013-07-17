package Dao;

public class FactoryDAO {

	public static CuotaDAO getCuotaDAO(){
		return new CuotaDAOhibernate();
	}
	
	public static NotificacionDAO getNotificacionDAO(){
		return new NotificacionDAOhibernate();
	}
	
	public static PagoDAO getPagoDAO(){
		return new PagoDAOhibernate();
	}
	
	public static ProductoDAO getProductoDAO(){
		return new ProductoDAOhibernate();
	}
	
	public static PerfilDAO getPerfilDAO(){
		return new PerfilDAOhibernate();
	}
	
	public static PerfilSocioDAO getPerfilSocioDAO(){
		return new PerfilSocioDAOhibernate();
	}
	
	public static RestauranteDAO getRestauranteDAO(){
		return new RestauranteDAOhibernate();
	}
	
	public static TipoUnidadDAO getTipoUnidadDAO(){
		return new TipoUnidadDAOhibernate();
	}
	
	public static UsuarioDAO getUsuarioDAO(){
		return new UsuarioDAOhibernate();
	}
}
