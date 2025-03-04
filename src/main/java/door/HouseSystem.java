package door;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;

@Getter
@Log4j2
public class HouseSystem implements IEventBus {
    private final House house;

    public HouseSystem(House house) {
        this.house = house;
        this.house.setHouseSystem(this);
    }

    @Override
    public <E> void send(E event) {
        log.debug("Received event {}", event);
    }
}
