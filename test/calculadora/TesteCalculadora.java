package calculadora;

/**
 * Testes unitários da classe {@link Calculadora}.
 * <p>
 * Cada teste mostra as entradas usadas, o resultado esperado e o resultado
 * obtido. No fim, é exibido um resumo com o total de testes aprovados.
 * </p>
 *
 * @author Mateus Coelho Cardoso
 * @version 2.0
 */
public class TesteCalculadora {

    /** Quantidade total de testes executados. */
    private static int total = 0;

    /** Quantidade de testes que falharam. */
    private static int falhas = 0;

    /** Cria a classe de teste. Os testes são executados pelo método {@link #main(String[])}. */
    public TesteCalculadora() {
        // Nada a configurar
    }

    /**
     * Executa todos os testes: soma, subtração, multiplicação, divisão,
     * divisão por zero, operador inválido e operador nulo.
     *
     * @param args argumentos de linha de comando (não utilizados)
     */
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

    /**
     * Testa uma operação que deve funcionar e compara com o valor esperado.
     *
     * @param calc     calculadora usada no teste
     * @param nome     nome do teste
     * @param a        primeiro número
     * @param b        segundo número
     * @param operador operação a ser testada
     * @param esperado resultado esperado
     */
    private static void testarOperacao(Calculadora calc, String nome, int a, int b, String operador, int esperado) {
        cabecalho(nome, a, b, operador);
        int obtido = calc.calcular(a, b, operador);
        System.out.println("Esperado: " + esperado + " | Obtido: " + obtido);
        registrar(obtido == esperado);
    }

    /**
     * Testa uma operação que deve lançar {@link IllegalArgumentException}.
     * O teste passa somente se a exceção for lançada.
     *
     * @param calc     calculadora usada no teste
     * @param nome     nome do teste
     * @param a        primeiro número
     * @param b        segundo número
     * @param operador operador que deve causar o erro
     */
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

    /**
     * Mostra o nome do teste e as entradas usadas.
     *
     * @param nome     nome do teste
     * @param a        primeiro número
     * @param b        segundo número
     * @param operador operador usado
     */
    private static void cabecalho(String nome, int a, int b, String operador) {
        System.out.println("--- " + nome + " ---");
        System.out.println("Entradas: a=" + a + ", b=" + b + ", operador=" + (operador == null ? "null" : "\"" + operador + "\""));
    }

    /**
     * Soma o teste ao total e mostra se ele passou ou falhou.
     *
     * @param passou {@code true} se o teste passou
     */
    private static void registrar(boolean passou) {
        total++;
        if (!passou) {
            falhas++;
        }
        System.out.println("Status: " + (passou ? "PASSOU" : "FALHOU"));
        System.out.println();
    }
}
