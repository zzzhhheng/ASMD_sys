package user;


import java.util.ArrayList;

/*User抽象类是所有人员类的基类，包含人员所必须的基本信息
 *User类的子类有，Teacher类，Student类，Administrator类
 *Administrator类又有子类，SchoolAdministrator类，SuperAdministrator类*/
abstract class User {
    private int userID;         //用户Id
    private String userName;    //用户名
    private String passWord;    //密码
    private String phoneNumber; //电话
    private String authority;   //权值

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }


}

class Student extends User {
    private String LearningClass;                            //班级
    private String studentGrade;                             //年级
    private ArrayList<Object> studentWrongQuestion;  //错题数组
    private String studentSchool;                            //学校

    public String getLearningClass() {
        return LearningClass;
    }

    public void setLearningClass(String learningClass) {
        LearningClass = learningClass;
    }

    public String getStudentGrade() {
        return studentGrade;
    }

    public void setStudentGrade(String studentGrade) {
        this.studentGrade = studentGrade;
    }

    public ArrayList<Object> getStudentWrongQuestion() {
        return studentWrongQuestion;
    }

    public void setStudentWrongQuestion(ArrayList<Object> studentWrongQuestion) {
        this.studentWrongQuestion = studentWrongQuestion;
    }

    public String getStudentSchool() {
        return studentSchool;
    }

    public void setStudentSchool(String studentSchool) {
        this.studentSchool = studentSchool;
    }


    //正常练习，输入题目数目，返回题目类型数组(方法先这样写，等梦珂分析好返回值和参数再改，-2023.3.10魔理沙)
    public ArrayList<Object> normalPractice(int number) {
        ArrayList<Object> answ = new ArrayList<>();
        return answ;
    }

    //复习练习，输入题目数量，返回题目类型数组
    public ArrayList<Object> reviewPractice(int number) {
        ArrayList<Object> answ = new ArrayList<>();
        return answ;
    }

    //困难练习，输入题目数量，返回题目类型数组
    public ArrayList<Object> hardPractice(int number) {
        ArrayList<Object> answ = new ArrayList<>();
        return answ;
    }

    //做作业，通过查询数据库，看老师是否布置作业，如果布置了，学生选择试卷并返回题目类型数组，如果没有，弹出窗口提示没有作业
    public ArrayList<Object> doHomework() {
        ArrayList<Object> answ = new ArrayList<>();
        return answ;
    }

    //查看历史错题，输入题目数量，返回题目类型数组
    public ArrayList<Object> viewWrongQuestion(int number) {
        ArrayList<Object> answ = new ArrayList<>();
        return answ;
    }
}

class Teacher extends User {
    private String teachingClass;  //班级
    private String teacherSchool;  //学校

    public String getTeachingClass() {
        return teachingClass;
    }

    public void setTeachingClass(String teachingClass) {
        this.teachingClass = teachingClass;
    }

    public String getTeacherSchool() {
        return teacherSchool;
    }

    public void setTeacherSchool(String teacherSchool) {
        this.teacherSchool = teacherSchool;
    }

    //管理班级，进入该界面之后有三个选项，包括删除学生，修改学生信息，查询学生信息，教师需要再次选择
    void managementClass() {

    }

    //出试卷，教师通过自己输入题目内容，整合出一张试卷存入数据库
    void publishPaper(ArrayList<Object> problems) {

    }

    //添加学生，输入学生信息，存入数据库。因为用的比较频繁，与管理学生的方法分离开
    void addStudent(Student stu) {

    }

}

