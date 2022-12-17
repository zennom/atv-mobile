package app.modelo.meusclientes.view;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import app.modelo.meusclientes.R;
import app.modelo.meusclientes.controller.ClienteController;
import app.modelo.meusclientes.model.Cliente;


public class AdicionarClienteFragment extends Fragment {

    //Declaração global de atributos - variaveis globais
    View view;
    TextView txtTitulo;
    EditText editNome, editTelefone, editEmail, editCep, editLogradouro, editNumero, editBairro, editCidade, editEstado;
    CheckBox chkTermosdeUso;
    Button btnCancelar, btnSalvar;

    Cliente novoCliente;
    ClienteController clienteController;

    public AdicionarClienteFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_adicionar_cliente, container, false);

        iniciarComponentesDeLayout();

        escutarEventosDosBotoes();

        return view;
    }


    /**
     * Inicializar os componentes da tela
     * para adicionar os clientes
     */
    private void iniciarComponentesDeLayout() {
        txtTitulo = view.findViewById(R.id.txtTitulo);
        txtTitulo.setText(R.string.novo_cliente);

        editNome = view.findViewById(R.id.editNomeCompleto);
        editTelefone = view.findViewById(R.id.editTelefone);
        editEmail = view.findViewById(R.id.editEmail);
        editLogradouro = view.findViewById(R.id.editLogradouro);
        editNumero = view.findViewById(R.id.editNumero);
        editCep = view.findViewById(R.id.editCep);
        editBairro = view.findViewById(R.id.editBairro);
        editCidade = view.findViewById(R.id.editCidade);
        editEstado = view.findViewById(R.id.editEstado);

        chkTermosdeUso = view.findViewById(R.id.chkTermosDeUso);

        btnCancelar = view.findViewById(R.id.btnCancelar);
        btnSalvar = view.findViewById(R.id.btnSalvar);


        clienteController = new ClienteController(getContext());

    }

    private void escutarEventosDosBotoes() {
        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isDadosOk = true;

                if (TextUtils.isEmpty(editNome.getText())) {
                    isDadosOk = false;
                    editNome.setError("Digite o nome completo...");
                    editNome.requestFocus();
                }
                if (TextUtils.isEmpty(editTelefone.getText())) {
                    isDadosOk = false;
                    editTelefone.setError("Digite o numero do telefone...");
                    editTelefone.requestFocus();
                }
                if (TextUtils.isEmpty(editEmail.getText())) {
                    isDadosOk = false;
                    editEmail.setError("Digite seu email...");
                    editEmail.requestFocus();
                }
                if (TextUtils.isEmpty(editCep.getText())) {
                    isDadosOk = false;
                    editCep.setError("Digite o CEP...");
                    editCep.requestFocus();
                }
                if (TextUtils.isEmpty(editLogradouro.getText())) {
                    isDadosOk = false;
                    editLogradouro.setError("Digite o Logradouro...");
                    editLogradouro.requestFocus();
                }
                if (TextUtils.isEmpty(editNumero.getText())) {
                    isDadosOk = false;
                    editNumero.setError("Digite o numero da casa...");
                    editNumero.requestFocus();
                }
                if (TextUtils.isEmpty(editBairro.getText())) {
                    isDadosOk = false;
                    editBairro.setError("Digite o nome do Bairro...");
                    editBairro.requestFocus();
                }
                if (TextUtils.isEmpty(editCidade.getText())) {
                    isDadosOk = false;
                    editCidade.setError("Digite o nome da Cidade...");
                    editCidade.requestFocus();
                }
                if (TextUtils.isEmpty(editEstado.getText())) {
                    isDadosOk = false;
                    editEstado.setError("Digite o nome do Estado...");
                    editEstado.requestFocus();
                }

                if(!chkTermosdeUso.isChecked()){
                    isDadosOk = false;
                    chkTermosdeUso.setError("");
                    chkTermosdeUso.requestFocus();
                }

                if (isDadosOk) {
                    novoCliente = new Cliente(editNome.getText().toString(), editTelefone.getText().toString(), editEmail.getText().toString(), Integer.parseInt(editCep.getText().toString()), editLogradouro.getText().toString(), editNumero.getText().toString(), editBairro.getText().toString(), editCidade.getText().toString(), editEstado.getText().toString(), chkTermosdeUso.isChecked());
                    clienteController.incluir(novoCliente);

                    Log.i("log_add_cliente", "onClick: Dados corretos");
                }
                {
                    Log.i("log_add_cliente", "onClick: Dados incorreto");
                }
            }
        });
    }


}
