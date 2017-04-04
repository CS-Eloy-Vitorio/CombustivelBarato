package br.com.kmob.combustivelbarato;

import java.math.BigDecimal;

public class VerificaEconomia {
	
	public double valorLitroGasolina, valorAbastecidoGasolina, valorLitroAlcool, valorAbastecidoAlcool, litrosPorKmGasolina, litrosPorKmAlcool;
	public double kmPercorridoGasolina, kmPercorridoAlcool;
	
	public VerificaEconomia (double valorLitroGasolina, double valorAbastecidoGasolina, double valorLitroAlcool, double valorAbastecidoAlcool,
			double kmPercorridoGasolina, double kmPercorridoAlcool){
		this.valorLitroGasolina = valorLitroGasolina;
		this.valorLitroAlcool = valorLitroAlcool;
		this.valorAbastecidoAlcool = valorAbastecidoAlcool;
		this.valorAbastecidoGasolina = valorAbastecidoGasolina;
		this.kmPercorridoGasolina = kmPercorridoGasolina;
		this.kmPercorridoAlcool = kmPercorridoAlcool;
		
	}

	public double getValorLitroGasoilna() {
		return valorLitroGasolina;
	}

	public void setValorLitroGasoilna(double valorLitroGasoilna) {
		this.valorLitroGasolina = valorLitroGasoilna;
	}

	public double getValorAbastecidoGasolina() {
		return valorAbastecidoGasolina;
	}

	public void setValorAbastecidoGasolina(double valorAbastecidoGasolina) {
		this.valorAbastecidoGasolina = valorAbastecidoGasolina;
	}

	public double getValorLitroAlcool() {
		return valorLitroAlcool;
	}

	public void setValorLitroAlcool(double valorLitroAlcool) {
		this.valorLitroAlcool = valorLitroAlcool;
	}

	public double getValorAbstecidoAlcool() {
		return valorAbastecidoAlcool;
	}

	public void setValorAbstecidoAlcool(double valorAbstecidoAlcool) {
		this.valorAbastecidoAlcool = valorAbastecidoAlcool;
	}

	public double getKmPercorridoGasolina() {
		return kmPercorridoGasolina;
	}

	public void setKmPercorridoGasolina(int kmPercorridoGasolina) {
		this.kmPercorridoGasolina = kmPercorridoGasolina;
	}

	public double getKmPercorridoAlcool() {
		return kmPercorridoAlcool;
	}

	public void setKmPercorridoAlcool(int kmPercorridoAlcool) {
		this.kmPercorridoAlcool = kmPercorridoAlcool;
	}
	
	public void calcularDesempenho (){
		double litrosPorKmGasolinaAux = this.kmPercorridoGasolina / (this.valorAbastecidoGasolina / this.valorLitroGasolina);
		double litrosPorKmAlcoolAux = this.kmPercorridoAlcool / (this.valorAbastecidoAlcool / this.valorLitroAlcool);
		this.litrosPorKmGasolina = setaDuasCasasDecimais(litrosPorKmGasolinaAux);
		this.litrosPorKmAlcool = setaDuasCasasDecimais(litrosPorKmAlcoolAux);
	}
	
	private double setaDuasCasasDecimais (double valorRecebido){
		double roundOff = Math.round(valorRecebido * 100.0) / 100.0;
        return roundOff;

	}
	

}
