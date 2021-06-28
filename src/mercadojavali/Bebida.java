package mercadojavali;


     public class Bebida extends Produto {

	private static final long serialVersionUID = 1L;

	//public String soar() {
		//return "Faz latidos";
	//}
	public Bebida(String nome, int codigo, String fornecedor) {
		super(nome, codigo, fornecedor);
		this.categoria= "Bebida";
	}
}
