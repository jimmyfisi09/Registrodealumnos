package com.appsbyjimmy.registrodealumons;

import java.util.List;
import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.content.DialogInterface;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListaAlumnos extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listaalumnos);
		
	  AlumnoDAO dao=new AlumnoDAO(this);
	  
	  List<Alumno> alumnos=dao.getlista();
	  dao.close();
	  int layout=android.R.layout.simple_list_item_1;
	  
	  ArrayAdapter<Alumno> adapter= new ArrayAdapter<Alumno>(this,layout,alumnos);
	  
	  ListView lista=(ListView)findViewById(R.id.lista);
	  
	  lista.setAdapter(adapter);
	  
	  
	  

	  
	}

	

	
	
}
