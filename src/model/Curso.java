package model;

import java.util.ArrayList;

public class Curso {
	private int idCurso;
	private Nivel nivel;
	private int idInstituicao;
	private Regime regime;
	private String nomeCurso;
	private int qtdPeriodos;
	private String cidade;
	private ArrayList<Periodo> periodos;
	

	public Curso(Nivel nivel, int idInstituicao, Regime regime, String nomeCurso, int qtdPeriodos, String cidade) {
		this.nivel = nivel;
		this.idInstituicao = idInstituicao;
		this.regime = regime;
		this.nomeCurso = nomeCurso;
		this.qtdPeriodos = qtdPeriodos;
		this.cidade = cidade;
	}
	
	public int getIdCurso() {
		return idCurso;
	}
	
	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}
	
	public Nivel getNivel() {
		return nivel;
	}
	
	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}
	
	public int getIdInstituicao() {
		return idInstituicao;
	}
	
	public void setIdInstituicao(int idInstituicao) {
		this.idInstituicao = idInstituicao;
	}
	
	public Regime getRegime() {
		return regime;
	}
	
	public void setRegime(Regime regime) {
		this.regime = regime;
	}
	
	public String getNomeCurso() {
		return nomeCurso;
	}
	
	public void setNomeCurso(String nomeDoCurso) {
		this.nomeCurso = nomeDoCurso;
	}
	
	public int getQtdPeriodos() {
		return qtdPeriodos;
	}
	
	public void setQtdPeriodos(int qtdPeriodos) {
		this.qtdPeriodos = qtdPeriodos;
	}
	
	public String getCidade() {
		return cidade;
	}
	
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public ArrayList<Periodo> getPeriodos() {
		return periodos;
	}

	public void setPeriodos(ArrayList<Periodo> periodos) {
		this.periodos = periodos;
	}
	
}
