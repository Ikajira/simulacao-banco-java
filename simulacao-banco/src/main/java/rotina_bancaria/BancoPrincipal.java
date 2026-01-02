package rotina_bancaria;

public class BancoPrincipal {
    public static void main(String[] args) {
        ContaBancaria conta = new ContaBancaria("Kaique", 50000);
        conta.iniciar();
    }
}