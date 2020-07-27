package interview.pinterest.TextJustification;

import java.util.*;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(i < words.length) {
            if(sb.length() == 0) {
                if(words[i].length() <= maxWidth) {
                    sb.append(words[i]);
                    i++;
                } else {
                    return null;
                }
            } else {
                if(sb.length() + 1 + words[i].length() <= maxWidth) {
                    sb.append(" ").append(words[i]);
                    i++;
                } else {
                    res.add(sb.toString());
                    sb.setLength(0);
                }
            }
        }

        if(sb.length() > 0)
            res.add(sb.toString());

        for(int j = 0; j < res.size() - 1; j++){
            process(res, j, maxWidth);
        }

        String last = res.get(res.size() - 1);
        while(last.length() < maxWidth)
            last = last + " ";
        res.set(res.size() - 1, last);
        return res;
    }

    private void process(List<String> res, int index, int maxWidth) {
        String s = res.get(index);
        if(s.length() == maxWidth)
            return;

        int count = 0;
        for(int i = 0; i < s.length(); i++)
            if(s.charAt(i) == ' ')
                count++;

        if(count == 0) {
            while(s.length() < maxWidth)
                s = s + " ";
            res.set(index, s);
            return;
        }

        int space = maxWidth - (s.length() - count);
        int[] spaceNum = new int[count];

        int initial = space / count;
        for(int i = 0; i < count; i++) {
            spaceNum[i] = initial;
            space -= initial;
        }

        int i = 0;
        while(i < count && space > 0) {
            spaceNum[i]++;
            i++;
            space--;

            if(i == count)
                i = 0;
        }
        String[] words = s.split("\\s+");
        StringBuilder sb = new StringBuilder();
        int w = 0;
        int p = 0;
        while(w < words.length && p < spaceNum.length) {
            sb.append(words[w++]);
            for(int k = 0; k < spaceNum[p]; k++)
                sb.append(" ");
            p++;
        }
        sb.append(words[w]);

        res.set(index, sb.toString());
    }
}