package com.example.mycat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.Preference;
import androidx.preference.PreferenceManager;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    private EditText editText1,editText2, editText3,editText4;
    private Button buttonSave;
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        editText1 = findViewById(R.id.editText);
        editText2 = findViewById(R.id.editText2);
        editText3 = findViewById(R.id.editText3);
        editText4 = findViewById(R.id.editText4);

        buttonSave = findViewById(R.id.save1);
        // Инициализация SharedPreferences
        preferences = getPreferences(MODE_PRIVATE);
        // Загрузка сохраненных данных при запуске приложения
        loadText();

        // Обработка нажатия кнопки "Сохранить"
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textToSave1 = editText1.getText().toString();
                String textToSave2 = editText2.getText().toString();
                String textToSave3 = editText3.getText().toString();
                String textToSave4 = editText4.getText().toString();
                saveText(textToSave1,textToSave2,textToSave3,textToSave4);
            }
        });
    }

    private void saveText(String text1, String text2, String text3, String text4) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("savedText1", text1);
        editor.putString("savedText2", text2);
        editor.putString("savedText3", text3);
        editor.putString("savedText4", text4);
        editor.apply();
    }

    private void loadText() {
        String savedText1 = preferences.getString("savedText1", "");
        String savedText2 = preferences.getString("savedText2", "");
        String savedText3 = preferences.getString("savedText3", "");
        String savedText4 = preferences.getString("savedText4", "");
        editText1.setText(savedText1);
        editText2.setText(savedText2);
        editText3.setText(savedText3);
        editText4.setText(savedText4);
    }

}