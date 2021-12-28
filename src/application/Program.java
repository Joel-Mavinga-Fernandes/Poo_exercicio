package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.HourContract;
import entities.Profissao;
import entities.Worker;
import entities.enums.NivelProfissao;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc= new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Digite a profissão: ");
		String profissao = sc.nextLine();
		System.out.println("Digite os dados do funcionario:");
		System.out.print("Nome: ");
		String nome = sc.nextLine();
		System.out.print("Nível: ");
		String nivel = sc.nextLine();
		System.out.print("Salário Base: ");
		Double salarioBase = sc.nextDouble();
		Worker worker = new Worker(nome, NivelProfissao.valueOf(nivel.toUpperCase()), salarioBase, (new Profissao(nome)));
		
		System.out.println(worker);
		
		System.out.print("Quantos contratos para esse funcionario: ");
		int n = sc.nextInt();
		
		for(int i=1; i<=n; i++) {
			System.out.println("Digite os dados do contrato #"+i);
			System.out.print("Digite o valor por hora do contrato: ");
			Double valorPorHora= sc.nextDouble();
			System.out.print("Digite a duração em horas: ");
			int hora = sc.nextInt();
			System.out.print("Digite a data DD/MM/YYYY: ");
			Date data = sdf.parse(sc.next());
			HourContract contrato = new HourContract(data,valorPorHora, hora);
			worker.addContrato(contrato);
		}
		
		System.out.print("Digite o mes: ");
		int mes = sc.nextInt();
		
		System.out.print("Digite o ano: ");
		int ano = sc.nextInt();
		
		System.out.println();
		System.out.println("Nome: "+nome);
		System.out.println("Profissão: "+profissao);
		System.out.println("Renda para "+mes+"/"+ano+": "+worker.renda(mes, ano));
		
		
		
		sc.close();

	}

	

}
