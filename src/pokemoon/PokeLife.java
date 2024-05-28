package pokemoon;
/*
 * gestion de la vie d'un pokemoon
 * m_pv le vie actuel du pokemoon
 * m_pvMax la vie maximum du pokemoon
 */

 class PokeLife {
    private int m_pv;
    private int m_pvMax;
    private int m_protection = 0;

    PokeLife(int pv){
        m_pv = pv;
        m_pvMax = pv;
    }

    int getPV(){
        return m_pv;
    }

    int getPvMax(){
        return m_pvMax;
    }

    void setProtec(int protec){
        m_protection = protec;
    }

    /**
     * @param attack la puissance de l'attaque reçut
     * @return le nombre de pv restant
     */
    int takeDamage(int attack){
        m_pv -= (attack-m_protection);
        if(m_pv<0){
            m_pv=0;
        }
        return m_pv;
    }

    int takeHeal(int heal) {
        m_pv += heal;
        if(m_pv>m_pvMax) {
            m_pv = m_pvMax;
        }
        return m_pv;
    }
}
