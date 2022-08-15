import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
class Student {

    private String name;
    //姓名
    private String sid;
    //学号
    private String gender;
    //性别
    private String address;
    //居住地
    private String college;
    //学院


    public Student() {
    }

    public Student(String name, String sid, String gender, String address,String college) {
        this.sid = sid;
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.college = college;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCollege(){
        return college;
    }

    public void setCollege(String college){
        this.college = college;
    }
}


public class StudentManager {
    public static void main(String[] args) {

        //创建集合对象，用于存储学生数据
        ArrayList<Student> array = new ArrayList<>();

        //用循环完成再次回到主界面
        while (true) {
            // 1. 用输出语句完成主界面的编写
            System.out.println("---------欢迎来到学生管理系统------------");
            System.out.println("（1）输入学生姓名、学号、性别、籍贯、所在学院");
            System.out.println("（2）统计籍贯为陕西的学生人数，以及男生和女生的人数");
            System.out.println("（3）统计每个学院的学生人数");
            System.out.println("（4）输入学号查询学生的信息；");
            System.out.println("（5）将学生信息保存在文本文件中");
            System.out.println("（6）退出");
            System.out.println("-------------------------------------");

            // 2. 用Scanner实现键盘录入数据
            Scanner scanner = new Scanner(System.in);
            int line = scanner.nextInt();


            //3. 用switch语句完成操作的选择
            switch (line) {
                case 1:
                    //System.out.println("输入8名学生姓名、学号、性别、籍贯、所在学院");
                    addStudent(array);
                    break;
                case 2:
                    //System.out.println("统计籍贯为陕西的学生人数，以及男生和女生的人数");
                    statisticStudent(array);
                    break;
                case 3:
                    //System.out.println("统计每个学院的学生人数");
                    collegeStudent(array);
                    break;
                case 4:
                    //System.out.println("输入学号查询学生的信息");
                    findStudent(array);
                    break;
                case 5:
                    txt(array);
                    break;
                case 6:
                    System.out.println("结束使用");
                    System.exit(0);
            }
        }
    }


    //定义一个方法，用于添加学生信息
    public static void addStudent(ArrayList<Student> array){


            //用键盘录入选择添加学生,显示提示信息，提示要输入何种信息
            Scanner sc = new Scanner(System.in);

            System.out.println("请输入学生学号：");
            String sid = sc.nextLine();
            System.out.println("请输入学生姓名：");
            String name = sc.nextLine();
            System.out.println("请输入学生性别：");
            String gender = sc.nextLine();
            System.out.println("请输入学生居住地：");
            String address = sc.nextLine();
            System.out.println("请输入学生所在学院：");
            String college = sc.nextLine();

            //创建学生对象，把键盘录入的数据赋值给学生对象的成员变量
            Student s = new Student();
            s.setSid(sid);
            s.setName(name);
            s.setAddress(address);
            s.setGender(gender);
            s.setCollege(college);

            //将学生对象添加到集合中（保存）
            array.add(s);



        //给出添加成功提示
        System.out.println("添加学生成功");

    }

    //定义一个方法，用于统计籍贯为陕西的学生人数，以及男生和女生的人数
    public  static void statisticStudent(ArrayList<Student> array){
        int num1=0,num2=0,num3=0;
        for (int i = 0; i < array.size(); i++) {
            Student s = array.get(i);
            if(s.getAddress().equals("陕西"))
                num1=num1+1;
            if(s.getGender().equals("男"))
                num2++;
            if(s.getGender().equals("女"))
                num3++;
        }
        System.out.println("籍贯为陕西的学生有"+num1+"人.男生有"+num2+"人，女生有"+num3+"人");
    }

    //定义一个方法，用于统计每个学院的学生人数
    public static void collegeStudent(ArrayList<Student> array){
        String colleg = "";
        int m=0;
        for(int i=0;i< array.size();i++){
            Student s = array.get(i);
            for(int j=0;j< array.size();j++){
                Student n = array.get(j);
                if(n.getCollege()!=s.getCollege()) {
                    colleg = n.getCollege();
                    m++;
                }
            }
        }
        for(int i=0;i< m;i++){
            Student s = array.get(i);
            String co=colleg;
            int q=0;
            for(int j=0;j< array.size();j++){
                Student n = array.get(j);
                if(n.getCollege().equals(co))
                    q++;
            }
            System.out.println(co+"院有"+q+"人");
        }
    }

    //定义一个方法，用于查看学生信息
    public static void findStudent(ArrayList<Student> array) {

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要查询的学生的学号");
        String num= sc.nextLine();
        if (array.size() == 0) {
            System.out.println("无信息，请先添加信息再查询");
            //为了不让程序继续往下执行
            return;
        }

        System.out.println("学号\t\t姓名\t\t性别\t\t居住地\t\t学院\t\t");

        for (int i = 0; i < array.size(); i++) {
            Student s = array.get(i);
            if(s.getSid().equals(num))
                System.out.println(s.getSid() + "\t\t" + s.getName() + "\t\t"  + s.getGender() +  "\t\t" + s.getAddress() + "\t\t" + s.getCollege());
        }
    }

    public static void txt(ArrayList<Student> arry){
        //目的地student.txt
        File destPath = new File("D:\\idea-java\\class\\student.txt");
        // 获取集合中的每一个Student对象
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(destPath));
            bw.write("学号\t");
            bw.write("姓名\t");
            bw.write("性别\t");
            bw.write("居住地\t");
            bw.write("学院\t");
            bw.newLine();
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Student s : arry) {
            //把信息存储到文本文件中
            //数据源Student s
            //目的地Student.txt
            String name = s.getName();
            String sid = s.getSid();
            String gender = s.getGender();
            String address = s.getAddress();
            String college = s.getCollege();

            try {
                bw.write(name + "\t");
                bw.write(sid + "\t");
                bw.write(gender + "\t");
                bw.write(address + "\t");
                bw.write(college + "\t");
                bw.newLine();
                bw.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("成功保存文件");
    }
}

