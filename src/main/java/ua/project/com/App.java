package ua.project.com;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entity.*;


/**
 * Hello world!
 *
 */
 public class App  {
	 
	 public static void main (String[] args) {
		 EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");
		 EntityManager em = factory.createEntityManager();
		 em.getTransaction().begin();
		 
		 Category category = new Category("category");
		 Firm firm = new Firm("Nike", "USA", "NY");
		 Order order = new Order();
		 for(int i = 1; i<=20; i++) {
			 Commodity c = new Commodity("commodity" + i, new BigDecimal(i*10),i);
			 c.setDetails(new C_Details("leather" + i, Size.M , "color" + i));
			 c.setFirm(firm);
			 c.setCategory(category);
			 c.setOrder(order);
//			 order.getCommodities().add(c);
//			 category.getCommodities().add(c);
//			 firm.getCommodities().add(c);
			 
			 em.persist(c);
		 }
//		 em.persist(firm);
//		 em.persist(category);
		 
		 List<Commodity> commodities = em.createQuery("select c from Commodity c", Commodity.class).getResultList();
		 commodities.forEach(c -> System.out.println(c));
		 
		 em.getTransaction().commit();
		 
		 em.close();
		 factory.close();
	 }
 }

