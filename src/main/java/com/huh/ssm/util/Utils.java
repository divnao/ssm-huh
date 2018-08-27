package com.huh.ssm.util;

import javax.servlet.http.HttpSession;

public class Utils {

    private static String sessionAttribute = "user";

    /**
     * check session.
     *
     * @return true, session has attribute named "user", user logged in;
     * @return false, user are not login.
     */
    public static boolean checkLogin(HttpSession session) {
        return session.getAttribute(sessionAttribute) != null;
    }

    public static int getTotalPage(int totalResult, int pageSize) {
        if (totalResult % pageSize == 0) {
            return totalResult / pageSize;
        } else {
            return totalResult / pageSize + 1;
        }
    }

}
