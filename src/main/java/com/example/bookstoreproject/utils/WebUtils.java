package com.example.bookstoreproject.utils;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class WebUtils {
    public static String toString(User user) {
        StringBuilder sb = new StringBuilder();
        sb.append("UserName: ").append(user.getUsername());
        Collection<GrantedAuthority> authorities = user.getAuthorities();
        if (authorities != null && !authorities.isEmpty()) {
            sb.append(" (");
            boolean first = true;
            for (GrantedAuthority authority : authorities) {
                if (first) {
                    sb.append(authority.getAuthority());
                    first = false;
                } else {
                    sb.append(", ").append(authority.getAuthority());
                }
            }
            sb.append(") ");

        }
        return sb.toString();
    }

}
