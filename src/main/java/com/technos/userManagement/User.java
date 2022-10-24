package com.technos.userManagement;

import com.mongodb.lang.NonNull;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
@Data
public class User {

    @Id
    private String id;

    private String firstName;

    private String lastName;

    private String country;

    @Transient
    private String email;

    private Gender gender;

    private int age;

    private String hobbies[];

}