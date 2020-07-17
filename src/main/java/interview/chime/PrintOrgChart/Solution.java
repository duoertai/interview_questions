package interview.chime.PrintOrgChart;

import java.util.*;

public class Solution {
    static class Employee {
        public String id;
        public String name;
        public List<Employee> reports;

        public Employee(String id, String name) {
            this.id = id;
            this.name = name;
            this.reports = new ArrayList<>();
        }
    }

    public static void printOrgChart(String[][] employees) {
        Map<String, Employee> map = new HashMap<>();

        for(String[] employee: employees) {
            map.put(employee[0], new Employee(employee[0], employee[1]));
        }

        int level = 0;
        Queue<Employee> curr = new LinkedList<>();
        Queue<Employee> next = new LinkedList<>();

        for(String[] employee: employees) {
            if (employee[0].equals(employee[2])) {
                curr.offer(map.get(employee[0]));
            }

            map.get(employee[2]).reports.add(map.get(employee[0]));
        }



        while(!curr.isEmpty()) {
            Employee temp = curr.poll();

            printEmployeeInfo(temp, level);

            for (Employee r: temp.reports) {
                if (r.id != temp.id)
                    next.offer(r);
            }

            if (curr.isEmpty()) {
                level++;
                curr = next;
                next = new LinkedList<>();
            }
        }

    }

    private static void printEmployeeInfo(Employee employee, int level) {
        for(int i = 0; i < level; i++) {
            System.out.print("-");
        }

        System.out.print(employee.id);
        System.out.println();
    }

    public static void main(String[] args) {
        Solution.printOrgChart(
                new String[][] {
                        new String[] {"1", "boss", "1"},
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
