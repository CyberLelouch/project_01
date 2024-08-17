package indiv.java.controller;

import indiv.java.entity.Student;
import indiv.java.service.StudentService;

import java.util.Scanner;

public class StudentController {
    StudentService studentService = new StudentService();
    public void addStudent(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入待添加学生的学号：");
        String studentId = scanner.nextLine();
        System.out.println("请输入姓名：");
        String studentName = scanner.nextLine();
        System.out.println("请输入学生年龄：");
        int studentAge = scanner.nextInt();

        //封装数据
        Student student = new Student(studentId,studentName,studentAge);
        //如何待添加学生不存在，添加
        if ( ! studentService.isExist(studentId)){
            if (studentService.addStudent(student)){
                System.out.println(student.getId()+"添加成功");
            }else {
                System.out.println("添加失败");
            }
        }else {
            System.out.println(student.getId()+"已存在，添加失败");
        }
    }

    //通过学号删除学生
    public void deleteStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入待删除的学生学号：");
        String studentId = scanner.nextLine();
        if (studentService.isExist(studentId)){
            if (studentService.deleteStudent(studentId)){
                System.out.println(studentId+"删除成功！");
            }else {
                System.out.println("删除失败");
            }
        }else {
            System.out.println("删除失败，"+studentId+"不存在。");
        }
    }

    public void updateStudent() {
    }

    public void findStudent() {
    }

    public void showAllStudentInfo() {
    }
}
