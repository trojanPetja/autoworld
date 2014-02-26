package be.vdab.voertuigen.div;

/**
 *
 * @author vera.baikova
 */
public class DIV {

    private static final DIV instance = new DIV();
    private int nr = 1;

    public static DIV getInstance() {
        return instance;
    }

    public Nummerplaat getNummerplaat() {
        if (nr == 999) {
            nr = 1;
        } else {
            nr++;
        }
        return new Nummerplaat(String.format("AAA%03d", nr));
    }
}
