package com.associates.votesubjects.core;

import org.springframework.util.StringUtils;

public class Utils {
    public static String getSlugFromString(String value) {
        String stringToSlug = StringUtils.isEmpty(value) ? "" : value;
        return stringToSlug.replace(' ', '-').toLowerCase();
    }
}
