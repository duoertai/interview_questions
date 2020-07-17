package interview.twilio.HostsAndTotalNumberOfRequests;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void getHostsAndTotalNumberOfRequests(String inputFileName) {
        if (inputFileName == null || inputFileName.length() == 0)
            return;

        Map<String, Integer> map = new HashMap<>();

        try{
            File file = new File(inputFileName);

            BufferedReader br = new BufferedReader(new FileReader(file));

            String st;
            while ((st = br.readLine()) != null){
                String hostname = st.split("\\s+")[0];
                if (!map.containsKey(hostname))
                    map.put(hostname, 1);
                else
                    map.put(hostname, map.get(hostname) + 1);
            }

            String outputFileName = "records";
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName));

            for (String hostname: map.keySet()) {
                String line = hostname + " " + map.get(hostname) + "\n";
                writer.write(line);
            }
            writer.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Solution.getHostsAndTotalNumberOfRequests("/Users/ertaiduo/IdeaProjects/interview_questions/src/main/java/interview/twilio/HostsAndTotalNumberOfRequests/input.txt");
    }
}
