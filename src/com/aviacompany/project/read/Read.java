package com.aviacompany.project.read;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Read {
    String line;
    List<User> mass = new ArrayList<User>();

    public List<User> getMass() {
        return mass;
    }

    public void reader() {
        BufferedReader readFromFile = null;
        try {
            readFromFile = new BufferedReader(new FileReader("./text.txt"));
            while ((line = readFromFile.readLine()) != null) {
                User newUser = new User();
                newUser.key = line;
                mass.add(newUser);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (readFromFile != null)
                try {
                    readFromFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }

    }

    /* Example:

    public static void main(String[] args) throws IOException {
        Read test = new Read();
        test.reader();
        int i=0;
        for (User newUser : test.mass) {
            newUser.chislo=i;
            if(i!=0)
            System.out.println(newUser.chislo+". "+newUser.key+".");
            i++;
        }
    }*/
}
