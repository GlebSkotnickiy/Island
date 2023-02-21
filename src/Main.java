import com.ua.glebskotnickiy.Controller.CliAplication;
import com.ua.glebskotnickiy.Model.Util.GameWorker;
import com.ua.glebskotnickiy.Model.AbstractOrganisms.Organism;
import com.ua.glebskotnickiy.Model.IslandSpace.IslandMap;
import com.ua.glebskotnickiy.View.IslandPrinter;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        CliAplication cliAplication = new CliAplication();
        List<Organism> typesOfOrganisms = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int x = 0;
        int y = 0;
        int seconds = 0;

        try {
            System.out.println("Выберете животных из этого списка и впишите через запятую с пробелом: Wolf, Tiger, Boa, Fox, Bear, Horse, Deer, Rabbit, Mouse, Goat, Sheep, Boar, Buffalo, Duck, Caterpillar, Grass");
            String s = scanner.nextLine();
            String[] sr = s.split(", ");
            typesOfOrganisms = cliAplication.getTypesOfOrganisms(sr);
            System.out.println("Ответ принят ✅");
            System.out.println("Введите количество клеток по вертикали:");
            x = scanner.nextInt();
            System.out.println("Ответ принят ✅");
            System.out.println("Введите количество клеток по горизонтали:");
            y = scanner.nextInt();
            System.out.println("Ответ принят ✅");
            System.out.println("Выберете длительность исполнения программы в секндах:");
            seconds = scanner.nextInt();
            System.out.println("Ответ принят ✅");
        } catch (InputMismatchException e) {
            System.out.println("Попробуйте ещё раз");
            System.exit(0);
        }

        IslandMap map = new IslandMap(x, y, typesOfOrganisms);
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(typesOfOrganisms.size());
        for (Organism organism : typesOfOrganisms) {
            executorService.scheduleAtFixedRate(new GameWorker(organism, map), 0, 2, TimeUnit.SECONDS);
        }
        executorService.scheduleAtFixedRate(new IslandPrinter(map), 0, 1, TimeUnit.SECONDS);
        Thread.sleep(seconds * 1000);
        executorService.shutdown();
    }
}