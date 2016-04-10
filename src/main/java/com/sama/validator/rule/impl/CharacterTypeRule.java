package com.sama.validator.rule.impl;

import com.sama.validator.rule.AbstractRule;
import com.sama.validator.rule.RuleResult;
import com.sama.validator.util.ValidatorUtils;

import java.util.HashSet;
import java.util.Set;

/**
 * Rule that validates string against the type of characters it has
 * If whitelist is not empty blacklist will be ignored
 * It cannot take both blacklist and whitelist with the assumption that there
 * is no intersection ie Characters that satisfy both conditions
 * Created by ksama on 4/9/16.
 */
public class CharacterTypeRule extends AbstractRule<String> {
    private static String BLACKLIST_DESCRIPTION= "Must not consist of %1 ";
    private static String WHITELIST_DESCRIPTION = "Must consist of %1 only";
    Set<CharacterType> list = null;
    Set<CharacterType> mandatory = null;
    boolean isWhitelist = true;

    public CharacterTypeRule(boolean isWhitelist,Set<CharacterType> list){
        this(isWhitelist, list, null);
    }

    public CharacterTypeRule(boolean isWhitelist, Set<CharacterType> list,
                             Set<CharacterType> mandatory) {
        this.isWhitelist  = isWhitelist;
        this.list = list;
        this.mandatory = mandatory;
        StringBuffer descBuff = new StringBuffer();

        if(isWhitelist){
            descBuff.append(WHITELIST_DESCRIPTION.replaceAll("%1",
                    ValidatorUtils.getStringFromSet(list)));
        } else{
            descBuff.append(BLACKLIST_DESCRIPTION.replaceAll("%1",
                    ValidatorUtils.getStringFromSet(list)));
            mandatory.removeAll(list);
        }

        if(mandatory != null && mandatory.size()>1){
          descBuff.append(", with at least one of each of ");
          descBuff.append(ValidatorUtils.getStringFromSet(mandatory));
        }
        setDescription(descBuff.toString());
    }

    public enum  CharacterType{
      LOWER("Lowercase Characters"),
      UPPER("Uppercase Characters"),
      NUMERIC("Numeric Digits"),
      OTHER("other");
        String desc;
        CharacterType(String s) {
          desc = s;
        }

        public String getDescription() {
            return desc;
        }
    }

    public RuleResult applyRule(String input) {
      boolean result = true;
      Set<CharacterType> local = new HashSet<CharacterType>();;
        if(mandatory != null){
            local.addAll(mandatory);
        }
      for(int i=0;i<input.length();i++){
        CharacterType type = CharacterType.OTHER;
          if(Character.isLowerCase(input.charAt(i))){
              type = CharacterType.LOWER;
          } else if(Character.isUpperCase(input.charAt(i))){
              type = CharacterType.UPPER;
          } else if(Character.isDigit(input.charAt(i))) {
              type = CharacterType.NUMERIC;
          }

          if(isWhitelist == list.contains(type)){
              local.remove(type);
          } else{
              result = false;
              break;
          }
      }
        result = result && local.size()==0;
        return new RuleResult(result, getDescription());
    }
}
