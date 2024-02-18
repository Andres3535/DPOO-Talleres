package uniandes.dpoo.estructuras.logica;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Esta clase tiene un conjunto de métodos para practicar operaciones sobre mapas.
 *
 * Todos los métodos deben operar sobre el atributo mapaCadenas que se declara como un Map.
 * 
 * En este mapa, las llaves serán cadenas y los valores serán también cadenas. La relación entre los dos será que cada llave será igual a la cadena del valor, pero invertida.
 * 
 * El objetivo de usar el tipo Map es que sólo puedan usarse métodos de esa interfaz y no métodos adicionales provistos por la implementación concreta (HashMap).
 * 
 * No pueden agregarse nuevos atributos.
 */
public class SandboxMapas
{
    /**
     * Un mapa de cadenas para realizar varias de las siguientes operaciones.
     * 
     * Las llaves del mapa son cadenas, así como los valores.
     * 
     * Las llaves corresponden a invertir la cadena que aparece asociada a cada llave.
     */
    private Map<String, String> mapaCadenas;

    /**
     * Crea una nueva instancia de la clase con las dos listas inicializadas pero vacías
     */
    public SandboxMapas( )
    {
        mapaCadenas = new HashMap<String, String>( );
    }

    /**
     * Retorna una lista con las cadenas del mapa (los valores) ordenadas lexicográficamente
     * @return Una lista ordenada con las cadenas que conforman los valores del mapa
     */
    public List<String> getValoresComoLista( )
    {
    	
    	List<String> NuevaLista = new ArrayList<String>();
    	Set<String> llaves = mapaCadenas.keySet();
    	Object[] Keys = llaves.toArray();
    	for (int i = 0; i < Keys.length; i++) {
    		NuevaLista.add(i, mapaCadenas.get(Keys[i]));
		}
    	Collections.sort(NuevaLista);
        return NuevaLista;
    }

    /**
     * Retorna una lista con las llaves del mapa ordenadas lexicográficamente de mayor a menor
     * @return Una lista ordenada con las cadenas que conforman las llaves del mapa
     */
    public List<String> getLlavesComoListaInvertida( )
    {
    	List<String> NuevaLista = getValoresComoLista();
    	Collections.sort(NuevaLista,Collections.reverseOrder());
        return NuevaLista;
    }

    /**
     * Retorna la cadena que sea lexicográficamente menor dentro de las llaves del mapa .
     * 
     * Si el mapa está vacío, debe retornar null.
     * @return
     */
    public String getPrimera( )
    {
    	if(mapaCadenas.size() == 0)
        	return null;
    	List<String> NuevaLista = getValoresComoLista();
    	return NuevaLista.get(0);
    }

    /**
     * Retorna la cadena que sea lexicográficamente mayor dentro de los valores del mapa
     * 
     * Si el conjunto está vacío, debe retornar null.
     * @return
     */
    public String getUltima( )
    {
    	if(mapaCadenas.size() == 0)
        	return null;
    	List<String> NuevaLista = getValoresComoLista();
    	Collections.sort(NuevaLista,Collections.reverseOrder());
        return NuevaLista.get(0);
    }

    /**
     * Retorna una colección con las llaves del mapa, convertidas a mayúsculas.
     * 
     * El orden de las llaves retornadas no importa.
     * @return Una lista de cadenas donde todas las cadenas están en mayúsculas
     */
    public Collection<String> getLlaves( )
    {
    	Collection<String> NuevaLista = new ArrayList<String>();
    	for (String n : mapaCadenas.keySet()) 
    	{
			NuevaLista.add(n.toUpperCase());
			
		}
        return NuevaLista;
    }

    /**
     * Retorna la cantidad de *valores* diferentes en el mapa
     * @return
     */
    public int getCantidadCadenasDiferentes( )
    {
    	List<String> NuevaLista = new ArrayList<>();
    	for (String n : getLlaves()) {
			if(!NuevaLista.contains(mapaCadenas.get(n))) NuevaLista.add(mapaCadenas.get(n));
    	}
        return NuevaLista.size();
    }

    /**
     * Agrega un nuevo valor al mapa de cadenas: el valor será el recibido por parámetro, y la llave será la cadena invertida
     * 
     * Este método podría o no aumentar el tamaño del mapa, dependiendo de si ya existía la cadena en el mapa
     * 
     * @param cadena La cadena que se va a agregar al mapa
     */
    public void agregarCadena( String cadena )
    {
    	StringBuilder cadenaInvertidaa = new StringBuilder(cadena).reverse();
    	String cadenaInvertida = cadenaInvertidaa.toString();
    	if(!mapaCadenas.containsKey(cadenaInvertida)) {
    		mapaCadenas.put(cadenaInvertida, cadena);
    	}
    	
    }

    /**
     * Elimina una cadena del mapa, dada la llave
     * @param cadena La llave para identificar el valor que se debe eliminar
     */
    public void eliminarCadenaConLLave( String llave )
    {
    	mapaCadenas.remove(llave);
    }

    /**
     * Elimina una cadena del mapa, dado el valor
     * @param cadena El valor que se debe eliminar
     */
    public void eliminarCadenaConValor( String valor )
    {
    	Iterator<Entry<String, String>> iterator = mapaCadenas.entrySet().iterator();
        while (iterator.hasNext()) {
            Entry<String, String> entry = iterator.next();
            if (entry.getValue().equals(valor)) {
                iterator.remove();
            }
        }
    }

    /**
     * Reinicia el mapa de cadenas con las representaciones como Strings de los objetos contenidos en la lista del parámetro 'objetos'.
     * 
     * Use el método toString para convertir los objetos a cadenas.
     * @param valores Una lista de objetos
     */
    public void reiniciarMapaCadenas( List<Object> objetos )
    {
    	mapaCadenas.clear();
    	for (Object n : objetos) {
            String cadena = n.toString(); 
            mapaCadenas.put("relleno" + mapaCadenas.size(), cadena);
    	}
    }

    /**
     * Modifica el mapa de cadenas reemplazando las llaves para que ahora todas estén en mayúsculas pero sigan conservando las mismas cadenas asociadas.
     */
    public void volverMayusculas( )
    {
    	Set<String> llaves = mapaCadenas.keySet();
    	Map<String, String> nuevoMapa = new HashMap<>();
    	 for (String n : llaves) {
             String llaveMayusculas = n.toUpperCase();
             if (!llaveMayusculas.equals(n)) {
                 String valor = mapaCadenas.get(n);
                 nuevoMapa.put(llaveMayusculas, valor);
             } else {
                 nuevoMapa.put(n, mapaCadenas.get(n));
             }
         }
    }

    /**
     * Verifica si todos los elementos en el arreglo de cadenas del parámetro hacen parte del mapa de cadenas (de los valores)
     * @param otroArreglo El arreglo de enteros con el que se debe comparar
     * @return True si todos los elementos del arreglo están dentro de los valores del mapa
     */
    public boolean compararValores( String[] otroArreglo )
    {
    	for (String n : otroArreglo) {
            if (!mapaCadenas.containsValue(n)) {
                return false;
            }
        }
        return true;
    }

}
