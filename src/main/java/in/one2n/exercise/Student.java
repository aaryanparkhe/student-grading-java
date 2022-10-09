package in.one2n.exercise;

public class Student {

    private String firstname;
    private String lastname;
    private String university;
    private Double test1Score;
    private Double test2Score;
    private Double test3Score;
    private Double test4Score;

    // computed fields
    private Double finalScore;
    private Grade grade;

    public Student(){super();}

    public Student(String firstname, String lastname, String university) {
        super();
        // TODO: add your implementation here
        this.firstname=firstname;
        this.lastname=lastname;
        this.university=university;
        this.test1Score = null;
        this.test2Score = null;
        this.test3Score = null;
        this.test4Score = null;
        this.finalScore = null;
        this.grade = null;
    }

    public Student(String firstname, String lastname, String university, Double test1Score, Double test2Score, Double test3Score, Double test4Score) {
        // TODO: add your implementation here
        this.firstname = firstname;
        this.lastname = lastname;
        this.university = university;
        this.test1Score = test1Score;
        this.test2Score = test2Score;
        this.test3Score = test3Score;
        this.test4Score = test4Score;
        this.finalScore=(this.test1Score+this.test2Score+this.test3Score+this.test4Score)/4;
        this.grade = null;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public Double getTest1Score() {
        return test1Score;
    }

    public void setTest1Score(Double test1Score) {
        this.test1Score = test1Score;
    }

    public Double getTest2Score() {
        return test2Score;
    }

    public void setTest2Score(Double test2Score) {
        this.test2Score = test2Score;
    }

    public Double getTest3Score() {
        return test3Score;
    }

    public void setTest3Score(Double test3Score) {
        this.test3Score = test3Score;
    }

    public Double getTest4Score() {
        return test4Score;
    }

    public void setTest4Score(Double test4Score) {
        this.test4Score = test4Score;
    }

    public void setFinalScore(Double finalScore) {
        this.finalScore = finalScore;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public Double getFinalScore() {

        return finalScore;
    }

    public Grade getGrade() {
        // TODO: add your implementation here
        double score = this.getFinalScore();
        if(score < 35)
            return Grade.F;
        else if(score >= 35 && score<50)
            return Grade.C;
        else if(score >= 50 && score<70)
            return Grade.B;
        else
            return Grade.A;
    }


    protected double test1Score() {
        return test1Score;
    }

    protected double test2Score() {
        return test2Score;
    }

    protected double test3Score() {
        return test3Score;
    }

    protected double test4Score() {
        return test4Score;
    }

    @Override
    public boolean equals(Object obj)
    {
        if(this == obj)
            return true;
        if(obj == null || this.getClass() != obj.getClass())
            return false;
        Student std = (Student) obj;

        return this.firstname.equals(std.firstname)
                && this.lastname.equals(std.lastname)
                && this.university.equals(std.university);
    }


}

