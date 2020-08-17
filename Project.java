public class Project {

    String name;
    
    public Project(String name){
        this.name = name;
    }
    
    @Override
    public boolean equals(Object o){
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        Project project = (Project)o;
        return name == project.name;
    }   
}