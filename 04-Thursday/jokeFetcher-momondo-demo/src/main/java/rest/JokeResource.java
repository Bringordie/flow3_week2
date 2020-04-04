package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import dto.ChuckDTO;
import dto.CombinedDTO;
import dto.DadJokeDTO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import utils.HttpUtils;

/**
 * REST Web Service
 *
 * @author lam
 */
@Path("jokes")
public class JokeResource {

    @Context
    private UriInfo context;

   
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJokes() throws IOException {
        return makeResponse();
    }

    private String makeResponse() throws IOException {
        /* Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String chuck = HttpUtils.fetchData("https://api.chucknorris.io/jokes/random");
        JsonObject chuckObject = new JsonParser().parse(chuck).getAsJsonObject();
        String dad = HttpUtils.fetchData("https://icanhazdadjoke.com");
        JsonObject dadObject = new JsonParser().parse(dad).getAsJsonObject();
        String returnChuck = "joke1: " + chuckObject.get("value").getAsString() +" joke1Reference: " + chuckObject.get("url").getAsString();
        String returnDad = " joke2: " + dadObject.get("joke").getAsString() +" joke2Reference: https://icanhazdadjoke.com";
        return gson.toJson(returnChuck+returnDad); */
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String chuck = HttpUtils.fetchData("https://api.chucknorris.io/jokes/random");
        ChuckDTO chuckDTO = gson.fromJson(chuck, ChuckDTO.class);
        
        String dad = HttpUtils.fetchData("https://icanhazdadjoke.com");
        DadJokeDTO dadJokeDTO = gson.fromJson(dad, DadJokeDTO.class);
        
        CombinedDTO combinedDTO = new CombinedDTO(chuckDTO,dadJokeDTO);
        
        return gson.toJson(combinedDTO);
    }
   
}
