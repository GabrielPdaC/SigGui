package com.gabrielpdc.sigercommandline.Interfaces;

/**
 * Interface para o padrão de construção de objetos que implementam
 * {@code SigerCommandLines}. Este padrão Builder é usado para facilitar a criação
 * de objetos complexos de linha de comando, permitindo a configuração granular
 * de suas propriedades antes da construção final do objeto.
 * <p>
 * Classes que implementam esta interface fornecem métodos para definir várias
 * configurações e parâmetros da linha de comando. O método {@code build} finaliza
 * a construção e retorna uma instância configurada de {@code SigerCommandLines}.
 * </p>
 */
public interface CommandLineBuilder {

    /**
     * Constrói e retorna uma instância configurada de {@code SigerCommandLines}.
     *
     * Este método finaliza o processo de construção, aplicando todas as configurações
     * definidas previamente através dos métodos do builder, e retorna o objeto
     * {@code SigerCommandLines} pronto para uso.
     *
     * @return Uma instância configurada de {@code SigerCommandLines}.
     */
    public SigerCommandLines build();

}
