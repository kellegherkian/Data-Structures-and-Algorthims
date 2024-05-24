import algorthims.aStar;
import algorthims.binarySearch;
import algorthims.linearSearch;
import algorthims.quickSort;
import dataStructures.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        if (args.length > 0) {
            runDemoFromArgs(args[0]);
        } else {
            showMenu();
        }
    }

    private static void runDemoFromArgs(String arg) {
        switch (arg.toLowerCase()) {
            case "linkedlist":
                linkedList.demoLinkedList();
                break;
            case "graph":
                graph.demoGraph();
                break;
            case "binarytree":
                binaryTree.demo();
                break;
            case "stack":
                stack.demo();
                break;
            case "queue":
                queue.demo();
                break;
            case "astar":
                aStar.demo();
                break;
            case "binarysearch":
                binarySearch.demo();
                break;
            case "linearsearch":
                linearSearch.demo();
                break;
            case "quicksort":
                quickSort.demo();
                break;
            default:
                System.out.println("Invalid demo name provided. Showing menu instead.");
                showMenu();
        }
    }

    private static void showMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            printMenu();
            try {
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        linkedList.demoLinkedList();
                        break;
                    case 2:
                        graph.demoGraph();
                        break;
                    case 3:
                        binaryTree.demo();
                        break;
                    case 4:
                        stack.demo();
                        break;
                    case 5:
                        queue.demo();
                        break;
                    case 6:
                        aStar.demo();
                        break;
                    case 7:
                        binarySearch.demo();
                        break;
                    case 8:
                        linearSearch.demo();
                        break;
                    case 9:
                        quickSort.demo();
                        break;
                    case 0:
                        exit = true;
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Clear the invalid input
            }

            System.out.println();
        }

        scanner.close();
    }

    private static void printMenu() {
        System.out.println("Select the demo to run:");
        System.out.println("1. LinkedList Demo");
        System.out.println("2. Graph Demo");
        System.out.println("3. BinaryTree Demo");
        System.out.println("4. Stack Demo");
        System.out.println("5. Queue Demo");
        System.out.println("6. A* Search Demo");
        System.out.println("7. Binary Search Demo");
        System.out.println("8. Linear Search Demo");
        System.out.println("9. QuickSort Demo");
        System.out.println("0. Exit");
    }
}
