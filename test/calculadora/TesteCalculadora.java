package calculadora;

public class TesteCalculadora {

    private static int total = 0;
    private static int falhas = 0;

    public static void main(String[] args) {
        Calculadora calc = new Calculadora();

        testarOperacao(calc, "Soma",          2,  3, "+", 5);
        testarOperacao(calc, "Subtracao",    10,  4, "-", 6);
        testarOperacao(calc, "Multiplicacao", 3,  5, "*", 15);
        testarOperacao(calc, "Divisao",       8,  2, "/", 4);

        testarErro(calc, "Divisao por zero",  8, 0, "/");   // excecao
        testarErro(calc, "Operacao invalida", 5, 5, "x");   // excecao
        testarErro(calc, "Operador nulo",     5, 5, null);  // excecao

        System.out.println("Total: " + total + " | Passaram: " + (total - falhas) + " | Falharam: " + falhas);
    }

    private static void testarOperacao(Calculadora calc, String nome, int a, int b, String operador, int esperado) {
        cabecalho(nome, a, b, operador);
        int obtido = calc.calcular(a, b, operador);
        System.out.println("Esperado: " + esperado + " | Obtido: " + obtido);
        registrar(obtido == esperado);
    }

    private static void testarErro(Calculadora calc, String nome, int a, int b, String operador) {
        cabecalho(nome, a, b, operador);
        System.out.println("Esperado: IllegalArgumentException");
        try {
            int obtido = calc.calcular(a, b, operador);
            System.out.println("Obtido: " + obtido + " (nenhuma excecao)");
            registrar(false);
        } catch (IllegalArgumentException e) {
            System.out.println("Obtido: IllegalArgumentException -> " + e.getMessage());
            registrar(true);
        }
    }

    private static void cabecalho(String nome, int a, int b, String operador) {
        System.out.println("--- " + nome + " ---");
        System.out.println("Entradas: a=" + a + ", b=" + b + ", operador=" + (operador == null ? "null" : "\"" + operador + "\""));
    }

    private static void registrar(boolean passou) {
        total++;
        if (!passou) {
            falhas++;
        }
        System.out.println("Status: " + (passou ? "PASSOU" : "FALHOU"));
        System.out.println();
    }
}
