package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.NivelTrabalhador;

public class Trabalhador {

	private String nome;
	private NivelTrabalhador nivel;
	private Double salarioBase;

	private List<HoraContrato> contratos = new ArrayList<>();
	private Departamento departamento;

	public Trabalhador() {
	}

	public Trabalhador(String nome, NivelTrabalhador nivel, Double salarioBase, Departamento departamento) {
		this.nome = nome;
		this.nivel = nivel;
		this.salarioBase = salarioBase;
		this.departamento = departamento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public NivelTrabalhador getNivel() {
		return nivel;
	}

	public void setNivel(NivelTrabalhador nivel) {
		this.nivel = nivel;
	}

	public Double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(Double salarioBase) {
		this.salarioBase = salarioBase;
	}

	public List<HoraContrato> getContratos() {
		return contratos;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public void addContrato(HoraContrato contrato) {
		contratos.add(contrato);
	}

	public void removeContrato(HoraContrato contrato) {
		contratos.remove(contrato);
	}

	public Double salario(Integer mes, Integer ano) {

		Double sum = salarioBase;
		Calendar cal = Calendar.getInstance();

		for (HoraContrato c : contratos) {

			cal.setTime(c.getData());
			
			int c_ano = cal.get(Calendar.YEAR);
			int c_mes = cal.get(Calendar.MONTH)+ 1;

			if (c_ano == ano && c_mes == mes) {
				sum += c.valorTotal();
			}
		}

		return sum;
	}

}
