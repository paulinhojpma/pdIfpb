import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

public class Cliente extends UnicastRemoteObject implements ICliente {
	String nome;
	 IServer server;
	static Scanner teclado; 
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Cliente() throws RemoteException {
		try{
			 server = (IServer) Naming.lookup("rmi://169.254.26.80:1099/Server");
			 
		}catch(Exception e){
			
		}
		chatCliente();
		// TODO Auto-generated constructor stub
	}
	
	public void enviaComando() throws RemoteException {
		
	}
	
	public Object executaMensagem(Mensagem mensagem) throws RemoteException {
		return mensagem.start();
	}
	

	@Override
	public void getMensagem(String mensagem) throws RemoteException {
		System.out.println(mensagem);
		
	}
	// o cliente loga e faz o comando daki
	
	public void chatCliente(){
		boolean i=false;
		String nom="";
		do{
			System.out.println("Insira um nome válido");
			nom=teclado.nextLine();
			if(!nom.equals("")){
				try {
					i=server.cadastraCliente(nom, this);
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(i==false){
					System.out.println("O nome informado já existe.");
				}else{
					this.nome=nom;
				}
			}else{
				System.out.println("Você não digitou nada.");
			}
		
		}while(i==false);
		
		i=false;
		do{
			System.out.println("------------Comando Chat-------------\n"
					 + "1 - Mensagem para todos:\n"
					 + "2 - Mensagem em privado:\n"
					 + "3 - Listar participantes:\n"
					 + "4 - Renomear:\n"
					 + "5 - Sair\n");
			int comando=Integer.parseInt(teclado.nextLine());
			String msg="";
			String destinatario="";
			
			switch (comando){
		
			case 1:
				System.out.println("Para todos.");
				msg=teclado.nextLine();
			
				break;
			case 2:
				System.out.println("Informe o nome do usuário.");
				destinatario=teclado.nextLine();
				System.out.println("digite a mensagem.");
				msg=teclado.nextLine();
				break;
			case 3:
				System.out.println("Participantes do Chat");
				break;
			case 4:
				System.out.println("Digite novo nome");
				msg=teclado.nextLine();
				break;
			case 5:
				System.out.println("Falou");
				i=true;
				break;
			default :
					System.out.println("Comando inválido tente novamente");
			}
			if(comando < 6 && comando > 0){
				try {
					//System.out.println("Nome enviado --- "+nome);
					boolean novoNome = server.trataComando(comando, msg, nome, destinatario);
					if(novoNome == true){
						this.nome=msg;
						//System.out.println("NOVO NOME -------" +this.nome);
						
					}
					
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
	
	//server.trataComando(comando, mensagem, remetente, destinatario);
			
		}while(i==false);
	}
	
	
	
	public static void main(String[] args) {
		teclado = new Scanner(System.in);
		 
		 ICliente cliente = null; 
		try {
			new Cliente();
			System.exit(0);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//chatCliente(cliente);
	
		

	}

}
