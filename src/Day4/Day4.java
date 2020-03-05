package Day4;

import java.io.DataInputStream;
import java.io.File;
import java.net.ServerSocket;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Properties;
import java.nio.file.*;
import java.nio.file.attribute.*;

public class Day4 {

    public static void main(String[] args) throws IOException {

        
//*******   Перебор файлов   *******
        Files.walkFileTree(Paths.get("C:"), new JavaApplication25());
        /*
//*******   Библиотека New IO   *******
        newIO();
//*******   Сохранение восстановление   *******
        ser();
//*******   Чтение файла   *******
        propert();
//*******   Обработка списка файлов   *******
        String args1[] = {"C:\\Users\\Student1\\Desktop\\Fedotovskikh"};        
        jDir(args1);        
//*******   Клиент   *******
//        IOclient
//*******   Сервер   *******
//        IOServer();
//*******   Обработка исключений   *******
//        tryTry();
         */
    }

    
    
//*******   Библиотека New IO   *******
    public static void newIO() {
        Path path = Paths.get("C:");
        try {
            FileStore fs = Files.getFileStore(path);
            printDetails(fs, AclFileAttributeView.class);
            printDetails(fs, BasicFileAttributeView.class);
            printDetails(fs, DosFileAttributeView.class);
            printDetails(fs, FileOwnerAttributeView.class);
            printDetails(fs, PosixFileAttributeView.class);
            printDetails(fs, UserDefinedFileAttributeView.class);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void printDetails(FileStore fs, Class<? extends FileAttributeView> attribClass) {
        boolean supported = fs.supportsFileAttributeView(attribClass);
        System.out.format("%s is  supported: %s%n", attribClass.getSimpleName(), supported);
    }

//*******   Сохранение восстановление   *******
    public static void ser() {
        MyC m1 = new MyC();
        m1.name = "m1";
        MyC m2 = new MyC();
        m2.name = "m2";
        try (var oos = new ObjectOutputStream(new FileOutputStream(
                new File("person.ser")));) {
            oos.writeObject(m1);
            oos.writeObject(m2);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        m1 = null;
        m2 = null;

        //Read again
        try (var ois = new ObjectInputStream(new FileInputStream(
                new File("person.ser")));) {
            m2 = (MyC) ois.readObject();
            m1 = (MyC) ois.readObject();
            System.out.println(m1.name + m2.name);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

//*******   Чтение файла   *******
    static void propert() {
        Properties props = new Properties();
        try (var input = new BufferedReader(new InputStreamReader(
                Day4.class.getResourceAsStream("../p2.properties")));) {
            props.load(input);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        System.out.println(
                props.getProperty("english") + " " + props.getProperty("russian"));
    }

//*******   Обработка списка файлов   *******
    static void jDir(String[] args) {
        try {
            File dir = new File((args.length > 0) ? args[0] : ".");
            System.out.println("For " + dir.getCanonicalFile().getPath());
            for (File file : dir.listFiles()) {
                System.out.println(file.getCanonicalFile().getName()
                        + " Can Read: " + file.canRead()
                        + " Can Write: " + file.canWrite()
                        + "Is Hidden: " + file.isHidden() + " Length: "
                        + file.length() + " bytes");
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

//*******   Клиент   *******
    static void IOclient() {
        try (Socket s = new Socket("localhost", 6666);
                DataOutputStream dout = new DataOutputStream(
                        s.getOutputStream());
                Scanner scanner = new Scanner(System.in);) {
            dout.writeUTF(scanner.next());
            dout.flush();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

//*******   Сервер   *******
    public static void IOServer() {
        String str;
        try (ServerSocket ss = new ServerSocket(6666);) {

            do {
                Socket cs = ss.accept();                //establishes connection   
                DataInputStream dis = new DataInputStream(cs.getInputStream());
                str = (String) dis.readUTF();
                System.out.println("get= " + str);
                cs.close();
            } while (!"quit".equalsIgnoreCase(str));
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

//*******   Обработка исключений   *******
    static void tryTry() {
        try {
            try {
                double ff = -10. / 0;
                System.out.println(ff + " " + (int) ff);
                int ii = 10 / 0;
            } catch (ArithmeticException e) {
                System.out.println(e);
                throw new Throwable();
            } finally {
                System.out.println("finally");
            }
        } catch (Throwable e) {
            System.out.println(e);
        }

    }

}

class MyC implements Serializable {

    MyC() {
        System.out.println("Constructor here " + this.hashCode());
    }
    String name;
}


class JavaApplication25 extends SimpleFileVisitor<Path> {
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
            throws IOException {
        System.out.println(file); 
        return FileVisitResult.CONTINUE; }
    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs)
            throws IOException {
        System.out.println(dir); 
        return FileVisitResult.CONTINUE; }
}
