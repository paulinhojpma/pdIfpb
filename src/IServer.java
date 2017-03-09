import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IServer extends Remote{
	public boolean cadastraCliente(String nome, ICliente cliente) throws RemoteException;
	public boolean trataComando(int comando, String mensagem, String remetente, String destinatario) throws RemoteException;
}
