package umc.spring.web.dto;

import lombok.Getter;

import java.util.List;

public class MemberRequest {

    @Getter
    public static class JoinDto{
        String username;
        Integer gender;
        Integer age;
        Integer birthYear;
        Integer birthMonth;
        Integer birthDay;
        String address;
        String specAddress;
        List<Long> preferCategory;
    }
}
