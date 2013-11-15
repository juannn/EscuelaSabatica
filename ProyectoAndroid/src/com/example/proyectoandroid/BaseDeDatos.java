package com.example.proyectoandroid;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class BaseDeDatos extends SQLiteOpenHelper {

	public BaseDeDatos(Context context) {
		super(context, "ControlAsistencia.db",null,1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		
		db.execSQL("CREATE TABLE Roles (_id INTEGER PRIMARY KEY AUTOINCREMENT,NombreRol TEXT);");
		
		db.execSQL("CREATE TABLE Usuarios (_id INTEGER PRIMARY KEY AUTOINCREMENT,NombreUsuario TEXT, Password TEXT,idRoles INTEGER);");
			
		db.execSQL("CREATE TABLE Personal (_id INTEGER PRIMARY KEY AUTOINCREMENT,FechaRegistro TEXT,Nombre TEXT, Apellido TEXT,Contacto TEXT,Domicilio TEXT,idUsuarios INTEGER);");
		
		db.execSQL("CREATE TABLE Clase (_id INTEGER PRIMARY KEY AUTOINCREMENT,NombreClase TEXT,idPersonal INTEGER);");
		
		db.execSQL("CREATE TABLE Miembros (_id INTEGER PRIMARY KEY AUTOINCREMENT,FechaRegistro TEXT,Nombre TEXT, Apellido TEXT,Contacto TEXT,Domicilio TEXT,idClase INTEGER);");
		
		db.execSQL("CREATE TABLE Llegadas (_id INTEGER PRIMARY KEY AUTOINCREMENT,Hora TEXT, Fecha TEXT);");
		
		db.execSQL("CREATE TABLE Asistencia (_id INTEGER PRIMARY KEY AUTOINCREMENT,idLlegadas INTEGER,idMiembros INTEGER);");
			
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int arg1, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("DROP TABLE IF EXISTS Roles");
		db.execSQL("DROP TABLE IF EXISTS Usuarios");
		db.execSQL("DROP TABLE IF EXISTS Personal");
		db.execSQL("DROP TABLE IF EXISTS Clase");
		db.execSQL("DROP TABLE IF EXISTS Miembros");
		db.execSQL("DROP TABLE IF EXISTS Llegadas");
		db.execSQL("DROP TABLE IF EXISTS Asistencia");
		onCreate(db);
	}
	
	public boolean NuevoRol(String rol) {
		// TODO Auto-generated method stub
		
		if(rol.trim().equals("")){
			return false;
		}
		else{
			
			SQLiteDatabase db=this.getWritableDatabase();
			ContentValues add=new ContentValues();
			
			add.put("NombreRol",rol);
			Long re=db.insert("Roles", "NombreRol", add);
			db.close();
			
			return true;
		}
		
	}

	public String ListaRol() {
		// TODO Auto-generated method stub
		
		String res="";
		
		SQLiteDatabase db=this.getWritableDatabase();
		// db.delete("Roles","_id='"+1+"'",null);
		//db.execSQL("UPDATE Roles SET NombreRol='"+"Administrador"+"'WHERE _id='"+1+"'");
		// db.execSQL("UPDATE ROLES SET NombreRol='"+"Lider"+"'WHERE _id='"+2+"'");
			
		// db.close();
		 
		Cursor c=db.query("Roles", new String []{"_id","NombreRol"}, null, null, null, null, null);
		
		for (c.moveToFirst();!c.isAfterLast();c.moveToNext()) {
			String id=c.getString(0);
			String nombreRol=c.getString(1);
			
			res +="ID "+id+" NombreRol "+nombreRol+"\n";
			
		}
		
		
		return res;
	}
	
	

}
