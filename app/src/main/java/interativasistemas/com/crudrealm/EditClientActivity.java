package interativasistemas.com.crudrealm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditClientActivity extends AppCompatActivity {

    private EditText nameEdit, emailEdit, cpfEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_client);

        nameEdit = findViewById(R.id.nameFieldTXT);
        emailEdit = findViewById(R.id.emailFieldTXT);
        cpfEdit = findViewById(R.id.cpfFieldTXT);

        String id = getIntent().getStringExtra("id");
        Client client = Client.findById(id);

        nameEdit.setText(client.getName());
        emailEdit.setText(client.getEmail());
        cpfEdit.setText(client.getCpf());

        Button saveBtn = findViewById(R.id.saveBtn);
        Button deleteBtn = findViewById(R.id.btnDelete);
        Button cancelBtn = findViewById(R.id.cancelBtn);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name  = nameEdit.getText().toString();
                String email = emailEdit.getText().toString();
                String cpf   = cpfEdit.getText().toString();

                client.setName(name);
                client.setEmail(email);
                client.setCpf(cpf);
                client.update();

                Toast.makeText(getApplicationContext(), "Cliente Atualizado", Toast.LENGTH_LONG).show();
                Intent mainActivityIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(mainActivityIntent);
            }
        });

        deleteBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                client.delete();
                Toast.makeText(getApplicationContext(), "Cliente deletado", Toast.LENGTH_LONG).show();
                Intent mainActivityIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(mainActivityIntent);
            }
        });

        cancelBtn.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent mainActivityIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(mainActivityIntent);
            }
        });

    }
}
