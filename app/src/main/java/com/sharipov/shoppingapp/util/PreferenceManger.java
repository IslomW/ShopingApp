package com.sharipov.shoppingapp.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.sharipov.shoppingapp.BuildConfig;
import com.sharipov.shoppingapp.model.User;

public class PreferenceManger implements PreferenceHelper {

    private static String SHARED_PREFERENCE_NAME = BuildConfig.APPLICATION_ID + (".local");

    private SharedPreferences sharedPreferences;

    private static PreferenceManger mInstance;

    public PreferenceManger(Context context) {
        sharedPreferences = context.getSharedPreferences(SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE);
    }

    public static PreferenceManger getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new PreferenceManger(context);
        }
        return mInstance;
    }


    @Override
    public void setValue(String key, Object value) {
        if (value.getClass().equals(String.class)) {
            sharedPreferences.edit().putString(key, (String) value).apply();
        } else if (value.getClass().equals(Boolean.class)) {
            sharedPreferences.edit().putBoolean(key, (Boolean) value).apply();
        } else if (value.getClass().equals(User.class)) {
            String json = new Gson().toJson(value);
            setValue(key, value);
        }
    }

    @Override
    public <T> Object getValue(Class<T> tClass, String key, Object defaultValue) {
        if (tClass.equals(String.class)) {
            return sharedPreferences.getString(key, (String) defaultValue);
        } else if (tClass.equals(Boolean.class)) {
            return sharedPreferences.getBoolean(key, (Boolean) defaultValue);
        } else if (tClass.equals(User.class)) {
            String json = sharedPreferences.getString(key, "");
            if (!json.isEmpty()) {
                User user = new Gson().fromJson(json, User.class);
                return user;
            }
        }

        return defaultValue;
    }

    @Override
    public void clear() {
        sharedPreferences.edit().clear().apply();
    }

    @Override
    public void remoteKey(String key) {
        sharedPreferences.edit().remove(key).apply();
    }
}
