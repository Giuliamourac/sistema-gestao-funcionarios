package Funcionario;

public class FuncionarioComissionado extends Funcionario
{
	protected int totalVendas;
	protected double percentualComissao;
	
	public FuncionarioComissionado(String nome, int matricula, double salarioBase, int totalVendas, double percentualComissao)
	{
		super(nome, matricula, salarioBase);
		this.totalVendas = totalVendas;
		this.percentualComissao = percentualComissao;
	}
	
	public double calcularComissao()
	{
		return this.totalVendas * this.percentualComissao;
	}
	
	@Override
	public double calcularSalarioFinal()
	{
		return this.salarioBase + calcularComissao();
	}
	
	@Override
	public String obterDescricao()
	{
		return "Funcionario Comissionado (Total de vendas: " + this.totalVendas + " -Comissão: " + calcularComissao() + " -Salário final: " + calcularSalarioFinal() + ")";
	}
	
	public void setTotalVendas(int totalVendas)
	{
		this.totalVendas = totalVendas;
	}
	
	public void setPercentualComissao(double percentualComissao)
	{
		this.percentualComissao = percentualComissao;
	}
	
	public int getTotalVendas()
	{
		return this.totalVendas;
	}
	
	public double getPercentualComissao()
	{
		return this.percentualComissao;
	}
}
