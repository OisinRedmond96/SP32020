import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public class Application {

    public static void main (String [] args) throws IOException {
        // Create needed ArrayLists 
        ArrayList <Student> students = new ArrayList<Student>();
        ArrayList <Project> projects = new ArrayList<Project>();

        // Fill project ArrayList
        for(int i = 0; i < 1000; i++){
            Project p = new Project("Project " + i);
            projects.add(p);
        }

        // Read names into a list called names 
        List <String> names = readFileInList("names.txt");


        // Fill students array list 
        for(int i = 0; i < 120; i++){
            Student s = new Student(names.get(i));
            students.add(s);
        }

        // Assign each student's preferences 
        for(Student s: students){
            ArrayList <Project> preferences = new ArrayList<Project>();
            Random r = new Random();
            for (int i = 0; i < 10; i++){
                boolean sem = false;
                while(!sem){
                  Project p = projects.get((int)(r.nextGaussian()*500 + 10));
                  if(!(preferences.contains(p))){
                    preferences.add(p);
                    sem = true;
                  }
                }
            s.assignPref(preferences); 
            }
        }

       // Use algorithm object to assign each student a project 
       Algorithm a = new Algorithm(projects, students);
       for(Student s: students){
           a.assignProject(s);
       }

       // Write info into a file
       FileWriter csvWriter = new FileWriter("outputdata.csv");
       csvWriter.append("Name, Assigned Project\n");
       for(Student s: students) {
           csvWriter.append(s.name + ", " + s.assignedProject.name + "\n");
       }
       csvWriter.flush();
       csvWriter.close();
    }

// Utility Methods


// Taken from Geeks for Geeks
    public static List<String> readFileInList(String fileName){ 
      List<String> lines = Collections.emptyList(); 
      try
      { 
      lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8); 
      } 
      catch (IOException e) 
      { 
       e.printStackTrace(); 
      } 
     return lines;   
    }

}