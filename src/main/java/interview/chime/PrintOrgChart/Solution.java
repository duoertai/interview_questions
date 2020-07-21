package interview.chime.PrintOrgChart;

import java.util.*;

public class Solution {
    static class Employee {
        public String id;
        public String name;
        public String managerId;
        public List<String> reports;

        public Employee() {
            this.reports = new ArrayList<>();
        }
    }

    public static void printOrgChart(String[][] employees) {
        Map<String, Employee> map = new HashMap<>();
        List<String> tops = new ArrayList<>();

        for(String[] employee: employees) {
            Employee e = new Employee();
            e.id = employee[0];
            e.name = employee[1];
            e.managerId = employee[2];
            map.put(employee[0], e);

            if (e.managerId.equals("0"))
                tops.add(e.id);
        }
        
        for(String id: map.keySet()) {
            Employee e = map.get(id);
            if (!e.managerId.equals("0"))
                map.get(e.managerId).reports.add(e.id);
        }

        for(String t: tops)
            printEmployeeInfo(map, t, 0);
    }

    private static void printEmployeeInfo(Map<String, Employee> map, String id, int level) {
        for(int i = 0; i < level; i++) {
            System.out.print("-");
        }

        System.out.print(map.get(id).name);
        System.out.println();

        for(String r: map.get(id).reports)
            printEmployeeInfo(map, r, level + 1);
    }

    public static void main(String[] args) {
        Solution.printOrgChart(
                new String[][] {
                        new String[] {"1", "boss", "0"},
                        new String[] {"3", "alice", "3"},
                        new String[] {"2", "bob", "1"},
                        new String[] {"4", "daniel", "2"},
                        new String[] {"7", "luis", "4"},
                        new String[] {"8", "john", "3"},
                        new String[] {"9", "angela", "8"},
                        new String[] {"77", "robert", "1"},
                }
        );
    }
}
