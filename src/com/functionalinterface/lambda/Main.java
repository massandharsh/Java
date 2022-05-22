package com.functionalinterface.lambda;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    /**
     * few transactions made to the credit card
     * 100 INR Donation
     * 500 Shopping
     * 200 Groceries
     * 100 Movie
     * 1000 Donations
     * 300 groceries
     * 2000 Donations
     *
     * find all the transactions of type donations and return the list of transaction id's
     * decreasing order of value
     * */
    public static void main(String[] args) {
        List<Transaction> transactions = Arrays.asList(
                                    new Transaction(100,TransactionType.DONATIONS),
                                    new Transaction(500,TransactionType.SHOPPING),
                                    new Transaction(200,TransactionType.GROCERY),
                                    new Transaction(1000,TransactionType.DONATIONS),
                                    new Transaction(100,TransactionType.MOVIE),
                                    new Transaction(300,TransactionType.GROCERY),
                                    new Transaction(2000,TransactionType.DONATIONS)
                                    );
        /**
         * First way is using the conventional approach
         * transactions ---> filter(Predicate)-->Sorted(Comperator)-->Map(function)-->Collect(reduce)(Terminator)
         * */
        List<Transaction> donationTransactions = new ArrayList<>();
        for(Transaction t : transactions){
            if(t.transactionType.equals(TransactionType.DONATIONS))donationTransactions.add(t);
        }
        donationTransactions.sort((t1,t2)->(t2.value).compareTo(t1.value));
        List<Double> creditIds = donationTransactions.stream().map(Transaction::getId).sorted(Comparator.reverseOrder()).collect(Collectors.toList());

        List<Double> creditCardTransactionIds = transactions.stream()
                                                .filter((transaction -> transaction.transactionType.equals(TransactionType.DONATIONS)))
                                                .map(Transaction::getId)
                                                .sorted(Comparator.reverseOrder())
                                                .collect(Collectors.toList());
        System.out.println(creditIds);
        System.out.println(creditCardTransactionIds);
        System.out.println(creditCardTransactionIds.equals(creditIds));
        creditCardTransactionIds.forEach(System.out::println);
        Optional<Integer> sample = Optional.of(1);
        if(sample.isEmpty()) System.out.println("Empty");

    }
}
