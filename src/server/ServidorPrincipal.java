package server;

import java.rmi.RemoteException;

public class ServidorPrincipal {
	public static void main(String[] args) {
            
		String ip = "192.168.43.229", name = "SD";
		try {
			Ordenar ordena = new Ordenar();
			Server servidor = new Server(ordena, ip, name);
		} catch (IllegalAccessException e) {
			
			e.printStackTrace();
		}catch (InstantiationException e) {
			
			e.printStackTrace();
		}catch (RemoteException e) {
			
			e.printStackTrace();
		}
                
                
	}
}
