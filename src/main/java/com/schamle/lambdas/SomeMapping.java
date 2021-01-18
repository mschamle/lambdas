package com.schamle.lambdas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class SomeMapping {

    public static void main(String[] args) {
        User sarah = new User("Sarah");
        User james = new User("James");
        User mary = new User("Mary");
        User john = new User("John");

        List<User> users = List.of(sarah, james, mary, john);

        //map list of users to strings
        List<String> names = new ArrayList<>();
        Function<User, String> toName = user -> user.getName();
        for (User user: users){
            names.add(toName.apply(user));
        }

        //note below that same lambda method can be applied to two different inputs
        users.forEach(user -> System.out.println(user));
        names.forEach(user -> System.out.println(user));
    }

    private static class User {
        private String name;

        public User(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}
