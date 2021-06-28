
package mercadojavali;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class MercadoJavali1 {
    
private ArrayList<Produto> produtos;


	public MercadoJavali1( ) {
		this.produtos = new ArrayList<Produto>();
	}

	public void adicionaProduto(Produto mani) {
		this.produtos.add(mani);
	}

	public void listarProdutos() {
		for(Produto mani:produtos) {
			System.out.println(mani.toString());
		}
		System.out.println("Total = " + this.produtos.size() + " produtos listados com sucesso!\n");
	}
	
	public void excluirProduto(Produto mani) {
		if (this.produtos.contains(mani)) {
			this.produtos.remove(mani);
			System.out.println("[Produto " + mani.toString() + "excluido com sucesso!]\n");
		}
		else
			System.out.println("Produto não encontrado!\n");
	}

	public void excluirProdutos() {
		produtos.clear();
		System.out.println("Produtos excluidos com sucesso!\n");
	}
	public void gravarProdutos()  {
		ObjectOutputStream outputStream = null;
		try {
			outputStream = new ObjectOutputStream (new FileOutputStream("c:\\temp\\produtos.dat"));
			for(Produto mani:produtos) {
				outputStream.writeObject(mani);
			}
		}catch (FileNotFoundException ex) {
			ex.printStackTrace();
		}catch (IOException ex) {
			ex.printStackTrace();
		}finally{
			try {
				if (outputStream != null ) {
					outputStream.flush();
					outputStream.close();
				}
			}catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}    
	public void recuperarProdutos() {
		ObjectInputStream inputStream = null;
		try {
			inputStream	= new ObjectInputStream (new FileInputStream ("c:\\temp\\produtos.dat"));
			Object obj = null;
			while((obj = inputStream.readObject ()) != null) {
				if (obj instanceof Limpeza)  
					this.produtos.add((Limpeza)obj);
				else if (obj instanceof Bebida)  
					this.produtos.add((Bebida)obj);
                                else if (obj instanceof Laticinio)  
					this.produtos.add((Laticinio)obj);
			}
		}catch (EOFException ex) {     // when EOF is reached
			System.out.println ("End of file reached");
		}catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}catch (FileNotFoundException ex) {
			ex.printStackTrace();
		}catch (IOException ex) {
			ex.printStackTrace();
		}finally{
			try {
				if (inputStream != null ) {
					inputStream.close();
					System.out.println("Produtos recuperados com sucesso!\n");
				}
			}catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}


	public static void main(String[] args) {
		MercadoJavali1 produto  = new MercadoJavali1();

		Limpeza detergente    = new Limpeza("Detergente",    3, "Limpol");
		Limpeza sabao = new Limpeza("Sabão", 7, "Omo");
		Bebida  cerveja      = new Bebida ("Cerveja",  2, "Skol");
		Bebida  suco    = new Bebida ("Suco", 5, "Do Bem");
                Laticinio  queijo     = new Laticinio ("Queijo",  2, "Frimesa");
		Laticinio  leite    = new Laticinio ("Leite", 5, "Batavo");
		produto.adicionaProduto(detergente);
		produto.adicionaProduto(sabao);
		produto.adicionaProduto(cerveja);
		produto.adicionaProduto(suco);
                produto.adicionaProduto(queijo);
                produto.adicionaProduto(leite);
		produto.listarProdutos();
		produto.gravarProdutos();
		produto.excluirProdutos();
		produto.listarProdutos();
		produto.excluirProdutos();
		produto.listarProdutos();
		produto.recuperarProdutos();
		produto.listarProdutos();
	}
        
}
