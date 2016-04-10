package com.sama.validator.rule.impl;

import com.sama.validator.rule.RegexRule;

/**
 * Looks for any repeated sequence of characters
 * Created by ksama on 4/9/16.
 */
public class NoSequenceRepetitionRule extends RegexRule{
    private static String  DESCRIPTION = "It must not contain any sequence of " +
            "characters immediately followed by the same sequence.";

    private static String PATTERN = "(\\w{2,})\\1";
    public NoSequenceRepetitionRule(){
        super(PATTERN, false, DESCRIPTION);
    }
}
