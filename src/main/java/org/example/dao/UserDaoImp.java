package org.example.dao;

import org.example.models.User;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserDaoImp implements  UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(User user) {
        entityManager.persist( user );
    }

    @Override
    public void delete(int id) {
        User user = entityManager.find(User.class, id);
        if (user != null) {
            entityManager.remove( user );
        }
    }

    @Override
    public List<User> getAll() {
        Query query = entityManager.createQuery( "from User" );
        return query.getResultList();
    }

    @Override
    public User get( int id ) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void uptdate(User user) {
        System.out.println( user.getName() );
        entityManager.merge( user );
    }
}
