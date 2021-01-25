package kz.attractorschool.moviereviewrr.service;

import kz.attractorschool.moviereviewrr.model.User;
import kz.attractorschool.moviereviewrr.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public User findUserByEmail(String email) {
        if (userRepository.findUserByEmail(email).isEmpty()) {
            throw new RuntimeException("no user with email: " + email);
        }
        return userRepository.findUserByEmail(email).get();
    }

    @Override
    public List<User> findAllByName(String name) {
        if (userRepository.findAllByName(name).isEmpty()) {
            throw new RuntimeException("no user with name: " + name);
        }
        return userRepository.findAllByName(name).get();
    }

    @Override
    public Boolean existsUserByEmail(String email) {
        return userRepository.existsUserByEmail(email);
    }
}
