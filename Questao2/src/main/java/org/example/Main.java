package org.example;

public class Main {
    public static void main(String[] args) {

        ItemIndividual refrigerante = new ItemIndividual("Refrigerante", 5.00);
        ItemIndividual hamburguer = new ItemIndividual("Hambúrguer", 25.00);
        ItemIndividual batataFrita = new ItemIndividual("Batata Frita", 10.00);
        ItemIndividual pizza = new ItemIndividual("Pizza Grande", 60.00);
        ItemIndividual suco = new ItemIndividual("Suco de Laranja", 8.00);
        ItemIndividual brownie = new ItemIndividual("Brownie de Chocolate", 12.00);


        Combo comboFamilia = new Combo("Combo Família", 0.15); // 15% de desconto
        comboFamilia.adicionar(pizza);
        comboFamilia.adicionar(refrigerante);


        Combo comboRefeicao = new Combo("Combo Refeição", 0.10); // 10% de desconto
        comboRefeicao.adicionar(hamburguer);
        comboRefeicao.adicionar(batataFrita);
        comboRefeicao.adicionar(refrigerante);


        Combo comboSobremesa = new Combo("Combo Sobremesa", 0.05); // 5% de desconto
        comboSobremesa.adicionar(suco);
        comboSobremesa.adicionar(brownie);


        Combo superCombo = new Combo("Super Combo", 0.20); // 20% de desconto
        superCombo.adicionar(comboRefeicao);
        superCombo.adicionar(comboSobremesa);

        System.out.println("--- Cardápio do Restaurante ---");
        comboFamilia.exibir(0);
        System.out.println("-----------------------------");
        comboRefeicao.exibir(0);
        System.out.println("-----------------------------");
        superCombo.exibir(0);
    }
}