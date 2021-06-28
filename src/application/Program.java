package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

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

		Trabalhador trabalhador = new Trabalhador(nome, NivelTrabalhador.valueOf(nivel), salarioBase,
				new Departamento(departamento));

		System.out.print("Quantos contratos para esse trabalhador? ");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {

			System.out.println("Entre com os dados do contrato #" + i);
			System.out.print("Data (DD/MM/AAAA): ");
			Date dataContrato = sdf.parse(sc.next());
			System.out.print("Valor por hora: ");
			Double valorHora = sc.nextDouble();
			System.out.print("Duração (hora): ");
			Integer horas = sc.nextInt();
			System.out.println();

			HoraContrato contrato = new HoraContrato(dataContrato, valorHora, horas);
			trabalhador.addContrato(contrato);

		}

		System.out.print("Entre com o mês e ano do recebimento (MM/AAAA): ");
		String mesEAno = sc.next();
		Integer mes = Integer.parseInt(mesEAno.substring(0, 2));
		Integer ano = Integer.parseInt(mesEAno.substring(3));

		System.out.println("Nome: " + trabalhador.getNome());
		System.out.println("Departamento: " + trabalhador.getDepartamento().getNome());
		System.out.println("Recebimentos no mês de " + mesEAno + ": " + String.format("%.2f", trabalhador.salario(mes, ano)));

		sc.close();

	}

}
