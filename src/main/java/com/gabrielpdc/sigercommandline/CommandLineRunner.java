package com.gabrielpdc.sigercommandline;

import java.util.Scanner;

import com.gabrielpdc.sigercommandline.commands.Itc.OperatingSystem;
import com.gabrielpdc.sigercommandline.controllers.CommandLineController;
import com.gabrielpdc.sigercommandline.controllers.CommandLineController.Architecture;
import com.gabrielpdc.sigercommandline.exceptions.SigerCommandLineException;

public class CommandLineRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CommandLineController sigerCommandLineController;
        String answer;

        System.out.println("Como deseja executar o SIGER?");
        System.out.println("[D] Desktop");
        System.out.println("[T] Thin Client");
        System.out.println("[M] Multi Tenant");

        answer = scanner.nextLine();

        if (answer.toUpperCase().contains("D")) {
            sigerCommandLineController = new CommandLineController(Architecture.DESKTOP);

        } else {
            sigerCommandLineController = new CommandLineController(Architecture.THIN_CLIENT);

            if (answer.toUpperCase().contains("M")) {
                sigerCommandLineController.setServerIsMultiTenant(true);
            }

            System.out.println("Qual sistema operacional utilizar no server?");
            System.out.println("[W] Windows");
            System.out.println("[L] Linux");
            answer = scanner.nextLine();

            if (answer.toUpperCase().contains("W")) {
                sigerCommandLineController.setServerServerOperatingSystem(OperatingSystem.WINDOWS);
            } else {
                sigerCommandLineController.setServerServerOperatingSystem(OperatingSystem.LINUX);
            }
        }

        System.out.println("Deseja executar no modo debug? (S/_)");
        answer = scanner.nextLine();

        if (answer.toUpperCase().contains("S")) {
            sigerCommandLineController.setClientIsDebug(true);
            sigerCommandLineController.setServerIsDebug(true);
        }

        System.out.println("\nLinhas de comando para execução do SIGER: ");
        try {
            for (String command : sigerCommandLineController.generateCommandLine()) {
                System.out.println(command);
            }
        } catch (SigerCommandLineException e) {
            e.printStackTrace();
        }

        scanner.close();
    }

}
