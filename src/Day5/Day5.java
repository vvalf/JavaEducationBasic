package Day5;

import java.nio.file.*;
import static java.nio.file.StandardWatchEventKinds.*;
import java.nio.file.WatchEvent.Kind;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.*;

public class Day5 {

    public static void main(String[] args) {

//*******   Коллекции   *******
        arrayExmpl();
        /*
//*******   Дженерики   *******
        generics();
//*******   Случайные числа   *******
        rndm();
//*******   Локализация   *******
        locale();
//*******   Мониторнг файловой системы   *******
        monitFileSys();
         */
    }

//*******   Коллекции   *******
    public static void arrayExmpl() {
        ArrayList list = new ArrayList<String>();
        list.add("Раз");
        list.add("Два");
        list.add("Три");
        for (Iterator itr = list.iterator(); itr.hasNext();) {
            System.out.println(itr.next());
        }
        for (var name : list) {
            System.out.println(name);
        }
        list.forEach((name) -> {
            System.out.println(name);
        });
    }

//*******   Дженерики   *******
    public static void generics() {
        //MyVar<> ii = new MyVar<>();
        MyVar jj = new MyVar<Integer>();
        jj.set(10);
        System.out.println(" " + jj.get());
    }

//*******   Случайные числа   *******
    public static void rndm() {
        Random ran = new Random();
        for (int i = 0; i < 10; i++) {
            System.out.println(ran.nextInt());
        }
    }
//*******   Локализация   *******

    public static void locale() {
        ResourceBundle bundle = ResourceBundle.getBundle("mybundle", Locale.US);
        System.out.println("Message in " + Locale.US + ": " + bundle.getString("hi"));

        Locale.setDefault(new Locale("ru", "RU"));
        bundle = ResourceBundle.getBundle("mybundle");

        System.out.println("Message in " + Locale.getDefault() + ": " + bundle.getString("hi"));

        String hi = bundle.getString("hi");
        System.out.println("Message in " + Locale.getDefault() + ": " + hi);
    }

//*******   Мониторнг файловой системы   *******
    public static void monitFileSys() {
        try (WatchService ws = FileSystems.getDefault().newWatchService()) {
            Path dirToWatch = Paths.get("C:\\Users\\Student1\\Desktop\\Fedotovskikh\\");
            dirToWatch.register(ws, ENTRY_CREATE, ENTRY_MODIFY, ENTRY_DELETE);
            while (true) {
                WatchKey key = ws.take();
                for (WatchEvent<?> event : key.pollEvents()) {
                    Kind<?> eventKind = event.kind();
                    if (eventKind == OVERFLOW) {
                        System.out.println("Избыток событий");
                        continue;
                    }
                    WatchEvent<Path> currEvent = (WatchEvent<Path>) event;
                    Path dirEntry = currEvent.context();
                    System.out.println(eventKind + "  случилось с  " + dirEntry);
                }
                boolean isKeyValid = key.reset();
                if (!isKeyValid) {
                    System.out.println("Все с " + dirToWatch);
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

}

class MyVar<T> {

    private T field;

    T get() {
        return field;
    }

    T set(T field) {
        this.field = field;
        return field;
    }
}
