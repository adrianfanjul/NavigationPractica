package com.tokioschool.navigationpractica.features.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.tokioschool.navigationpractica.R;
import com.tokioschool.navigationpractica.databinding.ActivityHomeBinding;
import com.tokioschool.navigationpractica.domain.User;
import com.tokioschool.navigationpractica.features.home.fragments.viewmodel.SharedViewModelHome;

public class HomeActivity extends AppCompatActivity {

    private ActivityHomeBinding binding;
    private AppBarConfiguration appBarConfiguration;
    private NavController navController;
    private User user;
    private SharedViewModelHome viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.homeToolbar);
        navController = Navigation.findNavController(this, R.id.nav_host_home_content);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        user = HomeActivityArgs.fromBundle(getIntent().getExtras()).getLoginUser();
        shareUser();

    }

    private void shareUser() {
        viewModel = new ViewModelProvider(this).get(SharedViewModelHome.class);
        viewModel.setUser(user);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menu_home_coche_item:
                coche_click();
                return true;
            case R.id.menu_home_eurodisney_item:
                eurodisney_click();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home,menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void eurodisney_click(){
        Uri uri=Uri.parse("https://disneylandparis-news.com/en/");
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }

    private void coche_click() {
        navController.navigate(R.id.action_global_lilaFragment);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_home_content);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }

}