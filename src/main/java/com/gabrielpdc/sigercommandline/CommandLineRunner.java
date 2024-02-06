package com.gabrielpdc.sigercommandline;

import java.util.Scanner;

import com.gabrielpdc.sigercommandline.Execptions.SigerCommandLineException;
import com.gabrielpdc.sigercommandline.controllers.CommandLineController;
import com.gabrielpdc.sigercommandline.controllers.CommandLineController.Architecture;
import com.gabrielpdc.sigercommandline.decorators.Itc.OperatingSystem;

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

        if (answer.contains("D")) {
            sigerCommandLineController = new CommandLineController(Architecture.DESKTOP);

        } else {
            sigerCommandLineController = new CommandLineController(Architecture.THIN_CLIENT);

            if (answer.contains("M")) {
                sigerCommandLineController.setServerIsMultiTenant(true);
            }

            System.out.println("Qual sistema operacional utilizar no server?");
            System.out.println("[W] Windows");
            System.out.println("[L] Linux");
            answer = scanner.nextLine();

            if (answer.contains("W")) {
                sigerCommandLineController.setServerServerOperatingSystem(OperatingSystem.WINDOWS);
            } else {
                sigerCommandLineController.setServerServerOperatingSystem(OperatingSystem.LINUX);
            }
        }


        //     System.out.println("Como deseja executar o client?");
        //     System.out.println("[D] Desktop");
        //     System.out.println("[G] GoGlobal");
        // }
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
