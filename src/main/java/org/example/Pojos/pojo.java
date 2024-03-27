package org.example.Pojos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder @Getter @Setter
public class pojo {
    private String userName;
    private String firstName;
    private String lastName;
    private String password;
    private String phone;
    private int userStatus;
    private int code;

}
