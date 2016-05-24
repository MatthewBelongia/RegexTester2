package io.MMJ;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.nio.file.Files.readAllBytes;
import static java.nio.file.Paths.get;

public class Main {

    public static String readRawDataToString() throws Exception{
        Path path = Paths.get(ClassLoader.getSystemResource("RawData.txt").toURI());
        return new String(readAllBytes(get(path.toUri())));
    }

    public static String regexTest(String input){
        input = input.replace("##","\n");
        StringBuilder buffer = new StringBuilder(input);
        //Pattern p = Pattern.compile("([A-Z])");
        Pattern p = Pattern.compile("name|price|type|expiration", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(buffer);
        while(m.find()){
            buffer.replace(m.start(),m.end(),m.group().toLowerCase());
        }
        input = buffer.toString();
        return input;
    }

    public static String correctSpelling(String input){
        input = input.replace("Co0kieS","cookies");
        return input;
    }

    public static String correctMilk(String input){
        input = input.replace("[milkMILK]{4}","Milk");
        StringBuilder buffer = new StringBuilder(input);
        //Pattern p = Pattern.compile("([A-Z])");
        Pattern p = Pattern.compile("milk", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(buffer);
        while(m.find()){
            buffer.replace(m.start(),m.end(),"Milk");
        }
        input = buffer.toString();
        return input;
    }
    public static String correctBread(String input){
        input = input.replace("[breadBREAD]{5}","Bread");
        StringBuilder buffer = new StringBuilder(input);
        //Pattern p = Pattern.compile("([A-Z])");
        Pattern p = Pattern.compile("bread", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(buffer);
        while(m.find()){
            buffer.replace(m.start(),m.end(),"Bread");
        }
        input = buffer.toString();
        return input;
    }
    public static String correctCookies(String input){
        input = input.replace("[cookiesCOOKIES]{7}","Cookies");
        StringBuilder buffer = new StringBuilder(input);
        //Pattern p = Pattern.compile("([A-Z])");
        Pattern p = Pattern.compile("cookies", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(buffer);
        while(m.find()){
            buffer.replace(m.start(),m.end(),"Cookies");
        }
        input = buffer.toString();
        return input;
    }
    public static String correctApples(String input){
        input = input.replace("[applesAPPLES]{6}","Apples");
        StringBuilder buffer = new StringBuilder(input);
        //Pattern p = Pattern.compile("([A-Z])");
        Pattern p = Pattern.compile("apples", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(buffer);
        while(m.find()){
            buffer.replace(m.start(),m.end(),"Apples");
        }
        input = buffer.toString();
        return input;
    }

    public static String correctFood(String input){
        input = input.replace("[foodFOOD.]{5}","Food:");
        StringBuilder buffer = new StringBuilder(input);
        //Pattern p = Pattern.compile("([A-Z])");
        Pattern p = Pattern.compile("food.", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(buffer);
        while(m.find()){
            buffer.replace(m.start(),m.end(),"Food;");
        }
        input = buffer.toString();
        return input;
    }

    public static ArrayList<Item> deserializeItem(String serialMessage){
        ArrayList<Item> listOfItems = new ArrayList<>();
        Item newItem = new Item();
        String[] splitMessage = serialMessage.split(";|:|\\n");
        for(int i =0;i<splitMessage.length;i++){
            switch(i%8){
                case 0:
                    break;
                case 1: newItem.setName(splitMessage[i]);
                    break;
                case 2:
                    break;
                case 3: newItem.setPrice(splitMessage[i]);
                    break;
                case 4:
                    break;
                case 5: newItem.setType(splitMessage[i]);
                    break;
                case 6:
                    break;
                case 7: newItem.setExpiration(splitMessage[i]);
                    listOfItems.add(newItem);
                    newItem = new Item();
                    break;
                default:
                    System.out.println("mayday mayday");
            }
        }return listOfItems;
    }

    public static void main(String[] args) throws Exception{
        String currenttext= "";
        currenttext = readRawDataToString();
        System.out.println(currenttext);
        currenttext=regexTest(currenttext);
        currenttext=correctSpelling(currenttext);
        currenttext=correctMilk(currenttext);
        currenttext=correctBread(currenttext);
        currenttext=correctCookies(currenttext);
        currenttext=correctApples(currenttext);
        currenttext=correctFood(currenttext);
        System.out.println(currenttext);
        ArrayList<Item> allItems = deserializeItem(currenttext);
        for(Item item : allItems){
            System.out.println("name: "+item.getName());
            System.out.println("price: "+item.getPrice());
            System.out.println("type: "+item.getType());
            System.out.println("expiration: "+item.getExpiration());
        }





    }
}
