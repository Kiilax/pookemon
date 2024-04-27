package pokemoon;

class PokePower {
    private int m_power;

    PokePower(int power){
        m_power = power;
    }

    int getPower(){
        return m_power;
    }

    /**
     * 
     * @param element le type de l'élèment du pokemoon qui attaque
     * @param elementEnemi le type de l'élèment du pokemoon qui prend cher
     * @return la puissance de l'attaque reçut
     */
    int getAttackPower(Element element, Element elementEnemi) {
        if(element.getAvantage().equals(elementEnemi.toString()))
            return m_power+10;
        else if(element.getDesavantage().equals(elementEnemi.toString()))
            return m_power-10;
        else
            return m_power;
    }
}
