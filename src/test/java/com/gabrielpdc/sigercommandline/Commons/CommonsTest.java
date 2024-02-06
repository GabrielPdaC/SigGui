package com.gabrielpdc.sigercommandline.Commons;

import java.util.ArrayList;

import com.gabrielpdc.sigercommandline.models.Term;
import com.gabrielpdc.sigercommandline.models.TermType;

public class CommonsTest {

    public static ArrayList<String> toArrayListString(ArrayList<Term> commandLines) {
        ArrayList<String> commandLineString = new ArrayList<>();

        StringBuilder commandLineStrBuilder = new StringBuilder();
        for (Term term : commandLines) {

            if (term.getType() == TermType.COMMAND) {
                if (!commandLineStrBuilder.isEmpty()) {
                    commandLineString.add(commandLineStrBuilder.toString());
                    commandLineStrBuilder = new StringBuilder();
                }
            } else {
                commandLineStrBuilder.append(" ");
            }
            commandLineStrBuilder.append(term.getTerm());
        }
        commandLineString.add(commandLineStrBuilder.toString());
        return commandLineString;
    }

}
