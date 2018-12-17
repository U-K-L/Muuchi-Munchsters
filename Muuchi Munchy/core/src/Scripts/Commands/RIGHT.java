package Scripts.Commands;

public class RIGHT implements Command {

    @Override
    public boolean getActive() {
        return false;
    }

    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }
}