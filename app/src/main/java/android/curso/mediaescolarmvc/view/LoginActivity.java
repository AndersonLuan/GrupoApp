package android.curso.mediaescolarmvc.view;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.curso.mediaescolarmvc.R;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private EditText Name;
    private EditText Password;
    private TextView Info;
    private Button Login;
    private int counter = 5;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Esconde a ActionBar
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Name = findViewById(R.id.etNome);
        Password = findViewById(R.id.etPass);
        Info = findViewById(R.id.etInfo);
        Login = findViewById(R.id.btnLogin);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(Name.getText().toString(), Password.getText().toString());
            }
        });

    }
    @SuppressLint("SetTextI18n")
    private void
    validate(String userName, String userPassword){
        if (userName.equals("adm") && userPassword.equals("123")){
            alert("Login Realizado com Sucesso.");
            Intent intent = new Intent(LoginActivity.this,
                    MainActivity.class);
            startActivity(intent);
            finish();
        }else{
            counter --;
            alert("Login e senha incorretos.");
            Info.setText("Número de Tentativas: " + String.valueOf(counter));
            if(counter == 0){
                Login.setEnabled(false);

            }
        }

    }

    private void alert(String s) {
        Toast.makeText(this,s,Toast.LENGTH_SHORT).show();
    }
}

  /*  @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    } */