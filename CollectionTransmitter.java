import java.util.Collection;

public class CollectionTransmitter {
    private Collection object;

    public CollectionTransmitter(Collection data) {
        this.object = data;
    }

    public Collection getData() {
        return object;
    }
}
