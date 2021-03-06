package ar.edu.usal.torneos.model.dto;

import java.util.ArrayList;

import ar.edu.usal.torneos.model.dao.EquiposDao;

public class Equipos implements Comparable<Equipos> {

	private String nombre;
	private ArrayList<Jugadores> jugadores;
	private int puntos;
	private int goles;
	private int cantidadPartidosGanados;
	private int cantidadPartidosEmpatados;
	private int cantidadPartidosPerdidos;
	private int golesEnContra;
	
	public Equipos(String nombre, ArrayList<Jugadores> jugadores, int puntos) {
		super();
		this.nombre = nombre;
		this.jugadores = jugadores;
		this.setPuntos(puntos);
	}
	
	public Equipos(){}
	
	@Override
	public boolean equals(Object arg0) {
		
		boolean esIgual = false;
		
		if(arg0 instanceof Equipos){
			
			esIgual = this.nombre.equals(((Equipos) arg0).getNombre());	
		}
		
		return esIgual; 
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Jugadores> getJugadores() {
		return jugadores;
	}

	public void setJugadores(ArrayList<Jugadores> jugadores) {
		this.jugadores = jugadores;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	public int getGoles() {
		return goles;
	}

	public void setGoles(int goles) {
		this.goles = goles;
	}

	public int getCantidadPartidosGanados() {
		return cantidadPartidosGanados;
	}

	public void setCantidadPartidosGanados(int cantidadPartidosGanados) {
		this.cantidadPartidosGanados = cantidadPartidosGanados;
	}

	public int getCantidadPartidosEmpatados() {
		return cantidadPartidosEmpatados;
	}

	public void setCantidadPartidosEmpatados(int cantidadPartidosEmpatados) {
		this.cantidadPartidosEmpatados = cantidadPartidosEmpatados;
	}

	public int getCantidadPartidosPerdidos() {
		return cantidadPartidosPerdidos;
	}

	public void setCantidadPartidosPerdidos(int cantidadPartidosPerdidos) {
		this.cantidadPartidosPerdidos = cantidadPartidosPerdidos;
	}

	public int getGolesEnContra() {
		return golesEnContra;
	}

	public void setGolesEnContra(int golesEnContra) {
		this.golesEnContra = golesEnContra;
	}

	@Override
	public int compareTo(Equipos equipo) {
		
		int resultado = Integer.valueOf(equipo.puntos).compareTo(Integer.valueOf(this.puntos));
		
		if(resultado == 0){
			
			resultado = Integer.valueOf(equipo.goles - equipo.golesEnContra).compareTo(Integer.valueOf(this.getGoles() - this.getGolesEnContra()));
			
			if(resultado == 0){
				
				resultado = Integer.valueOf(equipo.goles).compareTo(Integer.valueOf(this.getGoles()));
				
				if(resultado == 0){
					
					resultado = Integer.valueOf(equipo.golesEnContra).compareTo(Integer.valueOf(this.getGolesEnContra()));
					
					//Si tiene mas goles en contra debe ser penalizado en la tabla respecto al otro equipo.
//					resultado = resultado > 0 ? -1 : 1;
				}
			}
		}
		
		return resultado;
	}
}
