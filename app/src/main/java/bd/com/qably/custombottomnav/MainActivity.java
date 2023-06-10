package bd.com.qably.custombottomnav;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;

import bd.com.qably.custombottomnav.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private SpaceNavigationView spaceNavigationView;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Initialize bottom navigation view
        spaceNavigationView = binding.bottomNavId;
        spaceNavigationView.initWithSaveInstanceState(savedInstanceState);

        // Add items to bottom navigation view
        spaceNavigationView.addSpaceItem(new SpaceItem("Item 1", R.drawable.ic_item));
        spaceNavigationView.addSpaceItem(new SpaceItem("Item 2", R.drawable.ic_item));
        spaceNavigationView.addSpaceItem(new SpaceItem("Item 3", R.drawable.ic_item));
        spaceNavigationView.addSpaceItem(new SpaceItem("Item 4", R.drawable.ic_item));

        // Set bottom navigation view settings
        spaceNavigationView.shouldShowFullBadgeText(true);
        //spaceNavigationView.setCentreButtonIconColorFilterEnabled(false);
        spaceNavigationView.setActiveSpaceItemColor(ContextCompat.getColor(this, R.color.purple_200));
        spaceNavigationView.setInActiveSpaceItemColor(ContextCompat.getColor(this, R.color.purple_200));
        spaceNavigationView.setCentreButtonColor(ContextCompat.getColor(this, R.color.purple_200));
        spaceNavigationView.setActiveCentreButtonIconColor(ContextCompat.getColor(this,R.color.purple_200));
        spaceNavigationView.showIconOnly();
        spaceNavigationView.setSpaceBackgroundColor(ContextCompat.getColor(this, R.color.white));
    }
}