package com.example.projectsoundwavev2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class PlaylistAdapter extends RecyclerView.Adapter<PlaylistAdapter.PlaylistViewHolder> {

    private ArrayList<Playlist> playlists;

    public PlaylistAdapter(ArrayList<Playlist> lista) {
        this.playlists = lista;
    }

    @NonNull
    @Override
    public PlaylistViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_playlist, parent, false);
        return new PlaylistViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlaylistViewHolder holder, int position) {
        Playlist playlist = playlists.get(position);
        holder.playlistButton.setBackgroundResource(playlist.getImagenResId());
        holder.playlistName.setText(playlist.getNombre());
    }

    @Override
    public int getItemCount() {
        return playlists.size();
    }

    public static class PlaylistViewHolder extends RecyclerView.ViewHolder {
        Button playlistButton;
        TextView playlistName;

        public PlaylistViewHolder(View itemView) {
            super(itemView);
            playlistButton = itemView.findViewById(R.id.playlistButton);
            playlistName = itemView.findViewById(R.id.playlistName);
        }
    }
}