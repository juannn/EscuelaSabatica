package com.example.proyectoandroid;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.text.util.Linkify;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	BaseDeDatos sql =new BaseDeDatos(this);
	private Button btnAceptar,btnCancelar;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		btnAceptar=(Button)findViewById(R.id.btnAceptar);
		btnCancelar=(Button)findViewById(R.id.btnCancelar);
		
btnCancelar.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				EditText nom=(EditText)findViewById(R.id.txtNombreUsuario);
				EditText pas=(EditText)findViewById(R.id.txtPass);
			String nombreUsuario=nom.getText().toString();
			String password=pas.getText().toString();
			
			nom.setText("");
			pas.setText("");
			
			
			}
		});
		
		btnAceptar.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				EditText nom=(EditText)findViewById(R.id.txtNombreUsuario);
				EditText pas=(EditText)findViewById(R.id.txtPass);
			String nombreUsuario=nom.getText().toString();
			String password=pas.getText().toString();
			
			if(nombreUsuario.equals("Juan")&& password.equals("12345")){
				Intent inten=new Intent();
				inten.setClass(MainActivity.this,MenuAdministrador.class);
				startActivity(inten);
			}
			else
			{
			Toast.makeText(getApplication(), "Error de Contraseña", Toast.LENGTH_LONG).show();
			}
			
			}
		});
		
	}

	  

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
