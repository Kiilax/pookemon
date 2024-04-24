package pokemoon;

public enum Element {
    EAU("eau","feu","terre"),
    FEU("feu","air","eau"),
    TERRE("terre","eau","air"),
    AIR("air","terre","feu");

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

    public String getAvantage(){
        return new String(m_avantage);
    }

    public String getDesavantage(){
        return new String(m_desavantage);
    }
}
