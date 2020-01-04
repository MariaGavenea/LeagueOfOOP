package angel.angels;

import angel.Angel;
import common.Position;

import java.util.ArrayList;
import java.util.List;

public class AngelsFactory {
    protected List<Angel> angelsForCurrentRound;

    public AngelsFactory(final List<String> angelsInfoForCurrentRound) {
        angelsForCurrentRound = new ArrayList<>();
        for (int i = 0; i < angelsInfoForCurrentRound.size(); ++i) {
            String[] angelInfo = angelsInfoForCurrentRound.get(i).split(",");
            Angel angel = getAngel(angelInfo[0]);
            assert angel != null;
            angel.setPosition(new Position(Integer.parseInt(angelInfo[1]),
                    Integer.parseInt(angelInfo[2])));
            angelsForCurrentRound.add(angel);
        }
    }

    protected final Angel getAngel(final String angelType) {
        switch (angelType) {
            case "DamageAngel":
                return new DamageAngel();
            case "DarkAngel":
                return new DarkAngel();
            case "Dracula":
                return new Dracula();
            case "GoodBoy":
                return new GoodBoy();
            case "LevelUpAngel":
                return new LevelUpAngel();
            case "LifeGiver":
                return new LifeGiver();
            case "SmallAngel":
                return new SmallAngel();
            case "Spawner":
                return new Spawner();
            case "TheDoomer":
                return new TheDoomer();
            case "XPAngel":
                return new XPAngel();
            default:
                return null;
        }
    }

    public final Angel getAngelAt(final int index) {
        return angelsForCurrentRound.get(index);
    }

    public final int getSize() {
        return angelsForCurrentRound.size();
    }
}
