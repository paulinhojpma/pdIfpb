import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ICliente extends Remote {
	public void getMensagem(String mensagem) throws RemoteException;
}
