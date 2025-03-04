package door;

public interface IEventBus {
    <E> void send(E event);
}
