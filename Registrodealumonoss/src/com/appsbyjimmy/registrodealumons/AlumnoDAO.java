package com.appsbyjimmy.registrodealumons;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class AlumnoDAO extends SQLiteOpenHelper{

	
	private static final int VERSION = 1;
	private static final String Database = "RegistroAlumnos";

	public AlumnoDAO(Context context) 
	{
		super(context,Database,null, VERSION);
		// TODO Auto-generated constructor stub
	}

	public void guardar(Alumno alumno) {
		
		
		ContentValues values =new ContentValues();
		values.put("nombre",alumno.getNombre());
		values.put("site",alumno.getSite());
		values.put("direccion",alumno.getDireccion());
		values.put("telefono",alumno.getTelefono());
		values.put("nota",alumno.getNota());
		values.put("foto",alumno.getFoto());
		
		this.getWritableDatabase().insert("Alumnos", null, values );
		
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String dll="CREATE TABLE Alumnos (id PRIMARY KEY,"+
	                "nombre TEXT UNIQUE NOT NULL,"+
				    "site TEXT,"+
	                "direccion TEXT,"+
				    "telefono TEXT,"+
	                "nota TEXT,"+
				    "foto TEXT);";
		
		
		db.execSQL(dll);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		String dll="DROP TABLE IF EXITS Alumnos";
		
		db.execSQL(dll);
		this.onCreate(db);
		
	}

	public List<Alumno> getlista() {
		String[] columnas={"id","nombre","site","direccion","telefono","nota","foto"};
		Cursor cursor=this.getWritableDatabase().query("Alumnos", columnas,null,null,null,null,null);
	    
		ArrayList<Alumno> alumnos=new ArrayList<Alumno>();
		while(cursor.moveToNext()){
		Alumno alumno=new Alumno();
		
		alumno.setId(cursor.getLong(0));
		alumno.setNombre(cursor.getString(1));
		alumno.setSite(cursor.getString(2));
		alumno.setDireccion(cursor.getString(3));
		alumno.setTelefono(cursor.getString(4));
		alumno.setNota(cursor.getDouble(5));
		alumno.setFoto(cursor.getString(6));
		
		
		alumnos.add(alumno);
		
	    }
		return alumnos;
	}

}
