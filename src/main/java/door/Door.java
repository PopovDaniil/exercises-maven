package door;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.ObjectOutputStream;
import java.io.Serializable;

@Getter
@ToString
@RequiredArgsConstructor
public class Door implements Serializable {
    private boolean opened;
    private boolean locked;

    @Setter
    @ToString.Exclude
    private transient IEventBus eventBus;

    public void open() {
        setOpened(true);
        eventBus.send(DoorEvents.OPENED);
    }

    public void close() {
        setOpened(false);
        eventBus.send(DoorEvents.CLOSED);
    }

    public void lock() {
        locked = true;
        eventBus.send(DoorEvents.LOCKED);
    }

    public void unlock() {
        locked = false;
        eventBus.send(DoorEvents.UNLOCKED);
    }

    private void setOpened(boolean opened) {
        if (!locked) {
            this.opened = opened;
        }
    }

    public void writeObject(ObjectOutputStream outputStream) {

    }
}
