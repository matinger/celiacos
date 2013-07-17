package Dao;

import Celiacos.Producto;

public class ProductoDAOhibernate extends GenericDAOhibernate<Producto> implements ProductoDAO {

	public ProductoDAOhibernate() {
		super(Producto.class);
		// TODO Auto-generated constructor stub
	}

}
