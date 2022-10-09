package in.one2n.exercise;

import java.io.*;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Grader extends Student{



    public List<Student> parseCSV(String filepath) throws FileNotFoundException {

         // TODO: add your implementation here
//        return Collections.emptyList();

        List<Student> students = new ArrayList<>();
        String line = "";

        try{
            BufferedReader br = new BufferedReader(new FileReader(filepath));
            while((line = br.readLine())!=null){

                String values[] = line.split(",");

                if(!values[0].contains("FirstName")){
                    Student s = new Student(values[0],values[1],values[2],
                            Double.valueOf(values[3]),Double.valueOf(values[4]), Double.valueOf(values[5]),Double.valueOf(values[6]));

                    students.add(s);
                }
            }
            br.close();
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return students;

        }


    public List<Student> calculateGrade(List<Student> students) {
        // TODO: add your implementation here
        students.stream().forEach(eachstd -> eachstd.setGrade(eachstd.getGrade()));
        return students;


    }

    public Student findOverallTopper(List<Student> gradedStudents) {
        // TODO: add your implementation here
        return gradedStudents.stream().max(Comparator.comparingDouble(Student::getFinalScore)).get();

    }


    public Map <String, Student> findTopperPerUniversity(List <Student> gradedStudents) {
        List <String> universities = gradedStudents.stream().map(Student::getUniversity).collect(Collectors.toList());
        List <String> unique_universities = universities.stream().distinct().collect(Collectors.toList());
        Map <String, Student> hashmap = new HashMap<>();
        unique_universities.forEach((university) -> {
            hashmap.put(university, findUniversityTopper(gradedStudents,university));
        });
        return hashmap;
    }

    private Function<String, Student> mapToItem = (line) -> {
        String[] items = line.split(",");
        Student student = new Student(items[0], items[1], items[2], Double.parseDouble(items[3]), Double.parseDouble(items[4]), Double.parseDouble(items[5]), Double.parseDouble(items[6]));
        return student;
    };

    private Student findUniversityTopper(List <Student> students, String university)
    {
        return students.stream().filter(m -> m.getUniversity().equals(university)).max(Comparator.comparingDouble(Student::getFinalScore)).get();
    }
}
