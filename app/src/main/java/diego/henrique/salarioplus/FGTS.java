package diego.henrique.salarioplus;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class FGTS extends AppCompatActivity {

    Spinner spinner;
    EditText salario;
    TextView resultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_fgts);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        spinner = findViewById(R.id.spinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.categorias_fgts,
                android.R.layout.simple_spinner_item
        );

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);

        //

        salario = findViewById(R.id.salario);
        resultado = findViewById(R.id.resposta);
    }

    public void calcular(View view){
        String categoria = spinner.getSelectedItem().toString();
        double valorFgts = 0;
        double valorSalario = Double.parseDouble(salario.getText().toString());
        switch (categoria){
            case "Regime CLT":
                valorFgts = valorSalario * 0.08;
                break;
            case "Jovem Aprendiz":
                valorFgts = valorSalario * 0.02;
                break;
            case "Empregado Doméstico":
                valorFgts = valorSalario * 0.112;
                break;
        }
        resultado.setText(String.format("FGTS: R$ %.2f", valorFgts));
    }
}