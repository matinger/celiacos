package Beans;

import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import Servicios.GestionAdminServicio;
import Servicios.GestionOperadorServicio;
import Servicios.GestionUnidadesServicio;
import Servicios.ProductoServicio;
import Celiacos.Producto;



@ManagedBean
@SessionScoped
public class ProductosBean {
	private String nombre;
	private String marca;
	private String descripcion;
	private Date fechaAlta;
	private Date fechaCertificado;
	private String rne;
	private String rnpa;
	private String empresa;
	private Producto productoEditar;
	private int productoEliminar;

	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
		if(productoEditar !=null)
			productoEditar.setNombre(nombre);
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
		if(productoEditar !=null)
			productoEditar.setMarca(marca);
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
		if(productoEditar !=null)
			productoEditar.setDescripcion(descripcion);
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
		if(productoEditar !=null)
			productoEditar.setFechaAlta(fechaAlta);
	}

	public Date getFechaCertificado() {
		return fechaCertificado;
	}

	public void setFechaCertificado(Date fechaCertificado) {
		this.fechaCertificado = fechaCertificado;
		if(productoEditar !=null)
			productoEditar.setFechaCertificado(fechaCertificado);
	}

	public String getRne() {
		return rne;
	}

	public void setRne(String rne) {
		this.rne = rne;
		if(productoEditar !=null)
			productoEditar.setRne(rne);
	}

	public String getRnpa() {
		return rnpa;
	}

	public void setRnpa(String rnpa) {
		this.rnpa = rnpa;
		if(productoEditar !=null)
			productoEditar.setRnpa(rnpa);
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
		if(productoEditar !=null)
			productoEditar.setEmpresa(empresa);
	}
	

	public Producto getProductoEditar() {
		return productoEditar;
	}

	public void setProductoEditar(Producto producto) {
		this.productoEditar = producto;
	}

	public List<Producto> getListaProductos(){
		ProductoServicio p = new ProductoServicio();
		return p.getListaProductos();
	}
	
	public boolean eliminar(){
		ProductoServicio p = new ProductoServicio();		
		return p.eliminar(productoEliminar);
	}
	public boolean editar(){
		ProductoServicio p = new ProductoServicio();	
		return p.modificar(productoEditar);
		
	}
	public String editarProducto() {  
		this.setDescripcion(productoEditar.getDescripcion());
		this.setEmpresa(productoEditar.getEmpresa());
		this.setFechaAlta(productoEditar.getFechaAlta());
		this.setFechaCertificado(productoEditar.getFechaCertificado());
		this.setMarca(productoEditar.getMarca());
		this.setNombre(productoEditar.getNombre());
		this.setRne(productoEditar.getRne());
		this.setRnpa(productoEditar.getRnpa());
		return "editarproducto";
	}
	
	public void crearProducto(){
		ProductoServicio p = new ProductoServicio();
		p.crearProducto(nombre,marca,descripcion,fechaAlta,fechaCertificado,rne,rnpa,empresa );
	}

	public int getProductoEliminar() {
		return productoEliminar;
	}

	public void setProductoEliminar(int productoEliminar) {
		this.productoEliminar = productoEliminar;
	}
	public void clear(){

		this.setNombre(null);
		this.setDescripcion(null);
		this.setEmpresa(null);
		this.setFechaAlta(null);
		this.setFechaCertificado(null);
		this.setRne(null);
		this.setRnpa(null);
		this.setMarca(null);
	}
}
