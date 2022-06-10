package com.tokioschool.navigationpractica.features.login;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.tokioschool.navigationpractica.R;
import com.tokioschool.navigationpractica.databinding.ActivityLoginBinding;
import com.tokioschool.navigationpractica.features.login.viewmodel.SharedViewModelLogin;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "LoginActivity";
    private SharedViewModelLogin viewModel;
    private AppBarConfiguration appBarConfiguration;
    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.loginToolbar);
        NavController navController = Navigation.findNavController(this, R.id.nav_host_login_content);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        viewModel = new ViewModelProvider(this).get(SharedViewModelLogin.class);
        viewModel.getFragment().observe(this, this::toolbarControl);
    }

    public  void toolbarControl(String name) {
        switch (name) {

            case "FragmentRegister":
                binding.loginAppbar.setVisibility(View.VISIBLE);
                binding.loginToolbar.setTitle(getString(R.string.register_toolbar_title));
                break;

            default:
                binding.loginAppbar.setVisibility(View.GONE);
                break;
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_login_content);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}