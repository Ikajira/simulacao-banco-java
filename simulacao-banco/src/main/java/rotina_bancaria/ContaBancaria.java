package rotina_bancaria;

import java.util.Scanner;
import java.util.Random;

public class ContaBancaria {
    private int idConta;
    private String titularConta;
    private double saldoConta;
    
    private static final double SALDO_MINIMO_EMPRESTIMO = 5000.0;
    private static final double SALDO_MINIMO_CREDITO = 2500.0;
    private static final double DEPOSITO_MINIMO = 5.0;
    
    private Scanner entrada;
    private Random geradorId;

    public ContaBancaria(String nomeTitular, double saldoInicial) {
        if (nomeTitular == null || nomeTitular.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do titular não pode ser vazio");
        }
        
        if (saldoInicial < 0) {
            throw new IllegalArgumentException("Saldo inicial não pode ser negativo");
        }
        
        this.titularConta = nomeTitular;
        this.saldoConta = saldoInicial;
        this.entrada = new Scanner(System.in);
        this.geradorId = new Random();
        this.idConta = geradorId.nextInt(1000);
    }

    public int getIdConta() {
        return idConta;
    }

    public String getTitularConta() {
        return titularConta;
    }

    public double getSaldoConta() {
        return saldoConta;
    }

    public void verSaldo() {
        System.out.println("\n=== EXTRATO DA CONTA ===");
        System.out.println("Número da conta: " + idConta);
        System.out.println("Titular: " + titularConta);
        System.out.printf("Saldo atual: R$ %.2f\n", saldoConta);
        System.out.println("=======================\n");
    }

    public void saque(double valorSaque) {
        if (valorSaque <= 0) {
            System.out.println("ERRO: Valor do saque deve ser positivo.");
            return;
        }
        
        if (saldoConta >= valorSaque) {
            saldoConta -= valorSaque;
            System.out.printf("Saque de R$ %.2f realizado com sucesso!\n", valorSaque);
            System.out.printf("Saldo atual: R$ %.2f\n", saldoConta);
        } else {
            System.out.println("ERRO: Saldo insuficiente para realizar o saque.");
            System.out.printf("Saldo disponível: R$ %.2f | Valor solicitado: R$ %.2f\n", 
                            saldoConta, valorSaque);
        }
    }

    public void deposito(double valorDeposito) {
        if (valorDeposito < DEPOSITO_MINIMO) {
            System.out.printf("ERRO: Valor mínimo para depósito é R$ %.2f.\n", DEPOSITO_MINIMO);
            return;
        }
        
        saldoConta += valorDeposito;
        System.out.printf("Depósito de R$ %.2f realizado com sucesso!\n", valorDeposito);
        System.out.printf("Saldo atual: R$ %.2f\n", saldoConta);
    }

    public void emprestimo() {
        System.out.print("\nInsira o valor desejado para empréstimo: R$ ");
        
        try {
            double valorEmprestimo = entrada.nextDouble();
            entrada.nextLine();
            
            if (valorEmprestimo <= 0) {
                System.out.println("ERRO: Valor do empréstimo deve ser positivo.");
                return;
            }
            
            if (saldoConta < SALDO_MINIMO_EMPRESTIMO) {
                System.out.printf("ERRO: Empréstimo não aprovado.\n" +
                                "Saldo mínimo necessário: R$ %.2f\n" +
                                "Seu saldo atual: R$ %.2f\n", 
                                SALDO_MINIMO_EMPRESTIMO, saldoConta);
            } else {
                saldoConta += valorEmprestimo;
                System.out.println("\nEmpréstimo aprovado e realizado com sucesso!");
                System.out.printf("Valor creditado: R$ %.2f\n", valorEmprestimo);
                System.out.printf("Saldo atual: R$ %.2f\n", saldoConta);
            }
        } catch (Exception e) {
            System.out.println("ERRO: Valor inválido para empréstimo.");
            entrada.nextLine();
        }
    }

    public void credito() {
        double limiteCartao = saldoConta * 2;
        
        if (saldoConta < SALDO_MINIMO_CREDITO) {
            System.out.printf("Cartão de crédito não aprovado.\n" +
                            "Saldo mínimo necessário: R$ %.2f\n" +
                            "Seu saldo atual: R$ %.2f\n", 
                            SALDO_MINIMO_CREDITO, saldoConta);
        } else {
            System.out.println("\n=== CARTÃO DE CRÉDITO APROVADO ===");
            System.out.printf("Limite disponível: R$ %.2f\n", limiteCartao);
            System.out.println("===============================\n");
        }
    }

    public void iniciar() {
        int opcao;
        
        System.out.println("\n=== BEM-VINDO AO PROA BANK ===\n");
        
        do {
            exibirMenu();
            
            try {
                opcao = entrada.nextInt();
                entrada.nextLine();
                escolherFuncao(opcao);
            } catch (Exception e) {
                System.out.println("ERRO: Digite apenas números válidos.");
                entrada.nextLine();
                opcao = 0;
            }
            
        } while (opcao != 6);
        
        System.out.println("\nObrigado por usar o Proa Bank. Até logo!");
        entrada.close();
    }

    private void exibirMenu() {
        System.out.println("\n=== MENU PRINCIPAL ===");
        System.out.println("1 - Ver saldo");
        System.out.println("2 - Sacar");
        System.out.println("3 - Depositar");
        System.out.println("4 - Empréstimo");
        System.out.println("5 - Cartão de crédito");
        System.out.println("6 - Finalizar");
        System.out.print("Escolha uma opção: ");
    }

    private void escolherFuncao(int opcao) {
        switch(opcao) {
            case 1:
                verSaldo();
                break;
                
            case 2:
                System.out.print("Digite o valor para saque: R$ ");
                try {
                    double saque = entrada.nextDouble();
                    entrada.nextLine();
                    saque(saque);
                } catch (Exception e) {
                    System.out.println("ERRO: Valor inválido para saque.");
                    entrada.nextLine();
                }
                break;
                
            case 3:
                System.out.print("Digite o valor para depósito: R$ ");
                try {
                    double deposito = entrada.nextDouble();
                    entrada.nextLine();
                    deposito(deposito);
                } catch (Exception e) {
                    System.out.println("ERRO: Valor inválido para depósito.");
                    entrada.nextLine();
                }
                break;
                
            case 4:
                emprestimo();
                break;
                
            case 5:
                credito();
                break;
                
            case 6:
                break;
                
            default:
                System.out.println("ERRO: Opção inválida. Digite um número entre 1 e 6.");
                break;
        }
    }
}