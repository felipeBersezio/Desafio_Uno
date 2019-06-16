package cl.desafio.bo;

import org.joda.time.LocalDate;
import org.json.JSONArray;
import org.json.JSONObject;

public class DesafioBO {
	private static DesafioBO instance;
	
	public static DesafioBO getInstance() {
		if (instance == null) {
			instance = new DesafioBO();
		}
		return instance;
	}
	
	public String getFechas(String in) {
		JSONObject jsonIn = new JSONObject();
		LocalDate fechaCreacion = null;
		LocalDate fechaFin = null;
		JSONArray fechas = new JSONArray();
		JSONArray fechasFaltantes = new JSONArray();
		JSONObject jsonOut = new JSONObject();
		try {
			jsonIn = new JSONObject(in);
			
			fechaCreacion = new LocalDate(jsonIn.optString("fechaCreacion"));
			fechaFin 	  = new LocalDate(jsonIn.optString("fechaFin"));			
		 	fechas        = jsonIn.optJSONArray("fechas");
		 	jsonOut       = jsonIn;
			
			System.out.println("fechaCreacion : " + fechaCreacion);
		    System.out.println("fechaFin : " + fechaFin);
			
		    for (LocalDate fechaActual = fechaCreacion;		            
		    		fechaActual.isBefore(fechaFin) || fechaActual.isEqual(fechaFin); 
		            fechaActual= fechaActual.plusDays(1)){		    	
		    		if (fechaActual.getDayOfMonth() == fechaActual.dayOfMonth().getMinimumValue()) {
		    			if (!existeFecha(fechas, fechaActual)) {
		    				fechasFaltantes.put(fechaActual);
		    				System.out.println(fechaActual);	
		    			}   				    			
		    		}    
		    }		
			jsonOut.put("fechasFaltantes", fechasFaltantes);
		} catch (Exception e) {
			jsonOut.put("status", "NOK");
			jsonOut.put("status", e.getMessage());
		} finally {
			//String.valueOf(jsonIn);
			//String.valueOf(jsonOut);
		}	
		
		return String.valueOf(jsonOut);
	}
	
	public boolean existeFecha(JSONArray fechas, LocalDate fechaBuscada) {
		boolean existe = false;		
		for (int i = 0; i < fechas.length(); i++) {
			LocalDate fecha = new LocalDate(fechas.getString(i));
			
			if (fecha.isEqual(fechaBuscada)) {
				existe = true;
				break;
			}	
		}
		return existe;
	}	
}