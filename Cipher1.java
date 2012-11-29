package TPCtrl1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.Scanner;

public class Cipher1 implements Chiffrement{
	
	static Scanner in = new Scanner (System.in);
	private int offset;
	
	Cipher1(int offset){
		this.offset=offset;
	}

	//chiffrage avec code ascii
	public byte[] chiffre(byte[] msg){
		int i;
		for(i=0; i<msg.length; i++){
			msg[i]+=offset;
		}
		return msg;
	}
	
	//criptage d'une chaine
	public String chiffreMsg(String msg){
		byte[] tampon=msg.getBytes();
		tampon=chiffre(tampon);
		msg = new String(tampon);
		return msg;
	}
	
	//dechiffrage avec code ascii
	public byte[] dechiffre(byte[] cipher){
		int i;
		for(i=0; i<cipher.length; i++){
			cipher[i]-=offset;
		}
		return cipher;
	}
	
	//decriptage d'une chaine
	public String dechiffreMsg(String cipher){
		byte[] tampon=cipher.getBytes();
		tampon=dechiffre(tampon);
		cipher = new String(tampon);
		return cipher;
	}
	
	//Cryptage d'un fichier
	public static void cryptFichier(String fichier, String fichier1){
		boolean verif =true;
		String ligne;
		Cipher1 crypt = new Cipher1 (4);
		BufferedReader ficTexte ;
		try{
			ficTexte = new BufferedReader(new FileReader(new File(fichier)));
			PrintStream ps = new PrintStream(fichier1);
			do {
				ligne = ficTexte.readLine();
				if (ligne != null) {
					ps.println(crypt.chiffreMsg(ligne));
				}
				if(ficTexte.read()==-1){
					verif=false;
				}
			} while (verif);
			//ficTexte.close(); 
			ps.close();
			return;
		}		
		catch (Exception e){
			System.out.println(e.toString());
		}
	}
	
	//Decryptage d'un fichier
	public static void decryptFichier(String fichier, String fichier1){
		boolean verif =true;
		String ligne;
		Cipher1 crypt = new Cipher1 (1);
		BufferedReader ficTexte ;
		try{
			ficTexte = new BufferedReader(new FileReader(new File(fichier)));
			PrintStream ps = new PrintStream(fichier1);
			do {
				ligne = ficTexte.readLine();
				if (ligne != null) {
					ps.println(crypt.dechiffreMsg(ligne));
				}
				//if(ficTexte != null){
				if(ficTexte.read()==-1){
					verif=false;
				}
			} while (verif);
			ficTexte.close(); 
			ps.close();
			return;
		}		
		catch (Exception e){
			System.out.println(e.toString());
		}
	}
	
	public static void affichage(String test){
		byte[] tampon=test.getBytes();
		System.out.println("Le code ASCII de "+test+" : ");
		for(int i=0; i<tampon.length; i++){
              System.out.println(tampon[i]);
        }   
	}
	public static void affiche(byte[] tampon){
		System.out.println("Le code ASCII est  : ");
		for(int i=0; i<tampon.length; i++){
              System.out.println(tampon[i]);
        } 
	}
}

