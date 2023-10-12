package org.ulpgc.dacd.control;
import org.ulpgc.dacd.model.Movie;
import org.ulpgc.dacd.model.Session;
import org.ulpgc.dacd.model.Theater;
import com.google.gson.Gson;
import java.io.*;
import java.io.IOException;
import java.lang.reflect.Type;

public class SerializationExercises {
    /*
        Should define the class for the concepts Movie, Theater and Session.
        A session is a play of movie in a theater.
        Create 2 instances of each class and relate among them.
        Serialize to Json all objects and save them in different files.
     */
    public static class Exercise1 {
        public static void main(String[] args) {
            Movie movie1 = new Movie("Up", "Pedro");
            Movie movie2 = new Movie("Cars", "Juan");
            Theater theater1 = new Theater("Johnny Deep", "Barcelona");
            Theater theater2 = new Theater("Tom Holland", "Madrid");
            Session session1 = new Session(movie1, theater1, "Up");
            Session session2 = new Session(movie2, theater2, "Cars");

            Gson gson = new Gson();
            try {
                String movie1Json = gson.toJson(movie1);
                String movie2Json = gson.toJson(movie2);
                String theater1Json = gson.toJson(theater1);
                String theater2Json = gson.toJson(theater2);
                String session1Json = gson.toJson(session1);
                String session2Json = gson.toJson(session2);

                saveToFile("movie1.json", movie1Json);
                saveToFile("movie2.json", movie2Json);
                saveToFile("theater1.json", theater1Json);
                saveToFile("theater2.json", theater2Json);
                saveToFile("session1.json", session1Json);
                saveToFile("session2.json", session2Json);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        static void saveToFile(String file, String json) throws IOException {
            FileWriter writer = new FileWriter(file);
            writer.write(json);
            writer.close();
        }
    }

    /*
        Deserialize the objects created in exercise 1.
        Now serialize them using ObjectOutputStream
     */
    public static class Exercise2 {

        public static void main(String[] args) {
            Gson gson = new Gson();
            try {
                String movie1Json = String.valueOf(loadMovieJsonFromFile("movie1.json"));
                //Movie deserializedMovie = gson.fromJson(movie1Json, Movie.class);
                String movie2Json = String.valueOf(loadMovieJsonFromFile("movie2.json"));
                //Movie deserializedMovie2 = gson.fromJson(movie2Json, Movie.class);
                String theater1Json = String.valueOf(loadTheaterJsonFromFile("theater1.json"));
                //Theater deserializedTheater = gson.fromJson(theater1Json, Theater.class);
                String theater2Json = String.valueOf(loadTheaterJsonFromFile("theater2.json"));
                //Theater deserializedTheater2 = gson.fromJson(theater2Json, Theater.class);
                String session1Json = String.valueOf(loadSessionJsonFromFile("session1.json"));
                //Session deserializedSession = gson.fromJson(session1Json, Session.class);
                String session2Json = String.valueOf(loadSessionJsonFromFile("session2.json"));
                //Session deserializedSession2 = gson.fromJson(session2Json, Session.class);

                ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("exercise2.text"));
                objectOutputStream.writeObject(movie1Json);
                objectOutputStream.writeObject(movie2Json);
                objectOutputStream.writeObject(theater1Json);
                objectOutputStream.writeObject(theater2Json);
                objectOutputStream.writeObject(session1Json);
                objectOutputStream.writeObject(session2Json);
                objectOutputStream.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        public static Movie loadMovieJsonFromFile(String filename) throws IOException {
            Gson gson = new Gson();
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line = reader.readLine();
            reader.close();
            return gson.fromJson(line, Movie.class);
        }

        public static Theater loadTheaterJsonFromFile(String filename) throws IOException {
            Gson gson = new Gson();
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line = reader.readLine();
            reader.close();
            return gson.fromJson(line, Theater.class);
        }

        public static Session loadSessionJsonFromFile(String filename) throws IOException {
            Gson gson = new Gson();
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line = reader.readLine();
            reader.close();
            return gson.fromJson(line, Session.class);
        }
    }

    /*
       Deserialize the objects from the binary files created in exercise 2.
    */
    public static class Exercise3 {
        public static void main(String[] args) throws IOException, ClassNotFoundException {
            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("exercise2.json"));
                objectInputStream.readObject();
                /*Movie deserializedMovie2 = (Movie) objectInputStream.readObject();
                Theater deserializedTheater = (Theater) objectInputStream.readObject();
                Theater deserializedTheater2 = (Theater) objectInputStream.readObject();
                Session deserializedSession = (Session) objectInputStream.readObject();
                Session deserializedSession2 = (Session) objectInputStream.readObject();*/
                objectInputStream.close();
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
