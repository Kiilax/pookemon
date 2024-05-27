public class Pouvoir {
    private String m_nom;
    private String m_desc;

    protected Pouvoir(String nom, String desc){
        m_nom = nom;
        m_desc = desc;
    }

    public String getNom(){
        return m_nom;
    }

    public String getDesc(){
        return m_desc;
    }
}
