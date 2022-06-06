package TestAppRedo.source.App.service;

import TestAppRedo.source.App.entity.Role;
import TestAppRedo.source.App.entity.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName); // no duplicates in data base for usernames ,
    User getUser(String username);
    List<User> getUsers();

    User deleteUser(long user);


}
