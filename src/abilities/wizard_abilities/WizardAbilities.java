package abilities.wizard_abilities;

import abilities.Abilities;

public class WizardAbilities extends Abilities {
    public WizardAbilities() {
        super();
        abilities.add(new Drain());
        abilities.add(new Deflect());
    }
}
