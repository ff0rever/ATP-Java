package mercadojavali;


     public class Laticinio extends Produto {

	private static final long serialVersionUID = 1L;

	//public String soar() {
		//return "Faz latidos";
	//}
	public Laticinio(String nome, int codigo, String fornecedor) {
		super(nome, codigo, fornecedor);
		this.categoria= "Laticinio";
	}
}
