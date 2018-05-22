package com.konovalov.menu;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;
import java.util.Scanner;

public class MenuUtil {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA");
    private EntityManager em = emf.createEntityManager();
    private Scanner sc = new Scanner(System.in);

    public MenuUtil() {
    }

    public void close() {
        emf.close();
        sc.close();
    }

    public void add() {
        System.out.println("ADD MENU GO");
        System.out.println("Input name food");
        String name = sc.nextLine();
        System.out.println("Input price food");
        int price = sc.nextInt();
        System.out.println("Input weight food");
        int weight = sc.nextInt();
        System.out.println("Input % discount food, '0' if discount =0(not discount)");
        int discount = sc.nextInt();

        em.getTransaction().begin();
        try {
            Menu menu = new Menu(name, price, weight, discount);
            em.persist(menu);
            em.getTransaction().commit();
            System.out.println("ADD MENU OK");
        } catch (Exception ex) {
            em.getTransaction().rollback();
            System.out.println("ADD MENU NO");
        }
    }

    public void addFast(Menu menu) {
        em.getTransaction().begin();
        try {
            em.persist(menu);
            em.getTransaction().commit();
            System.out.println("ADD MENU OK");
        } catch (Exception ex) {
            em.getTransaction().rollback();
            System.out.println("ADD MENU NO");
        }
    }

    public void wiewCountFromTo() {

        System.out.println("Input count From");
        int from = sc.nextInt();
        System.out.println("Input count To");
        int to = sc.nextInt();

        Query query = em.createQuery("SELECT menu FROM Menu menu WHERE menu.price>:fr AND menu.price<:t ", Menu.class);
        query.setParameter("fr", from);
        query.setParameter("t", to);
        List<Menu> menuList = (List<Menu>) query.getResultList();
        System.out.println("WIEW COUNT FROM= "+from+" TO= "+to);

        for (Menu m :
                menuList) {
            System.out.println(m);
        }
    }

    public void wiewDiscount() {

        Query query = em.createQuery("SELECT menu FROM Menu menu WHERE menu.discount>0", Menu.class);
        List<Menu> menuList = (List<Menu>) query.getResultList();
        System.out.println("WIEW FOOD IS DISCOUNT");

        for (Menu m :
                menuList) {
            System.out.println(m);
        }
    }

    public void wiewWeight() {
        System.out.println("Input max weight set food");
        int weight=sc.nextInt();
        int totalWeight = 0;
        Query query = em.createQuery("SELECT menu FROM Menu menu WHERE menu.weight<:wei", Menu.class);
        query.setParameter("wei", weight);
        List<Menu> menuList = (List<Menu>) query.getResultList();
        System.out.println("WIEW FOOD IS WEIGHT < "+weight);
        for (Menu m :
                menuList) {
            if (totalWeight < weight) {
                totalWeight += m.getWeight();
                System.out.println(m);
            }
        }
        System.out.println("Set Foot total weight= "+ totalWeight);
    }


}
