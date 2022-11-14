package com.mattmatthias.quickstart.utility;

import java.util.regex.Pattern;

public class DummyUtil {
    public static boolean validDummyName(String name) {
        Pattern p = Pattern.compile("[A-Z]{1,15}", Pattern.CASE_INSENSITIVE);
        return p.matcher(name).matches();
    }
}
