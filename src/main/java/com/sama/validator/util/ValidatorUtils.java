package com.sama.validator.util;

import com.sama.validator.rule.impl.CharacterTypeRule;

import java.util.Set;

/**
 * Created by ksama on 4/9/16.
 */
public class ValidatorUtils {

    public static String getStringFromSet(Set<CharacterTypeRule.CharacterType> list){
      StringBuffer buffer = new StringBuffer();
        boolean first = true;
      for(CharacterTypeRule.CharacterType type:list){
          if(first){
              first = false;
          } else{
              buffer.append(",");
          }
         buffer.append(type.getDescription());
      }
        return buffer.toString();
    }
}
