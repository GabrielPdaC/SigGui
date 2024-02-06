package com.gabrielpdc.sigercommandline.exceptions;

/**
 * Exceção personalizada que representa erros ocorridos durante a geração
 * de linhas de comando no sistema SIGER Command Line.
 * <p>
 * Esta classe de exceção é usada para encapsular erros específicos que
 * surgem enquanto linhas de comando são construídas ou processadas,
 * permitindo que chamadores dessas operações tratem tais erros de maneira
 * mais específica e informativa.
 * </p>
 */
public class SigerCommandLineException extends Exception {

    /**
     * Constrói uma nova exceção com a mensagem de erro especificada.
     *
     * @param message A mensagem detalhando a razão da exceção. Esta mensagem
     *                é recuperável posteriormente através do método {@link #getMessage()}.
     */
    public SigerCommandLineException(String message) {
        super(message);
    }

}
