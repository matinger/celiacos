package Celiacos;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import Dao.CuotaDAO;
import Dao.FactoryDAO;
import Dao.NotificacionDAO;
import Dao.PagoDAO;
import Dao.PerfilDAO;
import Dao.ProductoDAO;
import Dao.TipoUnidadDAO;
import Dao.UsuarioDAO;




public class Test {

	/**
	 * @param args
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		/*
		 * EntityManager em = FactoryManager.getInstance(); em.persist(new
		 * Usuario("root", "root",null));
		 * 
		 * em.close();
		 */
		
		DateFormat dfm = new SimpleDateFormat("yyyy-MM-dd");

		//Crea unidades
		Unidad unidad1 = new Unidad("Unidad 1","12 y 35","4111111","unidad1@email.com","Organizacion");
		UnidadCentral unidad2 = new UnidadCentral("Unidad 2 ","60 y 1","4222222","unidad2@email.com");
		
		//Guarda las unidades
		TipoUnidadDAO tipodao = FactoryDAO.getTipoUnidadDAO();
		tipodao.guardar(unidad1);
		tipodao.guardar(unidad2);
		
		//Crea usuarios
		Usuario us1 = new Usuario("adminunidad", "adminunidad");
		us1.setNombre("Antonio");us1.setApellido("Rogelio");
		Usuario us2 = new Usuario("socio", "socio");
		us2.setNombre("Eduardo");us2.setApellido("rivas");
		Usuario us3 = new Usuario("operador", "operador");
		us3.setNombre("Carlos");us3.setApellido("Vimonte");
		Usuario us4 = new Usuario("admincentral", "admincentral");
		us4.setNombre("Jose");us4.setApellido("Hernandez");
		Usuario us5 = new Usuario("socio2", "socio2");
		us5.setNombre("Carlos");us5.setApellido("Wimmer");
		
		//Guarda los usuarios
		UsuarioDAO usuariodao = FactoryDAO.getUsuarioDAO();
		usuariodao.guardar(us1);
		usuariodao.guardar(us2);
		usuariodao.guardar(us3);
		usuariodao.guardar(us4);
		usuariodao.guardar(us5);
		
		//Crea perfiles
		PerfilAdministradorUnidad perfiladministrador = new PerfilAdministradorUnidad();
		PerfilAdministradorCentral perfiladministradorcentral = new PerfilAdministradorCentral();
		PerfilOperadorUnidad perfiloperador = new PerfilOperadorUnidad();
		Date fechanac = dfm.parse("1990-06-01");
		Date fechadiag = dfm.parse("2005-03-11");
		PerfilSocio perfilsocio = new PerfilSocio(2021,3232322,"51 y 23", "estudiante", fechanac, fechadiag,fechadiag, "Dr. Pepe", "4333333","email4@email.com",false);
		
		Date fechanac2 = dfm.parse("1990-06-02");
		Date fechadiag2 = dfm.parse("2005-03-14");
		PerfilSocio perfilsocio2 = new PerfilSocio(2020,35410175,"50 y 120", "estudiante", fechanac2, fechadiag2,fechadiag, "Dr. Pepe", "4222222","email@email.com",false);
		
		//Asocia perfiles a unidades
		unidad1.addPerfil(perfiladministrador);
		unidad1.addPerfil(perfilsocio2);
		unidad2.addPerfil(perfilsocio);
		unidad2.addPerfil(perfiloperador);
		unidad2.addPerfil(perfiladministradorcentral);
		
		//Asocia los perfiles a los usuarios	
		us1.addPerfil(perfiladministrador);	
		us2.addPerfil(perfilsocio);	
		us3.addPerfil(perfiloperador);
		us4.addPerfil(perfiladministradorcentral);
		us5.addPerfil(perfilsocio2);
		
		//Guarda los perfiles
		PerfilDAO perfildao = FactoryDAO.getPerfilDAO();
		perfildao.guardar(perfilsocio);
		perfildao.guardar(perfilsocio2);
		perfildao.guardar(perfiloperador);
		perfildao.guardar(perfiladministrador);
		perfildao.guardar(perfiladministradorcentral);
		
		
		// Crea las cuotas
		Date cuota1 = dfm.parse("2013-06-01");
		Cuota cu = new Cuota(100, cuota1);
		Date cuota2 = dfm.parse("2013-05-01");
		Cuota cu2 = new Cuota(100, cuota2);
						
		//Asigna las cuotas a las unidades
		unidad1.addCuota(cu);
		unidad1.addCuota(cu2);
		
		//Guarda las cuotas
		CuotaDAO cuotadao = FactoryDAO.getCuotaDAO();
		cuotadao.guardar(cu);
		cuotadao.guardar(cu2);		
		
		//Creo pago
		Date d2 = dfm.parse("2013-06-10");
		Pago pago = new Pago(d2,100);
		
		//Asigno pago a socio y a cuota
		perfilsocio.addPago(pago);
		cu.addPago(pago);
		
		//Guardo pago
		PagoDAO pagodao = FactoryDAO.getPagoDAO();
		pagodao.guardar(pago);
		
		//Creo notificacion
		Notificacion noti = new Notificacion("Esta es la primera noti");
		
		//Asigno notificacion
		cu2.addNotificacion(noti);
		perfilsocio.addNotificacion(noti);
		
		//Guardo notificacion
		NotificacionDAO notidao = FactoryDAO.getNotificacionDAO();
		notidao.guardar(noti);
		
		// Se crean productos
		Date d4 = dfm.parse("2013-06-04");
		Date d5 = dfm.parse("2013-06-05");
		Date d6 = dfm.parse("2013-06-06");
		Producto p1 = new Producto("a","a","a","a","a","a",d4,d4);
		Producto p2 = new Producto("b","b","b","b","b","b",d5,d5);
		Producto p3 = new Producto("c","c","c","c","c","c",d6,d6);
	
		// Se crea Restaurante y se guarda
		Restaurante r1 = new Restaurante("c","c","c","c","c");
		FactoryDAO.getRestauranteDAO().guardar(r1);
		
		// Modifico restaurante y lo guardo
		r1.setCiudad("d");
		FactoryDAO.getRestauranteDAO().modificar(r1);
		
		//Se guardan productos
		ProductoDAO pd = FactoryDAO.getProductoDAO();
		pd.guardar(p1);
		pd.guardar(p2);
		pd.guardar(p3);
		
		// Se eliminan varios
		pd.eliminarPorId(p1.getId());
				
		System.out.println("Va a listar productos");

		List<Producto> productos =  pd.listar();
		
		System.out.println("En BBDD: ");
		
		// Se checkea encontrar un producto
		for(Producto item : productos){
			System.out.println("Producto: " + item.getNombre());
			System.out.println("Checkeando metodo encontrar de este producto");
			Producto p = (Producto) pd.encontrar(item.getId());
			System.out.println("Producto encontrado: " + p.getNombre());			
		}	
		
		List<TipoUnidad> tipounidades = tipodao.listar();
		for(TipoUnidad item : tipounidades){
			System.out.println("Unidad: " + item.getNombre());
			System.out.println("Cantidad de perfiles: " + item.getPerfiles().size());
		}

	}

}
