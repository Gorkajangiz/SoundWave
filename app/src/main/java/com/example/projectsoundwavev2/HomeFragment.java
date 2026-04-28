package com.example.projectsoundwavev2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class HomeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        setupPlaylistsCarrusel(view);
        setupAlbumsCarrusel(view);
        return view;
    }

    private void setupPlaylistsCarrusel(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.recyclerViewPlaylists);

        ArrayList<Playlist> playlists = new ArrayList<>();
        playlists.add(new Playlist("Favoritos", R.drawable.albumprueba));
        playlists.add(new Playlist("Rock", R.drawable.albumprueba));
        playlists.add(new Playlist("Chill", R.drawable.albumprueba));
        playlists.add(new Playlist("Workout", R.drawable.albumprueba));
        playlists.add(new Playlist("Viaje", R.drawable.albumprueba));
        playlists.add(new Playlist("Jazz", R.drawable.albumprueba));
        playlists.add(new Playlist("Éxitos", R.drawable.albumprueba));

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);

        PlaylistAdapter adapter = new PlaylistAdapter(playlists);
        recyclerView.setAdapter(adapter);
    }

    public void irAListas(View view) {
        FragmentManager fragmentManager = getParentFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, new AlbumFragment());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    private void setupAlbumsCarrusel(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.recyclerViewAlbums);

        ArrayList<Album> albums = new ArrayList<>();
        albums.add(new Album("Thriller", "Michael Jackson", R.drawable.albumprueba));
        albums.add(new Album("Back in Black", "AC/DC", R.drawable.albumprueba));
        albums.add(new Album("The Dark Side", "Pink Floyd", R.drawable.albumprueba));
        albums.add(new Album("Abbey Road", "The Beatles", R.drawable.albumprueba));
        albums.add(new Album("Rumours", "Fleetwood Mac", R.drawable.albumprueba));
        albums.add(new Album("Nevermind", "Nirvana", R.drawable.albumprueba));
        albums.add(new Album("Bad", "Michael Jackson", R.drawable.albumprueba));

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);

        AlbumAdapter adapter = new AlbumAdapter(albums);
        recyclerView.setAdapter(adapter);
    }

    public void irAAlbumes(View view) {
        FragmentManager fragmentManager = getParentFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, new AlbumFragment());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}