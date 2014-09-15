package com.appsbyjimmy.registrodealumons;

import java.util.List;
import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListaAlumnos extends Activity{
  ListView lista;
  Alumno alumno;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
    
      super.onCreate(savedInstanceState);
	  setContentView(R.layout.listaalumnos);
		
	  AlumnoDAO dao=new AlumnoDAO(this);
	  
	  List<Alumno> alumnos=dao.getlista();
	  dao.close();
	  int layout=android.R.layout.simple_list_item_1;
	  
	  ArrayAdapter<Alumno> adapter= new ArrayAdapter<Alumno>(this,layout,alumnos);
	  
	  lista=(ListView)findViewById(R.id.lista);
	  
	  lista.setAdapter(adapter);
	  
	  registerForContextMenu(lista);
	  
	  lista.setOnItemLongClickListener(new OnItemLongClickListener(){

		@Override
		public boolean onItemLongClick(AdapterView<?> adapter, View view,
				int position, long arg3id) {
			alumno=(Alumno)adapter.getItemAtPosition(position);
			//Toast.makeText(ListaAlumnos.this,"Click largo en la posicion : "+adapter.getItemIdAtPosition(position),Toast.LENGTH_SHORT).show();
			return false;
		}});
	  
	  lista.setOnItemClickListener(new OnItemClickListener(){

		@Override
		public void onItemClick(AdapterView<?> adapter, View view, int position,
				long arg3) {
			
			Alumno alumnoseleccionado=(Alumno) adapter.getItemAtPosition(position);
			Intent irparaformulario=new Intent(ListaAlumnos.this,Formulario.class);
			irparaformulario.putExtra("alumnoseleccionado",alumnoseleccionado);
            startActivity(irparaformulario);
			
		}});
	  
      
	  }

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		
		menu.add("Matricular");
		menu.add("Enviar sms");
		menu.add("Visitra sitio web");
		MenuItem eliminar=menu.add("Eliminar");
		eliminar.setOnMenuItemClickListener(new OnMenuItemClickListener(){

			@Override
			public boolean onMenuItemClick(MenuItem arg0) {
				AlumnoDAO dao=new AlumnoDAO(ListaAlumnos.this);
				dao.eliminar(alumno);
				cargarlista();
				dao.close();
				return false;
			}

			
			
		});
		
		menu.add("Ver en el mapa");
		menu.add("Enviar un email");
		super.onCreateContextMenu(menu, v, menuInfo);
		
		
	}

	
	private void cargarlista() {
		  AlumnoDAO dao=new AlumnoDAO(this);
		  
		  List<Alumno> alumnos=dao.getlista();
		  dao.close();
		  int layout=android.R.layout.simple_list_item_1;
		  
		  ArrayAdapter<Alumno> adapter= new ArrayAdapter<Alumno>(this,layout,alumnos);
		  
		  lista=(ListView)findViewById(R.id.lista);
		  
		  lista.setAdapter(adapter);
		
	}
	


	

	
	
}
