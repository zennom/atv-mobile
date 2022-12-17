package app.modelo.meusclientes.view;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

import app.modelo.meusclientes.R;
import app.modelo.meusclientes.controller.ClienteController;

// TODO - Criar um novo fragmento (Classe Nova para listar os clientes (CARDS))
// TODO - Criar o novo Layout para suporte aos CARDS

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    FragmentManager fragmentManager;

    NavigationView navigationView;

    Menu menu;
    MenuItem nav_preto, nav_vermelho, nav_azul, nav_add_cliente,nav_add_cliente_cards, nav_listar_clientes, nav_listar_clientes_card;


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
                Snackbar.make(view, "Action Button Clicado", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        fragmentManager = getSupportFragmentManager();

        fragmentManager.beginTransaction().replace(R.id.content_fragment, new ListarClientesFragment()).commit();

        ClienteController clienteController = new ClienteController(getBaseContext());
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
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        // TODO: obter ID para a opção selecionada no MENU DRAWER
        if (id == R.id.nav_preto) {

            menu = navigationView.getMenu();

            nav_preto = menu.findItem(R.id.nav_preto);
            nav_preto.setTitle("Preto Ativado");

            nav_vermelho = menu.findItem(R.id.nav_vermelho);
            nav_vermelho.setTitle("Vermelho");

            nav_azul = menu.findItem(R.id.nav_azul);
            nav_azul.setTitle("Azul");

            nav_add_cliente = menu.findItem(R.id.nav_adicionar_cliente);
            nav_add_cliente.setTitle("Adicionar Cliente");

            nav_listar_clientes = menu.findItem(R.id.nav_lista_de_clientes);
            nav_listar_clientes.setTitle("Listar Clientes");

            nav_listar_clientes_card = menu.findItem(R.id.nav_lista_de_clientes_card);
            nav_listar_clientes_card.setTitle("Listar Clientes (Cards)");

            nav_add_cliente_cards = menu.findItem(R.id.nav_adicionar_cliente_cards);
            nav_add_cliente_cards.setTitle("Adicionar Cliente CARDS");

            navigationView.setItemTextColor(ColorStateList.valueOf(Color.BLACK));

            fragmentManager.beginTransaction().replace(R.id.content_fragment, new ModeloPretoFragment()).commit();

        } else if (id == R.id.nav_vermelho) {

            menu = navigationView.getMenu();

            nav_preto = menu.findItem(R.id.nav_preto);

            nav_preto.setTitle("Preto ");

            nav_vermelho = menu.findItem(R.id.nav_vermelho);
            nav_vermelho.setTitle("Vermelho Ativado");

            nav_azul = menu.findItem(R.id.nav_azul);
            nav_azul.setTitle("Azul");

            nav_add_cliente = menu.findItem(R.id.nav_adicionar_cliente);
            nav_add_cliente.setTitle("Adicionar Cliente ");

            nav_listar_clientes = menu.findItem(R.id.nav_lista_de_clientes);
            nav_listar_clientes.setTitle("Listar Clientes");

            nav_listar_clientes_card = menu.findItem(R.id.nav_lista_de_clientes_card);
            nav_listar_clientes_card.setTitle("Listar Clientes (Cards)");

            nav_add_cliente_cards = menu.findItem(R.id.nav_adicionar_cliente_cards);
            nav_add_cliente_cards.setTitle("Adicionar Cliente CARDS");

            // TODO: Mudar a cor de todos os itens do menu programaticamente
            navigationView.setItemTextColor(ColorStateList.valueOf(Color.BLACK));

            fragmentManager.beginTransaction().replace(R.id.content_fragment, new ModeloVermelhoFragment()).commit();

        } else if (id == R.id.nav_lista_de_clientes) {

            menu = navigationView.getMenu();

            nav_listar_clientes = menu.findItem(R.id.nav_lista_de_clientes);
            nav_listar_clientes.setTitle("Listar Clientes Ativado ");

            nav_preto = menu.findItem(R.id.nav_preto);
            nav_preto.setTitle("Preto ");

            nav_preto = menu.findItem(R.id.nav_preto);
            nav_preto.setTitle("Preto ");

            nav_vermelho = menu.findItem(R.id.nav_vermelho);
            nav_vermelho.setTitle("Vermelho");

            nav_azul = menu.findItem(R.id.nav_azul);
            nav_azul.setTitle("Azul");

            nav_add_cliente = menu.findItem(R.id.nav_adicionar_cliente);
            nav_add_cliente.setTitle("Adicionar Cliente ");

            nav_listar_clientes_card = menu.findItem(R.id.nav_lista_de_clientes_card);
            nav_listar_clientes_card.setTitle("Listar Clientes (Cards)");

            nav_add_cliente_cards = menu.findItem(R.id.nav_adicionar_cliente_cards);
            nav_add_cliente_cards.setTitle("Adicionar Cliente CARDS");

            // TODO: Mudar a cor de todos os itens do menu programaticamente
            navigationView.setItemTextColor(ColorStateList.valueOf(Color.BLACK));

            fragmentManager.beginTransaction().replace(R.id.content_fragment, new ListarClientesFragment()).commit();

        } else if (id == R.id.nav_lista_de_clientes_card) {

            menu = navigationView.getMenu();

            nav_listar_clientes_card = menu.findItem(R.id.nav_lista_de_clientes_card);
            nav_listar_clientes_card.setTitle("Listar Clientes (Cards) Ativado ");

            nav_listar_clientes = menu.findItem(R.id.nav_lista_de_clientes);
            nav_listar_clientes.setTitle("Listar Clientes  ");

            nav_preto = menu.findItem(R.id.nav_preto);
            nav_preto.setTitle("Preto ");

            nav_preto = menu.findItem(R.id.nav_preto);
            nav_preto.setTitle("Preto ");

            nav_vermelho = menu.findItem(R.id.nav_vermelho);
            nav_vermelho.setTitle("Vermelho");

            nav_azul = menu.findItem(R.id.nav_azul);
            nav_azul.setTitle("Azul");

            nav_add_cliente = menu.findItem(R.id.nav_adicionar_cliente);
            nav_add_cliente.setTitle("Adicionar Cliente ");

            nav_add_cliente_cards = menu.findItem(R.id.nav_adicionar_cliente_cards);
            nav_add_cliente_cards.setTitle("Adicionar Cliente CARDS");

            // TODO: Mudar a cor de todos os itens do menu programaticamente
            navigationView.setItemTextColor(ColorStateList.valueOf(Color.BLACK));

            fragmentManager.beginTransaction().replace(R.id.content_fragment, new ListarClientesCardsFragment()).commit();

        } else if (id == R.id.nav_azul) {

            menu = navigationView.getMenu();

            nav_preto = menu.findItem(R.id.nav_preto);
            nav_preto.setTitle("Preto");

            nav_vermelho = menu.findItem(R.id.nav_vermelho);
            nav_vermelho.setTitle("Vermelho");

            nav_azul = menu.findItem(R.id.nav_azul);
            nav_azul.setTitle("Azul Ativado");

            nav_add_cliente = menu.findItem(R.id.nav_adicionar_cliente);
            nav_add_cliente.setTitle("Adicionar Cliente ");

            nav_listar_clientes = menu.findItem(R.id.nav_lista_de_clientes);
            nav_listar_clientes.setTitle("Listar Clientes");

            nav_listar_clientes_card = menu.findItem(R.id.nav_lista_de_clientes_card);
            nav_listar_clientes_card.setTitle("Listar Clientes (Cards)");

            nav_add_cliente_cards = menu.findItem(R.id.nav_adicionar_cliente_cards);
            nav_add_cliente_cards.setTitle("Adicionar Cliente CARDS");

            navigationView.setItemTextColor(ColorStateList.valueOf(Color.BLACK));

            fragmentManager.beginTransaction().replace(R.id.content_fragment, new ModeloAzulFragment()).commit();

        } else if (id == R.id.nav_adicionar_cliente) {

            menu = navigationView.getMenu();

            nav_add_cliente = menu.findItem(R.id.nav_adicionar_cliente);
            nav_add_cliente.setTitle("Adicionar Cliente Ativado");

            nav_preto = menu.findItem(R.id.nav_preto);
            nav_preto.setTitle("Preto");

            nav_vermelho = menu.findItem(R.id.nav_vermelho);
            nav_vermelho.setTitle("Vermelho");

            nav_azul = menu.findItem(R.id.nav_azul);
            nav_azul.setTitle("Azul");

            nav_listar_clientes = menu.findItem(R.id.nav_lista_de_clientes);
            nav_listar_clientes.setTitle("Listar Clientes");

            nav_listar_clientes_card = menu.findItem(R.id.nav_lista_de_clientes_card);
            nav_listar_clientes_card.setTitle("Listar Clientes (Cards)");

            nav_add_cliente_cards = menu.findItem(R.id.nav_adicionar_cliente_cards);
            nav_add_cliente_cards.setTitle("Adicionar Cliente CARDS");

            navigationView.setItemTextColor(ColorStateList.valueOf(Color.BLACK));

            fragmentManager.beginTransaction().replace(R.id.content_fragment, new AdicionarClienteFragment()).commit();

        } else if (id == R.id.nav_adicionar_cliente_cards) {

            menu = navigationView.getMenu();

            nav_add_cliente_cards = menu.findItem(R.id.nav_adicionar_cliente_cards);
            nav_add_cliente_cards.setTitle("Adicionar Cliente CARDS Ativado");

            nav_add_cliente = menu.findItem(R.id.nav_adicionar_cliente);
            nav_add_cliente.setTitle("Adicionar Cliente");

            nav_preto = menu.findItem(R.id.nav_preto);
            nav_preto.setTitle("Preto");

            nav_vermelho = menu.findItem(R.id.nav_vermelho);
            nav_vermelho.setTitle("Vermelho");

            nav_azul = menu.findItem(R.id.nav_azul);
            nav_azul.setTitle("Azul");

            nav_listar_clientes = menu.findItem(R.id.nav_lista_de_clientes);
            nav_listar_clientes.setTitle("Listar Clientes");

            nav_listar_clientes_card = menu.findItem(R.id.nav_lista_de_clientes_card);
            nav_listar_clientes_card.setTitle("Listar Clientes (Cards)");

            navigationView.setItemTextColor(ColorStateList.valueOf(Color.BLACK));

            fragmentManager.beginTransaction().replace(R.id.content_fragment, new AdicionarClienteCardFragment()).commit();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
