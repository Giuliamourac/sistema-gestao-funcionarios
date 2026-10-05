package Funcionario;

public abstract class Funcionario 
{
	protected String nome;
	protected int matricula;
	protected double salarioBase;
	
	public Funcionario(String nome, int matricula, double salarioBase)
	{
		this.nome = nome;
		this.matricula = matricula;
		this.salarioBase = salarioBase;
	}
	
	public void exibirDados()
	{
		System.out.println("-- Dados de funcionário --");
		System.out.println("Nome: " + this.nome);
		System.out.println("Salário base: " + this.salarioBase);
	}
	
	public abstract double calcularSalarioFinal();
	
	public abstract String obterDescricao();
	
	public void setNome(String nome)
	{
		this.nome = nome;
	}
	
	public void setMatricula(int matricula)
	{
		this.matricula = matricula;
	}
	
	public void setSalarioBase(double salarioBase)
	{
		this.salarioBase = salarioBase;
	}
	
	public String getNome()
	{
		return this.nome;
	}
	
	public int getMatricula()
	{
		return this.matricula;
	}
	
	public double getSalarioBase()
	{
		return this.salarioBase;
	}
}
