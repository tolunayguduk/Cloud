package com.tolunayguduk.dao.classes;

import com.tolunayguduk.dao.interfaces.UserDAO;
import com.tolunayguduk.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.criteria.*;
import java.util.List;


@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
    @Override
    public void insertUser(User user) {
        Session session = getCurrentSession();

        session.saveOrUpdate(user);
        session.flush();
    }

    @Override
    public List<User> isExistSearchUserByEmail(String email, String password) {
        Session session = getCurrentSession();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);
        criteriaQuery.select(root);
        criteriaQuery.where(
                criteriaBuilder.equal(root.get("email"), email),
                criteriaBuilder.equal(root.get("password"), password)
        );
        Query query = session.createQuery(criteriaQuery);
        List<User> userList = query.getResultList();

        return userList;
    }

    @Override
    public List<User> isExistSearchUserByUsername(String username, String password) {
        Session session = getCurrentSession();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);
        criteriaQuery.select(root);
        criteriaQuery.where(
                criteriaBuilder.equal(root.get("username"), username),
                criteriaBuilder.equal(root.get("password"), password)
        );
        Query query = session.createQuery(criteriaQuery);
        List<User> userList = query.getResultList();

        return userList;
    }
}
