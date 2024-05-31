package org.example;

import org.example.classes.Trader;
import org.example.classes.Transaction;

import java.util.List;
import java.util.stream.Collectors;

public class TransWorker {

    // 1. Найти все транзакции за 2011 год и отсортировать их по сумме (от меньшей к большей)
    public List<Transaction> getByYear(List<Transaction> transactions, int year) {
        return transactions.stream().filter(t -> t.getYear() == year).sorted((t1, t2) -> Integer.compare(t1.getValue(), t2.getValue())).collect(Collectors.toList());
    }

    // 2. Вывести список неповторяющихся городов, в которых работают трейдеры.
    public List<String> getAllTowns(List<Transaction> transactions) {
        return transactions.stream().map(t -> t.getTrader().getCity()).distinct().collect(Collectors.toList());
    }

    // 3. Найти всех трейдеров из Кембриджа и отсортировать их по именам.
    public List<Trader> getAllTradersFromTown(List<Transaction> transactions, String city) {
        return transactions.stream().map(tr -> tr.getTrader()).distinct().filter(t -> t.getCity().equalsIgnoreCase(city)).sorted((t1, t2) -> t1.getName().compareTo(t2.getName())).collect(Collectors.toList());
    }

    // 4. Вернуть строку со всеми именами трейдеров, отсортированными в алфавитном порядке.
    public List<Trader> getAllTradersInAlphabeticOrder(List<Transaction> transactions) {
        return transactions.stream().map(tr -> tr.getTrader()).distinct().sorted((t1, t2) -> t1.getName().compareTo(t2.getName())).collect(Collectors.toList());
    }

    // 5. Выяснить, существует ли хоть один трейдер из Милана.
    public boolean hasTraderFromTown(List<Transaction> transactions, String city) {
        return transactions.stream().filter(tr -> tr.getTrader().getCity().equalsIgnoreCase(city)).findAny().isPresent();
    }

    // 6. Вывести суммы всех транзакций трейдеров из Кембриджа.
    public int getSumOfTransactions(List<Transaction> transactions) {
        return transactions.stream().map(t -> t.getValue()).reduce(0, (old, notOld) -> old + notOld);
    }

    // 7. Какова максимальная сумма среди всех транзакций?
    public int findMaxSum(List<Transaction> transactions) {
        return transactions.stream().map(t -> t.getValue()).max(Integer::compareTo).get();
    }

    // 8. Найти транзакцию с минимальной суммой.
    public int findMinSum(List<Transaction> transactions) {
        return transactions.stream().min((t1, t2) -> Integer.compare(t1.getValue(), t2.getValue())).get().getValue();
    }

}
