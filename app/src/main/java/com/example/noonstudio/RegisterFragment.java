package com.example.noonstudio;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class RegisterFragment extends Fragment {

    public RegisterFragment() { }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register, container, false);

        EditText email = view.findViewById(R.id.editEmail);
        EditText password = view.findViewById(R.id.editPassword);
        EditText confirmPassword = view.findViewById(R.id.editConfirmPassword);
        Button btnRegister = view.findViewById(R.id.buttonRegister);

        btnRegister.setOnClickListener(v -> {
            String emailStr = email.getText().toString().trim();
            String pwdStr = password.getText().toString().trim();
            String confirmPwdStr = confirmPassword.getText().toString().trim();

            if (emailStr.isEmpty() || pwdStr.isEmpty() || confirmPwdStr.isEmpty()) {
                Toast.makeText(getContext(), "Remplis tous les champs", Toast.LENGTH_SHORT).show();
                return;
            }

            if (!pwdStr.equals(confirmPwdStr)) {
                Toast.makeText(getContext(), "Les mots de passe ne correspondent pas", Toast.LENGTH_SHORT).show();
                return;
            }

            Toast.makeText(getContext(), "Inscription réussie pour " + emailStr, Toast.LENGTH_SHORT).show();

            // Navigate to MainActivity
            Intent intent = new Intent(getActivity(), MainActivity.class);
            startActivity(intent);
            getActivity().finish();
        });

        return view;
    }
}
