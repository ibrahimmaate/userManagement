package com.technos.userManagement;

public class Utils {

    static boolean isEmptyOrBlankOrNull(String string){
        return string == null || string.isEmpty() || string.isBlank();
    }
}
