package com.actuator.demo.users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class UserStatusCountContributor implements InfoContributor {

    @Autowired
    private UserDatabase userDatabase;

    @Override
    public void contribute(Info.Builder builder) {
        Map<String, Long> userStatusCount = new HashMap<>();
        userStatusCount.put("Active", userDatabase.getUserStatusDetails("Active"));
        userStatusCount.put("inActive", userDatabase.getUserStatusDetails("inActive"));

        builder.withDetail("userStatus", userStatusCount);
    }
}
