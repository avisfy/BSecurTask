package securitytask.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import securitytask.entity.Role;
import securitytask.entity.User;

import java.util.List;

@Transactional
@Repository
public class UserDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    public User getByLogin(String login) {
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(User.class);
        crit.add(Restrictions.eq("login", login));
        return (User) crit.list().get(0);
//        Session session = sessionFactory.getCurrentSession();
//        return session.get(User.class, login);
    }

    public void addUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(user);
    }

    public List<User> getAllUsers(){
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from User").list();
    }


}
