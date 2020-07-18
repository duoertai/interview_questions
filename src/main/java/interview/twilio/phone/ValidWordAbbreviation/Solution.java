package interview.twilio.phone.ValidWordAbbreviation;

class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        if(abbr == null || abbr.length() == 0)
            return false;

        int p1 = 0;
        int p2 = 0;

        while(p1 < word.length() && p2 < abbr.length()) {
            if(abbr.charAt(p2) >= 'a' && abbr.charAt(p2) <= 'z') {
                if(word.charAt(p1) != abbr.charAt(p2)) {
                    return false;
                } else {
                    p1++;
                    p2++;
                }
            } else {
                int leap = 0;
                // handle the case like 'w01rd' which is not a valid case
                if(abbr.charAt(p2) == '0')
                    return false;

                while(p2 < abbr.length() && abbr.charAt(p2) >= '0' && abbr.charAt(p2) <= '9') {
                    leap = leap * 10 + ((int) (abbr.charAt(p2) - '0'));
                    p2++;
                }
                p1 += leap;
            }
        }

        return p1 == word.length() && p2 == abbr.length();
    }
}