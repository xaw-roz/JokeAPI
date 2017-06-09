# JokeAPI

The APIClasses.StarterClass is the class whose main method gets executed when the system starts. 

The code block "SpringApplication.run(StarterClass.class,args);" Does the following task
1 Sets up default configuration
2 Starts spring application context
3 Perform classpath scan
4 Starts tomcat Server.

Joke class is declared having variables url and content.

FetchJokeService with method getJoke() is created which sends get request to "https://api.chucknorris.io/jokes/random" returns the response
to the method that calls the method.

RestAPIController and HtmlResponseController maps the request url to the respective method.

RestAPIController handles requests "/", "/tell-me-a-joke.json","/tell-me-a-joke.xml" using methods mainPage(), returnJson() and returnXml() respectively.

Method mainPage() retruns the html displaying the welcome message.

Method returnJson() uses FetchJokeService to get a joke response from "https://api.chucknorris.io/jokes/random". The response is then converted to the JSONObject. 
The an object of the Joke class is created by passing the url and content using the constructor. Then the object is returned.

Method returnXml() uses FetchJokeService to get a joke response from "https://api.chucknorris.io/jokes/random". The response is then converted to the JSONObject. 
The an object of the Joke class is created by passing the url and content using the constructor. The object is converted to XML using FasterXML library and then the 
object is returned.

HtmlResponseController handles request "/tell-me-a-joke.html" using method respondHtml(Model model) method.

Method respondHtml() uses FetchJokeService to get a joke response from "https://api.chucknorris.io/jokes/random". The response is then converted to the JSONObject. 

The an object of the Joke class is created by passing the url and content using the constructor. The values of content and url variable of object is passed to the
template using model object. The html template is stored at resources/templates/showjoke.html. Thymeleaf Java template engiene is used to access the values passed
to the template.

WebConfiguration class is added to add HTML5 support to thymeleaf.


