package com.example.projectsoundwavev2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder> {

    private ArrayList<Album> albumes;

    public AlbumAdapter(ArrayList<Album> lista) {
        this.albumes = lista;
    }

    @NonNull
    @Override
    public AlbumViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_albums, parent, false);
        return new AlbumViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AlbumViewHolder holder, int position) {
        Album album = albumes.get(position);
        holder.albumButton.setBackgroundResource(album.getImagenResId());
        holder.albumName.setText(album.getNombre());
        holder.albumArtist.setText(album.getArtista());
    }

    @Override
    public int getItemCount() {
        return albumes.size();
    }

    public static class AlbumViewHolder extends RecyclerView.ViewHolder {
        Button albumButton;
        TextView albumName;
        TextView albumArtist;

        public AlbumViewHolder(View itemView) {
            super(itemView);
            albumButton = itemView.findViewById(R.id.albumButton);
            albumName = itemView.findViewById(R.id.albumName);
            albumArtist = itemView.findViewById(R.id.albumArtist);
        }
    }
}