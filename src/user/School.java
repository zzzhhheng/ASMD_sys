package user;

import java.util.ArrayList;
/*学校类中包含某个学校的所有班级信息
可以通过声明一个学校类型的变量进行学校信息的存储和增删改查*/
public class School {
    private ArrayList<Class>classList;   //储存班级信息的数组
    private int SchoolId;                //学校id

    //getter和setter
    public ArrayList<Class> getClassList() {
        return classList;
    }

    public void setClassList(ArrayList<Class> classList) {
        this.classList = classList;
    }

    public int getSchoolId() {
        return SchoolId;
    }

    public void setSchoolId(int schoolId) {
        SchoolId = schoolId;
    }


}
