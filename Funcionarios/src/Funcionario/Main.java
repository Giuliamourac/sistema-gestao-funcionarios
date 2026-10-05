package Funcionario;

import java.util.Scanner;
import java.util.ArrayList;

public class Main 
{

	 public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		ArrayList<Funcionario> funcionarios = new ArrayList<>();

		int op = 0;
		while (op != 10) {
			System.out.println("---     SISTEMA DE GESTÃO DE FUNCIONÁRIOS     ---");
			System.out.println("1- Cadastrar Funcionário (Horista / Comissionado)");
			System.out.println("2- Listar Todos os Funcionários");
			System.out.println("3- Buscar Funcionário por Matrícula");
			System.out.println("4- Editar Funcionário");
			System.out.println("5- Remover Funcionário");
			System.out.println("-------------------------------------------------");
			System.out.println("6- Lançar Horas Extras (Horistas)");
			System.out.println("7- Lançar Vendar (Comissionados)");
			System.out.println("_________________________________________________");
			System.out.println("8- Exibir Folha de Pagamento Total");
			System.out.println("9- Relatório Detalhado de Salários e Descrições");
			System.out.println("10- Sair.");
			System.out.println("-------------------------------------------------");
			System.out.println("Escolha uma opção:");

			op = scanner.nextInt();
			scanner.nextLine();

			switch (op) 
			{
			case 1:
				cadastrarFuncionario(scanner, funcionarios);
				break;

			case 2:
				listarFuncionarios(funcionarios);
				break;

			case 3:
				buscarFuncionario(scanner, funcionarios);
				break;

			case 4:
				editarFuncionario(scanner, funcionarios);
				break;

			case 5:
				removerFuncionario(scanner, funcionarios);
				break;

			case 6:
				lancarHorasExtras(scanner, funcionarios);
				break;

			case 7:
				lancarVendas(scanner, funcionarios);
				break;

			case 8:
				folhaPagamento(funcionarios);
				break;

			case 9:
				relatorioDetalhado(funcionarios);
				break;

			case 10:
				System.out.println("Saindo...");
				break;

			default:
				System.out.println("Opção inválida! Digite um número de 1 a 10...");
				break;

			}
		}
		scanner.close();
	}

	private static void cadastrarFuncionario(Scanner scanner, ArrayList<Funcionario> funcionarios)
	{
		System.out.println("-- Cadástro de Funcionário --");
		System.out.println("Tipo de funcionario (Horista(H) / Comissionado(C))");
		String tipoFuncionario = scanner.nextLine().toUpperCase();

		while (!tipoFuncionario.equals("H") && !tipoFuncionario.equals("C")) {
			System.out.println("Opção inválida! Digite 'H' para Horista ou 'C' para Comissionado: ");
			tipoFuncionario = scanner.nextLine().toUpperCase();
		}

		if (tipoFuncionario.equals("H")) {
			System.out.println("-- Cadastro de Funcionário Horista --");

			System.out.println("Nome: ");
			String nome = scanner.nextLine();

			System.out.println("Matrícula: ");
			int matricula = scanner.nextInt();

			System.out.println("Salário Base: ");
			double salario = scanner.nextDouble();

			System.out.println("Quantidade de Horas Extras: ");
			int horasExtras = scanner.nextInt();

			System.out.println("Digite o Valor Base da Hora Extra: ");
			double valor = scanner.nextDouble();

			FuncionarioHorista funcionario = new FuncionarioHorista(nome, matricula, salario, horasExtras,
					valor);
			funcionarios.add(funcionario);
		} else {
			System.out.println("-- Cadastro de Funcionário Comissionado --");

			System.out.println("Nome: ");
			String nome = scanner.nextLine();

			System.out.println("Matrícula: ");
			int matricula = scanner.nextInt();

			System.out.println("Salário Base: ");
			double salario = scanner.nextDouble();

			System.out.println("Total de vendas: ");
			int vendas = scanner.nextInt();

			System.out.println("Percentual de Comissão: ");
			double percentual = scanner.nextDouble();

			FuncionarioComissionado funcionario = new FuncionarioComissionado(nome, matricula, salario, vendas,
					percentual);
			funcionarios.add(funcionario);
		}
	}

	private static void listarFuncionarios(ArrayList<Funcionario> funcionarios)
	{
		System.out.println("-- Listagem de Funcionários --");

		for (Funcionario funcionario: funcionarios) 
		{
			int contagem = 1;
			System.out.println(contagem);
			
			exibirDadosBasicos(funcionario);
			
			if(funcionario instanceof FuncionarioHorista)
			{
				System.out.println("Funcionário Horista");
			}
			else
			{
				System.out.println("Funcionário Comissionado");
			}
			
			System.out.println("------------------------------------------------------------------");
			contagem++;
		}
	}

	private static void buscarFuncionario(Scanner scanner, ArrayList<Funcionario> funcionarios)
	{
		System.out.println("-- Busca por Matrícula --");
		
		System.out.println("Digite a matrícula que deseja buscar: ");
		int matriculaBuscar = lerMatricula(scanner);
		
		Funcionario funcionario = encontrarFuncionario(funcionarios, matriculaBuscar);

		if (funcionario != null) 
		{
		    System.out.println("Funcionário encontrado!");
		    System.out.println("Nome: " + funcionario.getNome());
		} 
		else 
		{
		    System.out.println("Nenhum funcionário encontrado com essa matrícula.");
		}
	}

	private static void editarFuncionario(Scanner scanner, ArrayList<Funcionario> funcionarios)
	{
		System.out.println("-- Edição de Funcionário --");
		
		System.out.println("Digite a matrícula do Funcionário que deseja editar: ");
		int matriculaEditar = lerMatricula(scanner);
		
		Funcionario funcionario = encontrarFuncionario(funcionarios, matriculaEditar);

		if (funcionario != null) 
		{
		    System.out.println("Funcionário encontrado!");
		    
		    exibirDadosBasicos(funcionario);
		    
		    if(funcionario instanceof FuncionarioHorista)
		    {
		     System.out.println("Funcionário Horista");
		    }
		    else
		    {
		    	System.out.println("Funcionário comissionado");
		    }
		    
		    int opcao = 0;
		    
		    while(opcao != 4)
		    {
		    	 System.out.println("O que deseja alterar?");
		    	 System.out.println("1- Nome");
		    	 System.out.println("2- Matrícula");
		    	 System.out.println("3- Salário");
		    	 System.out.println("4- Cancelar");
				      
		    	 opcao = scanner.nextInt();
		    	 scanner.nextLine();
		    	
		    	switch(opcao)
		        {
		        case 1:
		        	System.out.println("Digite o Nome: ");
		        	String novoNome = scanner.nextLine();
		        	funcionario.setNome(novoNome);
		        	break;
		        	
		        case 2:
		        	System.out.println("Digite a Matrícula: ");
		        	int novaMatricula = scanner.nextInt();
		        	scanner.nextLine();
		        	funcionario.setMatricula(novaMatricula);
		        	break;
		        	
		        case 3:
		        	System.out.println("Digite o Salário: ");
		        	double novoSalario = scanner.nextDouble();
		        	scanner.nextLine();
		        	funcionario.setSalarioBase(novoSalario);
		        	break;
		        	
		        case 4:
		        	System.out.println("Edição cancelada.");
		        	break;
		        	
		        	default:
		        		System.out.println("Opção inválida! Digite um número de 1 a 4...");
		        		break;
		        }
		    }
		} 
		else 
		{
		    System.out.println("Nenhum funcionário encontrado com essa matrícula.");
		}
	}

	private static void removerFuncionario(Scanner scanner, ArrayList<Funcionario> funcionarios)
	{
		System.out.println("-- Remoção de Funcionário --");
		
		System.out.println("Digite a matrícula do funcionário que deseja remover: ");
		int matriculaExcluir = lerMatricula(scanner);
		
		Funcionario funcionario = encontrarFuncionario(funcionarios, matriculaExcluir);
		
		if (funcionario != null) 
		{
		    System.out.println("Funcionário encontrado!");
		    
		    exibirDadosBasicos(funcionario);
		    
		    System.out.println("Tem certeza que deseja excluir este funcionário? (S/N)");
		    String resposta = scanner.nextLine().toUpperCase();
		    
		    if(!resposta.equals("S") && !resposta.equals("N"))
		    {
		    	System.out.println("Resposta inválida, digite 'S' para sim ou 'N' para não: ");
		    	resposta = scanner.nextLine().toUpperCase();
		    }
		    else if(resposta.equals("S"))
		    {
		    	funcionarios.remove(funcionario);
		    	System.out.println("Funcionário removido com sucesso!");
		    }
		    else
		    {
		    	System.out.println("Ação abortada...");
		    }
		} 
		else 
		{
			System.out.println("Nenhum funcionário encontrado com essa matrícula.");
		}
	}

	private static void lancarHorasExtras(Scanner scanner, ArrayList<Funcionario> funcionarios)
	{
		System.out.println("-- Lançamento de Horas Extras --");
		System.out.println("Digite a matrícula do funcionário que deseja adicionar horas extras: ");
		
		int matriculaHorasExtras = lerMatricula(scanner);
		Funcionario funcionario = encontrarFuncionario(funcionarios, matriculaHorasExtras);
		
		if (funcionario != null && funcionario instanceof FuncionarioHorista) 
		{
		    System.out.println("Funcionário encontrado!");
		    
		    exibirDadosBasicos(funcionario);
		    
		    System.out.println("Quantas horas deseja adicionar?");
		    int horas = scanner.nextInt();
		    scanner.nextLine();
		    
		    FuncionarioHorista funcionarioHorista = (FuncionarioHorista) funcionario;
		    
		    funcionarioHorista.setHorasExtras(funcionarioHorista.getHorasExtras() + horas);
		    
		    System.out.println("Horas adicionadas com sucesso!");
		} 
		else 
		{
			System.out.println("Nenhum funcionário encontrado com essa matrícula.");
		}
	}
	
	private static void lancarVendas(Scanner scanner, ArrayList<Funcionario> funcionarios)
	{
		System.out.println("-- Lançamento de Vendas --");
		System.out.println("Digite a matrícula do funcionário que deseja adicionar vendas: ");
		
		int matriculaVendas = lerMatricula(scanner);
		Funcionario funcionario = encontrarFuncionario(funcionarios, matriculaVendas);
		
		if (funcionario != null && funcionario instanceof FuncionarioComissionado) 
		{
		    System.out.println("Funcionário encontrado!");
		    
		    exibirDadosBasicos(funcionario);
		    
		    System.out.println("Quantas vendas deseja adicionar?");
		    int vendas = scanner.nextInt();
		    scanner.nextLine();
		    
		    FuncionarioComissionado funcionarioComissionado = (FuncionarioComissionado) funcionario;
		    
		    funcionarioComissionado.setTotalVendas(funcionarioComissionado.getTotalVendas() + vendas);
		    
		    System.out.println("Vendas adicionadas com sucesso!");
		} 
		else 
		{
			System.out.println("Nenhum funcionário encontrado com essa matrícula.");
		}
	}

	// Método auxiliar reutilizado pela busca, edição e remoção: as três operações
	// precisam ler uma matrícula do teclado validando que o valor digitado seja
	// numérico, usando exatamente a mesma lógica de tentativa/captura de exceção.
	private static int lerMatricula(Scanner scanner)
	{
		int matricula;
		while (true) 
		{
		    try 
		    {
		        matricula = Integer.parseInt(scanner.nextLine());
		        break;
		    } 
		    catch (NumberFormatException letra) 
		    {
		        System.out.println("Matrícula inválida! Digite apenas números:");
		    }
		}
		return matricula;
	}
	
	private static void folhaPagamento(ArrayList<Funcionario> funcionarios)
	{
		System.out.println("-- Folha de Pagamento Total --");

	    double total = 0;

	    for (Funcionario funcionario : funcionarios)
	    {
	        total += funcionario.calcularSalarioFinal();
	    }

	    System.out.println("Total da folha de pagamento: R$ " + total);
	}

	private static void relatorioDetalhado(ArrayList<Funcionario> funcionarios)
	{
	    System.out.println("-- Relatório Detalhado de Salários e Descrições --");

	    for (Funcionario funcionario : funcionarios)
	    {
	        exibirDadosBasicos(funcionario);

	        System.out.println("Salário Final: R$ " + funcionario.calcularSalarioFinal());
	        System.out.println("Descrição: " + funcionario.obterDescricao());

	        System.out.println("------------------------------------------------------------------");
	    }
	}
	// Método auxiliar reutilizado pela busca, edição e remoção: as três operações
	// precisam percorrer a lista de funcionários procurando por uma matrícula
	// específica. Antes essa mesma busca (for + if + comparação) era escrita três
	// vezes; agora ela mora em um único lugar e devolve o funcionário encontrado
	// (ou null quando ninguém corresponde à matrícula informada).
	private static Funcionario encontrarFuncionario(ArrayList<Funcionario> funcionarios, int matricula)
	{
		for (Funcionario funcionario : funcionarios) 
		{
		    if (funcionario.getMatricula() == matricula) 
		    {
		        return funcionario;
		    }
		}
		return null;
	}

	// Método auxiliar reutilizado pela listagem, edição e remoção: as três
	// operações exibem exatamente as mesmas três linhas (Nome, Matrícula e
	// Salário Base) para um funcionário já localizado.
	private static void exibirDadosBasicos(Funcionario funcionario)
	{
		System.out.println("Nome: " + funcionario.getNome());
		System.out.println("Matrícula: " + funcionario.getMatricula());
		System.out.println("Salário Base: " + funcionario.getSalarioBase());
	}
}