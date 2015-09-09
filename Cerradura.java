public class Cerradura {
	private Integer clave; 					// Codigo para bloquear cerradura
	private Integer fallos_consecutivos;	// Cantidad maxima de fallos concecutivos hasta que se bloquee la cerradura
	private Integer fallo;					// Contador de fallos, mientras sea menor a fallos_consecutivos se podra abrir
	private Boolean abierta;				// Indicador que dice que la puerta esta abierta
		
	public Cerradura(int clave, int fallos_consecutivos) {
		this.clave = clave;
		this.fallos_consecutivos = fallos_consecutivos;
		this.fallo = 0;
		this.abierta = false;
	}
	
	public void abrir(int clave) {
		if (estaCerrada()) {
			if (this.fallo < this.fallos_consecutivos) {
				if (this.clave == clave) {
					this.abierta = true;
					this.fallo = 0;
				}
				else{
					this.fallo = this.fallo + 1;	
				    this.abierta = false;
				}
			}
		}	
	}
	
	public void cerrar() {
		if (this.abierta == true) {
			this.abierta = false;
		}
	}
	
	public boolean estaAbierta () {
		if (this.abierta == true)
			return true;
		else
			return false;
	}
	
	public boolean estaCerrada () {
		if (this.abierta == false)
			return true;
		else
			return false;
	}
	
	public boolean fueBloqueada(){
		if (this.fallo == this.fallos_consecutivos) 
				return true;
		else
				return false;
	}
}
