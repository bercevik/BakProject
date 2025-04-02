package com.example.bakproject;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentTransaction;

import com.example.bakproject.databinding.ActivityMainBinding;
import com.example.bakproject.fragments.ChatsListFragment;
import com.example.bakproject.fragments.FavouriteListFragment;
import com.example.bakproject.fragments.HomeFragment;
import com.example.bakproject.fragments.ProfileFragment;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
//      show home first
        showHomeFragment();


//       home navigation
        binding.bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();

                if(itemId == R.id.item_home) {
                    showHomeFragment();
                } else if (itemId == R.id.item_chats) {
                    showChatsListFragment();
                } else if (itemId == R.id.item_favourite) {
                    showFavouritesListFragment();
                } else if (itemId == R.id.item_profile) {
                    showProfileFragment();
                }

                return true;
            }
        });
    }

    private void showHomeFragment() {
        binding.toolbarTitleTv.setText("Home");

        HomeFragment homeFragment = new HomeFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(binding.fragmentsFl.getId(), homeFragment, "HomeFragment");
        fragmentTransaction.commit();
    }

    private void showChatsListFragment() {
        binding.toolbarTitleTv.setText("Chats");

        ChatsListFragment chatsListFragment = new ChatsListFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(binding.fragmentsFl.getId(), chatsListFragment, "ChatsListFragment");
        fragmentTransaction.commit();
    }

    private void showFavouritesListFragment() {
        binding.toolbarTitleTv.setText("Favourites");
        FavouriteListFragment favouriteListFragment = new FavouriteListFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(binding.fragmentsFl.getId(), favouriteListFragment, "FavouriteListFragment");
        fragmentTransaction.commit();
    }

    private void showProfileFragment() {
        binding.toolbarTitleTv.setText("Profile");
        ProfileFragment profileFragment = new ProfileFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(binding.fragmentsFl.getId(), profileFragment, "ProfileFragment");
        fragmentTransaction.commit();
    }
}