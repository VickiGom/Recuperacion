package com.example.recuperacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class EntradaProductoActivity extends AppCompatActivity {
    private TextView venta;
    private TextView productoo;
    private TextView compra;
    private TextView ganancia;
    private Button btnSalir;
    private Button btnCalcular;
    private EntradaProducto entt = new EntradaProducto();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrada_producto);
        iniciar();

        Bundle datos = getIntent().getExtras();
        EntradaProducto ent = (EntradaProducto) datos.getSerializable("entra");
        productoo.setText(ent.getDescripcion() + ent.getCodigo());
        Intent intent = getIntent();
        String ventaaa = intent.getStringExtra("venta");
        String compraaa = intent.getStringExtra("compra");
        String cantidada = intent.getStringExtra("cantidad");

        compra.setText("Total precio compra: ");
        venta.setText("Total precio venta: ");
        ganancia.setText("Total ganancia: ");



        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                entt.setCompra(Float.parseFloat(compraaa));
                entt.setCantidad(Integer.parseInt(cantidada));
                entt.setVenta(Float.parseFloat(ventaaa));
                compra.setText("Total precio compra:"+ String.valueOf(entt.calcularPrecioCompra()));
                venta.setText("Total precio venta: "+ String.valueOf(entt.calcularPrecioVenta()));
                ganancia.setText("Total ganancia: "+ String.valueOf(entt.calcularGanancia()));
            }
        });

        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EntradaProductoActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public void iniciar(){
        productoo = (TextView) findViewById(R.id.prod);
        venta = (TextView) findViewById(R.id.ventaa);
        compra = (TextView) findViewById(R.id.compraaa);
        ganancia = (TextView) findViewById(R.id.ganancia);
        btnSalir = (Button) findViewById(R.id.btnSalir);
        btnCalcular = (Button) findViewById(R.id.btnCalcular);



    }
}