package mx.com.allianz.course.bankws.types;

import java.math.BigDecimal;

public class TransferResponse {

	private BigDecimal saldoPrevio;
	private BigDecimal saldoNuevo;
	private BigDecimal balanceDestinoPrevio;
	private BigDecimal balanceDestinoNuevo;

	public BigDecimal getSaldoPrevio() {
		return saldoPrevio;
	}

	public void setSaldoPrevio(BigDecimal saldoPrevio) {
		this.saldoPrevio = saldoPrevio;
	}

	public BigDecimal getSaldoNuevo() {
		return saldoNuevo;
	}

	public void setSaldoNuevo(BigDecimal saldoNuevo) {
		this.saldoNuevo = saldoNuevo;
	}

	public BigDecimal getBalanceDestinoPrevio() {
		return balanceDestinoPrevio;
	}

	public void setBalanceDestinoPrevio(BigDecimal balanceDestinoPrevio) {
		this.balanceDestinoPrevio = balanceDestinoPrevio;
	}

	public BigDecimal getBalanceDestinoNuevo() {
		return balanceDestinoNuevo;
	}

	public void setBalanceDestinoNuevo(BigDecimal balanceDestinoNuevo) {
		this.balanceDestinoNuevo = balanceDestinoNuevo;
	}

}
