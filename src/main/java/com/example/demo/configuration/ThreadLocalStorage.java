package com.example.demo.configuration;

import java.util.HashMap;

public class ThreadLocalStorage {

    private static ThreadLocal<HashMap<String, String>> tenant = new ThreadLocal<>();
    private static ThreadLocal<HashMap<String, String>> auth = new ThreadLocal<>();
    private static ThreadLocal<HashMap<String, String>> token = new ThreadLocal<>();
    private static ThreadLocal<HashMap<String, String>> profile = new ThreadLocal<>();

    public static HashMap<String, String> getProfile() {
        return profile.get();
    }

    public static void setProfile(HashMap<String, String> profileSet) {
        profile.set(profileSet);
    }

    public static HashMap<String, String> getToken() {
        return token.get();
    }

    public static void setToken(HashMap<String, String> tokenSet) {
        token.set(tokenSet);
    }

    public static HashMap<String, String> getAuth() {
        return auth.get();
    }

    public static void setAuth(HashMap<String, String> authSet) {
        auth.set(authSet);
    }

    public static HashMap<String, String> getTenant() {
        return tenant.get();
    }

    public static void setTenant(HashMap<String, String> tenantSet) {
        tenant.set(tenantSet);
    }
}