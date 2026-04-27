package ap1;

public class Container {


	private String id, status, tipo;
	private double peso;
	private Navio navio;
	public Container() {
		
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public Navio getNavio() {
		return navio;
	}
	public void setNavio(Navio navio) {
		this.navio = navio;
	}
	@Override
	public String toString() {
		return "Container [id=" + id + ", status=" + status + ", tipo=" + tipo + ", peso=" + peso + "]";
	}
	
	
}
