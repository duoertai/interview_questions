package interview.pinterest.onsite.S3Reader;

/*
 * Click `Run` to execute the snippet below!
 */

import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.

We have a library interfacing with S3 files, providing an S3Reader.next() function which returns the next 8 characters in the file.  Empty string is returned when it reaches the end.

For example, with below contents in file s3://test/file
'This is the first line.\nThis is the second line.'

s3_reader = S3Reader("s3://test/file")
s3_reader.next() -> 'This is '
s3_reader.next() -> 'the firs'
s3_reader.next() -> 't line.\n'
s3_reader.next() -> 'This is '
s3_reader.next() -> 'the seco'
s3_reader.next() -> 'nd line.'
s3_reader.next() -> ''

The files can be very large and therefore impractical to fully download before working with them.
Write a wrapper around S3Reader with function next_line() which produces the next line in a file.

s3_line_reader.next_line() -> 'This is the first line.'
s3_line_reader.next_line() -> 'This is the second line.'
s3_line_reader.next_line() -> ''

 */

class Solution {
    class S3Reader {
        private String[] lines;
        private int index;

        public S3Reader() {
            lines = new String[] {
                    "This is ",
                    "the firs",
                    "t \nline.",
                    "This is ",
                    "the seco",
                    "nd\nl\nne.",
                    ""
            };

            index = 0;
        }

        public String next() {
            int j = index;
            if(index + 1 < lines.length)
                index++;
            else
                return "";
            return lines[j];
        }
    }


    private StringBuilder curr;
    private StringBuilder prev;

    private S3Reader reader;

    public Solution() {
        this.curr = new StringBuilder();
        this.prev = new StringBuilder();
        this.reader = new S3Reader();
    }

    public String next_line() {

        if(prev.length() > 0) {
            boolean newline = false;
            int i = 0;
            for(; i < prev.length(); i++) {
                if(prev.charAt(i) != '\n') {
                    curr.append(prev.charAt(i));
                } else {
                    newline = true;
                    break;
                }
            }

            if(i + 1 <= prev.length())
                prev = new StringBuilder(prev.substring(i + 1));
            else
                prev = new StringBuilder();

            if(newline) {
                String res = curr.toString();
                curr.setLength(0);
                return res;
            }
        }

        boolean stop = false;

        while(!stop) {
            String temp = reader.next();

            // end of the file
            if(temp.length() == 0) {
                //stop = true;
                break;
            }

            int i = 0;

            for(; i < temp.length(); i++) {
                if(temp.charAt(i) != '\n') {
                    curr.append(temp.charAt(i));
                } else {
                    stop = true;
                    break;
                }
            }

            i++;

            if(stop) {
                for(; i < temp.length(); i++) {
                    prev.append(temp.charAt(i));
                }
            }

        }

        String res = curr.toString();
        curr.setLength(0);

        return res;
    }



    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = 0;
        while(true) {
            String s = solution.next_line();
            System.out.println("" + i + " " + s);
            if(s.length() == 0)
                break;
            i++;
            if(i > 10)
                break;
        }
    }
}

