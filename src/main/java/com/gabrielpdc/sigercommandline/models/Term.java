package com.gabrielpdc.sigercommandline.models;

public class Term {

    private TermType type;
    private String term;
    private String help;

    public Term(TermType type, String term) {
        this.type = type;
        this.term = term;
    }


    public TermType getType() {
        return type;
    }

    public String getTerm() {
        return term;
    }

    public String getHelp() {
        return help;
    }

    public void setHelp(String help) {
        this.help = help;
    }

}
