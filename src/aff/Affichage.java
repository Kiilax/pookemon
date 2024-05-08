package aff;

import player.Player;

public class Affichage {
    private String m_titre = "\r\n" + //
        "PPPPPPPPPPPPPPPPP                   kkkkkkkk                                                                                                        \r\n" + //
        "P::::::::::::::::P                  k::::::k                                                                                                        \r\n" + //
        "P::::::PPPPPP:::::P                 k::::::k                                                                                                        \r\n" + //
        "PP:::::P     P:::::P                k::::::k                                                                                                        \r\n" + //
        "  P::::P     P:::::P  ooooooooooo    k:::::k    kkkkkkk eeeeeeeeeeee       mmmmmmm    mmmmmmm      ooooooooooo      ooooooooooo   nnnn  nnnnnnnn    \r\n" + //
        "  P::::P     P:::::Poo:::::::::::oo  k:::::k   k:::::kee::::::::::::ee   mm:::::::m  m:::::::mm  oo:::::::::::oo  oo:::::::::::oo n:::nn::::::::nn  \r\n" + //
        "  P::::PPPPPP:::::Po:::::::::::::::o k:::::k  k:::::ke::::::eeeee:::::eem::::::::::mm::::::::::mo:::::::::::::::oo:::::::::::::::on::::::::::::::nn \r\n" + //
        "  P:::::::::::::PP o:::::ooooo:::::o k:::::k k:::::ke::::::e     e:::::em::::::::::::::::::::::mo:::::ooooo:::::oo:::::ooooo:::::onn:::::::::::::::n\r\n" + //
        "  P::::PPPPPPPPP   o::::o     o::::o k::::::k:::::k e:::::::eeeee::::::em:::::mmm::::::mmm:::::mo::::o     o::::oo::::o     o::::o  n:::::nnnn:::::n\r\n" + //
        "  P::::P           o::::o     o::::o k:::::::::::k  e:::::::::::::::::e m::::m   m::::m   m::::mo::::o     o::::oo::::o     o::::o  n::::n    n::::n\r\n" + //
        "  P::::P           o::::o     o::::o k:::::::::::k  e::::::eeeeeeeeeee  m::::m   m::::m   m::::mo::::o     o::::oo::::o     o::::o  n::::n    n::::n\r\n" + //
        "  P::::P           o::::o     o::::o k::::::k:::::k e:::::::e           m::::m   m::::m   m::::mo::::o     o::::oo::::o     o::::o  n::::n    n::::n\r\n" + //
        "PP::::::PP         o:::::ooooo:::::ok::::::k k:::::ke::::::::e          m::::m   m::::m   m::::mo:::::ooooo:::::oo:::::ooooo:::::o  n::::n    n::::n\r\n" + //
        "P::::::::P         o:::::::::::::::ok::::::k  k:::::ke::::::::eeeeeeee  m::::m   m::::m   m::::mo:::::::::::::::oo:::::::::::::::o  n::::n    n::::n\r\n" + //
        "P::::::::P          oo:::::::::::oo k::::::k   k:::::kee:::::::::::::e  m::::m   m::::m   m::::m oo:::::::::::oo  oo:::::::::::oo   n::::n    n::::n\r\n" + //
        "PPPPPPPPPP            ooooooooooo   kkkkkkkk    kkkkkkk eeeeeeeeeeeeee  mmmmmm   mmmmmm   mmmmmm   ooooooooooo      ooooooooooo     nnnnnn    nnnnnn\r\n" + //
        "                                                                                                                                                    \r\n" + //
        "";
    private String m_separation = "----------------------------------------------------------------------------------------------------------------------------------------------------\n";

    public String getTitre() {
        return m_titre+m_separation;
    }
    
    private String getDeck(Player player) {
        return "Taille du Deck : "+player.getDeckSize()+" Pokémoons\n";
    }
    private String getDiscard(Player player) {
        return "Taille de la défausse : "+player.getDiscardSize()+" Pokémoons\n";
    }
    private String getHand(Player player) {
        return player.getHand();
    }
    public String getProfile(Player player) {
        return player.getPlayerName().toUpperCase()+" :\n\n"+
        getDeck(player)+
        getDiscard(player)+"\n"+
        getHand(player)+"\n"+m_separation;
    }
    public String getPlayground(Player player) {
        return "TERRAIN DE "+player.getPlayerName().toUpperCase()+" :\n\n"+
        player.getPlayground()+"\n"+m_separation;
    }
}