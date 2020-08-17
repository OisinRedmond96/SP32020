import java.util.ArrayList;

public class Student {

    String name;
    ArrayList <Project> preferences;
    Project assignedProject;

    public Student (String name){
        this.name = name;
    }

    public void assignPref(ArrayList<Project> preferences){
        this.preferences = preferences;
    }

    public void assignProject(Project p){
        this.assignedProject = p;
    }

    public String to_s(){
        String output = name + " ";
        for(Project p: preferences){
            output += p.name;
            output += " ";
        }
        return output;
    }
}