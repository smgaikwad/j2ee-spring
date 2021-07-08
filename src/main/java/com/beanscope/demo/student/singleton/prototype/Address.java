package com.beanscope.demo.student.singleton.prototype;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Address {
    @Value("${address.city}")
    private String city;

    @Value("${address.pinCode}")
    private Integer pinCode;

    @Override
    public String toString() {
        return "city='" + city + '\'' +
                ", pinCode=" + pinCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getPinCode() {
        return pinCode;
    }

    public void setPinCode(Integer pinCode) {
        this.pinCode = pinCode;
    }
}
