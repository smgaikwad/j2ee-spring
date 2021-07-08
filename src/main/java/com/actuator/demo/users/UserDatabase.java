package com.actuator.demo.users;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDatabase {
    public List<User> getUserDetails(){
        return List.of(
                new User("Sooraj Gaikwad",31,"inActive"),
                new User("Dhiraj Gaikwad",32,"Active"),
                new User("Avani Gaikwad",33,"inActive"),
                new User("Anjali Gaikwad",34,"Active"),
                new User("John Doe",35,"inActive"),
                new User("Smith Alex",36,"Active")
        );
    }


    public Long getUserStatusDetails(String status){
        return getUserDetails().stream().filter(user
                -> user.getStatus().equals(status)).count();
    }
}
