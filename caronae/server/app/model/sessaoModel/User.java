package model.sessaoModel;

/**
 * Created by gustavooliveira on 4/10/16.
 */
public class User {
    private String studentId;

    private String password;

    public User() {

    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String toString(){
        return "Matricula: " + studentId;
    }
}
