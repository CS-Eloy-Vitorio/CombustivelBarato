package br.com.kmob.combustivelbarato;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.view.View;

public class Comparativo extends Activity {
	
	private WebView webview;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_comparativo);
		
		double litrosPorKmGasolina, litrosPorKmAlcool;
		String comparativoHtml;
		String[] dadosComparativo = new String[]{};
		
		//Captura os parametros oriundos da tela anterior
		Intent intent = getIntent();
		dadosComparativo = intent.getStringArrayExtra(CombustivelBaratoMainActivity.EXTRA_MENSAGEM);
		
		//Cria webview para receber o resultado na tela
		webview = (WebView)findViewById(R.id.wbv_view);
		webview.getSettings().setJavaScriptEnabled(true);
		
		litrosPorKmGasolina = Double.parseDouble(dadosComparativo[6].toString());
		litrosPorKmAlcool = Double.parseDouble(dadosComparativo[7].toString());
		
		//Exibe o resultado na tela sinalizando de amarelo qual e o combustivel que fez mais Km por litro
		if(litrosPorKmGasolina > litrosPorKmAlcool){
			 comparativoHtml = "<html> <head> <style> table,th,td{border:1px solid black;border-collapse:collapse;} th,td{padding:5px;} </style> </head>"
					 + " <body>" 
					 + " <table align='" + "center" + "'>"
					 + " <tr>" 
					 + " <th>Km por Litro Gasolina</th>" 
					 + " </tr>"
					 + " <tr>" 
					 + " <td bgcolor='" + "yellow" + "'>" + dadosComparativo[6].toString() + "</td>" 
					 + " </tr>"   
					 + " <tr>"
					 + " <th>Km por Litro Alcool</th>"
					 + " </tr>"
					 + " <tr>"
					 + " <td>" + dadosComparativo[7].toString() + "</td>" 
					 + " </tr>"
					 + " </table>"
					 + " </body>"
					 + " </html>";
		}
		else if(litrosPorKmGasolina < litrosPorKmAlcool){
			 comparativoHtml = "<html> <head> <style> table,th,td{border:1px solid black;border-collapse:collapse;} th,td{padding:5px;} </style> </head>"
					 + " <body>" 
					 + " <table align='" + "center" + "'>"
					 + " <tr>" 
					 + " <th>Km por Litro Gasolina</th>" 
					 + " </tr>"
					 + " <tr>" 
					 + " <td>" + dadosComparativo[6].toString() + "</td>" 
					 + " </tr>"   
					 + " <tr>"
					 + " <th>Km por Litro Alcool</th>"
					 + " </tr>"
					 + " <tr>"
					 + " <td   bgcolor='" + "yellow" + "'>" + dadosComparativo[7].toString() + "</td>" 
					 + " </tr>"
					 + " </table>"
					 + " </body>"
					 + " </html>";
		}
		else{
			 comparativoHtml = "<html> <head> <style> table,th,td{border:1px solid black;border-collapse:collapse;} th,td{padding:5px;} </style> </head>"
					 + " <body>" 
					 + " <table align='" + "center" + "'>"
					 + " <tr>" 
					 + " <th>Km por Litro Gasolina</th>" 
					 + " </tr>"
					 + " <tr>" 
					 + " <td bgcolor='" + "yellow" + "'>" + dadosComparativo[6].toString() + "</td>" 
					 + " </tr>"   
					 + " <tr>"
					 + " <th>Km por Litro Alcool</th>"
					 + " </tr>"
					 + " <tr>"
					 + " <td   bgcolor='" + "yellow" + "'>" + dadosComparativo[7].toString() + "</td>" 
					 + " </tr>"
					 + " </table>"
					 + " </body>"
					 + " </html>";
		}
						
		webview.loadData(comparativoHtml, "text/html", null);
				
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.comparativo, menu);
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

	public void voltar(View v){
		finish();

	}
}
