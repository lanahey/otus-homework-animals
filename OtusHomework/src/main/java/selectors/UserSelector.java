package selectors;

import data.AnimalInputData;
import data.ColorsData;
import data.CommandsData;

import java.util.Scanner;

public abstract class UserSelector {

    public static CommandsData selectCommand(Scanner scanner){
        CommandsData[] commandsData = CommandsData.values();
        CommandsData userCommandData;
        while (true) {
            String commandStr = scanner.next().trim().toUpperCase();

            boolean isExist = false;
            for(CommandsData command: commandsData){
                if(command.name().equals(commandStr)){
                    isExist = true;
                    break;
                }
            }
            if (!isExist){
                System.out.println("Вы ввели неверную команду, попробуйте еще раз.");
                continue;
            }
            userCommandData = CommandsData.valueOf(commandStr);
            break;
        }
        return userCommandData;
    }

    public static AnimalInputData selectAnimal(Scanner scanner){
        AnimalInputData[] animalInputData = AnimalInputData.values();
        AnimalInputData userAnimalData;
        String[] animalList = new String[animalInputData.length];
        for (int i = 0; i < animalInputData.length; i++) {
            animalList[i] = animalInputData[i].name().toLowerCase();
        }
        while (true) {
            System.out.printf("Введите животное из списка: %s\n", String.join("/", animalList));
            String animalStr = scanner.next().trim().toUpperCase();

            boolean isExist = false;
            for(AnimalInputData animal: animalInputData){
                if(animal.name().equals(animalStr)){
                    isExist = true;
                    break;
                }
            }
            if (!isExist){
                if (animalStr.equalsIgnoreCase("EXIT")) {
                    System.out.println("До новых встреч!");
                    System.exit(0);
                } else {
                    System.out.println("Вы ввели неверное животное, попробуйте еще раз.");
                    System.out.println("Для выхода из системы введите exit.");
                    continue;
                }
            }
            userAnimalData = AnimalInputData.valueOf(animalStr);
            break;
        }
        return userAnimalData;
    }

    public static ColorsData selectAnimalColor(Scanner scanner){
        ColorsData[] colorsData = ColorsData.values();
        ColorsData userColorData;
        String[] colorsStr = new String[colorsData.length];
        for (int i = 0; i < colorsData.length; i++) {
            colorsStr[i] = colorsData[i].name().toLowerCase();
        }
        while (true) {
            System.out.printf("Введите цвет животного из списка: %s\n", String.join("/", colorsStr));
            String colorInputStr = scanner.next().trim().toUpperCase();

            boolean isColorExist = false;
            for (ColorsData colorInput : colorsData) {
                if (colorInput.name().equals(colorInputStr)) {
                    isColorExist = true;
                    break;
                }
            }
            if (!isColorExist) {
                if (colorInputStr.equalsIgnoreCase("EXIT")) {
                    System.out.println("До новых встреч!");
                    System.exit(0);
                } else {
                    System.out.println("Цвет должен быть из списка, попробуйте еще раз.");
                    System.out.println("Для выхода из системы введите exit.");
                }
                continue;
            }
            userColorData = ColorsData.valueOf(colorInputStr);
            break;
        }
        return userColorData;
    }
}
