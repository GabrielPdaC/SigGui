package com.gabrielpdc.sigercommandline.models;

/**
 * Representa um componente individual de uma linha de comando, incluindo seu tipo,
 * o conteúdo do termo e uma descrição de ajuda opcional.
 *
 * Esta classe é usada para construir linhas de comando detalhadas, permitindo a
 * organização e especificação de cada parte da linha de comando para execução
 * de operações no sistema SIGER.
 */
public class Term {

    private TermType type; // O tipo do termo, definindo sua função na linha de comando.
    private String term;   // O conteúdo do termo, como um comando ou parâmetro.
    private String help;   // Descrição de ajuda opcional para o termo.

    /**
     * Constrói um novo termo com o tipo e conteúdo especificados.
     *
     * @param type O tipo do termo, indicando sua função na linha de comando.
     * @param term O conteúdo do termo, podendo ser um comando, parâmetro, etc.
     */
    public Term(TermType type, String term) {
        this.type = type;
        this.term = term;
    }

    /**
     * Retorna o tipo do termo.
     *
     * @return O {@link TermType} do termo, indicando sua função na linha de comando.
     */
    public TermType getType() {
        return type;
    }

    /**
     * Retorna o conteúdo do termo.
     *
     * @return O conteúdo do termo como uma {@link String}.
     */
    public String getTerm() {
        return term;
    }

    /**
     * Retorna a descrição de ajuda do termo.
     *
     * @return A descrição de ajuda para o termo, ou {@code null} se não estiver definida.
     */
    public String getHelp() {
        return help;
    }

    /**
     * Define a descrição de ajuda para o termo.
     *
     * @param help A descrição de ajuda para o termo.
     */
    public void setHelp(String help) {
        this.help = help;
    }

}
