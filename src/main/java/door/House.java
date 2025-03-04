package door;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Getter
@ToString
@RequiredArgsConstructor
public class House implements Serializable {
    private final List<Door> doors;

    private transient HouseSystem houseSystem;

    public void setHouseSystem(HouseSystem houseSystem) {
        this.houseSystem = houseSystem;
        doors.forEach(door -> door.setEventBus(houseSystem));
    }
}
