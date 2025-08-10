package com.example.noonstudio;

import java.util.List; // Import de List
import com.example.noonstudio.Film; // Import de ta classe Film

public class Section {
    private String title;
    private List<Film> films;

    public Section(String title, List<Film> films) {
        this.title = title;
        this.films = films;
    }

    public String getTitle() {
        return title;
    }

    public List<Film> getFilms() {
        return films;
    }
}
