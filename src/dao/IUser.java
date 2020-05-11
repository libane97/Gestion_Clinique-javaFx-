package dao;

import model.User;

public interface IUser {
    public User getconnection(String email, String password);
}
