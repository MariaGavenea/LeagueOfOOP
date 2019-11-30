package abilities.knight_abilities;

import abilities.Abilities;

public class KnightAbilities extends Abilities {

    public KnightAbilities() {
        super();
        abilities.add(new Execute());
        abilities.add(new Slam());
    }
}
