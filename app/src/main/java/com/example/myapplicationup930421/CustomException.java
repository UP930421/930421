package com.example.myapplicationup930421;

import android.util.Log;


public class CustomException extends NullPointerException {
    public CustomException(String customInfo){
        super(customInfo);
    }
}
