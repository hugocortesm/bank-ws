package mx.com.allianz.course.bankws.types;

public class TransferRequest {

	private int cuentaOrigen;
	private int cuentaDestino;
	private double monto;

	public int getCuentaOrigen() {
		return cuentaOrigen;
	}

	public void setCuentaOrigen(int cuentaOrigen) {
		this.cuentaOrigen = cuentaOrigen;
	}

	public int getCuentaDestino() {
		return cuentaDestino;
	}

	public void setCuentaDestino(int cuentaDestino) {
		this.cuentaDestino = cuentaDestino;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

}
