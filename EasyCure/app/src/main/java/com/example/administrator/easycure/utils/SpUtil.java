package com.example.administrator.easycure.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.PorterDuff;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/10/26 0026.
 */

public class SpUtil {

    public static SharedPreferences sharedPreferences;
    public static Map<String,String> map;

    //保存用户信息到SP文件中
    public static void saveUserInfo(Context context,String passwordValue,
                                    String phoneNumValue){
        sharedPreferences = context.getSharedPreferences(Constant.SPFILE,context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(Constant.PASSWORD,passwordValue);
        editor.putString(Constant.PHONENUMBER,phoneNumValue);
        editor.commit();
    }

    //从SP文件中取出用户信息，这里是活的一部分，不包括绑定的用户安全号码
    public static Map<String,String> getUserInfo(Context context){
        sharedPreferences = context.getSharedPreferences(Constant.SPFILE,context.MODE_PRIVATE);

        map = new HashMap<>();
        map.put(Constant.PHONENUMBER,sharedPreferences.getString(Constant.PHONENUMBER,""));
        map.put(Constant.PASSWORD,sharedPreferences.getString(Constant.PASSWORD,""));

        return map;
    }

    //仅保存用户登录的账号
    public static void saveUserLoginAccount(Context context,String phoneNumValue){
        sharedPreferences = context.getSharedPreferences(Constant.SPFILE,context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(Constant.PHONENUMBER,phoneNumValue);
        editor.commit();
    }

    //保存安全号码
    public static void saveSecurityNumber(Context context,String securityNumberValue){
        sharedPreferences = context.getSharedPreferences(Constant.SPFILE,context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(Constant.SECURITY_NUMBER,securityNumberValue);
        editor.commit();
    }

    //--------------------------------以上写的是把用户的基本信息保存在SP文件中做二次登陆时的渲染--------------------------------------

    //保存自动更新的状态：仅WiFi下自动更新 或 从不自动更新
    public static void saveAutomaticUpdateStatus(Context context,String updateStatus){
        sharedPreferences = context.getSharedPreferences(Constant.SPFILE,context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(Constant.UPDATE_STATUS,updateStatus);
        editor.commit();
    }

    //获取自动更新的状态：仅WiFi下自动更新 或 从不自动更新
    public static String getAutomaticUpdateStatus(Context context){
        sharedPreferences = context.getSharedPreferences(Constant.SPFILE,context.MODE_PRIVATE);

        return sharedPreferences.getString(Constant.UPDATE_STATUS,"");
    }

    //获取当前登录用户的账号，前面有保存用户基本信息的，那个是注册的时候使用的，虽然键不同，但值会重叠，由于数据量比较小这里不考虑内存占用问题
    public static void saveLoginInfo(Context context,String loginAccount,String password){
        sharedPreferences = context.getSharedPreferences(Constant.SPFILE,context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(Constant.PHONENUMBER,loginAccount);
        editor.putString(Constant.PASSWORD,password);
        editor.commit();
    }
}
