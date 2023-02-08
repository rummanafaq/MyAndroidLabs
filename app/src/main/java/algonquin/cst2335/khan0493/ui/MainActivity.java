package algonquin.cst2335.khan0493.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import algonquin.cst2335.khan0493.R;
import algonquin.cst2335.khan0493.data.MainViewModel;
import algonquin.cst2335.khan0493.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding variableBinding;
    private MainViewModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        model = new ViewModelProvider(this).get(MainViewModel.class);

        variableBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(variableBinding.getRoot());

        // variableBinding.textview.setText(model.editString);

        variableBinding.mybutton.setOnClickListener(click -> {
            model.editString.postValue(variableBinding.myedittext.getText().toString());
        });

        model.editString.observe(this, s -> {
            variableBinding.textview.setText("Your edit has " + s);
        });

        model.isSelected.observe(this, selected -> {
            variableBinding.checkbox.setChecked(selected);
            variableBinding.radioButton1.setChecked(selected);
            variableBinding.switch1.setChecked(selected);

            Toast.makeText(this, "The value is now: " + selected, Toast.LENGTH_SHORT).show();
        });

        variableBinding.checkbox.setOnCheckedChangeListener((checkbox, isChecked) -> {
            if (isChecked) {
                model.isSelected.postValue(isChecked);
            }
        });

        variableBinding.radioButton1.setOnCheckedChangeListener((radioButton1, isChecked) -> {
            if (isChecked) {
                model.isSelected.postValue(isChecked);
            }
        });

        variableBinding.switch1.setOnCheckedChangeListener((switch1, isChecked) -> {
            if (isChecked) {
                model.isSelected.postValue(isChecked);
            }
        });

        variableBinding.myimagebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int width = variableBinding.myimagebutton.getWidth();
                int height = variableBinding.myimagebutton.getHeight();
                Toast.makeText(MainActivity.this,
                        "The width = " + width + " and height = " + height, Toast.LENGTH_SHORT).show();
            }
        });

    }
}