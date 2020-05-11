package test;

import dao.IUser;
import service.UserService;

public class test {
    public static  void main(String[] args){
        IUser iUser = new UserService();
        iUser.getconnection("libane@isi.sn","passer");
    }
}

