package com.example.noonstudio;

import androidx.annotation.NonNull;

public final class Film {

    private final String title;
    private final String posterName; // Nom du fichier image (sans extension)
    private final String trailerUrl; // Lien YouTube du trailer
    private final String description; // Petite description du film

    public Film(@NonNull String title, @NonNull String posterName, @NonNull String trailerUrl, @NonNull String description) {
        this.title = title;
        this.posterName = posterName;
        this.trailerUrl = trailerUrl;
        this.description = description;
    }

    @NonNull
    public String getTitle() {
        return title;
    }

    @NonNull
    public String getPosterName() {
        return posterName;
    }

    @NonNull
    public String getTrailerUrl() {
        return trailerUrl;
    }

    @NonNull
    public String getDescription() {
        return description;
    }

    @NonNull
    @Override
    public String toString() {
        return "Film{" +
                "title='" + title + '\'' +
                ", posterName='" + posterName + '\'' +
                ", trailerUrl='" + trailerUrl + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
