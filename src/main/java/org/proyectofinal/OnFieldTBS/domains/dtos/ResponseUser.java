package org.proyectofinal.OnFieldTBS.domains.dtos;


import org.proyectofinal.OnFieldTBS.domains.models.User;

public class ResponseUser {
    public String userid;
    public String username;

    private ResponseUser(User user) {
        this.userid = user.getUserId().toString();
        this.username = user.getUsername();
    }

    public static ResponseUser user(User user) {
        return new ResponseUser(user);
    }
}
