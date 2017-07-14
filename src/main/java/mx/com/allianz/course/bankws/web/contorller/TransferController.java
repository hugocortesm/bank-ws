package mx.com.allianz.course.bankws.web.contorller;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mx.com.allianz.course.bankws.types.TransferRequest;
import mx.com.allianz.course.bankws.types.TransferResponse;

@RestController
public class TransferController {

	@Autowired
	private DataSource dataSource;

	// Servicio REST definición, recibe parametro TransferRequest
	@RequestMapping(method = RequestMethod.POST, path = "/transferir")
	public ResponseEntity<TransferResponse> ejecutar(@RequestBody TransferRequest request) throws SQLException {
		// imprimir valores de entrada
		System.out.println("cuenta orige = " + request.getCuentaOrigen());
		System.out.println("cuenta destino = " + request.getCuentaDestino());
		System.out.println("cuenta saldo = " + request.getMonto());

		// Abrir conexión para comunicarnos con la base de datos
		MapSqlParameterSource spParams = new MapSqlParameterSource();
		spParams.addValue("numCuentaOrigen", request.getCuentaOrigen());
		spParams.addValue("numCuentaDestino", request.getCuentaDestino());
		spParams.addValue("monto", request.getMonto());

		spParams.addValue("saldoAnteriorOrigen", BigDecimal.ZERO);
		spParams.addValue("saldoNuevoOrigen", BigDecimal.ZERO);
		spParams.addValue("saldoAnteriorDestino", BigDecimal.ZERO);
		spParams.addValue("saldoNuevoDestino", BigDecimal.ZERO);

		// ejecutar el llamado al stored procedure enviando parametros
		SimpleJdbcCall sjc = new SimpleJdbcCall(dataSource);
		sjc.withProcedureName("ejecutaTransferencia");
		Map<String, Object> output = sjc.execute(spParams);

		TransferResponse response = new TransferResponse();
		response.setSaldoPrevio((BigDecimal) output.get("SALDOANTERIORORIGEN"));
		response.setSaldoNuevo((BigDecimal) output.get("SALDONUEVOORIGEN"));
		response.setBalanceDestinoPrevio((BigDecimal) output.get("SALDOANTERIORDESTINO"));
		response.setBalanceDestinoNuevo((BigDecimal) output.get("SALDONUEVODESTINO"));

		return new ResponseEntity<TransferResponse>(response, HttpStatus.OK);

	}
}
