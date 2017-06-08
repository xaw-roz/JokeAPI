package APIClasses.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by rocks on 6/7/2017.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Joke {
    @XmlElement
    String url;
    @XmlElement
    String content;
    /*No parameter constructor*/
    public Joke() {}

    /*Parameterized constructor*/
    public Joke(String url, String content) {
        this.url = url;
        this.content = content;
    }

    /*Getters and Setters*/

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


}
