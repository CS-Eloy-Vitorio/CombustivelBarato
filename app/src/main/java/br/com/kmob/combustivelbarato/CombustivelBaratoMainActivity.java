package br.com.kmob.combustivelbarato;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class CombustivelBaratoMainActivity extends Activity {
	
	//Identificador da mensagem
	public final static String EXTRA_MENSAGEM = "br.com.kmob.combustivelbarato.DADOS";

	
	EditText edtValorLitroGasolina, edtValorAbastecidoGasolina, edtKmPercorridoGasolina, edtValorLitroAlcool, edtValorAbastecidoAlcool, edtKmPercorridoAlcool;
	double valorLitroGasolina, valorAbastecidoGasolina, valorLitroAlcool, valorAbastecidoAlcool;
	double kmPercorridoGasolina, kmPercorridoAlcool;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_combustivel_barato_main);
		
		edtValorLitroGasolina = (EditText)findViewById(R.id.edt_valor_gasolina);
		edtValorAbastecidoGasolina = (EditText)findViewById(R.id.edt_valor_abastecido_gasolina);
		edtKmPercorridoGasolina = (EditText)findViewById(R.id.edt_distancia_percorrida_gasolina);
		
		edtValorLitroAlcool = (EditText)findViewById(R.id.edt_valor_alcool);
		edtValorAbastecidoAlcool = (EditText)findViewById(R.id.edt_valor_abastecido_alcool);
		edtKmPercorridoAlcool = (EditText)findViewById(R.id.edt_distancia_percorrida_alcool);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.combustivel_barato_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	/*Listener do botao Verificar para calcular a diferenca de precos entre alcool e gasolina
	 * Apos calcular vai chamar a proxima tela e passar o resultado como parametro
	 */
	public void verificar (View v) {
		valorLitroGasolina = Double.parseDouble(edtValorLitroGasolina.getText().toString());
		valorAbastecidoGasolina = Double.parseDouble(edtValorAbastecidoGasolina.getText().toString());
		valorLitroAlcool = Double.parseDouble(edtValorLitroAlcool.getText().toString());
		valorAbastecidoAlcool = Double.parseDouble(edtValorAbastecidoAlcool.getText().toString());
		kmPercorridoGasolina = Double.parseDouble(edtKmPercorridoGasolina.getText().toString());
		kmPercorridoAlcool = Double.parseDouble(edtKmPercorridoAlcool.getText().toString());
		
		VerificaEconomia verificaEconomia = new VerificaEconomia(valorLitroGasolina, valorAbastecidoGasolina, valorLitroAlcool, 
				valorAbastecidoAlcool, kmPercorridoGasolina, kmPercorridoAlcool);
		
		verificaEconomia.calcularDesempenho();
		
		String [] dadosConsumo = new String[] {String.valueOf(valorLitroGasolina), String.valueOf(valorAbastecidoGasolina), String.valueOf(valorLitroAlcool), 
				String.valueOf(valorAbastecidoAlcool), String.valueOf(kmPercorridoGasolina), String.valueOf(kmPercorridoAlcool), String.valueOf(verificaEconomia.litrosPorKmGasolina),
				String.valueOf(verificaEconomia.litrosPorKmAlcool)};
		
		Intent intent = new Intent(this, Comparativo.class);
		intent.putExtra(EXTRA_MENSAGEM, dadosConsumo);
		
		startActivity(intent);
	}

	public void limpar(View v){
		edtValorLitroGasolina.setText("");
		edtValorAbastecidoGasolina.setText("");
		edtValorLitroAlcool.setText("");
		edtValorAbastecidoAlcool.setText("");
		edtKmPercorridoGasolina.setText("");
		edtKmPercorridoAlcool.setText("");
	}
}
