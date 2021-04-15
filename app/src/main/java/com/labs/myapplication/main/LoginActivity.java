package com.labs.myapplication.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.labs.myapplication.R;
import com.labs.myapplication.presenter.LoginInteractor;
import com.labs.myapplication.presenter.LoginPresenter;
import com.labs.myapplication.presenter.LoginView;

public class LoginActivity extends AppCompatActivity implements LoginView {

    private EditText user;
    private EditText pass;
    private ProgressBar progressBar;
    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        presenter = new LoginPresenter(this,new LoginInteractor());

        user = findViewById(R.id.edtUsername);
        pass = findViewById(R.id.edtPassword);
        AppCompatButton login = findViewById(R.id.button);
        login.setOnClickListener(v -> validateCredentials());
        progressBar = findViewById(R.id.progressBar);

    }

    private void validateCredentials() {
        presenter.validateCredentials(user.getText().toString(),pass.getText().toString());
    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);

    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void setUsernameError() {
        user.setError(getString(R.string.username_error));

    }

    @Override
    public void setPasswordError() {
        pass.setError(getString(R.string.password_error));

    }

    @Override
    public void navigateToHome() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}