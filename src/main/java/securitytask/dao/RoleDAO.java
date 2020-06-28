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
public class RoleDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    public Role getByRoleName(String role) {
//        Session session = sessionFactory.getCurrentSession();
//        return session.get(Role.class, role);
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(Role.class);
        crit.add(Restrictions.eq("role", role));
        return (Role) crit.list().get(0);
    }


    public List<User> getAllUsers(){
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from User").list();
    }

}
