package main;

import dao.InsuranceServiceImpl;
import entity.Policy;
import exception.PolicyNotFoundException;

import java.util.List;
import java.util.Scanner;

public class MainModule {
    public static void main(String[] args) {
        InsuranceServiceImpl service = new InsuranceServiceImpl();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n===== Insurance Policy Menu =====");
            System.out.println("1. View All Policies");
            System.out.println("2. View Policy by ID");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();

            try {
                switch (choice) {
                    case 1:
                        List<Policy> policies = service.getAllPolicies();
                        if (policies.isEmpty()) {
                            System.out.println("No policies found.");
                        } else {
                            for (Policy p : policies) {
                                System.out.println(p);
                            }
                        }
                        break;

                    case 2:
                        System.out.print("Enter Policy ID: ");
                        int id = scanner.nextInt();
                        Policy policy = service.getPolicy(id);
                        if (policy != null) {
                            System.out.println(policy);
                        } else {
                            throw new PolicyNotFoundException("Policy ID " + id + " not found.");
                        }
                        break;

                    case 3:
                        exit = true;
                        System.out.println("Exiting... Thank you!");
                        break;

                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            } catch (PolicyNotFoundException e) {
                System.out.println("🚫 " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Something went wrong: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
