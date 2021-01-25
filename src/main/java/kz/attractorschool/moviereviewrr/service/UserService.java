package kz.attractorschool.moviereviewrr.service;

import kz.attractorschool.moviereviewrr.model.User;

import java.util.List;

public interface UserService {
    User findUserByEmail(String email);

    List<User> findAllByName(String name);

    Boolean existsUserByEmail(String email);

}
