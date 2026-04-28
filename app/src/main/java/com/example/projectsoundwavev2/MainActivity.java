package com.example.projectsoundwavev2;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.example.projectsoundwavev2.databinding.ActivityMainBinding;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    private BottomSheetBehavior behavior;
    private MenuItem lastSelectedItem;
    private View expandedPlayer;
    private View miniPlayer;
    private ImageButton botonMeGusta;
    private ImageButton btnCorazonBig;
    private boolean meGustaActivo = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        View bottomSheet = findViewById(R.id.bottom_sheet);
        expandedPlayer = findViewById(R.id.expanded_player);
        miniPlayer = findViewById(R.id.mini_player);

        botonMeGusta = findViewById(R.id.botonmegusta);
        btnCorazonBig = findViewById(R.id.btnCorazonGrande);

        behavior = BottomSheetBehavior.from(bottomSheet);

        int screenHeight = getResources().getDisplayMetrics().heightPixels;
        float menuPercentage = 0.12f;
        float miniplayerPercentage = 0.10f;
        int menuHeight = (int) (screenHeight * menuPercentage);
        int miniplayerHeight = (int) (screenHeight * miniplayerPercentage);
        int totalHeightInHalfExpanded = menuHeight + miniplayerHeight;
        float mediumPositionRatio = (float) totalHeightInHalfExpanded / screenHeight;

        behavior.setPeekHeight(0);
        behavior.setHideable(false);
        behavior.setFitToContents(false);
        behavior.setExpandedOffset(0);
        behavior.setHalfExpandedRatio(mediumPositionRatio);
        behavior.setState(BottomSheetBehavior.STATE_HALF_EXPANDED);

        behavior.addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(View bottomSheet, int newState) {
                switch (newState) {
                    case BottomSheetBehavior.STATE_EXPANDED:
                        showExpandedPlayer();
                        break;
                    case BottomSheetBehavior.STATE_HALF_EXPANDED:
                        showMiniPlayer();
                        break;
                    case BottomSheetBehavior.STATE_COLLAPSED:
                    case BottomSheetBehavior.STATE_HIDDEN:
                        behavior.setState(BottomSheetBehavior.STATE_HALF_EXPANDED);
                        break;
                }
            }

            @Override
            public void onSlide(View bottomSheet, float slideOffset) {
                if (slideOffset > 0.6f) {
                    if (miniPlayer.getVisibility() == View.VISIBLE) {
                        miniPlayer.setVisibility(View.GONE);
                        expandedPlayer.setVisibility(View.VISIBLE);
                    }
                } else {
                    if (expandedPlayer.getVisibility() == View.VISIBLE) {
                        expandedPlayer.setVisibility(View.GONE);
                        miniPlayer.setVisibility(View.VISIBLE);
                    }
                }
            }
        });

        configurarBotonesMeGusta();

        binding.bottomNavigation.setBackground(null);

        binding.bottomNavigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if (id == R.id.home) {
                    reemplazarFragmento(new HomeFragment());
                    lastSelectedItem = item;
                    return true;
                } else if (id == R.id.album) {
                    reemplazarFragmento(new AlbumFragment());
                    lastSelectedItem = item;
                    return true;
                } else if (id == R.id.info) {
                    toggleBottomSheet();
                    binding.bottomNavigation.getMenu().findItem(R.id.home).setChecked(true);
                    return false;
                } else if (id == R.id.discover) {
                    reemplazarFragmento(new DiscoverFragment());
                    lastSelectedItem = item;
                    return true;
                }

                return false;
            }
        });

        binding.bottomNavigation.setSelectedItemId(R.id.home);
        showMiniPlayer();
    }

    private void configurarBotonesMeGusta() {
        View.OnClickListener meGustaListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                meGustaActivo = !meGustaActivo;
                actualizarIconosMeGusta();
            }
        };

        if (botonMeGusta != null) {
            botonMeGusta.setOnClickListener(meGustaListener);
        }

        if (btnCorazonBig != null) {
            btnCorazonBig.setOnClickListener(meGustaListener);
        }
    }

    private void actualizarIconosMeGusta() {
        int resource = meGustaActivo ? R.drawable.corazonlleno : R.drawable.corazon;

        if (botonMeGusta != null) {
            botonMeGusta.setImageResource(resource);
        }

        if (btnCorazonBig != null) {
            btnCorazonBig.setImageResource(resource);
        }
    }

    public void setMeGustaEstado(boolean activo) {
        this.meGustaActivo = activo;
        actualizarIconosMeGusta();
    }

    public boolean isMeGustaActivo() {
        return meGustaActivo;
    }

    private void toggleBottomSheet() {
        if (behavior.getState() == BottomSheetBehavior.STATE_EXPANDED) {
            behavior.setState(BottomSheetBehavior.STATE_HALF_EXPANDED);
        } else {
            behavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        }
    }

    public void collapseBottomSheet(View view) {
        behavior.setState(BottomSheetBehavior.STATE_HALF_EXPANDED);
    }

    private void showExpandedPlayer() {
        expandedPlayer.setVisibility(View.VISIBLE);
        miniPlayer.setVisibility(View.GONE);
    }

    private void showMiniPlayer() {
        expandedPlayer.setVisibility(View.GONE);
        miniPlayer.setVisibility(View.VISIBLE);
    }

    private void reemplazarFragmento(Fragment fragment){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frameLayout, fragment);
        ft.commit();
    }
}