package com.service;

import com.dto.UserDTO;
import com.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserDTO repo;

    List<User> list = new ArrayList<User>();

    public void addUser(User user){
        repo.save(user);
    }
    public List<User> loadAll(){
        return  (List<User>)  repo.findAll();
    }

    public boolean searchUser(String uname){
//        for(User us: list){
//            if(uname.equals(us.getUserName())){
//                return true;
//            }
//        }
//        return false;

        Optional<User> data = repo.findById(uname);
        if(data.isPresent()){
            return true;
        }
        return false;

    }

    public  boolean deleteuser(String uname){
        for(User us: list){
            if((uname.equals(us.getUserName()))){
                list.remove(us);
                return true;
            }
        }
        return false;
    }
    public boolean findUser(String uname, String pass){
        for(User us: list){
            if(uname.equals(us.getUserName())  && pass.equals(us.getPassword())){
                return true;
            }
        }
        return false;
    }

    public  boolean updateuser(String uname, User user){
//        for(User us: list){
//            if((uname.equals(us.getUserName()))){
//                us.setUserName(user.getUserName());
//                us.setPassword(user.getPassword());
//                us.setEmail(user.getEmail());
//                us.setCity(user.getCity());
//                return true;
//            }
//        }
//        return false;

        Optional<User> data= repo.findById(uname);
        if(data.isPresent()){
            User existingUSer=data.get();

            existingUSer.setPassword(user.getPassword());
            existingUSer.setCity(user.getCity());
            existingUSer.setEmail(user.getEmail());
            repo.save(existingUSer);
            return true;
        }
        return false;
    }


}
