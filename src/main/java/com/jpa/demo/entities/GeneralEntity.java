package com.jpa.demo.entities;
import lombok.Data;
import org.springframework.stereotype.Component;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
@Data
@Component
public abstract class GeneralEntity {

    public static final String REGISTRATION_DATE = "registration_date";
    public static final String LAST_MODIFIED_DATE = "last_modified_date";

    @Column(name = REGISTRATION_DATE)
    private LocalDateTime registrationDate;

    @Column(name = LAST_MODIFIED_DATE)
    private LocalDateTime lastModifiedDate;
}
