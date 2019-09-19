package edu.eci.cvds.game;

import java.util.ArrayList;
import java.util.Random;

import javax.faces.bean.ApplicationScoped; 
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.*;

@ManagedBean(name = "guess")
@SessionScoped
public class Game{
    private int numeroAdivinar;
    private int intentos;
    private int puntaje;
    private String estado;
    private ArrayList<Integer> listaIntentos;
	
	public Game(){
        listaIntentos = new ArrayList<Integer>();
        Random rand = new Random();
        numeroAdivinar = rand.nextInt(10)+1;
		intentos = 0;
		estado = "No gano";
		puntaje = 0;
    }

	public int getIntentos(){
		return intentos;
    }
    
	public void guess(int x){
		intentos++;
		if (numeroAdivinar != x){
            puntaje-=10000;
		}else{
            if (intentos==1){
                puntaje+=100000;
            }
            estado = this.getGano();
        }
        listaIntentos.add(x);
	}
	
	public String getGano() {
		return "Gano "+ puntaje;
	}
    
    public void restart(){
        listaIntentos = new ArrayList<Integer>();
		Random rand = new Random();
        numeroAdivinar = rand.nextInt(10)+1;
		intentos=0;
		estado = "No gano";
		puntaje = 0;
	}
    
	public int getPuntaje(){
		return puntaje;
	}
	
	public String getEstado(){
		return estado;
	}
    
    public int getNumeroAdivinar(){
        return numeroAdivinar;
    }

    public void setNumeroAdivinar(int num){
        numeroAdivinar=num;
    }

    public ArrayList<Integer> getListaIntentos(){
        return listaIntentos;
    }
}