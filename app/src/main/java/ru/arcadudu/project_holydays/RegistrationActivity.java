package ru.arcadudu.project_holydays;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public class RegistrationActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        // Кнопка возврата на предыдущий экран
        View back = findViewById(R.id.iv_btn_back_to_profileLogin);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        // Кнопка "зарегистрироваться"
        Button finishRegistration = findViewById(R.id.btn_finish_registration);
//        finishRegistration.setEnabled(false);
//        int passiveColor = ContextCompat.getColor(this, R.color.frameColor);
//        finishRegistration.setTextColor(passiveColor);
//        finishRegistration.setBackgroundResource(R.drawable.style_edit_text);
//        finishRegistration.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });

        CheckBox checkBoxLicense = findViewById(R.id.checkbox_license);
        checkBoxLicense.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

            }
        });
        checkBoxLicense.setChecked(false);
//        if(checkBoxLicense.isChecked()){
//            finishRegistration.setEnabled(true);
//            finishRegistration.setTextColor(getResources().getColor(R.color.colorAccent));
//            finishRegistration.setBackgroundResource(R.drawable.style_active_button);
//        }

    }
}