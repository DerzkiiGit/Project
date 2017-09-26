package net.myProject.dao;

import net.myProject.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by SpooN on 30.08.2017.
 */

@Repository
public class UserDaoImpl implements UserDao {

   private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public User getById(int id) {

        User user = sessionFactory.getCurrentSession().load(User.class, new Integer(id));

        return user;
    }

    public List<User> getAllUsers() {
        Session session = sessionFactory.getCurrentSession();

        List <User> users = session.createQuery("From User").getResultList();

        return users;
    }

    public List<User> getUserByName(String name) {
        Session session = sessionFactory.getCurrentSession();
       Query query = session.createQuery("From User u where u.name = :name");
        query.setParameter("name",name);
        List<User> users = (List<User>) query.getResultList();

        return users;
    }

    public void removeUser(int id) {
        Session session = sessionFactory.getCurrentSession();

        User user = session.load(User.class, new Integer(id));

        if (user!=null){
            session.delete(user);
        }
    }

    public void updateUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.update(user);
    }

    public void createUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(user);
    }


}
