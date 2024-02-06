package com.gabrielpdc.sigercommandline.models;

/**
 * Define os tipos de termos utilizáveis em linhas de comando no sistema SIGER Command Line.
 *
 * Esta enumeração é utilizada para diferenciar os termos que compõem uma linha de comando,
 * permitindo uma distinção clara entre os comandos e seus parâmetros associados.
 */
public enum TermType {

    /**
     * Representa um comando a ser executado.
     *
     * Este tipo é usado para termos que especificam a ação principal a ser realizada
     * pela linha de comando.
     */
    COMMAND,

    /**
     * Representa um parâmetro que modifica ou especifica o comportamento de um comando.
     *
     * Este tipo é usado para termos que fornecem informações adicionais, configurações
     * ou modificam a maneira como um comando deve ser executado.
     */
    PARAM;
}
