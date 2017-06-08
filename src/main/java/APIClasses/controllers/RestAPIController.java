package APIClasses.controllers;

import APIClasses.models.Joke;
import APIClasses.services.FetchJokeService;
import okhttp3.Response;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by rocks on 6/7/2017.
 */
@RestController
public class RestAPIController {

    JSONObject jsonObject = null;//object to store the json object created from the response
    Response response = null;//object that stores response object returned from fetchJokeService.getJoke() method


    @Autowired
    public FetchJokeService fetchJokeService;

    /* method returnJson
    * params none
    * purpose collect JSON Response with the help of FetchJokeService,create Joke object using the JSON response and return the Joke Object in JSON format
    *Called when the request url is /tell-me-a-joke.json and request method is GET
    */
    @RequestMapping(value = "/tell-me-a-joke.json", method = RequestMethod.GET, produces = {"application/json"})
    public Joke returnJson() {

        try {
            response = fetchJokeService.getJoke();
            if (response.message().equalsIgnoreCase("OK")) {
                String responseStr = response.body().string();
                responseStr = responseStr.replaceAll("\"", "'");
                responseStr = responseStr.replaceAll("\n", "");
                jsonObject = new JSONObject(responseStr);
                Joke joke = new Joke(jsonObject.getString("url"), jsonObject.getString("value"));
                return joke;
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* method mainPage()
    * params none
    * purpose retruns welcome message
    *Called when the request url is /
    */
    @RequestMapping("/")
    public String mainPage() {
        fetchJokeService.getJoke();
        return "Hello Welcome to the jokes API<br>The jokes are fetched from chucknorris.io";
    }


    /* method returnXml
    * params none
    * purpose collect JSON Response with the help of FetchJokeService, create Joke object using the JSON response and return the Joke Object in XML format
    *Called when the request url is /tell-me-a-joke.xml and request method is GET
    */
    @RequestMapping(value = "/tell-me-a-joke.xml", method = RequestMethod.GET, produces = {"application/xml"})
    public Joke returnXml(){
        try {
            response = fetchJokeService.getJoke();
            if (response.message().equalsIgnoreCase("OK")) {
                String responseStr = response.body().string();
                responseStr = responseStr.replaceAll("\"", "'");
                responseStr = responseStr.replaceAll("\n", "");
                jsonObject = new JSONObject(responseStr);
                Joke joke = new Joke(jsonObject.getString("url"), jsonObject.getString("value"));
                return joke;
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }


}