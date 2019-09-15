package br.com.projuris;

import java.util.List;

public interface Calculo {

    /**
     * Calcula os custos por cargo.
     *
     * @param funcionarios Lista de funcionarios.
     * @return Lista de custos por cargo.
     */
    List<CustoCargo> custoPorCargo(List<Funcionario> funcionarios);

    /**
     * Calcula os custos por departamento.
     *
     * @param funcionarios Lista de funcionarios.
     * @return Lista de custos por funcionario.
     */
    List<CustoDepartamento> custoPorDepartamento(List<Funcionario> funcionarios);

}