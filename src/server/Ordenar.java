package server;

import DAO.Ordena_DAO;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class Ordenar extends UnicastRemoteObject implements InterfaceOrdena{
    
	protected Ordenar() throws RemoteException {
		
	}
	
	public ArrayList<Integer> ordenarNumeros(ArrayList<Integer> numeros) throws RemoteException {
            
		System.out.println("Numeros que foram inseridos");
		for(int i=0; i<numeros.size(); i++) {
			System.out.print(numeros.get(i) + "  ");
		}
	
                Collections.sort(numeros);
                
                String sequenciaOrdenada="";
                
                for(int i=0; i<numeros.size(); i++){
                    sequenciaOrdenada = sequenciaOrdenada + " "+ numeros.get(i);
                }
                
               Ordena_DAO sdao = new Ordena_DAO();
                sdao.add(sequenciaOrdenada);

		
		System.out.println("\nNumeros ordenados");
		for(int i=0; i<numeros.size(); i++) {
			System.out.print(numeros.get(i) + "  ");
		}
		System.out.println("\n\n");                
		
		return numeros;
	}
}