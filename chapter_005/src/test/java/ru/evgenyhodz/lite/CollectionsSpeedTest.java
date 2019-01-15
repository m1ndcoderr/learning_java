package ru.evgenyhodz.lite;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.TreeSet;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 15.03.2017
 */
public class CollectionsSpeedTest {

    private LinkedList<String> linkedList;
    private ArrayList<String> arrayList;
    private TreeSet<String> treeSet;
    private CollectionsSpeed test;

    @Before
    public void createCollections() {
        linkedList = new LinkedList<>();
        arrayList = new ArrayList<>();
        treeSet = new TreeSet<>();
        test = new CollectionsSpeed();
    }

    @Test
    public void testsOfSpeed() {
        // LinkedList :
        long listResult = test.add(linkedList, "String", 1000000);
        System.out.println("LinkedList add() result : " + listResult + " milliseconds");
        long removeList = test.delete(linkedList, "String", 500000);
        System.out.println("LinkedList deleting result : " + removeList + " milliseconds\n");

        // ArrayList :
        long arrayResult = test.add(arrayList, "String", 1000000);
        System.out.println("ArrayList add() result : " + arrayResult + " milliseconds");
        long removeArray = test.delete(arrayList, "String", 500000);
        System.out.println("ArrayList deleting result : " + removeArray + " milliseconds\n");

        // TreeSet :
        long treeResult = test.add(treeSet, "String", 1000000);
        System.out.println("TreeSet add() result : " + treeResult + " milliseconds");
        long removeTree = test.delete(treeSet, "String", 500000);
        System.out.println("TreeSet deleting result : " + removeTree + " milliseconds\n");
    }
}