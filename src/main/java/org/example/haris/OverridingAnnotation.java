package org.example.haris;


    class Animal {
        void sound() {
            System.out.println("Animals make sounds");
        }
    }

    class Dog extends Animal {
        @Override
        void sound() {
            System.out.println("Dog barks" );
        }
    }

    public class OverridingAnnotation {
        public static void main(String[] args) {
            Animal myDog = new Dog();
            myDog.sound(); // Output: Dog barks
        }
    }



