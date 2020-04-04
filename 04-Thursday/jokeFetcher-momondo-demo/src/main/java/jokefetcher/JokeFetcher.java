package jokefetcher;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import utils.HttpUtils;


public class JokeFetcher {
    public static void main(String[] args) throws IOException {


        /*String chuck = HttpUtils.fetchData("https://api.chucknorris.io/jokes/random");
        String dad = HttpUtils.fetchData("https://icanhazdadjoke.com");
        
        System.out.println("JSON fetched from chucknorris:");
        System.out.println(chuck);
        System.out.println("JSON fetched from dadjokes:");
        System.out.println(dad);*/
        
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String chuck = HttpUtils.fetchData("https://api.chucknorris.io/jokes/random");
        JsonObject chuckObject = new JsonParser().parse(chuck).getAsJsonObject();
        String dad = HttpUtils.fetchData("https://icanhazdadjoke.com");
        JsonObject dadObject = new JsonParser().parse(dad).getAsJsonObject();
        String returnChuck = "joke1: " + chuckObject.get("value").getAsString() +" joke1Reference: " + chuckObject.get("url").getAsString();
        String returnDad = " joke2: " + dadObject.get("joke").getAsString() + " joke2Reference: https://icanhazdadjoke.com";
        System.out.println(gson.toJson(returnChuck+returnDad));
        
        
       
    }
}
