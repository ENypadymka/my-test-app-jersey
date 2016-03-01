package com.test.resources;

import com.test.data.User;
import com.test.data.UserDao;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.List;

@Path("/users")
public class UserService {
    private UserDao dao = new UserDao();

    @GET
    @Path("/addUser/{firstName}/{lastName}")
    public void addUser(@PathParam("firstName") String firstName, @PathParam("lastName") String lastName) {
        User user = new User();
        user.setFirstname(firstName);
        user.setLastname(lastName);

        dao.addUser(user);
    }

    @GET
    public List<User> getUsers() {
        return dao.getAllUsers();
    }
}
