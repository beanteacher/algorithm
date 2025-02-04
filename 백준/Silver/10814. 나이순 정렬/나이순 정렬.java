import java.util.*;
import java.io.*;

public class Main {

    static class Person {
        int age;
        String name;

        public Person(int age, String name) {
            this.age = age;
            this.name = name;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Person[] people = new Person[n];
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            people[i] = new Person(age, name);
        }

        Arrays.sort(people, (a1, a2) -> a1.age - a2.age);

        for(int i = 0; i < n; i++) {
            System.out.println(people[i].age + " " + people[i].name);
        }
    }
}