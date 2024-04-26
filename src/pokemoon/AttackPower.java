package pokemoon;

class AttackPower extends PokePower {
    AttackPower(int power){
        super(power);
    }

    /**
     * 
     * @param element le type de l'élèment du pokemoon qui attaque
     * @param elementEnemi le type de l'élèment du pokemoon qui prend cher
     * @return la puissance de l'attaque reçut
     */
    int getAttackPower(Element element, Element elementEnemi) {
        if(element.getAvantage().equals(elementEnemi.toString()))
            return super.getPower()+10;
        else if(element.getDesavantage().equals(elementEnemi.toString()))
            return super.getPower()-10;
        else
            return super.getPower();
    }
}