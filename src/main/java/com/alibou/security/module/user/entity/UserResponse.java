package com.alibou.security.module.user.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.util.ArrayList;
import java.util.List;
import com.alibou.security.module.user.entity.User;

@Data
@Builder
@AllArgsConstructor
@ToString
@Getter
@Setter
public class UserResponse {
    private String firstname;
    private String lastname;
    private String email;
    private String password = "hide";

    public UserResponse(){

    }

    public UserResponse(User user){
        this.firstname = user.getFirstname();
        this.lastname = user.getLastname();
        this.email = user.getEmail();
    }

    public List<UserResponse> convertToLists(List<User> users){
        List<UserResponse> response = new ArrayList<>();
        for (User user : users) {
            UserResponse uResponse = new UserResponse(user);
            response.add(uResponse);
        }
        return response;
    }
}
