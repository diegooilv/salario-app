package diego.henrique.salarioplus;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.PopupMenu;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void fgts(View view){
        Intent intent = new Intent(this, FGTS.class);
        startActivity(intent);
    }

    public void menu(View view) {
        PopupMenu popup = new PopupMenu(this, view);

        popup.getMenu().add("Início");
        popup.getMenu().add("Configurações");
        popup.getMenu().add("Sobre");
        popup.getMenu().add("Sair");

        popup.setOnMenuItemClickListener(item -> {
            switch (item.getTitle().toString()) {
                case "Início":
                    Snackbar.make(
                            findViewById(android.R.id.content),
                            "Você já está no início!",
                            Snackbar.LENGTH_SHORT
                    ).show();                    return true;

                case "Configurações":
                    Intent intent = new Intent(this, Configs.class);
                    startActivity(intent);
                    return true;

                case "Sobre":
                    Intent intent2 = new Intent(this, Sobre.class);
                    startActivity(intent2);
                    return true;

                case "Sair":
                    finish();
                    return true;
            }
            return false;
        });

        popup.show();
    }
}