package com.yoyo.yopassword.check;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.yoyo.yopassword.R;
import com.yoyo.yopassword.common.util.ACacheUtils;
import com.yoyo.yopassword.common.view.YoSnackbar;
import com.yoyo.yopassword.hello.activity.HelloLoginActivity;
import com.yoyo.yopassword.main.activity.MainActivity;

public class CheckPasswordActivity extends AppCompatActivity {
    boolean isFinish;
    EditText etPassword,etPassword2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);
        isFinish=false;
        etPassword=(EditText)findViewById(R.id.et_password);
        etPassword2=(EditText)findViewById(R.id.et_password2);
        etPassword2.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER) {
                    switch (event.getAction()) {
                        case KeyEvent.ACTION_UP:             // 键盘松开
                            doConfirm();
                            break;
                        case KeyEvent.ACTION_DOWN:          // 键盘按下
                            break;
                    }
                }

                return false;
            }
        });

    }

    @Override
    public void finish() {
        if (isFinish){
            super.finish();
        }
    }

    public void onYoClick(View view){
        switch (view.getId()){
            case R.id.btn_sign_out:
                ACacheUtils.signOut(CheckPasswordActivity.this);
                startActivity(new Intent(CheckPasswordActivity.this, HelloLoginActivity.class).putExtra(HelloLoginActivity.KEY_TO_LOGIN,true));
                isFinish=true;
                finish();
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_check_password, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_confirm) {
            doConfirm();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    /**
     * 确定完成
     */
    private void doConfirm() {
        String password = etPassword.getText().toString();
        String password2 = etPassword2.getText().toString();

        if (TextUtils.isEmpty(password)) {
            YoSnackbar.showSnackbar(etPassword, R.string.edit_password);
            return;
        }
        if (TextUtils.isEmpty(password2)) {
            YoSnackbar.showSnackbar(etPassword, R.string.edit_password_too);
            return;
        }
        if(!password.equals(password2)){
            YoSnackbar.showSnackbar(etPassword, R.string.edit_password_no_same);
            return;
        }
        ACacheUtils.setCheckPassword(CheckPasswordActivity.this,password);
        startActivity(new Intent(CheckPasswordActivity.this, MainActivity.class));
        isFinish=true;
        finish();
    }
}
