package chapter15;

import java.util.List;

/**
 * Created by shadowwingz on 2018-11-07 23:14
 */
interface SuperPower {

}

interface XRayVision extends SuperPower {
    void seeThroughWalls();
}

interface SuperHearing extends SuperPower {
    void hearSubtleNoises();
}

interface SuperSmell extends SuperPower {
    void trackBySmell();
}

class SuperHero<POWER extends SuperPower> {
    POWER power;

    SuperHero(POWER power) {
        this.power = power;
    }

    POWER getPower() {
        return power;
    }
}

class SuperSleuth<POWER extends XRayVision> extends SuperHero<POWER> {

    SuperSleuth(POWER power) {
        super(power);
    }

    void see() {
        power.seeThroughWalls();
    }
}

class CanineHero<POWER extends SuperHearing & SuperSmell> extends SuperHero<POWER> {

    CanineHero(POWER power) {
        super(power);
    }

    void hear() {
        power.hearSubtleNoises();
    }

    void smell() {
        power.trackBySmell();
    }
}

class SuperHearSmell implements SuperHearing, SuperSmell {

    @Override
    public void hearSubtleNoises() {

    }

    @Override
    public void trackBySmell() {

    }
}

class DogBoy extends CanineHero<SuperHearSmell> {

    DogBoy() {
        super(new SuperHearSmell());
    }
}

public class EpicBattle {
    private static <POWER extends SuperHearing> void useSuperHearing(SuperHero<POWER> hero) {
        /**
         * hero.getPower() 返回 POWER 实例，
         * 由于 POWER 继承自 SuperHearing，所以 POWER 有 hearSubtleNoises 方法。
         */
        hero.getPower().hearSubtleNoises();
    }

    /**
     * POWER 继承自 SuperHearing 接口和 SuperSmell 接口
     */
    private static <POWER extends SuperHearing & SuperSmell> void superFind(SuperHero<POWER> hero) {
        hero.getPower().hearSubtleNoises();
        hero.getPower().trackBySmell();
    }

    public static void main(String[] args) {
        DogBoy dogBoy = new DogBoy();
        useSuperHearing(dogBoy);
        superFind(dogBoy);

        /**
         * ? 问号，表示通配符，通配符只能继承一个类或接口
         */
        List<? extends SuperHearing> audioBoys;
//        List<? extends SuperHearing & SuperSmell> dogBoys;
    }
}
