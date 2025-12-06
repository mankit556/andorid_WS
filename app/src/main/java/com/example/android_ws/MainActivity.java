package com.example.android_ws;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.concurrent.ConcurrentHashMap;

public class MainActivity extends AppCompatActivity {

    private static final ConcurrentHashMap<String , Object> MEMORY_STORE = new ConcurrentHashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.layoutui);
    }

    public static void put(String key, Object value){
        if (key == null)return;
        if (value == null){
            MEMORY_STORE.remove(key);
        }else{
            MEMORY_STORE.put(key,value);
        }
    }

    @SuppressWarnings("unchecked")
    public static<T> T get(String key){
        return (T) MEMORY_STORE.get(key);
    }

    public static void remove(String key){
        MEMORY_STORE.remove(key);
    }

    public static boolean contains(String key){
        return MEMORY_STORE.containsKey(key);
    }
}