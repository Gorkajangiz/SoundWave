package com.example.projectsoundwavev2;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class AlbumFragment extends Fragment {

    private GridLayout albumsGrid;
    private List<Album> albumsList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_album, container, false);

        albumsGrid = view.findViewById(R.id.albumsGrid);
        setupAlbumsData();
        setupAlbumsGrid();

        return view;
    }

    private void setupAlbumsData() {
        albumsList = new ArrayList<>();

        // Agrega tus álbumes aquí con las imágenes reales
        albumsList.add(new Album("Thriller", "Michael Jackson", R.drawable.senosllevaelaire));
        albumsList.add(new Album("Back in Black", "AC/DC", R.drawable.senosllevaelaire));
        albumsList.add(new Album("The Dark Side", "Pink Floyd", R.drawable.senosllevaelaire));
        albumsList.add(new Album("Rumours", "Fleetwood Mac", R.drawable.senosllevaelaire));
        albumsList.add(new Album("Nevermind", "Nirvana", R.drawable.senosllevaelaire));
        albumsList.add(new Album("Abbey Road", "The Beatles", R.drawable.senosllevaelaire));
        albumsList.add(new Album("Hotel California", "Eagles", R.drawable.senosllevaelaire));
        albumsList.add(new Album("Born to Run", "Bruce Springsteen", R.drawable.senosllevaelaire));
        albumsList.add(new Album("Led Zeppelin IV", "Led Zeppelin", R.drawable.senosllevaelaire));
        albumsList.add(new Album("Purple Rain", "Prince", R.drawable.senosllevaelaire));
        albumsList.add(new Album("Appetite for Destruction", "Guns N' Roses", R.drawable.senosllevaelaire));
        albumsList.add(new Album("The Joshua Tree", "U2", R.drawable.senosllevaelaire));
        albumsList.add(new Album("Sgt. Pepper", "The Beatles", R.drawable.senosllevaelaire));
        albumsList.add(new Album("OK Computer", "Radiohead", R.drawable.senosllevaelaire));
        albumsList.add(new Album("The Wall", "Pink Floyd", R.drawable.senosllevaelaire));
        albumsList.add(new Album("Kind of Blue", "Miles Davis", R.drawable.senosllevaelaire));
        albumsList.add(new Album("Revolver", "The Beatles", R.drawable.senosllevaelaire));
        albumsList.add(new Album("Pet Sounds", "The Beach Boys", R.drawable.senosllevaelaire));
        albumsList.add(new Album("What's Going On", "Marvin Gaye", R.drawable.senosllevaelaire));
        albumsList.add(new Album("London Calling", "The Clash", R.drawable.senosllevaelaire));
    }

    private void setupAlbumsGrid() {
        LayoutInflater inflater = LayoutInflater.from(getContext());

        for (Album album : albumsList) {
            View albumView = inflater.inflate(R.layout.item_albums, albumsGrid, false);

            Button albumButton = albumView.findViewById(R.id.albumButton);
            TextView albumName = albumView.findViewById(R.id.albumName);
            TextView albumArtist = albumView.findViewById(R.id.albumArtist);

            // Configurar los datos
            albumName.setText(album.getNombre());
            albumArtist.setText(album.getArtista());
            albumButton.setBackgroundResource(album.getImagenResId());

            // Configurar click listener para el botón
            albumButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Aquí tu lógica cuando se hace click en un álbum
                    openAlbumDetail(album.getNombre(), album.getArtista());
                }
            });

            // El GridLayout se encarga automáticamente del layout 3xN
            albumsGrid.addView(albumView);
        }
    }

    private void openAlbumDetail(String albumName, String artistName) {
        // Tu lógica para abrir el detalle del álbum
    }
}