package org.example;

import org.example.classes.*;

import java.util.Arrays;
import java.util.List;

public class PuttingIntoClasses {
    public static void main(String... args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        TransWorker tw = new TransWorker();
        System.out.println(tw.getByYear(transactions, 2011)); // [{Trader:Brian in Cambridge, year: 2011, value: 300}, {Trader:Raoul in Cambridge, year: 2011, value: 400}]
        System.out.println(tw.getAllTowns(transactions)); // [Cambridge, Milan]
        System.out.println(tw.getAllTradersFromTown(transactions, "cambridge")); // [Trader:Alan in Cambridge, Trader:Brian in Cambridge, Trader:Raoul in Cambridge]
        System.out.println(tw.getAllTradersInAlphabeticOrder(transactions)); // [Trader:Alan in Cambridge, Trader:Brian in Cambridge, Trader:Mario in Milan, Trader:Raoul in Cambridge]
        System.out.println(tw.hasTraderFromTown(transactions, "cambridge")); // true
        System.out.println(tw.getSumOfTransactions(transactions)); // 4060
        System.out.println(tw.findMaxSum(transactions)); // 1000
        System.out.println(tw.findMinSum(transactions)); // 300
    }
}
