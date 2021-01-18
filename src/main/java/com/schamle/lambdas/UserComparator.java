package com.schamle.lambdas;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class UserComparator {

    public static void main(String[] args) {
        User sarah = new User("Sarah", 28);
        User james = new User("James", 35);
        User mary = new  User("Mary", 33);
        User john1 = new  User("John", 24);
        User john2 = new  User("John", 25);

        List<User> users = Arrays.asList(sarah, james, mary, john1, john2);

        Comparator<User> cmpName = Comparator.comparing(user -> user.getName());
        Comparator<User> cmpAge = Comparator.comparing(user -> user.getAge());
        Comparator<User> comparator = cmpName.thenComparing(cmpAge);
        Comparator<User> reversed = comparator.reversed();

        users.sort(comparator);
        users.forEach(user ->System.out.println(user));

        users.sort(reversed);
        users.forEach(user ->System.out.println(user));
    }


    private static class User {
        private String name;
        private int age;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
