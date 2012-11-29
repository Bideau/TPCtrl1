package TPCtrl1;
import java.lang.Double;
import java.lang.Math;
import java.util.ArrayList;
import java.lang.Exception;

public class Complexe{
	private double reel;
	private double imaginaire;
	
	Complexe(){
		this.reel=0;
		this.imaginaire = 0;
	}
	
	Complexe(double reel, double imaginaire){
		this.reel=reel;
		this.imaginaire = imaginaire;
	}
	
	/** methode permettant de renvoyer le nom de la banque */
	public double getReel(){
		return reel;
	}
	/** methode permettant de renvoyer le nom de la banque */
	public double getImag(){
		return imaginaire;
	}
	
	public void affichage (){
		System.out.println("Votre nombre est "+imaginaire+"i + "+reel);
	}
	
	public boolean isZero(){
		if(reel ==0 && imaginaire==0){
			return true;
		}else{
			return false;
		}
	}
	
	public double module (){
		double mod;
		mod = Math.pow(reel,2)+Math.pow(imaginaire,2);
		return mod;
	}
	
	public double argument (){
		double arg=Math.PI;
		boolean verif=true;
		arg=Math.atan2(imaginaire,reel);
		while(verif){
			if (arg <-Math.PI){
				arg +=Math.PI;
			}else if(arg > Math.PI){
				arg -= Math.PI;
			}
			if(arg>=-Math.PI && arg<=Math.PI){
				verif=false;
			}
		}
		return arg;
	}
	
	//Addition de 2 complexes
	public Complexe addition(Complexe w){
        return new Complexe(reel+w.getReel(),imaginaire+w.getImag());
    }
    
    //Multiplication de  2 complexes
    public Complexe multiplication(Complexe w){
        return new Complexe((reel*w.getReel()-imaginaire*w.getImag())
					,(reel*w.getReel()+imaginaire*w.getImag()));
    }
    
    //Division de  2 complexes
    public Complexe division(Complexe w) {
		Complexe result =new Complexe();
        double deno=Math.pow(w.module(),2);
        try{
			result =  new Complexe((reel*w.getReel()+imaginaire*w.getImag())/deno
						,(imaginaire*w.getReel()-reel*w.getImag())/deno);
		}catch(Exception e){
			
		}
		return result;
    }
    /*
    //Racine carré du complexe
    public Complexe[] sqrt (){
		Complexe [] soluce;
		return soluce;
	}
	*/	


	
	public static void main(String[] args) {
		double x;
		double y;
		Complexe ctampon=new Complexe();
		Complexe ctest=new Complexe(1.3,2.4);
		Complexe c1;
		if (args.length==2){
			c1 = new Complexe (Double.parseDouble(args[0]),Double.parseDouble(args[1]));
		}else{
			c1= new Complexe (3.5,2.0);
		}
		c1.affichage();
		// teste1d
		System.out.println(c1.isZero());
		System.out.println(ctampon.isZero());
		//test 1e
		System.out.println(c1.module());
		System.out.println(ctampon.module());
		//test 1f
		System.out.println(c1.argument());
		System.out.println(ctampon.argument());
		//test 1g
		(c1.addition(ctest)).affichage();
		//test 1h
		c1.multiplication(ctest).affichage();
		//test 1j
		c1.division(ctest).affichage();
		
		Complexe c2=new Complexe (0.5,0.8);
		ArrayList<Complexe> liste=new ArrayList<Complexe>();
		liste.add(new Complexe(0,0));
		for (int i=0;i<10;i++){
			//ctampon=liste.get(i);
			x = (Math.pow(liste.get(i).getReel(),2))-(Math.pow(liste.get(i).getImag(),2))+(c2.getReel());
			y = (liste.get(i).getReel())*2*(liste.get(i).getImag());
			liste.add(new Complexe(x,y));
		}
	}
}

