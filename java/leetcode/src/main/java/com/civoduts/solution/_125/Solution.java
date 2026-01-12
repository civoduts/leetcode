package com.civoduts.solution._125;

public class Solution {
  public boolean isPalindrome(String s) {
    int i = 0;
    int j = s.length() - 1;

    while (i < j) {
      while (i < j && !(Character.isAlphabetic(s.charAt(i)) || Character.isDigit(s.charAt(i))))
        i++;
      while (i < j && !(Character.isAlphabetic(s.charAt(j)) || Character.isDigit(s.charAt(j))))
        j--;

      if (
        i < j &&
        Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))
      )
        return false;
      i++;
      j--;
    }

    return true;
  }
}
