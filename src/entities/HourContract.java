package entities;

import java.util.Date;

public class HourContract {
	
	private Date data;
	private Double valorPorHora;
	private int hora;
	
	
	
	public HourContract(Date data, Double valorPorHora, int hora) {
		this.data = data;
		this.valorPorHora = valorPorHora;
		this.hora = hora;
	}
	
	@Override
	public String toString() {
		return "HourContract [data=" + data + ", valorPorHora=" + valorPorHora + ", hora=" + hora + "]";
	}
	
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Double getValorPorHora() {
		return valorPorHora;
	}
	public void setValorPorHora(Double valorPorHora) {
		this.valorPorHora = valorPorHora;
	}
	public int getHora() {
		return hora;
	}
	public void setHora(int hora) {
		this.hora = hora;
	}
	
	public double valorTotal() {
		return valorPorHora * hora;
	}
	

}
