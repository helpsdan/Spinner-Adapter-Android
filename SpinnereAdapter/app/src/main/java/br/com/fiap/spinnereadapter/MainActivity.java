package br.com.fiap.spinnereadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.DataOutput;
import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {

    Spinner spnPaises;
    AutoCompleteTextView actPaises;
    String[] paises = {
       "Alemanha",
       "Belize",
       "Camarões",
       "Dinamarca",
       "Espanha",
       "Finlândia"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spnPaises = findViewById(R.id.spnPaises);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
           this,
            android.R.layout.simple_list_item_1,
            paises
        );

        actPaises = findViewById(R.id.actPaises);
        ArrayAdapter<String> adapterParaAutoComplete = new ArrayAdapter<String>(
            this,
            android.R.layout.simple_list_item_1,
            paises);

        spnPaises.setAdapter(adapter);

        spnPaises.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String pais = paises[position];
                Toast.makeText(MainActivity.this, "Voce selecionou " + pais, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        actPaises.setAdapter(adapterParaAutoComplete);
    }

    public void Salvar(View view) {
        String pais = spnPaises.getSelectedItem().toString();
        Toast.makeText(this, "Voce selecionou " + pais, Toast.LENGTH_SHORT).show();
    }
}
