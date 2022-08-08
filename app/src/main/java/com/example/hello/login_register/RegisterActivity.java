package com.example.hello.login_register;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.hello.R;

public class RegisterActivity extends AppCompatActivity {
    EditText id, pw, check_pw, email;
    Button btn;
    AlertDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        id = findViewById(R.id.editText);
        pw = findViewById(R.id.editText_pw);
        check_pw = findViewById(R.id.editText3);
        email= findViewById(R.id.editText4);
        btn = findViewById(R.id.button_login);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String Id = id.getText().toString();
                final String Pw = pw.getText().toString();
                final String CheckPw = check_pw.getText().toString();
                final String Email = email.getText().toString();

                //한 칸이라도 입력 안했을 경우
                if(Id.equals("") || Pw.equals("") || CheckPw.equals("") || Email.equals("")){
                    AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                    dialog = builder.setMessage("모두 입력해주세요.").setPositiveButton("확인", null).create();
                    dialog.show();
                }
                //비밀번호 체크
                if(!Pw.equals(check_pw)){
                    AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                    dialog = builder.setMessage("비밀번호 확인이 일치하지 않습니다.").setPositiveButton("확인", null).create();
                    dialog.show();
                }

                //리퀘 클래스
            }
        });
    }

    //리퀘 클래스 생

}