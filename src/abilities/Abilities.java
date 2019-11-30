package abilities;

import java.util.LinkedList;
import java.util.List;

public class Abilities {
    protected List<Ability> abilities;

    public Abilities() {
        abilities = new LinkedList<Ability>();
    }

    public final List<Ability> getListOfAbilities() {
        return abilities;
    }
}
