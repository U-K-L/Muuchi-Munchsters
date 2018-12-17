package Scripts.Commands;

public class UP implements Command {

    @Override
    public boolean getActive() {
        return false;
    }

    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }
}