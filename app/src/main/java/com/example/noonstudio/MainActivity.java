package com.example.noonstudio;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewSections;
    private SectionAdapter sectionAdapter;
    private final List<Section> sections = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initRecyclerView();
        loadSections();
    }

    private void initRecyclerView() {
        recyclerViewSections = findViewById(R.id.recyclerViewSections);
        recyclerViewSections.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewSections.setHasFixedSize(true); // optimisation
        sectionAdapter = new SectionAdapter(this, sections);
        recyclerViewSections.setAdapter(sectionAdapter);
    }

    private void loadSections() {
        sections.add(new Section("Popular on Noon Studio", getPopularMovies()));
        sections.add(new Section("Trending Now", getTrendingMovies()));
        sections.add(new Section("Watch it Again", getWatchAgainMovies()));

        sectionAdapter.notifyDataSetChanged();
    }

    private List<Film> getPopularMovies() {
        List<Film> list = new ArrayList<>();
        list.add(new Film(
                "Whoopi",
                "film3",
                "https://www.youtube.com/watch?v=3B7HG8_xbDw",
                "Un agent secret découvre que sa femme mène une double vie..."
        ));
        list.add(new Film(
                "Ninja Turtles",
                "film2",
                "https://www.youtube.com/watch?v=zxkqixUKZt8",
                "Les Tortues Ninja combattent le crime dans New York..."
        ));
        list.add(new Film(
                "Pulp Fiction",
                "film4",
                "https://www.youtube.com/watch?v=s7EdQ4FqbhY",
                "Une série d'histoires interconnectées dans le milieu criminel."
        ));
        return list;
    }

    private List<Film> getTrendingMovies() {
        List<Film> list = new ArrayList<>();
        list.add(new Film(
                "Léon the Professional",
                "film8",
                "https://www.youtube.com/watch?v=lCBjHkCK1Vw",
                "Un tueur à gages prend sous son aile une jeune fille."
        ));
        list.add(new Film(
                "Fast & Furious 9",
                "film6",
                "https://www.youtube.com/watch?v=k98tBkRsGl4",
                "Courses-poursuites et action intense autour de la famille."
        ));
        list.add(new Film(
                "Hook",
                "film7",
                "https://www.youtube.com/watch?v=hook_trailer", // Remplace par vrai lien si besoin
                "Peter Pan revient au Pays Imaginaire pour sauver ses enfants."
        ));
        return list;
    }

    private List<Film> getWatchAgainMovies() {
        List<Film> list = new ArrayList<>();
        list.add(new Film(
                "Now You See Me",
                "film10",
                "https://www.youtube.com/watch?v=now_you_see_me", // Remplace par vrai lien si besoin
                "Un groupe d'illusionnistes vole des banques en direct."
        ));
        list.add(new Film(
                "Inception",
                "film11",
                "https://www.youtube.com/watch?v=inception_trailer", // Remplace par vrai lien si besoin
                "Un voleur qui pénètre les rêves pour voler des secrets."
        ));
        list.add(new Film(
                "Ninja Turtles",
                "film2",
                "https://www.youtube.com/watch?v=zxkqixUKZt8",
                "Les Tortues Ninja combattent le crime dans New York..."
        ));
        return list;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_hamburger) {
            showMenu(findViewById(R.id.toolbar));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void showMenu(View anchor) {
        PopupMenu popup = new PopupMenu(this, anchor);
        popup.getMenuInflater().inflate(R.menu.menu_options, popup.getMenu());

        popup.setOnMenuItemClickListener(menuItem -> {
            int id = menuItem.getItemId();
            if (id == R.id.menu_rented) {
                Toast.makeText(this, "Films loués", Toast.LENGTH_SHORT).show();
                return true;
            } else if (id == R.id.menu_new_release) {
                Toast.makeText(this, "New Release", Toast.LENGTH_SHORT).show();
                return true;
            } else if (id == R.id.menu_favorites) {
                Toast.makeText(this, "Favoris", Toast.LENGTH_SHORT).show();
                return true;
            }
            return false;
        });

        popup.show();
    }
}
