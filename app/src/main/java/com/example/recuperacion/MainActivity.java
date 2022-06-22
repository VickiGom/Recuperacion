package com.example.recuperacion;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText txtCodigo;
    private EditText txtDescripcion;
    private EditText txtUnicad;
    private EditText txtVenta;
    private EditText txtCompra;
    private EditText txtCantidad;
    private Button btnSalir;
    private Button btnSiguiente;
    private Button btnLimpiar;
    private EntradaProducto entra = new EntradaProducto();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iniciar();
        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salir();
            }
        });
        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtCodigo.setText("");
                txtCantidad.setText("");
                txtCompra.setText("");
                txtDescripcion.setText("");
                txtUnicad.setText("");
                txtVenta.setText("");
            }
        });
        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtCodigo.getText().toString().matches("") || txtCantidad.getText().toString().matches("") || txtCompra.getText().toString().matches("")
                        || txtDescripcion.getText().toString().matches("")|| txtUnicad.getText().toString().matches("") || txtVenta.getText().toString().matches("")){
                    Toast.makeText(MainActivity.this, "Falto capturar informacion, ingrese la informacion faltante",Toast.LENGTH_SHORT).show();

                }else{
                    entra.setCodigo(txtCodigo.getText().toString());
                    entra.setDescripcion(txtDescripcion.getText().toString());
                    String uni = txtUnicad.getText().toString();
                    String ven = txtVenta.getText().toString();
                    String com = txtCompra.getText().toString();
                    String can = txtCantidad.getText().toString();
                    Intent intent = new Intent(MainActivity.this,EntradaProductoActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("entra", entra);
                    intent.putExtras(bundle);
                    intent.putExtra("compra",uni);
                    intent.putExtra("venta", ven);
                    intent.putExtra("unidad", com);
                    intent.putExtra("cantidad", can);
                    startActivity(intent);



                }


            }
        });

    }
    public void iniciar(){

        txtCodigo = (EditText) findViewById(R.id.txtCodigo);
        txtDescripcion = (EditText) findViewById(R.id.txtDescripcion);
        txtUnicad = (EditText) findViewById(R.id.txtUnidad);
        txtVenta = (EditText) findViewById(R.id.txtVenta);
        txtCompra = (EditText) findViewById(R.id.txtCompra);
        txtCantidad = (EditText) findViewById(R.id.txtCantidad);
        btnSalir = (Button) findViewById(R.id.btnSalir);
        btnSiguiente = (Button) findViewById(R.id.btnSiguiente);
        btnLimpiar = (Button) findViewById(R.id.btnLimpiar);


    }
    public void salir(){
        AlertDialog.Builder confirmar = new AlertDialog.Builder(this);
        confirmar.setTitle("Cerrar app");
        confirmar.setMessage("¿Seguro que quieres cerrar la app?");
        confirmar.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                finishAffinity();
            }
        });
        confirmar.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        confirmar.show();

    }
}