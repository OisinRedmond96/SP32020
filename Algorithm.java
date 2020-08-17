import java.util.ArrayList;
import java.util.Random;

public class Algorithm {

    ArrayList <Project> projects;
    ArrayList <Student> students;
    ArrayList <Project> assignedProjects = new ArrayList<Project>();

    public Algorithm(ArrayList <Project> projects,
                     ArrayList <Student> students){
        this.projects = projects;
        this.students = students;
        }
    
    public void assignProject(Student s){
        for(Project project : s.preferences){
            if (!(assignedProjects.contains(project))){
                s.assignedProject = project;
                assignedProjects.add(project);
                break;
            }
        }
        
    }
}