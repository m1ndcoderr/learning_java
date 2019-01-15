package ru.evgenyhodz;

import java.lang.instrument.Instrumentation;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 06.03.2017
 */
public class User {
    /**
     * Name.
     */
    private String name;
    /**
     * Age.
     */
    private int age;

    public User() {
    }

    /**
     * Constructor.
     *
     * @param name name
     * @param age  age
     */
    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * Finalize.
     *
     * @throws Throwable throwable
     */
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("Finalized.");
    }

    /**
     * Shows statistics.
     */
    public static void showInfo() {
        Runtime runtime = Runtime.getRuntime();
        System.out.println("##### Heap utilization statistics [bytes] #####");
        System.out.println("Used memory: " + (runtime.totalMemory() - runtime.freeMemory()) + " bytes");
        System.out.println("Free memory: " + runtime.freeMemory() + " bytes");
        System.out.println("Total memory: " + (runtime.totalMemory()) + " bytes");
        System.out.println("Max memory: " + (runtime.maxMemory()) + " bytes");
    }

//    KEYS:
//    -XX:+UseSerialGC - 57804
//    -XX:+UseParallelOldGC - 42923
//    -XX:+UseParNewGC - 57855 + message below:
//      Java HotSpot(TM) 64-Bit Server VM warning: Using the ParNew young collector
//      with the Serial old collector is deprecated and will likely be removed in a future release
//    -XX:+UseConcMarkSweepGC - 59394

    /**
     * Main method.
     *
     * @param args args
     */
    public static void main(String[] args) {
      //test();
        create();
    }

    private static void test() {
        Runtime runtime = Runtime.getRuntime();
        int num = 0;
        System.out.println("Start...");
        for (int i = 0; i < 100000; i++) {
            try {
                num++;
                new User();
            } catch (OutOfMemoryError e) {
                System.out.println("Size of object = " + (runtime.totalMemory()/num) + " bytes");
                break;

            }
        }
        System.out.println("Objects created before error: " + num);
        showInfo();
        System.out.println("Finish.");
    }

    private static void create(){
        int mb = 1024*1024;
        Runtime runtime = Runtime.getRuntime();
        for(int i = 0; i < 1; i++){
            new User();
        }
        float usedMemory = (runtime.totalMemory() - runtime.freeMemory());
        float objectSize = usedMemory/mb;
        float total = runtime.totalMemory()/mb;
        System.out.println(objectSize);
        System.out.println(total);

    }
}