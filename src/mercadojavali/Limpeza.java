
package mercadojavali;


     public class Limpeza extends Produto {

	private static final long serialVersionUID = 1L;

	//public String soar() {
		//return "Faz latidos";
	//}
	public Limpeza(String nome, int codigo, String fornecedor) {
		super(nome, codigo, fornecedor);
		this.categoria= "Limpeza";
	}
}
