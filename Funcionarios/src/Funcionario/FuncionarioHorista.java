package Funcionario;

public class FuncionarioHorista extends Funcionario
{
	protected int horasExtras;
	protected double valorHorasExtras;
	
	public FuncionarioHorista(String nome, int matricula, double salarioBase, int horasExtras, double valorHorasExtras)
	{
		super(nome, matricula, salarioBase);
		this.horasExtras = horasExtras;
		this.valorHorasExtras = valorHorasExtras;
	}
	
	public double calcularHorasExtras()
	{
		return this.horasExtras * this.valorHorasExtras;
	}
	
	@Override
	public double calcularSalarioFinal()
	{
		return this.salarioBase + calcularHorasExtras();
	}
	
	@Override
	public String obterDescricao()
	{
		return "Funcionario horista (Horas extras: " + this.horasExtras + " -Valor total horas extras: " + calcularHorasExtras() + " -Salário final: " + calcularSalarioFinal() + ")";	
	}
	
	public void setHorasExtras(int horasExtras)
	{
		this.horasExtras = horasExtras;
	}
	
	public void setValorHorasExtras(double valorHorasExtras)
	{
		this.valorHorasExtras = valorHorasExtras;
	}
	
	public int getHorasExtras()
	{
		return this.horasExtras;
	}
	
	public double getValorHorasExtras()
	{
		return this.valorHorasExtras;
	}
}
