package abilities.pyromancer_abilities;

import abilities.Abilities;

public class PyromancerAbilities extends Abilities {

    public PyromancerAbilities() {
        super();
        abilities.add(new Fireblast());
        abilities.add(new Ignite());
    }
}
