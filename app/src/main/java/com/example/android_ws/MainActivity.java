package com.example.android_ws;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MainActivity extends AppCompatActivity {

    private EditText cxEditText;
    private EditText knifeEditText;
    private EditText hpEditText;

    private static final ConcurrentHashMap<String , Object> MEMORY_STORE = new ConcurrentHashMap<>();
    private final Map<String, Integer> selectedLevels = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layoutui);

        cxEditText = findViewById(R.id.cxEditText);
        knifeEditText = findViewById(R.id.knifeEditText);
        hpEditText = findViewById(R.id.hpEditText);

        setupButtonGroup("cxButton",8);
        setupButtonGroup("knifeButton",8);
        setupButtonGroup("hpButton",7);
        setupButtonGroup("levelButton",3);

        setGroupLevel("cxButton", 0, 8);
        setGroupLevel("knifeButton", 0, 8);
        setGroupLevel("hpButton", 0, 7);
        setGroupLevel("levelButton", 0, 3);
    }

    private void setupButtonGroup(final String baseIdName, final int count) {
        for (int i = 1; i <= count; i++) {
            final int value = i;
            int resId = getResources().getIdentifier(baseIdName + value, "id", getPackageName());
            if (resId != 0) {
                Button b = findViewById(resId);
                if (b != null) {
                    b.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            // toggle behavior: if clicked again on same level -> clear (0)
                            int current = selectedLevels.containsKey(baseIdName) ? selectedLevels.get(baseIdName) : 0;
                            int newLevel = (current == value) ? 0 : value;
                            setGroupLevel(baseIdName, newLevel, count);
                        }
                    });
                }
            }
        }
    }

    private void setGroupLevel(String baseIdName, int level, int count) {
        selectedLevels.put(baseIdName, level);
        for (int i = 1; i <= count; i++) {
            int resId = getResources().getIdentifier(baseIdName + i, "id", getPackageName());
            if (resId == 0) continue;
            Button b = findViewById(resId);
            if (b == null) continue;

            if (i <= level) {
                // active state
                b.setAlpha(1f);
                b.setSelected(true);
                b.setEnabled(true);
            } else {
                // inactive state
                b.setAlpha(0.4f);
                b.setSelected(false);
                b.setEnabled(true);
            }
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




