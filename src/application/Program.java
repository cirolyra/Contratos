package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import com.sun.java.swing.action.NextAction;

import entities.Departamento;
import entities.HoraContrato;
import entities.Trabalhador;
import entities.enums.NivelTrabalhador;

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Entre com o nome do departamento: ");
		String departamento = sc.nextLine();

		System.out.println();
		System.out.println("Entre com os dados do trabalhador: ");
		System.out.print("Nome: ");
		String nome = sc.nextLine();
		System.out.print("Nível: ");
		String nivel = sc.nextLine();
		System.out.print("Salário-base: ");
		Double salarioBase = sc.nextDouble();
		
		Trabalhador trabalhador = new Trabalhador(nome, NivelTrabalhador.valueOf(nivel), salarioBase,new Departamento(departamento));
		
		System.out.print("Quantos contratos para esse trabalhador? ");
		int n = sc.nextInt();


		for (int i = 0; i < n; i++) {

			System.out.println("Entre com os dados do contrato #" + i + 1);
			System.out.print("Data (DD/MM/AAAA): ");
			Date dataContrato = sdf.parse(sc.next());
			System.out.print("Valor por hora: ");
			Double valorHora = sc.nextDouble();
			System.out.println("Duração (hora): ");
			Integer horas = sc.nextInt();
			
			HoraContrato contrato = new HoraContrato(dataContrato, valorHora, horas);
			trabalhador.addContrato(contrato);

		}
		
		System.out.print("Entre com o mês e ano do recebimento (MM/AAAA): ");
		String mesEAno = sc.next();
		

		sc.close();

	}

}
