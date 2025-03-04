package door;

import file.FileService;
import lombok.extern.log4j.Log4j2;

import java.io.*;
import java.util.List;

@Log4j2
public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File dataFile = FileService.getFile("data.bin");

        var house = new House(
                List.of(new Door(), new Door(), new Door())
        );
        var houseSystem = new HouseSystem(house);

        house.getDoors().getFirst().open();
        house.getDoors().get(1).lock();
        house.getDoors().get(1).open();
        house.getDoors().get(2).close();
        log.debug(house);

        serialize(dataFile, house);
        var loadedHouse = deserialize(dataFile);
        log.debug(loadedHouse);
    }

    private static void serialize(File dataFile, Object object) throws IOException {
        try (ObjectOutput outputStream = new ObjectOutputStream(new FileOutputStream(dataFile))) {
            outputStream.writeObject(object);
        }
    }

    private static <T> T deserialize(File dataFile) throws IOException, ClassNotFoundException {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(dataFile))) {
            return (T) inputStream.readObject();
        }
    }
}
