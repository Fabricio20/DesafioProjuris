package br.com.projuris;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyCalculo implements Calculo {

    @Override
    public List<CustoCargo> custoPorCargo(List<Funcionario> funcionarios) {
        Map<String, BigDecimal> custoPorCargo = new HashMap<>();
        for (Funcionario funcionario : funcionarios) {
            BigDecimal salario = custoPorCargo
                    .getOrDefault(funcionario.getCargo().toLowerCase(), BigDecimal.ZERO);
            salario = salario.add(funcionario.getSalario());
            custoPorCargo.put(funcionario.getCargo().toLowerCase(), salario);
        }
        List<CustoCargo> custosCargo = new ArrayList<>();
        for (Map.Entry<String, BigDecimal> entry : custoPorCargo.entrySet()) {
            custosCargo.add(new CustoCargo(entry.getKey(), entry.getValue()));
        }
        return custosCargo;
    }

    @Override
    public List<CustoDepartamento> custoPorDepartamento(List<Funcionario> funcionarios) {
        Map<String, BigDecimal> custoPorDepartamento = new HashMap<>();
        for (Funcionario funcionario : funcionarios) {
            BigDecimal custo = custoPorDepartamento
                    .getOrDefault(funcionario.getDepartamento().toLowerCase(), BigDecimal.ZERO);
            custo = custo.add(funcionario.getSalario());
            custoPorDepartamento.put(funcionario.getDepartamento().toLowerCase(), custo);
        }
        List<CustoDepartamento> custosDepartamento = new ArrayList<>();
        for (Map.Entry<String, BigDecimal> entry : custoPorDepartamento.entrySet()) {
            custosDepartamento.add(new CustoDepartamento(entry.getKey(), entry.getValue()));
        }
        return custosDepartamento;
    }

}