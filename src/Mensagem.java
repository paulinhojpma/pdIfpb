import java.io.Serializable;

public class Mensagem implements Serializable{
	private String cliente;
	private int comando;
	private String destinario;
	private String mensagem;
	public Mensagem(String cliente){
		this.cliente=cliente;
	}
	
	public Mensagem( String mensagem, String cliente, String destinario) {
		//super();
		this.cliente = cliente;
		
		this.destinario = destinario;
		this.mensagem = mensagem;
	}

	public Object start() {
		// TODO Auto-generated method stub
		return null;
	}
	public int getComando() {
		return comando;
	}
	public void setComando(int comando) {
		this.comando = comando;
	}
	public String getDestinario() {
		return destinario;
	}
	public void setDestinario(String destinario) {
		this.destinario = destinario;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	
	public void gerarMensagem(){
		System.out.println(cliente+" "+mensagem);
	}

}
