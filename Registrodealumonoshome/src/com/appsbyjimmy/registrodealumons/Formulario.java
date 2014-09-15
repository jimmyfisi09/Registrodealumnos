package com.appsbyjimmy.registrodealumons;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;


public class Formulario extends ActionBarActivity {
	private FormularioHelper formulariohelper;
	Button grabar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	
    	super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);
        
        Intent intent=getIntent();
        final Alumno alumnoamodificar=(Alumno)intent.getSerializableExtra("alumnoseleccionado");
       
        
        //Toast.makeText(this,"Alumno "+alumnoamodificar,Toast.LENGTH_LONG).show();
        formulariohelper=new FormularioHelper(this);
       
        grabar=(Button)findViewById(R.id.grabar);
        
        if(alumnoamodificar!=null){
        	grabar.setText("Modificar");
        	formulariohelper.colocarAlumnoEnFormulario(alumnoamodificar);
        }
    	
        
        
     
        
		grabar.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				
				Alumno alumno=formulariohelper.guardar();
		    	
                AlumnoDAO dao=new AlumnoDAO(Formulario.this);
                  
                
                if(alumnoamodificar==null){
                dao.guardar(alumno);
                
               Toast t=Toast.makeText(Formulario.this, "alumno guardado",Toast.LENGTH_LONG);
               t.show();
                }else{
                	
                	alumno.setId(alumnoamodificar.getId());
                	dao.modificaralumno(alumno);
                }
               
               dao.close();
                
                Intent int1=new Intent("com.appsbyjimmy.registrodealumons.ListaAlumnos");
                startActivity(int1);
                
	
			}});
    }

	/*@Override
	public void onClick(View arg0) {
		switch(arg0.getId()){
		
		case R.id.grabar:  Alumno alumno=formulariohelper.guardar();
    	
                           AlumnoDAO dao=new AlumnoDAO(this);
                             
                           dao.guardar(alumno);
                           
                          
                           dao.close();
                           
                           Intent int1=new Intent("com.appsbyjimmy.registrodealumons.ListaAlumnos");
                           startActivity(int1);
			 Toast t=Toast.makeText(this,"alumno guardado",Toast.LENGTH_LONG);
             t.show();
                           
                           
			
		
		
	}


 
}*/
}
