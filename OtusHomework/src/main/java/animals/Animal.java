package animals;

import data.ColorsData;

public abstract class Animal {

    private String name="";
    private int age=0;
    private int weight=0;
    private ColorsData color;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public ColorsData getColor() {
        return color;
    }

    public void setColor(ColorsData color) {
        this.color = color;
    }

    public void say(){
        System.out.println("Я говорю");
    };
    public void go(){
        System.out.println("Я иду");
    };;
    public void drink(){
        System.out.println("Я пью");
    };
    public void eat(){
        System.out.println("Я ем");
    };

    @Override
    public String toString() {
        return "Привет! Меня зовут "+ name.substring(0,1).toUpperCase() + name.substring(1) +
                ", мне " + age + getAgeEnd() +
                ", я вешу - " + weight +
                "кг, мой цвет - " + color.getName().toLowerCase() +
                '.';
    }

    private String getAgeEnd(){
        int ostatok = age % 10;

        if (ostatok == 1 ){
            return " год";
        }

        if (ostatok >= 2 && ostatok <= 4 ){
            return " года";
        }

        if (age >= 11 && age <= 19 ){
            return " лет";
        }

        return " лет";
    }


}
