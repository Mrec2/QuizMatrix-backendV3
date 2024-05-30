package org.grupoquizjava.springboot.quizmatrixbackendv3.quizmatrixbackendv3.repository;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.grupoquizjava.springboot.quizmatrixbackendv3.quizmatrixbackendv3.models.UserModel;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional
public class UserDaoImp implements IUserDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<UserModel> getAllUsers() {

        String query = "FROM UserModel";

        return entityManager.createQuery(query).getResultList();

    }


    @Override
    public boolean insert(UserModel usermodel) {

        String query = "FROM UserModel WHERE emailuser = :email";

        List<UserModel> lista = entityManager.createQuery(query)
                .setParameter( "email", usermodel.getEmailuser())
                .getResultList();

        if(lista.isEmpty()) {
            entityManager.merge(usermodel);
            return true;
        }
        return false;

    }

    @Override
    public boolean delete(int id) {

        UserModel usermodel = entityManager.find(UserModel.class ,id);

        if(usermodel != null) {
            entityManager.remove(usermodel);
            return true;
        }
        return false;
    }


    @Override
    public boolean credentials(UserModel usermodel) {

        //String query = "FROM UserModel WHERE emailuser = :email AND passworduser= :password";
        /*
        List<UserModel> lista = entityManager.createQuery(query)
                .setParameter( "email", usermodel.getEmailuser())
                .setParameter( "password", usermodel.getPassworduser())
                .getResultList();

        return !lista.isEmpty();

         */

        String query = "FROM UserModel WHERE emailuser = :email";

        List<UserModel> lista = entityManager.createQuery(query)
                .setParameter( "email", usermodel.getEmailuser())
                .getResultList();

        if(lista.isEmpty()) {
            return false;
        }

        String passwordHashed = lista.get(0).getPassworduser();

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);

        return argon2.verify(passwordHashed, usermodel.getPassworduser());

    }

}
