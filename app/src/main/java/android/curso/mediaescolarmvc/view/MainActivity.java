package android.curso.mediaescolarmvc.view;



import android.curso.mediaescolarmvc.R;
import android.curso.mediaescolarmvc.fragmets.BimestreAFragment;
import android.curso.mediaescolarmvc.fragmets.BimestreBFragment;
import android.curso.mediaescolarmvc.fragmets.BimestreCFragment;
import android.curso.mediaescolarmvc.fragmets.BimestreDFragment;
import android.curso.mediaescolarmvc.fragmets.ModeloFragment;
import android.curso.mediaescolarmvc.fragmets.ResultadoFinalFragment;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);



        fragmentManager = getSupportFragmentManager();


        fragmentManager.beginTransaction().replace(R.id.content_fragment, new ModeloFragment()).commit();


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        //botão sair
        if (id == R.id.action_sair) {

            finish();

            return true;
        }




        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
    //abre os fragments quando item do menu é clicado pelo usuário.
        int id = item.getItemId();

        if (id == R.id.nav_bimestre_a) {

            setTitle("Notas 1º Bimestre");

            fragmentManager.beginTransaction().replace(R.id.content_fragment, new BimestreAFragment()).commit();

        } else if (id == R.id.nav_bimestre_b) {

            setTitle("Notas 2º Bimestre");

            fragmentManager.beginTransaction().replace(R.id.content_fragment, new BimestreBFragment()).commit();

        } else if (id == R.id.nav_bimestre_c) {

            setTitle("Notas 3º Bimestre");

            fragmentManager.beginTransaction().replace(R.id.content_fragment, new BimestreCFragment()).commit();

        } else if (id == R.id.nav_bimestre_d) {

            setTitle("Notas 4º Bimestre");

            fragmentManager.beginTransaction().replace(R.id.content_fragment, new BimestreDFragment()).commit();

        } else if (id == R.id.nav_resultado_final) {

            setTitle("Resultado Final");

            fragmentManager.beginTransaction().replace(R.id.content_fragment, new ResultadoFinalFragment()).commit();

        } else if (id == R.id.nav_share) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    //Método para exibir Nota da média do aluno exibido em Decimal. Ex.: 8,95
    public static String formatarValorDecimal(Double valor)
    {
        DecimalFormat df = new DecimalFormat("#,###,##0.00");
        return df.format(valor);
    }
}
