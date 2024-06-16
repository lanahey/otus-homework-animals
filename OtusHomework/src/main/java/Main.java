import animals.Animal;
import data.AnimalInputData;
import data.ColorsData;
import data.CommandsData;
import factory.AnimalFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static selectors.UserSelector.*;

public class Main {
    public static void main(String... args){
        List<Animal> animals = new ArrayList();

        Scanner scanner = new Scanner(System.in);

        CommandsData[] commandsData = CommandsData.values();
        String[] commandsStr = new String[commandsData.length];
        for (int i = 0; i < commandsData.length; i++){
            commandsStr[i] = commandsData[i].name().toLowerCase();
        }

        while(true) {
            System.out.printf("Введите одну из команд: %s\n", String.join("/", commandsStr));
            CommandsData userCommandData = selectCommand(scanner);

            switch (userCommandData) {
                case ADD -> {
                    AnimalInputData userAnimalInputData = selectAnimal(scanner);

                    AnimalFactory animalFactory = new AnimalFactory();
                    Animal userAnimal = animalFactory.create(userAnimalInputData);

                    System.out.println("Введите имя животного");
                    String name = scanner.next();
                    userAnimal.setName(name);

                    while(true) {
                        try {
                            System.out.println("Введите возраст животного. Возраст это число больше нуля и меньше 50.");
                            int age = Integer.parseInt(scanner.next());
                            if (age <= 0) {
                                System.out.println("Вы ввели неверный возраст. Возраст должен быть больше нуля");
                            }
                            if (age > 49) {
                                System.out.println("Обратитесь в Книгу рекордов Гиннеса.");
                                System.out.println("Вот вам несколько интересных фактов:");
                                System.out.println("- самый старый кот, занесенный в Книгу рекордов Гиннеса, дожил до 38 лет.");
                                System.out.println("- самая старая собака, занесенная в Книгу рекордов Гиннеса, дожила до 31 года.");
                                System.out.println("- самая старая утка, занесенная в Книгу рекордов Гиннеса, дожила до 49 лет.");
                            }
                            if (age >= 1 && age < 50) {
                                userAnimal.setAge(age);
                                break;
                            }
                        } catch (Exception e){
                            System.out.println("Вы должны ввести целое число.");
                        }
                    }

                    while(true) {
                        try {
                            System.out.println("Введите вес животного. Вес это число больше нуля и меньше 59.");
                            int weight = Integer.parseInt(scanner.next());
                            if (weight <= 0) {
                                System.out.println("Вы ввели неверный возраст. Возраст должен быть больше нуля");
                            }
                            if (weight > 59) {
                                System.out.println("Обратитесь в Книгу рекордов Гиннеса.");
                                System.out.println("Вот вам несколько интересных фактов:");
                                System.out.println("- самая толстая кошка, занесенный в Книгу рекордов Гиннеса, весила 21 кг.");
                                System.out.println("- самая толстая собака, занесенная в Книгу рекордов Гиннеса, весила 58 кг.");
                                System.out.println("- самая толстая утка, занесенная в Книгу рекордов Гиннеса, весила 2 кг.");
                            }
                            if (weight >= 1 && weight < 60) {
                                userAnimal.setWeight(weight);
                                break;
                            }
                        } catch (Exception e){
                            System.out.println("Вы должны ввести целое число.");
                        }
                    }
                    userAnimal.setColor(ColorsData.valueOf(String.valueOf(selectAnimalColor(scanner))));
                    animals.add(userAnimal);
                    userAnimal.say();
                }
                case LIST -> {
                    System.out.println("Вы ввели List");
                    for(Animal animal: animals){
                        System.out.println(animal.toString());
                    }
                }
                case EXIT -> {
                    System.out.println("До новых встреч!");
                    System.exit(0);
                }
            }
        }
    }
}
