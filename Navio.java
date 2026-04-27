package ap1;

import java.util.ArrayList;
import java.util.Iterator;

public class Navio {

	private String nome, bandeira;
	private int id;
	private double capacidade;
	private ArrayList<Container> listaContainers;
	public Navio() {
		this.listaContainers = new ArrayList<Container>();
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getBandeira() {
		return bandeira;
	}
	public void setBandeira(String bandeira) {
		this.bandeira = bandeira;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getCapacidade() {
		return capacidade;
	}
	public void setCapacidade(double capacidade) {
		this.capacidade = capacidade;
	}
	public ArrayList<Container> getListaContainers() {
		return listaContainers;
	}
	public void setListaContainers(ArrayList<Container> listaContainers) {
		this.listaContainers = listaContainers;
	}
	public void addContainer (Container container) {
		listaContainers.add(container);
	}
	public void removerContainer(Container container) {
		Iterator<Container> it = listaContainers.iterator();
		while (it.hasNext()) {
			if (it.next().getId().equals(container.getId())) {
				it.remove();
	
			}
			
		}
	}
	@Override
	public String toString() {
		return "Navio [nome=" + nome + ", bandeira=" + bandeira + ", id=" + id + ", capacidade=" + capacidade
				+ ", listaContainers=" + listaContainers + "]";
	}
	
	
	
	
	
	
}
