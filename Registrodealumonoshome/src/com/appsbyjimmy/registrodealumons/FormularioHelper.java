package com.appsbyjimmy.registrodealumons;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;

public class FormularioHelper {
	 EditText nombre;
	 EditText site;
	 EditText telefono;
	 RatingBar calificacion;
	 ImageView foto;
	 Alumno alumno;
	
	public FormularioHelper(Formulario formulario){
	        
	        nombre=(EditText)formulario.findViewById(R.id.nombre);
	        site=(EditText)formulario.findViewById(R.id.site);
	        telefono=(EditText)formulario.findViewById(R.id.telefono);
	        calificacion=(RatingBar)formulario.findViewById(R.id.calificacion);
	        foto=(ImageView)formulario.findViewById(R.id.foto);
	        alumno=new Alumno();
	}
	public ImageView getFoto(){
		return foto;
	}
	public void cargarImagen(String rutaArchivo){
		alumno.setFoto(rutaArchivo);
		Bitmap imagen=BitmapFactory.decodeFile(rutaArchivo);
		Bitmap imagenReducida=Bitmap.createScaledBitmap(imagen,50,50, true);
		foto.setImageBitmap(imagenReducida);
		
	}
	public Alumno guardar(){
		 
	        
		    alumno.setNombre(nombre.getText().toString());
	        alumno.setTelefono(telefono.getText().toString());
	        alumno.setSite(site.getText().toString());
	        alumno.setNota(Double.valueOf(calificacion.getRating()));
	        
	        return alumno;
	}

	public  void colocarAlumnoEnFormulario(Alumno alumnoamodificar) {
		alumno=alumnoamodificar;
		nombre.setText(alumnoamodificar.getNombre());
		site.setText(alumnoamodificar.getSite());
		telefono.setText(alumnoamodificar.getTelefono());
		calificacion.setRating(alumnoamodificar.getNota().floatValue());
		
	}
}
