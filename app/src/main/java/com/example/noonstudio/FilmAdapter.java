package com.example.noonstudio;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FilmAdapter extends RecyclerView.Adapter<FilmAdapter.FilmViewHolder> {

    private final Context context;
    private final List<Film> films;

    public FilmAdapter(@NonNull Context context, @NonNull List<Film> films) {
        this.context = context;
        this.films = films;
    }

    @NonNull
    @Override
    public FilmViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_film, parent, false);
        return new FilmViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull FilmViewHolder holder, int position) {
        Film film = films.get(position);

        // Set title
        holder.title.setText(film.getTitle());

        // Load poster safely
        @DrawableRes int resId = context.getResources().getIdentifier(
                film.getPosterName(),
                "drawable",
                context.getPackageName()
        );

        if (resId != 0) {
            holder.poster.setImageResource(resId);
        } else {
            holder.poster.setImageResource(R.drawable.placeholder_poster);
        }

        // Clic sur l'image pour afficher le dialog
        holder.poster.setOnClickListener(v -> showFilmDialog(film, context));

        // Clic sur l'item entier (optionnel) : ici je le retire pour éviter conflit
        /*
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("title", film.getTitle());
            intent.putExtra("poster", film.getPosterName());
            context.startActivity(intent);
        });
        */
    }

    private void showFilmDialog(Film film, Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(film.getTitle());

        // Inflate custom layout dialog_film_detail.xml (à créer)
        View dialogView = LayoutInflater.from(context).inflate(R.layout.dialog_film_detail, null);

        TextView descriptionText = dialogView.findViewById(R.id.film_description);
        Button buttonRent = dialogView.findViewById(R.id.button_rent);
        Button buttonTrailer = dialogView.findViewById(R.id.button_trailer);

        descriptionText.setText(film.getDescription());

        buttonRent.setOnClickListener(v -> {
            Toast.makeText(context, "Film loué : " + film.getTitle(), Toast.LENGTH_SHORT).show();
        });

        buttonTrailer.setOnClickListener(v -> {
            // Lance le trailer YouTube
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(film.getTrailerUrl()));
            context.startActivity(intent);
        });

        builder.setView(dialogView);
        builder.setNegativeButton("Fermer", (dialog, which) -> dialog.dismiss());

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    public int getItemCount() {
        return films != null ? films.size() : 0;
    }

    static class FilmViewHolder extends RecyclerView.ViewHolder {
        final ImageView poster;
        final TextView title;

        FilmViewHolder(@NonNull View itemView) {
            super(itemView);
            poster = itemView.findViewById(R.id.poster);
            title = itemView.findViewById(R.id.title);
        }
    }
}
