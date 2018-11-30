package interativasistemas.com.crudrealm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddClientActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_client);

        EditText nameField = findViewById(R.id.nameFieldTXT);
        EditText emailFiled = findViewById(R.id.emailFieldTXT);
        EditText cpfFiled = findViewById(R.id.cpfFieldTXT);

        Button cancelbtn = findViewById(R.id.cancelBtn);
        Button savebtn = findViewById(R.id.saveBtn);

        cancelbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent mainActivityIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(mainActivityIntent);
            }
        });

        savebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nome     = nameField.getText().toString();
                String email    = emailFiled.getText().toString();
                String cpf      = cpfFiled.getText().toString();

                //Salvando no banco de dados
                Client client = new Client(nome, email, cpf);
                client.save();
                //Fim salvamento banco de dados

                Toast.makeText(getApplicationContext(),
                        "Cliente salvo com sucesso",
                        Toast.LENGTH_LONG).show();

                Intent mainActivityIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(mainActivityIntent);
            }
        });
    }
}
