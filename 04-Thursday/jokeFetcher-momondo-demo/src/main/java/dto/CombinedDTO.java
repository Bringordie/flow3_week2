/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author Frederik
 */
public class CombinedDTO {
    private String chuckJoke;
    private String chuckJokeURL;
    private String dadJoke;
    private String dadJokeURL;

    public CombinedDTO(ChuckDTO chuck, DadJokeDTO dad) {
        this.chuckJoke = chuck.getValue();
        //this.chuckJokeURL = chuck.getUrl();
        this.chuckJokeURL = "https://api.chucknorris.io/jokes";
        this.dadJoke = dad.getJoke();
        //this.dadJokeURL = dad.getUrl();
        this.dadJokeURL = "https://icanhazdadjoke.com";
    }
    
    
    
}
