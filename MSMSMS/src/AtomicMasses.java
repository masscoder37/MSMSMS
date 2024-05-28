//set atomic masses here
    //reference for all the other classes
    //reference masses: https://www.ciaaw.org/atomic-masses.htm
//data from 17. March 2021
public class AtomicMasses {
    private static final double H_MASS =  1.0078250319;
    private static final double PROTON = 1.00727647;
    private static final double C_MASS = 12.0;
    private static final double O_MASS =  15.994914619;
    private static final double N_MASS = 14.003074004;
    private static final double S_MASS = 31.97207117;
    private static final double Na_MASS =  22.98976928;
    private static final double F_MASS =  18.998403162;
    private static final double P_MASS = 30.973761998;
    private static final double Hx_MASS = 2.0141017778 ;
    private static final double Cx_MASS = 13.003354835;
    private static final double Nx_MASS = 15.000108898;
    private static final double NEUTRON_H = Hx_MASS-H_MASS; // 1.0062767459
    private static final double NEUTRON_C = Cx_MASS-C_MASS; // 1.003354835
    private static final double NEUTRON_N = Nx_MASS-N_MASS; // 0.997034894
    private static final double ELECTRON = H_MASS-PROTON;
    private static final double NEUTRON = 1.001734443; //weighted neutron mass according to 13C, 15N, 2H respective to their abundances

    //mean of neutron masses: 1.002222158
    //abundance 2H : 0.000145 --> 0.00997249
    //abundance 13C : 0.0106--> 0.729023384
    //abundance 15N : 0.003795 --> 0.261004127
    //weighted Neutron mass: 1.001734443 (diff to CNeutron: 0.001620392)

    public static double getHMASS(){
        return H_MASS;
    }
    public static double getPROTON(){
        return PROTON;
    }
    public static double getCMASS(){
        return C_MASS;
    }
    public static double getNMASS(){return N_MASS;}
    public static double getOMASS(){
        return O_MASS;
    }
    public static double getSMASS(){return S_MASS; }
    public static double getNaMASS(){return  Na_MASS;}
    public static double getCxMASS(){return  Cx_MASS;}
    public static double getFMASS(){return F_MASS;}
    public static double getNEUTRON(){return NEUTRON;}
    public static double getPMASS() {return P_MASS;}
    public static double getNxMASS(){return Nx_MASS;}
    public static double getELECTRON(){return ELECTRON;}
}
