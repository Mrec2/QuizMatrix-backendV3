package org.grupoquizjava.springboot.quizmatrixbackendv3.quizmatrixbackendv3.repository;

import org.grupoquizjava.springboot.quizmatrixbackendv3.quizmatrixbackendv3.models.UserModel;

import java.util.List;

public interface IUserDao {

    public List<UserModel> getAllUsers();

    public boolean insert(UserModel usermodel);

    public boolean delete(int id);

    public boolean credentials(UserModel usermodel);


}
