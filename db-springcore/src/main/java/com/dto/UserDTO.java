package com.dto;

import com.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDTO extends CrudRepository<User,String> {

}