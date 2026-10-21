package calculadora;

public class TesteCalculadora {

    private static int total = 0;
    private static int falhas = 0;

    public static void main(String[] args) {
        Calculadora calc = new Calculadora();

        // Testes: entradas, resultado esperado e resultado obtido
        testar(calc, "Soma",                 2,  3, "+", 5);
        testar(calc, "Subtracao",           10,  4, "-", 6);
        testar(calc, "Multiplicacao",        3,  5, "*", 15);
        testar(calc, "Divisao",              8,  2, "/", 4);
        testar(calc, "Divisao por zero",     8,  0, "/", 0);   // divisao por zero
        testar(calc, "Operacao invalida",    5,  5, "x", 0);   // operacao invalida

        System.out.println();
        System.out.println("Total: " + total + " | Passaram: " + (total - falhas) + " | Falharam: " + falhas);
    }

    private static void testar(Calculadora calc, String nome, int a, int b, String op, int esperado) {
        System.out.println("--- " + nome + " ---");
        System.out.println("Entradas: a=" + a + ", b=" + b + ", op=\"" + op + "\"");
        int obtido = calc.calc(a, b, op);
        System.out.println("Esperado: " + esperado + " | Obtido: " + obtido);
        total++;
        if (obtido == esperado) {
            System.out.println("Status: PASSOU");
        } else {
            System.out.println("Status: FALHOU");
            falhas++;
        }
        System.out.println();
    }
}
