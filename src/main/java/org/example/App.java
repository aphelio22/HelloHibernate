package org.example;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //Para hibernate:
        //Configuración de hibernate
        /*Crea resources y dentro de resources un hibernate.cfg.xml (copia lo que hay ya dentro)*/
        Configuration configuration = new Configuration();
        configuration.configure();

        //Para hacer operaciones de cualquier tipo, primero hay que declarar esto:
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Usuario usuario = new Usuario();
        usuario.setNombre("Jorge");
        usuario.setEmail("jorge@gmail.com");

        try {
            //Operación de escritura (se hace igual con cualquier otra):
            Session session = sessionFactory.openSession();
            //Necesario para hacer operaciones de escritura (junto a 'transaction.commit()'):
            Transaction transaction = session.beginTransaction();
            //Es necesario mappear la info. de Usuario.
            session.persist(usuario);
            transaction.commit();

            Query query = session.createQuery("FROM Usuario");
            ArrayList<Usuario> salida = (ArrayList<Usuario>) query.getResultList();

            System.out.println(salida);
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }
}
