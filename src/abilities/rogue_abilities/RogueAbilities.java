package abilities.rogue_abilities;

import abilities.Abilities;

public class RogueAbilities extends Abilities {

    public RogueAbilities() {
        super();
        abilities.add(new Backstab());
        abilities.add(new Paralysis());
    }
}
