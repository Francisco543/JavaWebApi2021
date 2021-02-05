package ar.com.educacionit.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import ar.com.educacionit.domain.Producto;
import ar.com.educacionit.domain.TipoProducto;
import ar.com.educacionit.repository.hibernate.HibernateUtils;

public class TestAltaProducto {
	
	public static void main(String[] args) {
		
		SessionFactory sf = HibernateUtils.getSessionFactory();
		
		Producto p = new Producto();
		
		p.setCodigo("abc001");
		p.setPrecio(1500f);
		p.setTitulo("mouse");
		TipoProducto tp = new TipoProducto();
		tp.setDescripcion("Tipo1");
		p.setTipoProducto(tp);
		
		Session session = sf.getCurrentSession();
		
		session.beginTransaction();
		
		session.saveOrUpdate(tp);
		session.getTransaction().commit();
	}
}
