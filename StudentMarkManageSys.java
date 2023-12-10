import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
class StudentMarkManageSys{
    static Scanner keyIn=new Scanner(System.in);
     //////////////////////////////////////////////////////////////////////////////////////
    static String keyBoard = 
        "\n\n\t\t  _____________________________________________________________________\n" +
        "\t\t | Esc | 1! | 2@ | 3# | 4$ | 5% | 6^ | 7& | 8* | 9( | 0) | -_ | =+ | ⌫ |\n" +
        "\t\t |---------------------------------------------------------------------|\n" +
        "\t\t | Tab | Q | W | E | R | T | Y | U | I | O | P | [{ | ]} |  \\          |\n" +
        "\t\t |---------------------------------------------------------------------|\n" +
        "\t\t | Caps | A | S | D | F | G | H | J | K | L | ;: | '\"' |     Enter     |\n" +
        "\t\t |---------------------------------------------------------------------|\n" +
        "\t\t | Shift | Z | X | C | V | B | N | M | ,< | .> | /? | ↑ |    Shift     |\n" +
        "\t\t |---------------------------------------------------------------------|\n" +
        "\t\t | Ctrl | Win | Alt |   ©Developed by ShenSingh   | Alt | FN | Ctrl    |\n" +
        "\t\t \\_____________________________________________________________________/\n";
    /////////////////////////////////////////////////////////////////////////////////////////////

    public static void clearConsole() { //////////////// clear consol//////////////////////
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    public static void disTimeDate(){/////////////////////////Print DateAndTime//////////////////////
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String formattedDateTime = currentDateTime.format(formatter);
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t" + formattedDateTime);
    }
    /////////////////////////////////////////////////////////////Student Arr////////////////////
    public static Student[] students=new Student[0];
    ///////////////////////////////////////////////////////////////////////////////////////////
    public static void main(String [] args){////////////////////////////////Main Mathod//////////////////////////////////////

        homePage();
    }
    private static void homePage(){
        clearConsole();
        disTimeDate();
        System.out.println("\t\t\t+-----------------------------------------------------------+");
        System.out.println("\t\t\t|          WELLCOME TO GDSE MARKS MANAGEMENT SYSTEM         |");
        System.out.println("\t\t\t+-----------------------------------------------------------+");
        System.out.println("\n\n");
        System.out.println("\t\t[1] Add New Student"+"\t\t\t     [2] Add New Student With Marks");
        System.out.println("\t\t[3] Add Marks"+"\t\t\t\t     [4] Update Student Details");
        System.out.println("\t\t[5] update marks"+"\t\t\t     [6] Delete Student");
        System.out.println("\t\t[7] Print Student Details"+"\t\t     [8] Print Student Ranks");
        System.out.println("\t\t[9] Best In Programming fundamentals"+"\t     [10] Best In Database Management System");
        System.out.println("\t\t[11] Exit Program");
        
        boolean flog01=false;
        
        do{
            flog01=false;
            System.out.println("\n");
            System.out.print("Enter Option"+keyBoard+"\n\t\t"+"✎. ");
            String option1=keyIn.next();
    
            switch (option1) {
                case "1":
                    addNewStudent();
                    break;
                case "2":
                    addNewMarkWithMark();
                    break;
                case "3":
                    addMark();
                    break;
                case "4":
                    updateStuDet();
                    break;
                case "5":
                    updateMarks();
                    break;
                case "6":
                    deleteStu();
                    break;
                case "7":
                    printStuDet();
                    break;
                case "8":
                    printStuRank();
                    break;
                case "9":
                    bestInPrf();
                    break;
                case "10":
                    bestInDbm();
                    break;
                case "11":
                    System.exit(0);
                default:
                    clearConsole();
                    disTimeDate();
                    System.out.println("wrong command try agin.\n");
                    System.out.println("\t\t\t+-----------------------------------------------------------+");
                    System.out.println("\t\t\t|          WELLCOME TO GDSE MARKS MANAGEMENT SYSTEM         |");
                    System.out.println("\t\t\t+-----------------------------------------------------------+");
                    System.out.println();
                    System.out.println("\t[1] Add New Student"+"\t\t\t     [2] Add New Student With Marks");
                    System.out.println("\t[3] Add Marks"+"\t\t\t\t     [4] Update Student Details");
                    System.out.println("\t[5] update marks"+"\t\t\t     [6] Update Student Details");
                    System.out.println("\t[7] Print Student Details"+"\t\t     [8] Print Student Ranks");
                    System.out.println("\t[9] Best In Programming fundamentals"+"\t     [10] Best In Database Management System");
                    System.out.println("\t[11] Exit Program");
                    flog01=true;
                    break;
            }
        }while(flog01);
    }
    private static void bestInDbm(){
        clearConsole();
        disTimeDate();
        System.out.println("\t\t\t+-----------------------------------------------------------+");
        System.out.println("\t\t\t|                  Best In Database managament              |");
        System.out.println("\t\t\t+-----------------------------------------------------------+");
        System.out.println();

        boolean flog01=false;

        Student[] sortDbmMark =rankDbmMark();
        /////////////////////////////////////////////////////////////////////////////
        int i=0;

        System.out.printf("\t\t+------------------+----------------------+------------------+------------------+%n");
        System.out.printf("\t\t| %-16s | %-20s | %-16s | %-16s |%n", "ID", "Name", "DBM Mark", "PRF Mark");
        System.out.printf("\t\t+------------------+----------------------+------------------+------------------+%n");
        
        for (Student student : sortDbmMark) {
            System.out.printf("\t\t| %-16s | %-20s | %-16s | %-16s |%n", student.getsId(), student.getsName(), student.dbmMark, student.prfMark);
        }
        System.out.printf("\t\t+------------------+----------------------+------------------+------------------+%n");
       //////////////////////////////////////////////////////////////////////////////////

        do {
            System.out.println();
            flog01=false;
            System.out.print("Do you view agin(y/n)"+keyBoard+"\n\t\t"+"✎. ");
            String option02=keyIn.next();
    
            if (option02.equals("y")) {
                bestInDbm();
            }
            if (option02.equals("n")) {
                homePage();
            }
            else{
                bestInDbm();
                System.out.println("Wrong Commonmd! Try Agin.");
                flog01=true;
            }
        } while (flog01);
    }
    private static Student[] rankDbmMark(){
        Student[] sortStudent =new Student[students.length];

        sortStudent=students;
        //////////////////////////////////////////////////////////
        for (int i = 0; i <sortStudent.length; i++){
			for (int j = 0; j < sortStudent.length-1; j++){
				if(sortStudent[j].dbmMark<sortStudent[j+1].dbmMark){
					Student temp = sortStudent[j];
					sortStudent[j] = sortStudent[j+1];
					sortStudent[j+1] = temp;
				}
            }
        }
        return sortStudent;
    }
    private static void bestInPrf(){
        clearConsole();
        disTimeDate();
        System.out.println("\t\t\t+-----------------------------------------------------------+");
        System.out.println("\t\t\t|              Best In Programming Fundarmentals            |");
        System.out.println("\t\t\t+-----------------------------------------------------------+");
        System.out.println();

        boolean flog01=false;

        Student[] sortPrfMark =rankPrfMark();
        /////////////////////////////////////////////////////////////////////////////
        int i=0;
        System.out.printf("\t\t+------------------+----------------------+------------------+------------------+%n");
        System.out.printf("\t\t| %-16s | %-20s | %-16s | %-16s |%n", "ID", "Name", "PRF Mark", "DBM Mark");
        System.out.printf("\t\t+------------------+----------------------+------------------+------------------+%n");
        
        for (Student student : sortPrfMark) {
            System.out.printf("\t\t| %-16s | %-20s | %-16s | %-16s |%n", student.getsId(), student.getsName(), student.prfMark, student.dbmMark);
        }
        
        System.out.printf("\t\t+------------------+----------------------+------------------+------------------+%n");
       //////////////////////////////////////////////////////////////////////////////////
        do {
            System.out.println();
            flog01=false;
            System.out.print("Do you view agin(y/n)"+keyBoard+"\n\t\t"+"✎. ");
            String option02=keyIn.next();
    
            if (option02.equals("y")) {
                bestInPrf();
            }
            if (option02.equals("n")) {
                homePage();
            }
            else{
                bestInPrf();
                System.out.println("Wrong Commond! Try Agin.");
                flog01=true;
            }
        } while (flog01);
    }
    private static Student[] rankPrfMark(){
        Student[] sortStudent =new Student[students.length];

        sortStudent=students;
        //////////////////////////////////////////////////////////
        for (int i = 0; i <sortStudent.length; i++){
			for (int j = 0; j < sortStudent.length-1; j++){
				if(sortStudent[j].prfMark<sortStudent[j+1].prfMark){
					Student temp = sortStudent[j];
					sortStudent[j] = sortStudent[j+1];
					sortStudent[j+1] = temp;
				}
            }
        }
        return sortStudent;
    }
    private static void printStuRank(){
        clearConsole();
        disTimeDate();
        System.out.println("\t\t\t+-----------------------------------------------------------+");
        System.out.println("\t\t\t|                  Print Student's Ranks                    |");
        System.out.println("\t\t\t+-----------------------------------------------------------+");
        System.out.println();

        boolean flog01=false;

        Student[] sorStudents= rankingStu();
       /////////////////////////////////////////////////////////////////////////////////
        int i=0;
        System.out.printf("+------------------+----------------------+------------------+------------------+------------------+%n");
        System.out.printf("| %-16s | %-16s | %-20s | %-16s | %-16s |%n", "Rank", "ID", "Name", "Total Mark", "Ave. Mark");
        System.out.printf("+------------------+----------------------+------------------+------------------+------------------+%n");
        
        for (Student student : sorStudents) {
            System.out.printf("| %-16s | %-16s | %-20s | %-16s | %-16s |%n", (i + 1), student.getsId(), student.getsName(), student.totalMark(), student.aveMark());
            i++;
        }
        System.out.printf("+------------------+----------------------+------------------+------------------+------------------+%n");
       //////////////////////////////////////////////////////////////////////////////////
        do {
            System.out.println();
            flog01=false;
            System.out.print("Do you view agin(y/n)"+keyBoard+"\n\t\t"+"✎. ");
            String option02=keyIn.next();
    
            if (option02.equals("y")) {
                printStuRank();
            }
            if (option02.equals("n")) {
                homePage();
            }
            else{
                printStuRank();
                System.out.println("Wrong Commonmd! Try Agin.");
                flog01=true;
            }
        } while (flog01);
    }
    private static Student[] rankingStu(){
        Student[] sortStudent =new Student[students.length];

        sortStudent=students;
        //////////////////////////////////////////////////////////
        for (int i = 0; i <sortStudent.length; i++){
			for (int j = 0; j < sortStudent.length-1; j++){
				if(sortStudent[j].totalMark()<sortStudent[j+1].totalMark()){
					Student temp = sortStudent[j];
					sortStudent[j] = sortStudent[j+1];
					sortStudent[j+1] = temp;
				}
            }
        }
        return sortStudent;
    }
    private static void printStuDet(){
        clearConsole();
        disTimeDate();
        System.out.println("\t\t\t+-----------------------------------------------------------+");
        System.out.println("\t\t\t|               Print Student Details                       |");
        System.out.println("\t\t\t+-----------------------------------------------------------+");
        System.out.println();

        boolean flog01=false;
        boolean flog02=false;
        do {
            flog01=false;
            System.out.println();
            System.out.print("Enter Student Id"+keyBoard+"\n\t\t"+"✎. ");
            String sId=keyIn.next();
    
           Student student =findStudentById(sId);
    
            if (student != null) {
                if (student.dbmMark !=0&&student.prfMark !=0){
                    int indexNumber = rankNumber(student);
                    int rankNumber=indexNumber+1;

                    System.out.printf("\t\t+-----------------------------------------------------------------+%n");
                    System.out.printf("\t\t|                   %-38s        |%n", student.getsName());
                    
                    System.out.printf("\t\t+---------------------------------------------+-------------------+%n");
                    System.out.printf("\t\t|          %-28s       |      %-10s   |%n", "Details", "Values");
                    System.out.printf("\t\t+---------------------------------------------+-------------------+%n");
                    
                    System.out.printf("\t\t|    %-28s             |      %-10s   |%n", "Programming Fundamentals", student.prfMark);
                    System.out.printf("\t\t|    %-28s             |      %-10s   |%n", "Database Management", student.dbmMark);
                    System.out.printf("\t\t|    %-28s             |      %-10s   |%n", "Total Mark", student.totalMark());
                    System.out.printf("\t\t|    %-28s             |      %-10s   |%n", "Ave. Mark", student.aveMark());
                    
                    if (rankNumber == 1) {
                        System.out.printf("\t\t|    %-28s             |      %-10s   |%n", "Rank", rankNumber + "(First)");
                    } else if (rankNumber == 2) {
                        System.out.printf("\t\t|    %-28s             |      %-10s   |%n", "Rank", rankNumber + "(Second)");
                    } else if (rankNumber == 3) {
                        System.out.printf("\t\t|    %-28s             |      %-10s   |%n", "Rank", rankNumber + "(Third)");
                    } else {
                        System.out.printf("\t\t|    %-28s             |      %-10s   |%n", "Rank", rankNumber);
                    }
                    
                    System.out.printf("\t\t+---------------------------------------------+-------------------+%n");
                                
                   //////////////////////////////////////////////////////////////////////
                }else{
                    System.out.println("Student Name is : "+student.getsName());
                    System.out.println("\nMarks yet be added.");
                }
            }else{
                clearConsole();
                disTimeDate();
                System.out.println("\t\t\t+-----------------------------------------------------------+");
                System.out.println("\t\t\t|               Print Student Details                       |");
                System.out.println("\t\t\t+-----------------------------------------------------------+");
                System.out.println();
                System.out.println("Wrong Student ID! Try Agin.");
                flog01=true;
            }
        } while (flog01);
            
        do {
            System.out.println();
            flog02=false;
            System.out.print("Do you wont to view another Student(y/n)"+"\n\t\t"+"✎. ");
            String option02=keyIn.next();
    
            if (option02.equals("y")) {
                printStuDet();
            }
            if (option02.equals("n")) {
                homePage();
            }
            else{
                System.out.println("Wrong Commond! Try Agin.");
                flog02=true;
            }
        } while (flog02);
    }
    private static int rankNumber(Student student){

        Student[] sortArr = rankingStu();
        int i=0;

        for (i = 0; i < sortArr.length; i++) {
            if (sortArr[i].equals(student)){
                break;
            }
        }
        return i;
    }
    private static void deleteStu(){
        clearConsole();
        disTimeDate();
        System.out.println("\t\t\t+-----------------------------------------------------------+");
        System.out.println("\t\t\t|                    Delete Student                         |");
        System.out.println("\t\t\t+-----------------------------------------------------------+");
        System.out.println();

        boolean flog01=false;
        boolean flog02=false;

        do {
            System.out.println();
            flog01=false;
            System.out.print("Enter Student Id"+keyBoard+"\n\t\t"+"✎. ");
            String sId=keyIn.next();
    
           Student student =findStudentById(sId);
    
           if (student !=null) {
                deletingStudent(student.getsId());
                System.out.println("Student Delete successfully.");
           }else{
                clearConsole();
                disTimeDate();
                System.out.println("\t\t\t+-----------------------------------------------------------+");
                System.out.println("\t\t\t|                    Delete Student                         |");
                System.out.println("\t\t\t+-----------------------------------------------------------+");
                System.out.println();
                System.out.println("Wrong Student Id! Try Agin.");
                flog01=true;
           }
        } while (flog01);

        do {
            System.out.println();
            flog02=false;
            System.out.print("Do you wont to delete another Student(y/n)"+"\n\t\t"+"✎. ");
            String option02=keyIn.next();
    
            if (option02.equals("y")) {
                deleteStu();
            }
            if (option02.equals("n")) {
                homePage();
            }
            else{
                System.out.println("Wrong Commond! Try Agin.");
                flog02=true;
            }
        } while (flog02);
    }
    private static void deletingStudent(String Id){
        Student[] temp=new Student[students.length-1];

        int tempLength=0;
        for (int i = 0; i < students.length; i++) {
            if (!students[i].getsId().equals(Id)) {
                temp[tempLength]=students[i];
                tempLength++;
            }
        }
        students=temp;
    }
    private static void updateMarks(){
        clearConsole();
        disTimeDate();
        System.out.println("\t\t\t+-----------------------------------------------------------+");
        System.out.println("\t\t\t|                  Update Student Mark                      |");
        System.out.println("\t\t\t+-----------------------------------------------------------+");
        System.out.println();

        boolean flog01=false;
        boolean flog02=false;
        boolean flog03=false;
        boolean flog04=false;
        
        do{
            flog02=false;
            System.out.print("Enter Student Id"+keyBoard+"\n\t\t"+"✎. ");
            String sId=keyIn.next();
    
            Student student=findStudentById(sId);
    
            if (student !=null){
    
                System.out.println("programming fundamentals marks : "+student.prfMark);
                System.out.println("Database management marks : "+student.dbmMark);

                do {
                    System.out.println();
                    flog04=false;
                    System.out.print("Enter New programming fundamantals mark"+"\n\t\t"+"✎. ");
                    int newPrfMark=keyIn.nextInt();
        
                    if (newPrfMark>=1&&newPrfMark<=100){
                        do {
                            flog03=false;
                            System.out.println();
                            System.out.print("Enter New Database manage mark"+"\n\t\t"+"✎. ");
                            int newDbmMark=keyIn.nextInt();
            
                            if (newDbmMark>=1&&newDbmMark<=100) {
                                student.prfMark=newPrfMark;
                                student.dbmMark=newDbmMark;
                                System.out.println("Marks have been updated successfully.");
                            }else{
                                System.out.println("Wrong Marks! Try Agin");
                                flog03=true;
                            }
                        } while (flog03); 
                    }
                    else{
                        System.out.println("Wrong Marks! Try Agin.");
                        flog04=true;
                    }
                } while (flog04);
            }else{
                clearConsole();
                disTimeDate();
                System.out.println("\t\t\t+-----------------------------------------------------------+");
                System.out.println("\t\t\t|                  Update Student Mark                      |");
                System.out.println("\t\t\t+-----------------------------------------------------------+");
                System.out.println();
                System.out.println("Wrong Student Id Try Agin.");
                flog02=true;
            }
        }while(flog02);

        do {
            System.out.println();
            flog01=false;
            System.out.print("Do you wont to update another Student(y/n)"+"\n\t\t"+"✎. ");
            String option02=keyIn.next();
    
            if (option02.equals("y")){
                updateMarks();
            }
            if (option02.equals("n")) {
                homePage();
            }
            else{
                System.out.println("Wrong Commond! Try Agin.");
                flog01=true;
            }
        } while (flog01);
    }
    private static void updateStuDet(){
        clearConsole();
        disTimeDate();
        System.out.println("\t\t\t+-----------------------------------------------------------+");
        System.out.println("\t\t\t|                  Update Student Details                   |");
        System.out.println("\t\t\t+-----------------------------------------------------------+");
        System.out.println();

        boolean flog01=false;
        boolean flog02=false;

        do{
            flog02=false;
            System.out.print("Enter Student Id"+keyBoard+"\n\t\t"+"✎. ");
            String sId=keyIn.next();
    
            Student student=findStudentById(sId);
    
            if (student !=null){
    
                System.out.println("current Student Name Is : "+student.getsName());
                System.out.print("Enter New Student Name"+"\n\t\t"+"✎. ");
                String sName=keyIn.next();
    
                student.setsName(sName);
                System.out.println("Update Succsusfully.");
            }else{
                clearConsole();
                disTimeDate();
                System.out.println("\t\t\t+-----------------------------------------------------------+");
                System.out.println("\t\t\t|                  Update Student Details                   |");
                System.out.println("\t\t\t+-----------------------------------------------------------+");
                System.out.println();
                System.out.println("Wrong Student Id! Try Agin.");
                flog02=true;
            }
        }while(flog02);

        do {
            System.out.println();
            flog01=false;
            System.out.print("Do you wont to update another Student(y/n)"+"\n\t\t"+"✎. ");
            String option02=keyIn.next();
    
            if (option02.equals("y")) {
                addMark();
            }
            if (option02.equals("n")) {
                homePage();
            }
            else{
                System.out.println("wrong commonmd! try Agin.");
                flog01=true;
            }
        } while (flog01);
    }
    private static void addMark(){
        clearConsole();
        disTimeDate();
        System.out.println("\t\t\t+-----------------------------------------------------------+");
        System.out.println("\t\t\t|                          Add Mark                         |");
        System.out.println("\t\t\t+-----------------------------------------------------------+");
        System.out.println();

        boolean flog01=false;
        boolean flog02=false;
        boolean flog03=false;
        boolean flog04=false;

        do {
            flog04=false;
            System.out.print("Enter Student Id"+keyBoard+"\n\t\t"+"✎. ");
            String sId=keyIn.next();
    
           Student student= findStudentById(sId);
    
           
           if (student!=null){
                System.out.println("Student Name is : "+student.getsName());
                System.out.println();
                do {
                    flog02=false;
                    System.out.println();
                    System.out.print("Enter prf mark"+"\n\t\t"+"✎. ");
                    int prfMarkIn=keyIn.nextInt();
        
                    if (prfMarkIn>=1&&prfMarkIn<=100){
                        do {
                            flog01=false;
                            System.out.println();
                            System.out.print("Enter dbm mark"+"\n\t\t"+"✎. ");
                            int dbmMarkIn=keyIn.nextInt();
            
        
                            if (dbmMarkIn>=1&&dbmMarkIn<=100){
                                student.prfMark=prfMarkIn;
                                student.dbmMark=dbmMarkIn;
                                System.out.println("Student And Marks Added Successfully.");
                            }
                            else{
                                System.out.println("Wrong Mark! Try Agin.");
                                flog01=true;
                            }
                        } while (flog01);
                    }
                    else{
                        System.out.println("Wrong Mark! Try Agin.");
                        flog02=true;
                    }
                } while (flog02);
            }else{
                clearConsole();
                disTimeDate();
                System.out.println("\t\t\t+-----------------------------------------------------------+");
                System.out.println("\t\t\t|                          Add Mark                         |");
                System.out.println("\t\t\t+-----------------------------------------------------------+");
                System.out.println();
                System.out.println("Wrong Student Id! Try Agin.");
                flog04=true;
            }
        } while (flog04);

        do {
            System.out.println();
            flog03=false;
            System.out.print("Do you wont to Add Another Sutuden And Mark(y/n)"+"\n\t\t"+"✎. ");
            String option02=keyIn.next();
    
            if (option02.equals("y")){
                addMark();
            }
            if (option02.equals("n")) {
                homePage();
            }
            else{
                System.out.println("wrong commonmd! try Agin.");
                flog03=true;
            }
        } while (flog03);
    }
    private static void addNewMarkWithMark(){
        clearConsole();
        disTimeDate();
        System.out.println("\t\t\t+-----------------------------------------------------------+");
        System.out.println("\t\t\t|                Add Student With Marks                     |");
        System.out.println("\t\t\t+-----------------------------------------------------------+");
        System.out.println("\n");

        boolean flog01=false;
        boolean flog02=false;
        boolean flog03=false;
        boolean flog04=false;
        
        do {
            flog03=false;
            System.out.println();
            System.out.print("Enter Studet id"+keyBoard+"\n\t\t"+"✎. ");
            String sId=keyIn.next();
    
            boolean rem = checkStuId(sId);
            if (rem){
                System.out.print("Enter student name"+"\n\t\t"+"✎. ");
                String sName=keyIn.next();
                growStudentsArr(sId, sName);
                System.out.println("Student Add Successfully.");

                Student student = findStudentById(sId);
    
                if (student!=null){
                    do {
                        flog02=false;
                        System.out.println();
                        System.out.print("Enter PRF Mark"+"\n\t\t"+"✎. ");
                        int prfMarkIn=keyIn.nextInt();
            
                        if (prfMarkIn>=1&&prfMarkIn<=100){
        
                            do {
                                flog01=false;
                                System.out.println();
                                System.out.print("Enter DBM Mark"+"\n\t\t"+"✎. ");
                                int dbmMarkIn=keyIn.nextInt();
                
                                if (dbmMarkIn>=1&&dbmMarkIn<=100){
                                    student.prfMark=prfMarkIn;
                                    student.dbmMark=dbmMarkIn;
                                    System.out.println("Student And Marks Added Successfully.");
                                }
                                else{
                                    System.out.println("Wrong Mark! Try Agin.");
                                    flog01=true;
                                }
                            } while (flog01);
                        }
                        else{
                            System.out.println("Wrong Mark! Try Agin.");
                            flog02=true;
        
                        }
                    } while (flog02);
                }
            }else{
                clearConsole();
                disTimeDate();
                System.out.println("\t\t\t+-----------------------------------------------------------+");
                System.out.println("\t\t\t|                Add Student With Marks                     |");
                System.out.println("\t\t\t+-----------------------------------------------------------+");
                System.out.println("\n");
                System.out.println("Already exit Student Id! Enter anethor Id.");
                flog03=true;
            }
        } while (flog03);    

        do {
            System.out.println();
            flog04=false;
            System.out.print("Do you wont to Add Another Sutuden And Mark(y/n)"+"\n\t\t"+"✎. ");
            String option02=keyIn.next();
    
            if (option02.equals("y")) {
                addNewMarkWithMark();
            }
            if (option02.equals("n")) {
                homePage();
            }
            else{
                System.out.println("Wrong Commond! Try Agin.");
                flog04=true;
            }
        } while (flog04);
    }
    private static Student findStudentById(String sId) {
        for (Student student : students) {
            if (student.getsId().equals(sId)) {
                return student;
            }
        }
        return null;
    }
    private static void addNewStudent(){
        clearConsole();
        disTimeDate();
        System.out.println("\t\t\t+-----------------------------------------------------------+");
        System.out.println("\t\t\t|                        Add Student                        |");
        System.out.println("\t\t\t+-----------------------------------------------------------+");
        System.out.println("\n");

        boolean flog01=false;
        boolean flog02=false;
        do{
            flog01=false;
            System.out.println();
            System.out.print("Enter student Id"+keyBoard+"\n\t\t"+"✎. ");
            String sId=keyIn.next();
    
            boolean rem = checkStuId(sId);
    
            if (rem) {
                System.out.print("Enter Student Name"+"\n\t\t"+"✎. ");
                String sName=keyIn.next();
                growStudentsArr(sId,sName);
                System.out.println();
                System.out.println("Student Added Successfully.");

                flog01=false;
            }else{
                clearConsole();
                disTimeDate();
                System.out.println("\t\t\t+-----------------------------------------------------------+");
                System.out.println("\t\t\t|                        Add Student                        |");
                System.out.println("\t\t\t+-----------------------------------------------------------+");
                System.out.println("\n\n");
                System.out.println("already exit Id. try agin");
                flog01=true;
            }
        }while(flog01);

        do{
            System.out.println();
            System.out.print("Do You Wont To Add Anothar Student(y/n)"+"\n\t\t"+"✎. ");
            String op=keyIn.next();
    
            if (op.equals("y")) {
                addNewStudent();
            }
            if (op.equals("n")) {
                homePage();
            }
            else{
                System.out.println("Wrong Comond! Try Agin.");
                flog02=true;
            }
        }while(flog02);
    }
    private static void growStudentsArr(String sId, String sName){
        Student[] temp=new Student[students.length+1];

        for (int i = 0; i < students.length; i++) {
            temp[i]=students[i];
        }
        temp[temp.length-1]= new Student(sId,sName);

        students=temp;
    }
    private static boolean checkStuId(String sId){

        for (int i = 0; i < students.length; i++) {
            if (students[i].getsId().equals(sId)) {
                return false;
            }
        }
        return true;
    }
}
class Student {
        private String sId;
        private String sName;
        int prfMark;
        int dbmMark;

        public Student(String sId, String sName) {
            this.sId = sId;
            this.sName = sName;
        }

        ///////////////////////// Getter method - sId
        public String getsId(){
            return sId;
        }

        ///////////////////////// Setter method - sId
        public void setsId(String sId) {
            this.sId = sId;
        }

        ///////////////////////// Getter method - sName        
        public String getsName() {
            return sName;
        }
        ///////////////////////// Setter method - sName
        public void setsName(String sName) {
            this.sName = sName;
        }
        ////////////////////////////////Total mark////////////////
        public int totalMark(){
            int totalMark=prfMark+dbmMark;
            return totalMark;
        }
        ///////////////////////////Ave mark/////////////////////
        public double aveMark(){
            double aveMark= prfMark+dbmMark/2;
            return aveMark;
        }
    }
    ///////////////////////////////////End Program////////////////////////////////////
    /////////////////////////////////////////////////   ShenSingh   ////2023-12-10///