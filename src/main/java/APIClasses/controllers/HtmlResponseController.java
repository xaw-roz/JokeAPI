package APIClasses.controllers;

import APIClasses.models.Joke;
import APIClasses.services.FetchJokeService;
import okhttp3.Response;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by rocks on 6/8/2017.
 */
@Controller
public class HtmlResponseController {
    @Autowired
    FetchJokeService fetchJokeService;
    Response response=null;//object that stores response object returned from fetchJokeService.getJoke() method
    JSONObject jsonObject=null;//object to store the json object created from the response

    /* method respondHtml
     * params (model)
     * purpose collect JSON Response with the help of FetchJokeService and render the joke content using showjoke.html
     * Called when the request url is /tell-me-a-joke.html and request method is GET
    */
    @RequestMapping(value = "/tell-me-a-joke.html",method = RequestMethod.GET)
    public String respondHtml(Model model)
    {
        try {
            response = fetchJokeService.getJoke();
            if (response.message().equalsIgnoreCase("OK")) {
                String responseStr = response.body().string();
                responseStr = responseStr.replaceAll("\"", "'");
                responseStr = responseStr.replaceAll("\n", "");
                jsonObject = new JSONObject(responseStr);
                Joke joke = new Joke(jsonObject.getString("url"), jsonObject.getString("value"));
                model.addAttribute("joke",joke.getContent());
                return "showjoke";
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }


    }
}
