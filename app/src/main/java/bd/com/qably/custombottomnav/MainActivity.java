package bd.com.qably.custombottomnav;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import bd.com.qably.custombottomnav.databinding.ActivityMainBinding;
import bd.com.qably.custombottomnav.toast.Toasty;

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

        spaceNavigationView.setSpaceOnClickListener(new SpaceOnClickListener() {
            @Override
            public void onCentreButtonClick() {
                Toasty.info(getApplicationContext(),getString(R.string.app_name), Toast.LENGTH_SHORT).show();

                Log.d("onCentreButtonClick ", "onCentreButtonClick");
                spaceNavigationView.shouldShowFullBadgeText(true);
            }

            @Override
            public void onItemClick(int itemIndex, String itemName) {
                Log.d("onItemClick ", "" + itemIndex + " " + itemName);
            }

            @Override
            public void onItemReselected(int itemIndex, String itemName) {
                Log.d("onItemReselected ", "" + itemIndex + " " + itemName);
            }
        });
    }
}