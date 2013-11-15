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

public class MenuAdministrador extends Activity {

private Button btn1;
	
	BaseDeDatos sql =new BaseDeDatos(this);
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu_administrador);
		
		btn1=(Button)findViewById(R.id.btnNuevoUsuario);
		
		btn1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent inten=new Intent();
				inten.setClass(MenuAdministrador.this,NuevoUsuario.class);
				startActivity(inten);
				
			}
		});
		
		
		configureButtonReader(); 
	}

	 private <QrReaderActity> void configureButtonReader() {  
	        final ImageButton buttonReader = (ImageButton)findViewById(R.id.btReader);  
	        buttonReader.setOnClickListener(new View.OnClickListener() {  
	            @Override  
	            public void onClick(View view) {  
	            	  new IntentIntegrator(MenuAdministrador.this).initiateScan();  
	            }  
	        });  
	    }
	   
	   @Override  
	    public void onActivityResult(int requestCode, int resultCode, Intent intent) {  
	        final IntentResult scanResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);  
	        handleResult(scanResult);  
	    }
	   
	    private void handleResult(IntentResult scanResult) {  
	        if (scanResult != null) {  
	            updateUITextViews(scanResult.getContents(), scanResult.getFormatName());  
	        } else {  
	            Toast.makeText(this, "No se ha leído nada :(", Toast.LENGTH_SHORT).show();  
	        }  
	    }  
	    
	    private void updateUITextViews(String scan_result, String scan_result_format) {  
	        ((TextView)findViewById(R.id.tvFormat)).setText(scan_result_format);  
	        final TextView tvResult = (TextView)findViewById(R.id.tvResult);  
	        tvResult.setText(scan_result);  
	        Linkify.addLinks(tvResult, Linkify.ALL);  
	    }
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_administrador, menu);
		return true;
	}

}
