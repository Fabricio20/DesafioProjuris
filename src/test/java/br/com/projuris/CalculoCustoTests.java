package br.com.projuris;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class CalculoCustoTests {

    @Test
    public void custoPorCargoShouldReturnCorrectCosts() {
        Map<String, BigDecimal> custosPorCargo = new HashMap<>();
        custosPorCargo.put("assistente", new BigDecimal(4101.8).setScale(3, RoundingMode.HALF_UP));
        custosPorCargo.put("gerente", new BigDecimal(24001.2).setScale(3, RoundingMode.HALF_UP));
        custosPorCargo.put("diretor", new BigDecimal(34000.45).setScale(3, RoundingMode.HALF_UP));
        custosPorCargo.put("estagiario", new BigDecimal(700.4).setScale(3, RoundingMode.HALF_UP));

        MyCalculo myCalculo = new MyCalculo();
        List<CustoCargo> cargos = myCalculo.custoPorCargo(getFuncionarios());
        for (CustoCargo custoCargo : cargos) {
            BigDecimal calculated = custoCargo.getCusto().setScale(3, RoundingMode.HALF_UP);
            BigDecimal expected = custosPorCargo.getOrDefault(custoCargo.getCargo(), BigDecimal.ZERO);
            assertEquals("Custo do Cargo " + custoCargo.getCargo() + " Invalido", calculated, expected);
        }
    }

    @Test
    public void custoPorDepartamentoShouldReturnCorrectCosts() {
        Map<String, BigDecimal> custosPorCargo = new HashMap<>();
        custosPorCargo.put("administrativo", new BigDecimal(18001.15).setScale(3, RoundingMode.HALF_UP));
        custosPorCargo.put("financeiro", new BigDecimal(19800.9).setScale(3, RoundingMode.HALF_UP));
        custosPorCargo.put("juridico", new BigDecimal(25001.8).setScale(3, RoundingMode.HALF_UP));

        MyCalculo myCalculo = new MyCalculo();
        List<CustoDepartamento> departamentos = myCalculo.custoPorDepartamento(getFuncionarios());
        for (CustoDepartamento custoDepartamento : departamentos) {
            BigDecimal calculated = custoDepartamento.getCusto().setScale(3, RoundingMode.HALF_UP);
            BigDecimal expected = custosPorCargo.getOrDefault(custoDepartamento.getDepartamento(), BigDecimal.ZERO);
            assertEquals("Custo do Departamento " + custoDepartamento.getDepartamento() + " Invalido", calculated, expected);
        }
    }

    private List<Funcionario> getFuncionarios() {
        List<Funcionario> listaFuncionario = new ArrayList<>();
        listaFuncionario.add(new Funcionario("Assistente", "Administrativo", new BigDecimal(1000.0)));
        listaFuncionario.add(new Funcionario("Gerente", "Administrativo", new BigDecimal(7000.70)));
        listaFuncionario.add(new Funcionario("Diretor", "Administrativo", new BigDecimal(10000.45)));
        listaFuncionario.add(new Funcionario("Assistente", "Financeiro", new BigDecimal(1300.9)));
        listaFuncionario.add(new Funcionario("Gerente", "Financeiro", new BigDecimal(7500)));
        listaFuncionario.add(new Funcionario("Diretor", "Financeiro", new BigDecimal(11000.0)));
        listaFuncionario.add(new Funcionario("Estagiario", "Juridico", new BigDecimal(700.4)));
        listaFuncionario.add(new Funcionario("Assistente", "Juridico", new BigDecimal(1800.90)));
        listaFuncionario.add(new Funcionario("Gerente", "Juridico", new BigDecimal(9500.50)));
        listaFuncionario.add(new Funcionario("Diretor", "Juridico", new BigDecimal(13000.0)));
        return listaFuncionario;
    }

}