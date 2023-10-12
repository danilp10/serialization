package org.ulpgc.dacd.control;

import org.ulpgc.dacd.model.Movie;
import org.ulpgc.dacd.model.Session;
import org.ulpgc.dacd.model.Theater;
import com.google.gson.Gson;

import java.io.*;

import static org.ulpgc.dacd.control.SerializationExercises.Exercise1.saveToFile;
//import static org.ulpgc.dacd.control.SerializationExercises.Exercise2.loadMovieJsonFromFile;
import static org.ulpgc.dacd.control.SerializationExercises.Exercise2.loadTheaterJsonFromFile;
import static org.ulpgc.dacd.control.SerializationExercises.Exercise2.loadSessionJsonFromFile;

public class Main {
    public static void main(String[] args) {

        //System.out.println(new Movie("Up", "Pepe"));
        //System.out.println(new Theater("Johnny", "Madrid"));
        Session test = new Session(new Movie("Cars", "Pepe"), new Theater("Tom", "Barcelona"), "2");
        System.out.println(test);
        Gson gson = new Gson();
        String test2 = gson.toJson(test);
        System.out.println(test2);

        try {
            saveToFile("aaaa.json", test2);
            String session1Json = String.valueOf(loadSessionJsonFromFile("aaaa.json"));
            System.out.println(session1Json);

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("exercise2.json"));
            objectOutputStream.writeObject(session1Json);
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("exercise2.json"));
            System.out.println(objectInputStream.readObject());

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}