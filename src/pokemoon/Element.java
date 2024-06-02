package pokemoon;

enum Element {
    EAU("EAU","FEU","TERRE"),
    FEU("FEU","AIR","EAU"),
    TERRE("TERRE","EAU","AIR"),
    AIR("AIR","TERRE","FEU"),
    ETHER("ETHER","tous", "rien"),
    PLOMB("PLOMB","rien","tous");

    private String m_type;
    private String m_avantage;
    private String m_desavantage;

    private Element(String type,String avantage, String desavantage){
        m_type = type;
        m_avantage = avantage;
        m_desavantage = desavantage;
    }

    @Override
    public String toString(){
        return m_type;
    }

    String getAvantage(){
        return new String(m_avantage);
    }

    String getDesavantage(){
        return new String(m_desavantage);
    }
}
