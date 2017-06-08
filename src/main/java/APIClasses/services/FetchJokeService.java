package APIClasses.services;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Created by rocks on 6/7/2017.
 */
@Service
public class FetchJokeService {
    OkHttpClient okHttpClient=new OkHttpClient();
    Request request=new Request.Builder().url("https://api.chucknorris.io/jokes/random").build();
    Response response=null;
    public Response  getJoke()
    {
        try {
            response=okHttpClient.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }
}
