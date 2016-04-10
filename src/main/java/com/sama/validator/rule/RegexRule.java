package com.sama.validator.rule;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ksama on 4/9/16.
 */
public class RegexRule extends AbstractRule<String>{
    private Pattern pattern;
    private boolean shouldMatch;

    public RegexRule(String pattern, boolean shouldMatch, String description){
      super(description);
      this.pattern = Pattern.compile(pattern);
      this.shouldMatch = shouldMatch;
    }

    public RuleResult applyRule(String input) {
        Matcher matcher = pattern.matcher(input);
        boolean matchResult =  matcher.find();
        return  new RuleResult(shouldMatch == matchResult,getDescription());
    }
}
