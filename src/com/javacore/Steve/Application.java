package com.javacore.Steve;

import com.javacore.Steve.common.ConsoleCanvas;
import com.javacore.Steve.db.DataBase;
import com.javacore.Steve.db.Record;
import com.javacore.Steve.db.Table;
import com.javacore.Steve.profile.ProfileController;
import com.javacore.Steve.stage.ApplicationState;
import com.javacore.Steve.stage.StateIdle;
import sun.tools.jconsole.Tab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Project for JavaCore course.
 * @author Alexander Isaev
 * @version 0.0.2
 */
public class Application {

    static public final String APP_NAME = "Steve";
    static public final String AUTHOR = "Alexander Isaev";
    static public final String VERSION = "0.0.2";

    static public final String ANSI_YELLOW = "\u001B[33m";
    static public final String ANSI_RESET = "\u001B[0m";
    static public final String ANSI_BLUE = "\u001B[34m";

    static ApplicationState currentState;

    public static void main(String[] args) {

        // We can't not to write try-catch with Throws exception.
        List<String> records = DataBase.readDataFile("C/...");

        

        Table table = new Table("Criminals", Arrays.asList(new String[]{"id", "name", "deceased"}));
        Record record = new Record(table);
        record.setValues(new String[]{"100", "Anthony Soprano", "false"});
        try {
            System.out.println(record.getInt("id"));
            System.out.println(record.getBoolean("deceased"));
        } catch (Record.FieldNotFoundExeption ex) {
            ex.printStackTrace();
        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
        }
        System.out.println("All is ok, all exceptions have been caught!");

//        DataBase db = new DataBase();
//        Thread thread = new Thread() {
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(1000);
//                    db.select();
//                } catch (InterruptedException e) {
//
//                }
//            }
//        };
//
//        // While update hasn't done, select won't execute.
//
//       Runnable runnable1 = new Runnable() {
//            @Override
//            public void run() {
//               db.update();
//            }
//        };
//
//       thread.start();
//       (new Thread(runnable1)).start();


//        List<String> columns = new ArrayList<>();
//        columns.add("id");
//        columns.add("firstName");
//        columns.add("lastName");
//        Table criminalTable = new Table("Criminals", columns);
//        List<String> values = new ArrayList<>();
//        List<String> values2 = new ArrayList<>();
//        values.add("1");
//        values.add("Vladimir");
//        values.add("Trampo");
//        values2.add("2");
//        values2.add("Donald");
//        values2.add("Timosh");
//        criminalTable.insert(new Record(values));
//        criminalTable.insert(new Record(values2));
//
//        List<String> result = criminalTable.selectField("firstName");
//        for (String s: result) {
//            System.out.println(s);
//        }


        // Two options for creating threads.

        // Runnable is an interface.
//        Runnable runnable1 = new Runnable() {
////            @Override
////            public void run() {
////                for (int i = 0; i < 100; i++) {
////                    System.out.printf("-");
////                    try {
////                        Thread.sleep(100);
////                    } catch (InterruptedException e) {
////
////                    }
////                }
////            }
////        };

//       Thread thread1 = new Thread() {
//           @Override
//           public void run() {
//               for (int i = 0; i < 100; i++) {
//                   System.out.print(".");
//                   try {
//                       Thread.sleep(500);
//                   } catch (InterruptedException e) {
//
//                   }
//               }
//                System.out.println("done!");
//            }
//        };

//        // Running two threads at the same time.
//        System.out.printf(thread.getState() + ""); // Prints thread state.
//        (new Thread(runnable1)).start();
//        thread.start();
//        System.out.printf(thread.getState() + "");

//        System.out.print("\nLoading");
//        thread.start();

//        ConsoleCanvas consoleCanvas = new ConsoleCanvas(100,100);
//        consoleCanvas.setSymbolAt(0,2,'A');
//        consoleCanvas.draw();
//        consoleCanvas.drawSquareAt(3,4, 4);

        ///////////////////////////////////////////////////////////// OLD

       /* Scanner in = new Scanner(System.in);
        String commandName;
        changeState(new StateIdle(), "Idle");

        do {
            System.out.print(ANSI_BLUE + "Me: ");
            commandName = in.nextLine();
            System.out.print(ANSI_RESET);

            currentState.onCommand(commandName);
        } while (!commandName.equals("exit"));
        // TODO: Exit command.

        // TODO: It should be a new command, this part shouldn't be here.
        System.out.println();
        ProfileController profileController = new ProfileController();
        profileController.showProfile(7);*/
    }

    public static void changeState(ApplicationState newState, String commandName) {
        if (currentState != null)
            currentState.exit();

        currentState = newState;
        currentState.enter(commandName);
    }
}
