package application.model;

public class Alunos {

	private int id;
	private String nome;
	private int ra;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getRa() {
		return ra;
	}
	public void setRa(int ra) {
		this.ra = ra;
	}
	
	@Override
	public String toString() {
		return "Alunos [id=" + id + ", nome=" + nome + ", ra=" + ra + "]";
	}
	
}
