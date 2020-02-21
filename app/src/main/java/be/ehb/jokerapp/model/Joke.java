package be.ehb.jokerapp.model;

import java.io.Serializable;

/**
 * Created by Banaan on 20/01/2038. ;)
 */
public class Joke implements Serializable {

    private String setup, punchline;

    public Joke(String setup, String punchline) {
        this.setup = setup;
        this.punchline = punchline;
    }

    public String getSetup() {
        return setup;
    }

    public void setSetup(String setup) {
        this.setup = setup;
    }

    public String getPunchline() {
        return punchline;
    }

    public void setPunchline(String punchline) {
        this.punchline = punchline;
    }
}
