package me.study.oauth2.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class UserProfile {

    private String name;
    private String email;
}
