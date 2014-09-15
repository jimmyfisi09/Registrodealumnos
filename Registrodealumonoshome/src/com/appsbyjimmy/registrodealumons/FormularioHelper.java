package com.appsbyjimmy.registrodealumons;

import android.widget.EditText;
import android.widget.RatingBar;

public class FormularioHelper {
	 EditText nombre;
	 EditText site;
	 EditText telefono;
	 RatingBar calificacion;
	
	public FormularioHelper(Formulario formulario){
	        
	        nombre=(EditText)formulario.findViewById(R.id.nombre);
	        site=(EditText)formulario.findViewById(R.id.site);
	        telefono=(EditText)formulario.findViewById(R.id.telefono);
	        calificacion=(RatingBar)formulario.findViewById(R.id.calificacion);
	}
	
	public Alumno guardar(){
		   Alumno alumno=new Alumno();
	        
		    alumno.setNombre(nombre.getText().toString());
	        alumno.setTelefono(telefono.getText().toString());
	        alumno.setSite(site.getText().toString());
	        alumno.setNota(Double.valueOf(calificacion.getRating()));
	        
	        return alumno;
	}

	public  void colocarAlumnoEnFormulario(Alumno alumnoamodificar) {
		
		nombre.setText(alumnoamodificar.getNombre());
		site.setText(alumnoamodificar.getSite());
		telefono.setText(alumnoamodificar.getTelefono());
		calificacion.setRating(alumnoamodificar.getNota().floatValue());
		
	}
}
