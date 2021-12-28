package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.NivelProfissao;

public class Worker {

	private String nome;
	private NivelProfissao nivel;
	private double salarioBase;

	private Profissao profissao;
	private List<HourContract> contratos = new ArrayList<>();

	@Override
	public String toString() {
		return "Worker [nome=" + nome + ", nivel=" + nivel + ", salarioBase=" + salarioBase + ", profissao=" + profissao
				+ "]";
	}

	public Worker(String nome, NivelProfissao nivel, double salarioBase, Profissao profissao) {
		this.nome = nome;
		this.nivel = nivel;
		this.salarioBase = salarioBase;
		this.profissao = profissao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public NivelProfissao getNivel() {
		return nivel;
	}

	public void setNivel(NivelProfissao nivel) {
		this.nivel = nivel;
	}

	public double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(double salarioBase) {
		this.salarioBase = salarioBase;
	}

	public Profissao getProfissao() {
		return profissao;
	}

	public void setProfissao(Profissao profissao) {
		this.profissao = profissao;
	}

	public List<HourContract> getContratos() {
		return contratos;
	}

	public void setContratos(List<HourContract> contratos) {
		this.contratos = contratos;
	}

	public void addContrato(HourContract contrato) {
		contratos.add(contrato);
	}

	public void removerContrato(HourContract contrato) {
		contratos.remove(contrato);
	}

	public double renda(int mes, int ano) {
		Double soma = salarioBase;
		Calendar cal = Calendar.getInstance();
		for (HourContract c : contratos) {
			cal.setTime(c.getData());
			int c_mes = 1 + cal.get(Calendar.MONTH);
			int c_ano = cal.get(Calendar.YEAR);
			if (c_mes == mes && c_ano == ano) {
			soma += c.valorTotal();

			}
		}
		return soma;
	}

}
